package org.mda.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.mda.MidiPlayerService;
import org.mda.ui.util.ScreenComboBoxModel;

public class ConfigurationDialog extends JDialog implements ActionListener {

  /**
   *
   */
  private static final long serialVersionUID = 6075383036770875497L;
  private JComboBox cmbScreenPresentation = new JComboBox();
  private JComboBox cmbScreenAdmin = new JComboBox();
  private JTextField txtExportPathPdf = new JTextField();
  private JButton btnOK = new JButton("OK");
  private JButton btnCancel = new JButton("Cancel");

  private MidiPlayerApplicationFrame applicationFrame;
  private Insets defaultInsets = new Insets(5, 5, 5, 5);

  public ConfigurationDialog (final MidiPlayerApplicationFrame frame) {
    super (frame, "Configuration");
    this.applicationFrame = frame;

    setLayout(new GridBagLayout());
    setSize(600, 400);

    cmbScreenAdmin.setModel(new ScreenComboBoxModel());
    cmbScreenPresentation.setModel(new ScreenComboBoxModel());

    add(new JLabel ("Admin:"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,  defaultInsets, 0, 0));
    add(cmbScreenAdmin, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  defaultInsets, 0, 0));
    add(new JLabel ("Presentation:"), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,  defaultInsets, 0, 0));
    add(cmbScreenPresentation, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  defaultInsets, 0, 0));

    add(new JLabel ("Exportpath PDF:"), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,  defaultInsets, 0, 0));
    add(txtExportPathPdf, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  defaultInsets, 0, 0));

    add(btnOK, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,  defaultInsets, 0, 0));
    add(btnCancel, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,  defaultInsets, 0, 0));
    btnOK.addActionListener(this);
    btnCancel.addActionListener(this);

    txtExportPathPdf.setText(applicationFrame.getRoot().getConfig().getPdfExportPath());
    select(cmbScreenAdmin, applicationFrame.getRoot().getConfig().getScreenIDAdmin());
    select(cmbScreenPresentation, applicationFrame.getRoot().getConfig().getScreenIDPresentation());
    setVisible(true);
  }

  private void select (final JComboBox cmb, final String valueToSelect) {
	  ScreenComboBoxModel model = (ScreenComboBoxModel) cmb.getModel();
	  for (int i = 0; i < model.getSize(); i++) {
		  String next =  (String) model.getElementAt(i);
		  if (next.equals(valueToSelect))
			  cmb.setSelectedIndex(i);
	  }

	  if (cmb.getSelectedItem() == null)
		  cmb.setSelectedIndex(0);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnOK)) {
      if (applicationFrame.getRoot().getConfig() == null)
        applicationFrame.getRoot().setConfig(MidiPlayerService.mf.createConfiguration());
      applicationFrame.getRoot().getConfig().setScreenIDAdmin(cmbScreenAdmin.getSelectedItem().toString());
      applicationFrame.getRoot().getConfig().setScreenIDPresentation(cmbScreenPresentation.getSelectedItem().toString());
      applicationFrame.getRoot().getConfig().setPdfExportPath(txtExportPathPdf.getText());

      MidiPlayerService.saveRootObject(applicationFrame.getRoot());
      setVisible(false);
    }

    if (e.getSource().equals(btnCancel)) {
      setVisible(false);

    }

  }

}
