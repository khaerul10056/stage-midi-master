package org.mda.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SongDetailDialog extends JDialog implements ActionListener {

  private JTextField txtImage;
  private JTextField txtFontSize;

  private JButton btnOK = new JButton("OK");
  private JButton btnCancel = new JButton("Cancel");

  private MidiPlayerApplicationFrame appframe;

  public SongDetailDialog (final MidiPlayerApplicationFrame appframe) {
    super (appframe, "Song-Details", true);
    this.appframe = appframe;
    setLayout(new GridBagLayout());

    txtImage = new JTextField();
    add(new JLabel ("Image: "), new GridBagConstraints(0, 0, 1, 1, 0d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets (0,0,0,0), 100, 10));
    add(txtImage, new GridBagConstraints(1, 0, 1, 1, 1d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets (0,0,0,0), 100, 10));

    txtFontSize = new JTextField();
    add(new JLabel ("FontSize: "), new GridBagConstraints(0, 1, 1, 1, 0d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets (0,0,0,0), 100, 10));
    add(txtFontSize, new GridBagConstraints(1, 1, 1, 1, 1d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets (0,0,0,0), 100, 10));

    txtImage.setText(appframe.getPlayer().getCurrentMidifile().getPic());
    txtFontSize.setText(appframe.getPlayer().getCurrentMidifile().getFontsize());

    add(btnOK);
    add(btnCancel);
    btnOK.addActionListener(this);
    btnCancel.addActionListener(this);
    setSize(400, 300);
    setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnOK)) {
      appframe.getPlayer().getCurrentMidifile().setPic(txtImage.getText());
      appframe.getPlayer().getCurrentMidifile().setFontsize(txtFontSize.getText());
      setVisible(false);
    }

    if (e.getSource().equals(btnCancel)) {
      setVisible(false);
    }

  }

}
