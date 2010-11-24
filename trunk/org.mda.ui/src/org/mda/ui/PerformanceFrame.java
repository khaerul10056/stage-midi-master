package org.mda.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;

import mda.AbstractSessionItem;
import mda.Session;

import org.mda.MidiPlayer;
import org.mda.MidiPlayerListener;
import org.mda.PlayerMode;

public class PerformanceFrame extends JFrame implements MidiPlayerListener {

	/**
   *
   */
  private static final long serialVersionUID = -6977663670857143518L;

  private MidiFileContentEditor contentEditor;

  public PerformanceFrame (final GraphicsConfiguration gc, MidiPlayer player) {
		super (gc);
		addKeyListener(player);
		getContentPane().setBackground(Color.WHITE);
		//setAlwaysOnTop(true);
		setUndecorated(true);
		setBounds(gc.getBounds());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		player.addMidiPlayerListener(this);
		DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
		config.setEditable(false);
		config.setShowOnlyCurrentPart(true);
		PlaybackMonitor playbackMonitor = new PlaybackMonitor(player);
		contentEditor = new MidiFileContentEditor(null, player, config);
		add(playbackMonitor);
        add(contentEditor);
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




}
