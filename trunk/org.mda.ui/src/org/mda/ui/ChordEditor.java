package org.mda.ui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JTextField;

import org.mda.Chord;
import org.mda.importer.InvalidChordException;

public class ChordEditor extends JDialog implements KeyListener {

  /**
   *
   */
  private static final long serialVersionUID = 681755066251752359L;
  private JTextField txtChord = new JTextField();
  private Chord      chord;

  public ChordEditor(JTextField txtFieldChordLine) {
    super();
    setSize(100, txtFieldChordLine.getSize().height);
    txtChord.setFont(GuiHelper.fontText);
    GuiHelper.layout(txtChord, false);
    setUndecorated(true);
    setModal(true);
    txtChord.addKeyListener(this);
    add(txtChord);
    txtChord.requestFocus();
  }

  public void show(final int x, final int y, Chord chord) {
    this.setChord(chord);
    setLocation(x, y);
    txtChord.setText(chord.toString());
    setVisible(true);
    setBackground(Color.WHITE);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.isConsumed())
      return;

    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      setChord(null);
      setVisible(false);
    } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      try {
        chord = new Chord(txtChord.getText());
        setVisible(false);
      } catch (InvalidChordException e1) {
      }

    }

  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.isConsumed())
      return;
    try {
      getChord().render(txtChord.getText());
      setBackground(Color.WHITE);
    } catch (InvalidChordException e1) {
      setBackground(Color.RED);
      return;
    }
    txtChord.setText(getChord().toString());

  }

  private void setChord(Chord chord) {
    this.chord = chord;
  }

  public Chord getChord() {
    return chord;
  }

}
