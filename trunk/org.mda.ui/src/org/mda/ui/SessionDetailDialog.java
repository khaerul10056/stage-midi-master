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

public class SessionDetailDialog extends JDialog implements ActionListener {

  private JTextField txtName;

  private JButton btnOK = new JButton("OK");
  private JButton btnCancel = new JButton("Cancel");

  private MidiPlayerApplicationFrame appframe;

  public SessionDetailDialog (final MidiPlayerApplicationFrame appframe) {
    super (appframe, "Session-Details", true);
    this.appframe = appframe;
    setLayout(new GridBagLayout());

    txtName = new JTextField();
    add(new JLabel ("Name: "), new GridBagConstraints(0, 0, 1, 1, 0d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets (0,0,0,0), 100, 10));
    add(txtName, new GridBagConstraints(1, 0, 1, 1, 1d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets (0,0,0,0), 100, 10));

    txtName.setText(appframe.getPlayer().getCurrentSession().getName());

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
      appframe.getPlayer().getCurrentSession().setName(txtName.getText());
      setVisible(false);
    }

    if (e.getSource().equals(btnCancel)) {
      setVisible(false);
    }

  }

}
