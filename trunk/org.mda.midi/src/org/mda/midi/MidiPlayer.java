package org.mda.midi;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Transmitter;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.Session;

import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.additionals.Additional;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.IPresentationContext;
import org.mda.presenter.IPresentationController;

import com.google.inject.Inject;


public class MidiPlayer implements Runnable, LineListener, MetaEventListener {
	
	private MidiInfo midiinfo = new MidiInfo();

	@Inject
	ApplicationSession applicationSession;
	
	@Inject
	IPresentationContext presentationContext;
	
	@Inject
	IPresentationController presentationController;
	
	@Inject
	MidiFileCurrentSlideCalculator currentSlideCalculator;

	private static final Log LOGGER = LogFactory.getLogger(MidiPlayer.class);

	private HashMap<MidiFile, Sequence> sequences = new HashMap<MidiFile, Sequence>();

	private Thread thread;
	private Sequencer sequencer;
	private Sequence currentSequence;
	protected boolean running = false;
	
	protected boolean isWaitingForNextSong;

	protected int newTick;

	protected int currentTick;

	private MidiDevice midiDevice;
	
	private Session currentPlayingSession;
	
	private MidiFilePart currentPlayingPart;
	
	private boolean configWaitAfterSong = true;

	private MidiplayerMode mode;
	
	
	
	
	
	@Override
	public void update(LineEvent event) {
		if (event.getType() == LineEvent.Type.STOP) {
			LOGGER.info("Stop recieved");
		}
	}

	@Override
	public void meta(MetaMessage message) {
		if (message.getType() == 47) { // 47 is end of track
			LOGGER.info("End of track rescieved");
			
			if (configWaitAfterSong) {
				LOGGER.info("Stop Sequencer after end recievd");
				getSequencer().stop();
				isWaitingForNextSong = true;
			}
		}
	}

	/**
	 * starts the midiplayer to play the current session in a seperate thread
	 * @throws MidiUnavailableException
	 * @throws NoMidiFileFoundException 
	 * @throws IOException 
	 * @throws InvalidMidiDataException 
	 * @throws MidiFileInvalidBarDataException 
	 * @throws InvalidMidiDeviceConfiguredException 
	 * @throws NoMidiDeviceConfiguredException 
	 */
	public void start(MidiplayerMode mode) throws MidiUnavailableException, NoMidiFileFoundException, InvalidMidiDataException, IOException, MidiFileInvalidBarDataException, NoMidiDeviceConfiguredException, InvalidMidiDeviceConfiguredException {
		initDevices();
		this.setMode(mode);
		
		loadSequences();
		running = true;
		thread = new Thread(this);
		thread.setName("Juke");
		thread.start();
	}
	
	/**
	 * save current position in song (in recording mode)
	 * 
	 * @param position
	 */
	public void savePartIntersection () {
		if (isRunning() && getMode().equals(MidiplayerMode.RECORDING)) {
		  String position = getCurrentPositionInSong();
		  MidiFile midifile = (MidiFile) currentPlayingPart.eContainer();
		  MidiFilePart nextPart = MidiPlayerService.getNextPart(midifile, currentPlayingPart);
		  LOGGER.info("Save part intersection " + position + " for part " + nextPart);
		  nextPart.setPosition(position);
		}
	}



	/**
	 * load sequences for all song
	 * @throws IOException 
	 * @throws InvalidMidiDataException 
	 * @throws MidiFileInvalidBarDataException 
	 */
	private void loadSequences() throws NoMidiFileFoundException, InvalidMidiDataException, IOException, MidiFileInvalidBarDataException {
		
		NoMidiFileFoundException noMidiFileFoundException = new NoMidiFileFoundException();
		
		//check, if all files have a midifile assigned
		for (AbstractSessionItem sessionItem: presentationContext.getCurrentSession().getItems()) {
			if (sessionItem instanceof MidiFile) {
				MidiFile nextMidiFile = (MidiFile) sessionItem;
				if (nextMidiFile.getPath() == null || nextMidiFile.getPath().trim().isEmpty())
					noMidiFileFoundException.add(nextMidiFile);
				else {
					Additional midifileAdditional = applicationSession.getAdditionalsHandler().findByKey(nextMidiFile.getPath());
					if (midifileAdditional != null) {
					  Sequence loadedSequence = MidiSystem.getSequence(midifileAdditional.getFile());
					  LOGGER.info("Loaded sequence for midifile " + nextMidiFile.getName());
					  sequences.put(nextMidiFile, loadedSequence);
					}
					else {
						LOGGER.error("No additional found for " + nextMidiFile.getPath());
						noMidiFileFoundException.add(nextMidiFile);
					}			
				}
			}
			else
				LOGGER.info("No sequence loaded for nonmidifile " + sessionItem.getName());
		}
		
		currentSlideCalculator.init(presentationContext.getCurrentSession());
		
		
		LOGGER.info("Loaded " + sequences.keySet().size() + " sequences for " + presentationContext.getCurrentSession().getItems().size() + " items");
		
		if (noMidiFileFoundException.mustBeThrown())
			throw noMidiFileFoundException;
		
	}

