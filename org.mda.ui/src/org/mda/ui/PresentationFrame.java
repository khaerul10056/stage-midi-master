package org.mda.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JFrame;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePartType;
import mda.Session;

import org.mda.MidiPlayer;
import org.mda.MidiPlayerListener;
import org.mda.PlayerMode;

public class PresentationFrame extends JFrame implements MidiPlayerListener {

  /**
   *
   */
  private static final long serialVersionUID = 8919514758061566112L;

  private MidiFileContentShower contentEditor;
  private MidiPlayer player;

  private final HashMap <String, Image> images = new HashMap<String, Image>();

  public PresentationFrame(final GraphicsConfiguration gc, MidiPlayer player) {

    super(gc);
    this.player = player;
    getContentPane().setBackground(Color.BLACK);
    addKeyListener(player);
    //setAlwaysOnTop(true);
    setUndecorated(true);
    setBounds(gc.getBounds());
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    player.addMidiPlayerListener(this);

    contentEditor = new MidiFileContentShower(null, this, player, new PresentationEditorConfig());
    add(contentEditor);
  }

  @Override
  public void sessionItemChanged(AbstractSessionItem newSong) {
  }

  @Override
  public void started() {
    contentEditor.setCurrentBar(0);
    for (AbstractSessionItem nextItem: player.getCurrentSession().getItems()) {
      if (nextItem instanceof MidiFile) {
        MidiFile player = (MidiFile) nextItem;
        String pic = player.getPic();
        if (pic != null) {
          Image createImage = Toolkit.getDefaultToolkit().createImage(pic).getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);
          getImages().put(pic, createImage);
        }
      }
    }
  }

  @Override
  public void stopped() {
    contentEditor.setCurrentBar(-1);
  }

  @Override
  public void modeToggled(PlayerMode chosePlayerMode) {
    if (chosePlayerMode == PlayerMode.PERFORMANCE) {
      setVisible(true);
    }
    else setVisible(false);
  }

  @Override
  public void barChanged(int currentBar) {
    contentEditor.setCurrentBar(currentBar);
    repaint();
  }

  @Override
  public void sessionChanged(Session newSession) {
  }

  public HashMap <String, Image> getImages() {
    return images;
  }

}
