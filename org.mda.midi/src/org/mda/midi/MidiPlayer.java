package org.mda.midi;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.sound.midi.Transmitter;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.Session;

import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
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

	protected boolean stoppedByEvent;

	protected int newTick;

	protected int currentTick;

	private MidiDevice midiDevice;
	
	private Session currentPlayingSession;
	
	private MidiFilePart currentPlayingPart;
	
	
	
	
	
	@Override
	public void update(LineEvent event) {
		if (event.getType() == LineEvent.Type.STOP) {
			// TODO
		}
	}

	@Override
	public void meta(MetaMessage message) {
		if (message.getType() == 47) { // 47 is end of track
			// TODO
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
	public void start() throws MidiUnavailableException, NoMidiFileFoundException, InvalidMidiDataException, IOException, MidiFileInvalidBarDataException, NoMidiDeviceConfiguredException, InvalidMidiDeviceConfiguredException {
		initDevices();
		loadSequences();
		running = true;
		thread = new Thread(this);
		thread.setName("Juke");
		thread.start();
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
		MidiFile midifile = (MidiFile) presentationContext.getCurrentSessionItem();
		currentSequence = sequences.get(midifile);

		for (int i = 0; i < currentSequence.getTracks().length; i++) {

			Track track = currentSequence.getTracks()[i];
			MetaMessage message2 = new MetaMessage();
			message2.setMessage(0, new byte[] { 00, 02, 99 }, 0);

			track.add(new MidiEvent(message2, 0));

			//LOGGER.info("Track " + i + " : " + track);
			
			for (int j = 0; j < track.size(); j++) {
				MidiMessage message = track.get(j).getMessage();
				String bytesAsString = "";
				for (int byteIndex = 0; byteIndex < message.getMessage().length; byteIndex++)
					bytesAsString += message.getMessage()[byteIndex] + " ";

				//LOGGER.info("  - " + track.get(j).getTick() + "-" + track.get(j).getMessage().getStatus() + bytesAsString + "-" + track.get(j).getMessage().getLength());
			}

		}

		if (getSequencer() != null) {
			getSequencer().open();
			getSequencer().setSequence(currentSequence);
		}

	}

	@Override
	public void run() {
		currentPlayingSession = getCurrentSession();
		LOGGER.info("Run Session " + currentPlayingSession.getName());
		if (isSessionListEmpty())
			return;
		
		for (final AbstractSessionItem nextItem: getCurrentSession().getItems()) {
		
		  open();

		  LOGGER.info("Session is not empty");
		  Display.getDefault().asyncExec(new Runnable() {
	            public void run() {
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

		  if (getSequencer() != null) {
			LOGGER.info("Current position initialized pre start to bar " + sequencer.getTickPosition() + "(" + getSequencer().getTickLength() + ")");
			LOGGER.info("Start sequencer" + getSequencer());
			getSequencer().start();
			LOGGER.info("Current position initialized after start to bar " + sequencer.getTickPosition());
		  }

//		  for (MidiPlayerListener listener : listeners)
//			listener.started();

		  while (isRunning()) {
			newTick = getCurrentTick();
			if (newTick != currentTick) {
				currentTick = newTick;
//				for (MidiPlayerListener listener : listeners) {
//					//LOGGER.info("sending tick changed to " + currentTick + " to " + listener.getClass().getName());
//					listener.tickChanged(currentTick);
//				}
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
				    
				    Display.getDefault().asyncExec(new Runnable() {
			            public void run() {
			            	presentationController.toPart(currentPart);
			            }
			        });
				    
				    currentPlayingPart = currentPart;
				    
			  	  }
				}
//				for (MidiPlayerListener listener : listeners)
//					listener.barChanged(currentBar);
			}

		  }
		
		  stop();
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
		
		String midiDeviceKey = applicationSession.getCurrentModel().getConfig().getMididevice();
		if (midiDeviceKey == null || midiDeviceKey.trim().length() == 0)
			throw new NoMidiDeviceConfiguredException();
			
		MidiDeviceInfo infodevice = midiinfo.findDeviceInfoRecieving(midiDeviceKey);
		if (infodevice == null)
			throw new InvalidMidiDeviceConfiguredException(midiDeviceKey);
		else
			LOGGER.info ("Using " + infodevice.getKey() + "-" + infodevice.getDevice());
		
		midiDevice = infodevice.getDevice();
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

	public void stop() {
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



	

}
