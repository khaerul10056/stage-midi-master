package org.mda.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import mda.AbstractSessionItem;
import mda.Session;

import org.mda.MidiPlayer;
import org.mda.MidiPlayerListener;
import org.mda.PlayerMode;

/**
 * GUI controls for start, stop, previous, next, pan and gain.
 */
public class ItemDetailsPanel extends JPanel implements MidiPlayerListener {

  /**
   *
   */
  private static final long serialVersionUID = -6030576004343098408L;

  private MidiPlayer                  midiPlayer;

  private final MidiFileContentEditor contenteditor;

  private final PlaybackMonitor       playbackMonitor;



  public ItemDetailsPanel(MidiPlayerApplicationFrame application) {
    this.midiPlayer = application.getPlayer();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setEditable(true);

    contenteditor = new MidiFileContentEditor(application, midiPlayer, config);
    playbackMonitor = new PlaybackMonitor(midiPlayer);
    setBackground(Color.BLACK);
    setLayout(new GridBagLayout());
    midiPlayer.addMidiPlayerListener(this);

    add(getContenteditor(), new GridBagConstraints(0, 1, 1, 1, 1d, 1d, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    add(getPlaybackMonitor(), new GridBagConstraints(0, 0, 1, 1, 1d, 0d, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0,100));
  }

  public MidiFileContentEditor getContenteditor() {
    return contenteditor;
  }

  public PlaybackMonitor getPlaybackMonitor() {
    return playbackMonitor;
  }

  @Override
  public void sessionItemChanged(AbstractSessionItem abstractSessionItem) {

  }

  @Override
  public void started() {
    // TODO Auto-generated method stub

  }

  @Override
  public void stopped() {
    // TODO Auto-generated method stub

  }

  @Override
  public void modeToggled(PlayerMode chosePlayerMode) {
    // TODO Auto-generated method stub

  }

  /**
   * renders the details to be called if the content of the current file changes
   */
  public void renderContent() {
    contenteditor.refresh(0);
    playbackMonitor.repaint();
  }

  @Override
  public void barChanged(int currentBar) {
    // TODO Auto-generated method stub

  }

  @Override
  public void sessionChanged(Session newSession) {
    renderContent();
  }

@Override
public void tickChanged(int currentTick) {
	// TODO Auto-generated method stub

}

}
