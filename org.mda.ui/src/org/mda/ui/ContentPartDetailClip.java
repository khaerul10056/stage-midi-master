package org.mda.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mda.MidiFilePart;
import mda.MidiFilePartType;

public class ContentPartDetailClip extends JDialog implements MouseWheelListener  {

  private MidiFilePart part;

  private JTextField txtBarAssociation = new JTextField ();

  private static HashMap<MidiFilePartType, Color> hicolors = new HashMap<MidiFilePartType, Color>();

  static {
    hicolors.put(MidiFilePartType.VERS, new Color (250, 200, 200));
    hicolors.put(MidiFilePartType.REFRAIN, new Color (200, 250, 200));
    hicolors.put(MidiFilePartType.SOLO, new Color (200, 200, 250));
  }

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public ContentPartDetailClip (final JFrame owner, final MidiFilePart part) {
    super (owner);
    this.part = part;
    setVisible(false);
    setModal(false);

    setUndecorated(true);
    getContentPane().setBackground(getHiColor(part.getParttype()));
    setLayout(new GridBagLayout());
    add(new JLabel ("Bar: "), new GridBagConstraints(0, 0, 1, 1, 0d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets (0,0,0,0), 100, 10));
    add(txtBarAssociation, new GridBagConstraints(1, 0, 1, 1, 1d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets (0,0,0,0), 100, 10));

    txtBarAssociation.setText(String.valueOf(part.getBar()));
    addMouseWheelListener(this);
  }

  private Color getHiColor (final MidiFilePartType parttype) {
    Color color = parttype != null ? hicolors.get(parttype): null;
    return color != null ? color: new Color (250, 250, 250);
  }

  @Override
  public void setVisible(boolean b) {
    if (b == false) {

      if (txtBarAssociation.getText().length() > 0) {
        Integer valueOf = Integer.valueOf(txtBarAssociation.getText());
        part.setBar(valueOf.intValue());
      }

    }
    super.setVisible(b);
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    setVisible(false);

  }








}
