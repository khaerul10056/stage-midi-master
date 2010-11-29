package org.mda;

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
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Transmitter;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import mda.Session;

public class MidiPlayer implements Runnable, LineListener, MetaEventListener, KeyListener {

  private MidiPlayerRoot           root       = null;

  private List<MidiPlayerListener> listeners  = new ArrayList<MidiPlayerListener>();

  private Thread                   thread;
  private Sequencer                sequencer;
  private Sequence                 currentSequence;
  private int                      currentSongIndex;
  private PlayerMode               playerMode = PlayerMode.PROBE;
  private int loopFrom =0;
  private int loopTo = -1;

private boolean shouldStepToNext;

private boolean stoppedByEvent;

private int newTick;

private int currentTick;

  public MidiPlayer(MidiPlayerRoot root) {
    setRoot(root);
  }

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
    thread = new Thread(this);
    thread.setName("Juke");
    thread.start();
  }

  public PlayerMode getPlayerMode() {
    return playerMode;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_DOWN && e.isShiftDown()) {
      moveSongDown();
      e.consume();


    } else if (e.getKeyChar() == '1') {
    	 togglePlayingCurrentSong();
         e.consume();
    }else if (e.getKeyChar() == ' ') {
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
    } else if (e.getKeyCode() == KeyEvent.VK_F9) {
      PlayerMode[] modes = PlayerMode.values();
      for (int i = 0; i < modes.length; i++) {
        if (modes[i] == playerMode) {
          if (i < modes.length - 1)
            playerMode = modes[i + 1];
          else playerMode = modes[0];
          break;
        }
      }

      for (MidiPlayerListener listener : listeners) {
        listener.modeToggled(playerMode);
      }
      e.consume();
    }

  }

  public void addMidiPlayerListener(final MidiPlayerListener listener) {
    listeners.add(listener);
  }

  public void assignCurrentSong () throws Exception {
    String completeFile = getCurrentMidifile().getPath() + "/" + getCurrentMidifile().getName();
    currentSequence = MidiSystem.getSequence(new File(completeFile));

    System.out.println("Setze Sequence " + currentSequence + "(" + completeFile + ")");
		if (getSequencer() != null) {
			getSequencer().open();
			getSequencer().setSequence(currentSequence);
		}

  }

  public void run() {
      if (isSessionListEmpty()) return;

      try {

    	  if (shouldStepToNext == true) {
    		  shouldStepToNext = false;
    		  currentSongIndex ++;
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
        System.out.println ("Current position initialized pre start to bar " + sequencer.getTickPosition() + "(" + getSequencer().getTickLength() + ")");
        getSequencer().start();
        System.out.println ("Current position initialized after start to bar " + sequencer.getTickPosition());
      }

      //Jump to a several tick
      if (getLoopFrom() >= 0) {

    	  if (getSequencer() != null)
            getSequencer().setTickPosition(berechnePosition(getLoopFrom()));

        for (MidiPlayerListener listener : listeners)
          listener.barChanged(getCurrentBar());
      }



      for (MidiPlayerListener listener : listeners)
        listener.started();

      while (isRunning()) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          break;
        }
        
        newTick = getCurrentTick();
        if (newTick != currentTick) {
        	currentTick = newTick; 
        	for (MidiPlayerListener listener : listeners)
        		listener.tickChanged (currentTick);
        }

        newBar = getCurrentBar();
        if (newBar != currentBar) {
          currentBar = newBar;
          for (MidiPlayerListener listener : listeners)
            listener.barChanged(currentBar);
        }

      }

      stop();

      shouldStepToNext = ! stoppedByEvent;
      stoppedByEvent = false;




  }

  public void setSequencer(Sequencer sequencer) {
    this.sequencer = sequencer;
  }

  public Sequencer getSequencer() {
    return sequencer;
  }

  public boolean isRunning() {
    return getSequencer() != null && getSequencer().isRunning();
  }

  public void playNextSong() {
    if (!isSessionListEmpty() && currentSongIndex < getCurrentSession().getItems().size() - 1) {
      boolean currentlyRunning = isRunning();
      stop();
      currentSongIndex += 1;

      for (MidiPlayerListener listener : listeners)
        listener.sessionItemChanged(getCurrentMidifile());

      if (currentlyRunning) start();
    }
  }

  public boolean isSessionListEmpty() {
    return getCurrentSession() == null || getCurrentSession().getItems().size() == 0;
  }

  public Session getCurrentSession() {

    if (root.getConfig() != null && root.getConfig().getLastSession() != null)
      return root.getConfig().getLastSession();

    if (root.getSessions().size() == 0) return null;

    return root.getSessions().get(0);
  }

  public void setRoot(MidiPlayerRoot root) {
    this.root = root;
  }

  public MidiPlayerRoot getRoot() {
    return root;
  }

  private final static String normalizeName(final String name) {

    if (name == null) return "<k.A.>";

    if (name.indexOf(".") >= 0)
      return name.substring(0, name.indexOf("."));
    else return name;
  }

  public void togglePlayingCurrentSong() {
    /**for (MidiPlayerListener listener : listeners)
      listener.sessionItemChanged(getCurrentMidifile());**/

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

      if (currentlyRunning) start();
    }
  }

  public void replayCurrentSong() {
    stop();
    start();
  }

  public String getNameOf(int index) {
    if (isSessionListEmpty() || getCurrentSongIndex() < 0) return "";

    return normalizeName(getCurrentSession().getItems().get(index).getName());

  }

  public String getCurrentName() {
    return getNameOf(getCurrentSongIndex());
  }

  public String getCurrentPositionInSong() {
    if (getSequencer() != null && getSequencer().getSequence() != null) {
      return "" + getCurrentBar();
    }

    return "";

  }

  public int getCurrentTick() {
    if (getSequencer() != null && getSequencer().getSequence() != null) {
      if (getSequencer().getSequence().getDivisionType() == Sequence.PPQ) {
        int resolution = getSequencer().getSequence().getResolution();
        int bar = ((int) (getSequencer().getTickPosition() / resolution) % 4);
        return bar;

      } else return 0;
    }
    return 0;
  }

  public int berechnePosition (final int bar) {
    return bar * 4 * getSequencer().getSequence().getResolution();
  }

  public int getCurrentBar() {
    if (getSequencer() != null && getSequencer().getSequence() != null) {
      if (getSequencer().getSequence().getDivisionType() == Sequence.PPQ) {
        int resolution = getSequencer().getSequence().getResolution() * 4;
        int bar = (int) (getSequencer().getTickPosition() / resolution) + 1;
        return bar;

      } else return 0;
    }
    return 0;
  }

  public int getMaxBar() {
    if (getSequencer() != null && getSequencer().getSequence() != null) {
      if (getSequencer().getSequence().getDivisionType() == Sequence.PPQ) {
        int resolution = getSequencer().getSequence().getResolution() * 4;
        int bar = (int) (getSequencer().getTickLength() / resolution) + 1;
        return bar;

      } else return 0;
    }
    return 0;
  }

  public void moveSongUp() {
    if (!isRunning() && playerMode == PlayerMode.PROBE && currentSongIndex > 0) {
      AbstractSessionItem abstractSessionItem = getCurrentSession().getItems().get(currentSongIndex);
      getCurrentSession().getItems().remove(currentSongIndex);
      currentSongIndex--;
      getCurrentSession().getItems().add(currentSongIndex, abstractSessionItem);

      for (MidiPlayerListener listener : listeners)
        listener.sessionItemChanged(getCurrentMidifile());

      MidiPlayerService.saveRootObject(root);
    }
  }

  public void moveSongDown() {
    if (!isRunning() && playerMode == PlayerMode.PROBE && currentSongIndex < getCurrentSession().getItems().size() - 1) {
      AbstractSessionItem abstractSessionItem = getCurrentSession().getItems().get(currentSongIndex);
      getCurrentSession().getItems().remove(currentSongIndex);
      currentSongIndex++;
      getCurrentSession().getItems().add(currentSongIndex, abstractSessionItem);

      for (MidiPlayerListener listener : listeners)
        listener.sessionItemChanged(getCurrentMidifile());

      MidiPlayerService.saveRootObject(root);
    }
  }

  public MidiFile getCurrentMidifile() {
    AbstractSessionItem sessionItem = getCurrentSession().getItems().get(getCurrentSongIndex());
    if (sessionItem instanceof MidiFile)
      return (MidiFile) sessionItem;
    else return null;
  }

  public void setCurrentSession (final Session session) {

    root.getConfig().setLastSession(session);

    for (MidiPlayerListener listener : listeners)
      listener.sessionChanged(session);

  }

  public void setCurrentSong(int currentPosition) {
    if (getCurrentSession().getItems().size() == 0 )
      return;

    this.currentSongIndex = currentPosition;

    for (MidiPlayerListener listener : listeners)
      listener.sessionItemChanged(getCurrentSession().getItems().get(getCurrentSongIndex()));

  }

  public int getCurrentSongIndex() {
    return currentSongIndex;
  }

  public void stop() {
    if (isRunning()) {
      getSequencer().stop();

      for (MidiPlayerListener listener : listeners)
        listener.stopped();

    }
    thread = null;
  }

  public void open() {
    try {

      Info[] midiDeviceInfo = MidiSystem.getMidiDeviceInfo();
      for (int i = 0; i < midiDeviceInfo.length; i++) {
        System.out.println("Device:" + midiDeviceInfo[i].getName() + " + " + midiDeviceInfo[i].getDescription() + "\n");
      }

      MidiDevice midiDevice = MidiSystem.getMidiDevice(midiDeviceInfo[1]);
      midiDevice.open();
      setSequencer(MidiSystem.getSequencer());
      Transmitter trans = getSequencer().getTransmitter();
      getSequencer().open();

      // connect sequencer and midi out device
      trans.setReceiver(midiDevice.getReceiver());


    } catch (Exception ex) {
      ex.printStackTrace();
      // System.exit(1);
    }
    if (getSequencer() != null) getSequencer().addMetaEventListener(this);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println ("keyTyped of " + getClass().getName());


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



}
