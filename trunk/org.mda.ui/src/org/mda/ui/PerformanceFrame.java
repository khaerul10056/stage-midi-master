package org.mda.ui;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import mda.AbstractSessionItem;
import mda.Session;

import org.mda.MidiPlayerListener;
import org.mda.PlayerMode;
import org.mda.player.IPlayer;

public class PerformanceFrame extends JFrame implements MidiPlayerListener {

	/**
   *
   */
  private static final long serialVersionUID = -6977663670857143518L;

  private MidiFileContentEditor contentEditor;

  public PerformanceFrame (final GraphicsConfiguration gc, IPlayer player) {
		super (gc);
		addKeyListener(player);
		getContentPane().setBackground(Color.WHITE);
		//setAlwaysOnTop(true);
		setUndecorated(true);
		setBounds(gc.getBounds());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new GridBagLayout());
		player.addMidiPlayerListener(this);
		DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
		config.setEditable(false);
		config.setShowOnlyCurrentPart(true);
		PlaybackMonitor playbackMonitor = new PlaybackMonitor(player);
		contentEditor = new MidiFileContentEditor(null, player, config);
		add(playbackMonitor, new GridBagConstraints(0, 0, 1, 1, 1d, 0d, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0,0));
	    add(contentEditor, new GridBagConstraints(0, 1, 1, 1, 1d, 1d, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}

	@Override
	public void sessionItemChanged (AbstractSessionItem newSong) {
	}

	@Override
	public void started() {
	  contentEditor.setCurrentBar(0);
	}

	@Override
	public void stopped() {
	  contentEditor.setCurrentBar(-1);
	}

	@Override
	public void modeToggled(PlayerMode chosePlayerMode) {
		if (chosePlayerMode == PlayerMode.PERFORMANCE)
			setVisible(true);
		else
			setVisible(false);
	}

  @Override
  public void barChanged(int currentBar) {
    contentEditor.setCurrentBar(currentBar);
    repaint();
  }

  @Override
  public void sessionChanged(Session newSession) {


  }

@Override
public void tickChanged(int currentTick) {
	// TODO Auto-generated method stub

}




}