	public void startNewSong() throws InvalidMidiDataException, IOException, MidiUnavailableException {
		if (! (presentationContext.getCurrentSessionItem() instanceof MidiFile)) {
			currentSequence = null;
			return;
		}
		final MidiFile midifile = (MidiFile) presentationContext.getCurrentSessionItem();
		
		currentSequence = sequences.get(midifile);
		LOGGER.info("Starting new song " + midifile.getName() + "-" + currentSequence);

	    Display.getDefault().asyncExec(new Runnable() {
	            public void run() {
	            	if (midifile.getParts().size() > 0) {
	            	LOGGER.info("Send toPart 0 for midifile " + midifile.getName());
	            	  currentPlayingPart = midifile.getParts().get(0);
	            	  presentationController.toPart(currentPlayingPart);
	            	}
	            }
	    });
	    
		if (getSequencer() != null) {
			getSequencer().close();
			getSequencer().open();
			
			getSequencer().setSequence(currentSequence);
			getSequencer().setMicrosecondPosition(0);
			LOGGER.info("Current sequence from midifile " + midifile.getPath());
			
			LOGGER.info("Current position initialized pre start to bar " + sequencer.getTickPosition() + "(" + getSequencer().getTickLength() + ")");
			LOGGER.info("Start sequencer " + getSequencer());
			getSequencer().start();
			LOGGER.info("Current position initialized after start to bar " + sequencer.getTickPosition());
		}

	}
	
	

	@Override
	public void run() {
		currentPlayingSession = getCurrentSession();
		LOGGER.info("Run Session " + currentPlayingSession.getName());
		if (isSessionListEmpty())
			return;
		
		open();
		
		
		for (final AbstractSessionItem nextItem: getCurrentSession().getItems()) {
		
		  LOGGER.info("Session is not empty, start new song " + nextItem.getName());
		  Display.getDefault().syncExec(new Runnable() {
	          public void run() {
	            LOGGER.info("Trigger toItem " + nextItem.getName());
	            presentationController.toItem(nextItem);
	          }
	      });


		  try {
			startNewSong();
		  } catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
			LOGGER.error(e.toString(), e);
		  }


		  int currentBar = -1;
		  int newBar = 0;

		  

		  while (! isWaitingForNextSong) {
			newTick = getCurrentTick();
			if (newTick != currentTick) {
				currentTick = newTick;
			}
			
			newBar = getCurrentBar();
			if (newBar != currentBar) {
				currentBar = newBar;
				LOGGER.info("Bar changed to " + newBar);
				if (nextItem instanceof MidiFile) {
				  MidiFile midifile = (MidiFile) nextItem;
				  final MidiFilePart currentPart = currentSlideCalculator.getCurrentPart(midifile, currentBar);
				  if (currentPart != currentPlayingPart) {
					LOGGER.info ("Slide changes");
				    
					if (isRunning()) {
				    Display.getDefault().asyncExec(new Runnable() {
			            public void run() {
			            	presentationController.toPart(currentPart);
			            }
			        });
					}
				    
				    currentPlayingPart = currentPart;
				    
			  	  }
				}
			}
		  }
		  
		  LOGGER.info("ConfigWaitAfterSong = " + configWaitAfterSong);
		  while (isWaitingForNextSong && configWaitAfterSong) {
			  if (isRunning())
				  getSequencer().stop();
			  
			  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				LOGGER.error(e.toString(), e);
			} 
			  LOGGER.info("Waiting for next song....");
		  }
		  
