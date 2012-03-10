package org.mda.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiDevice.Info;
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
import mda.MidiPlayerRoot;
import mda.Session;
import org.mda.MidiPlayerListener;
import org.mda.MidiPlayerService;

public class MidiPlayer implements Runnable, LineListener, MetaEventListener,
		KeyListener, IPlayer {

	private MidiPlayerRoot root = null;

	protected List<MidiPlayerListener> listeners = new ArrayList<MidiPlayerListener>();

	private Thread thread;
	private Sequencer sequencer;
	private Sequence currentSequence;
	private int currentSongIndex;
	private int loopFrom = 0;
	private int loopTo = -1;

	protected boolean running = false;

	protected boolean shouldStepToNext;

	protected boolean stoppedByEvent;

	protected int newTick;

	protected int currentTick;

	private MidiDevice midiDevice;

	public void update(LineEvent event) {
		if (event.getType() == LineEvent.Type.STOP) {
			// TODO
		}
	}

	public void meta(MetaMessage message) {
		if (message.getType() == 47) { // 47 is end of track
			// TODO
		}
	}

	public void start() {
		running = true;
		thread = new Thread(this);
		thread.setName("Juke");
		thread.start();
	}


	@Override
	public void keyPressed(KeyEvent e) {
	  System.out.println ("midiplayer recieved keyPressed");
		if (e.getKeyCode() == KeyEvent.VK_DOWN && e.isShiftDown()) {
			moveSongDown();
			e.consume();
		} else if (e.getKeyChar() == '1') {
			togglePlayingCurrentSong();
			e.consume();
		} else if (e.getKeyChar() == ' ') {
		  System.out.println ("midiplayer recieved start/stop");
			togglePlayingCurrentSong();
			e.consume();
		} else if (e.getKeyCode() == KeyEvent.VK_UP && e.isShiftDown()) {
			moveSongUp();
			e.consume();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			playNextSong();
			e.consume();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			playPrevSong();
			e.consume();
		} else if (e.getKeyChar() == 'r') {
			replayCurrentSong();
			e.consume();
		}

	}

	public void addMidiPlayerListener(final MidiPlayerListener listener) {
		listeners.add(listener);
	}

	public void assignCurrentSong() throws Exception {
		String completeFile = getCurrentMidifile().getPath() + "/"
				+ getCurrentMidifile().getName();
		currentSequence = MidiSystem.getSequence(new File(completeFile));

		for (int i = 0; i < currentSequence.getTracks().length; i++) {

		  Track track = currentSequence.getTracks() [i];
		  MetaMessage message2 = new MetaMessage();
		  message2.setMessage(0, new byte [] {00, 02, 99}, 0);


		  track.add(new MidiEvent(message2, 0));

		  System.out.println ("Track " + i + " : " + track );
		  for (int j = 0; j < track.size(); j++) {
		    MidiMessage message = track.get(j).getMessage();
		    String bytesAsString = "";
		    for (int byteIndex = 0; byteIndex < message.getMessage().length; byteIndex ++)
		      bytesAsString += message.getMessage() [byteIndex] + " ";

		    System.out.println ("  - " + track.get(j).getTick() + "-" + track.get(j).getMessage().getStatus() + bytesAsString + "-" + track.get(j).getMessage().getLength());
		  }

		}


		System.out.println("Setze Sequence " + currentSequence + "("
				+ completeFile + ")");
		if (getSequencer() != null) {
			getSequencer().open();
			getSequencer().setSequence(currentSequence);
		}

	}

	public void run() {
		if (isSessionListEmpty())
			return;

		try {

			if (shouldStepToNext == true) {
				shouldStepToNext = false;
				currentSongIndex++;
				for (MidiPlayerListener listener : listeners)
					listener.sessionItemChanged(getCurrentMidifile());
			}

			assignCurrentSong();

		} catch (InvalidMidiDataException imde) {
			imde.printStackTrace();
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}

		int currentBar = -1;
		int newBar = 0;

		if (getSequencer() != null) {
			System.out.println("Current position initialized pre start to bar "
					+ sequencer.getTickPosition() + "("
					+ getSequencer().getTickLength() + ")");
			getSequencer().start();
			System.out.println("Current position initialized after start to bar "
							+ sequencer.getTickPosition());
		}

		// Jump to a several tick
		if (getLoopFrom() >= 0) {

			if (getSequencer() != null)
				getSequencer().setTickPosition(berechnePosition(getLoopFrom()));

			for (MidiPlayerListener listener : listeners) {
			  //System.out.println ("BarChanged to " + getCurrentBar());
				listener.barChanged(getCurrentBar());
			}
		}

		for (MidiPlayerListener listener : listeners)
			listener.started();

		while (isRunning()) {
			newTick = getCurrentTick();
			if (newTick != currentTick) {
				currentTick = newTick;
				for (MidiPlayerListener listener : listeners) {
				  //System.out.println ("sending tick changed to " + currentTick + " to " + listener.getClass().getName());
					listener.tickChanged(currentTick);
				}
			}

			newBar = getCurrentBar();
			if (newBar != currentBar) {
				currentBar = newBar;
				for (MidiPlayerListener listener : listeners)
					listener.barChanged(currentBar);
			}

		}

		stop();

		shouldStepToNext = !stoppedByEvent;
		stoppedByEvent = false;

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

	public void playNextSong() {
		if (!isSessionListEmpty()
				&& currentSongIndex < getCurrentSession().getItems().size() - 1) {
			boolean currentlyRunning = isRunning();
			stop();
			currentSongIndex += 1;

			for (MidiPlayerListener listener : listeners)
				listener.sessionItemChanged(getCurrentMidifile());

			if (currentlyRunning)
				start();
		}
	}

	public boolean isSessionListEmpty() {
		return getCurrentSession() == null
				|| getCurrentSession().getItems().size() == 0;
	}

	public Session getCurrentSession() {

		if (getRoot().getConfig() != null
				&& getRoot().getConfig().getLastSession() != null)
			return getRoot().getConfig().getLastSession();

		if (getRoot().getSessions().size() == 0)
			return null;

		return getRoot().getSessions().get(0);
	}

	public void init(MidiPlayerRoot root) throws MidiUnavailableException {
		this.setRoot(root);
		Info[] midiDeviceInfo = MidiSystem.getMidiDeviceInfo();
    for (int i = 0; i < midiDeviceInfo.length; i++) {
      System.out.println("Device:" + midiDeviceInfo[i].getName() + " + "
          + midiDeviceInfo[i].getDescription() + "\n");
    }

    midiDevice = MidiSystem.getMidiDevice(midiDeviceInfo[1]);
    midiDevice.open();
	}

	public MidiPlayerRoot getRoot() {
		return root;
	}

	private final static String normalizeName(final String name) {

		if (name == null)
			return "<k.A.>";

		if (name.indexOf(".") >= 0)
			return name.substring(0, name.indexOf("."));
		else
			return name;
	}

	public void togglePlayingCurrentSong() {
		/**
		 * for (MidiPlayerListener listener : listeners)
		 * listener.sessionItemChanged(getCurrentMidifile());
		 **/

		stoppedByEvent = false;

		if (isRunning()) {
			stoppedByEvent = true;
			stop();
		} else {
			start();
		}
	}

	public void playPrevSong() {
		if (currentSongIndex > 0) {
			boolean currentlyRunning = isRunning();
			stop();
			currentSongIndex -= 1;

			for (MidiPlayerListener listener : listeners)
				listener.sessionItemChanged(getCurrentMidifile());

			if (currentlyRunning)
				start();
		}
	}

	public void replayCurrentSong() {
		stop();
		start();
	}

	public String getNameOf(int index) {
		if (isSessionListEmpty() || getCurrentSongIndex() < 0)
			return "";

		return normalizeName(getCurrentSession().getItems().get(index)
				.getName());

	}

	public String getCurrentName() {
		return getNameOf(getCurrentSongIndex());
	}

	public String getCurrentPositionInSong() {
		if (getSequencer() != null && getSequencer().getSequence() != null) {
		  String currentPosition = "" + getCurrentBar() + "/" + currentTick;
		  //System.out.println ("CurrentPosition = " + currentPosition);
		  return currentPosition;
		}

		//System.out.println ("CurrentPosition = <null>");
		return "";

	}

	public int getCurrentTick() {
		if (getSequencer() != null && getSequencer().getSequence() != null) {
			if (getSequencer().getSequence().getDivisionType() == Sequence.PPQ) {
				int resolution = getSequencer().getSequence().getResolution();
				int bar = ((int) (getSequencer().getTickPosition() / resolution) % 4);

				//System.out.println (getSequencer().getTickPosition() / resolution);
				//System.out.println (bar);

				return bar;

			} else
				return 0;
		}
		return 0;
	}

	public int berechnePosition(final int bar) {
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

	public void moveSongUp() {
		if (!isRunning() 	&& currentSongIndex > 0) {
			AbstractSessionItem abstractSessionItem = getCurrentSession()
					.getItems().get(currentSongIndex);
			getCurrentSession().getItems().remove(currentSongIndex);
			currentSongIndex--;
			getCurrentSession().getItems().add(currentSongIndex,
					abstractSessionItem);

			for (MidiPlayerListener listener : listeners)
				listener.sessionItemChanged(getCurrentMidifile());

			MidiPlayerService.saveRootObject(getRoot());
		}
	}

	public void moveSongDown() {
		if (!isRunning() 	&& currentSongIndex < getCurrentSession().getItems().size() - 1) {
			AbstractSessionItem abstractSessionItem = getCurrentSession()
					.getItems().get(currentSongIndex);
			getCurrentSession().getItems().remove(currentSongIndex);
			currentSongIndex++;
			getCurrentSession().getItems().add(currentSongIndex,
					abstractSessionItem);

			for (MidiPlayerListener listener : listeners)
				listener.sessionItemChanged(getCurrentMidifile());

			MidiPlayerService.saveRootObject(getRoot());
		}
	}

	public MidiFile getCurrentMidifile() {
		AbstractSessionItem sessionItem = getCurrentSession().getItems().get(
				getCurrentSongIndex());
		if (sessionItem instanceof MidiFile)
			return (MidiFile) sessionItem;
		else
			return null;
	}

	public void setCurrentSession(final Session session) {

		getRoot().getConfig().setLastSession(session);

		for (MidiPlayerListener listener : listeners)
			listener.sessionChanged(session);

	}

	public void setCurrentSong(int currentPosition) {
		if (getCurrentSession().getItems().size() == 0)
			return;

		this.currentSongIndex = currentPosition;

		for (MidiPlayerListener listener : listeners)
			listener.sessionItemChanged(getCurrentSession().getItems().get(
					getCurrentSongIndex()));

	}

	public int getCurrentSongIndex() {
		return currentSongIndex;
	}

	public void stop() {
		if (isRunning()) {
			if (getSequencer() != null)
			  getSequencer().stop();

			running = false;

			for (MidiPlayerListener listener : listeners)
				listener.stopped();

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

		} catch (Exception ex) {
			ex.printStackTrace();
			// System.exit(1);
		}
		if (getSequencer() != null)
			getSequencer().addMetaEventListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped of " + getClass().getName());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setLoopFrom(int gotoBar) {
		this.loopFrom = gotoBar;
	}

	public void setLoopTo(int i) {
		this.loopTo = i;

	}

	public int getLoopFrom() {
		return loopFrom;
	}

  public void setRoot (MidiPlayerRoot root) {
    this.root = root;
  }

}
