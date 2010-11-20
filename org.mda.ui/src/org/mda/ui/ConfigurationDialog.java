package org.mda.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import org.mda.MidiPlayerService;
import org.mda.ui.util.ScreenComboBoxModel;

public class ConfigurationDialog extends JDialog implements ActionListener {

  /**
   *
   */
  private static final long serialVersionUID = 6075383036770875497L;
  private JComboBox cmbScreenPresentation = new JComboBox();
  private JComboBox cmbScreenAdmin = new JComboBox();
  private JButton btnOK = new JButton("OK");
  private JButton btnCancel = new JButton("Cancel");

  private MidiPlayerApplicationFrame applicationFrame;

  public ConfigurationDialog (final MidiPlayerApplicationFrame frame) {
    super (frame, "Configuration");
    this.applicationFrame = frame;

    setLayout(new GridLayout(3, 2));
    setSize(600, 400);

    cmbScreenAdmin.setModel(new ScreenComboBoxModel());
    cmbScreenPresentation.setModel(new ScreenComboBoxModel());

    add(new JLabel ("Admin:"));
    add(cmbScreenAdmin);
    add(new JLabel ("Presentation:"));
    add(cmbScreenPresentation);
    add(btnOK);
    add(btnCancel);
    btnOK.addActionListener(this);
    btnCancel.addActionListener(this);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnOK)) {
      if (applicationFrame.getRoot().getConfig() == null)
        applicationFrame.getRoot().setConfig(MidiPlayerService.mf.createConfiguration());
      applicationFrame.getRoot().getConfig().setScreenIDAdmin(cmbScreenAdmin.getSelectedItem().toString());
      applicationFrame.getRoot().getConfig().setScreenIDPresentation(cmbScreenPresentation.getSelectedItem().toString());

      MidiPlayerService.saveRootObject(applicationFrame.getRoot());
      setVisible(false);
    }

    if (e.getSource().equals(btnCancel)) {
      setVisible(false);

    }

  }

}