		  LOGGER.info("After waiting for new song");
		  
		}
		end();
	}
	
	
	public void togglePause () {
		
		LOGGER.info("Toggle pause");
		if (getSequencer().isRunning()) {
			LOGGER.info("Pause playback");
			getSequencer().stop();
		}
		else {
			
			if (isWaitingForNextSong) {
				LOGGER.info("Set waitingForNextSong to false");
				isWaitingForNextSong = false;
			}
			else {
		  	  LOGGER.info("Resume playback in bar " + getCurrentBar() + "(waiting =" + isWaitingForNextSong + ")");
			  getSequencer().start();
			}
		}
	}

	public void setSequencer(Sequencer sequencer) {
		this.sequencer = sequencer;
	}

	private Sequencer getSequencer() {
		return sequencer;
	}

	public boolean isRunning() {
		return running;
	}

	
	public boolean isSessionListEmpty() {
		return getCurrentSession() == null
				|| getCurrentSession().getItems().size() == 0;
	}

	public Session getCurrentSession() {
		return presentationContext.getCurrentSession();
	}

	/**
	 * initialize the devices from model configurastions data
	 * @param root model
	 * @throws MidiUnavailableException thrown if midi is not available
	 */
	private void initDevices() throws MidiUnavailableException, NoMidiDeviceConfiguredException, InvalidMidiDeviceConfiguredException {
		
		String configuredDevices = applicationSession.getCurrentModel().getConfig().getMididevice();
		if (configuredDevices == null)
			throw new NoMidiDeviceConfiguredException();
		
		String [] midiDeviceKeys = configuredDevices.split("#");
		
		
		for (String nextKey: midiDeviceKeys) {
			if (nextKey == null || nextKey.trim().length() == 0)
				continue;
			
			MidiDeviceInfo infodevice = midiinfo.findDeviceInfoRecieving(nextKey);
			if (infodevice != null) { 
				midiDevice = infodevice.getDevice();
				break;
			}
		}
		
		
		if (midiDevice == null)
			throw new InvalidMidiDeviceConfiguredException(configuredDevices);
		else
			LOGGER.info ("Using " + midiDevice.getDeviceInfo().getDescription());

		midiDevice.open();
	}

	public String getCurrentPositionInSong() {
		if (getSequencer() != null && getSequencer().getSequence() != null) {
			String currentPosition = "" + getCurrentBar() + "/" + currentTick;
			LOGGER.info("CurrentPosition = " + currentPosition);
			return currentPosition;
		}

		LOGGER.info("CurrentPosition = <null>");
		return "";

	}

	public int getCurrentTick() {
		if (getSequencer() != null && getSequencer().getSequence() != null) {
			if (getSequencer().getSequence().getDivisionType() == Sequence.PPQ) {
				int resolution = getSequencer().getSequence().getResolution();
				int bar = ((int) (getSequencer().getTickPosition() / resolution) % 4);
				return bar;

			} else
				return 0;
		}
		return 0;
	}

	public int calculatePosition(final int bar) {
		return bar * 4 * getSequencer().getSequence().getResolution();
	}

	public int getCurrentBar() {
		if (getSequencer() != null && getSequencer().getSequence() != null) {
			if (getSequencer().getSequence().getDivisionType() == Sequence.PPQ) {
				int resolution = getSequencer().getSequence().getResolution() * 4;
				int bar = (int) (getSequencer().getTickPosition() / resolution) + 1;
				return bar;

			} else
				return 0;
		}
		return 0;
	}

	public int getMaxBar() {
		if (getSequencer() != null && getSequencer().getSequence() != null) {
			if (getSequencer().getSequence().getDivisionType() == Sequence.PPQ) {
				int resolution = getSequencer().getSequence().getResolution() * 4;
				int bar = (int) (getSequencer().getTickLength() / resolution) + 1;
				return bar;

			} else
				return 0;
		}
		return 0;
	}

	public void end() {
		if (isRunning()) {
			if (getSequencer() != null)
				getSequencer().stop();

			running = false;
			
			presentationController.end();

		}
		thread = null;
	}

	public void open() {
		
			try {
				setSequencer(MidiSystem.getSequencer());
				Transmitter trans = getSequencer().getTransmitter();
				getSequencer().open();
				
				// connect sequencer and midi out device
				trans.setReceiver(midiDevice.getReceiver());
				
			} catch (MidiUnavailableException e) {
				LOGGER.error(e.getLocalizedMessage(), e);
			}
		
		if (getSequencer() != null)
			getSequencer().addMetaEventListener(this);
	}

	/**
	 * getter
	 * @return current mode player started with
	 */
	public MidiplayerMode getMode() {
		return mode;
	}

	private void setMode(MidiplayerMode mode) {
		this.mode = mode;
	}



	

}
