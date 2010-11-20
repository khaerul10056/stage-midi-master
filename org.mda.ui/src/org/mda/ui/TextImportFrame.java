package org.mda.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mda.MidiFile;
import mda.MidiPlayerRoot;

import org.mda.MidiPlayerService;
import org.mda.importer.DefaultTextImporterConfig;
import org.mda.importer.TextImporterConfigIF;
import org.mda.importer.TextImporterService;

public class TextImportFrame extends JDialog implements ActionListener, KeyListener {

	/**
   *
   */
  private static final long serialVersionUID = 8019818253223993147L;

  private MidiFile midifile;

	private JTextArea txtImport = new JTextArea();

	private JButton btnImport = new JButton("Import");
	private JButton btnCancel = new JButton("Cancel");

	private TextImporterConfigIF config = new DefaultTextImporterConfig();

	private DefaultMidiFileContentEditorConfig contentEditorconfig;

	private MidiFileContentEditor previewEditor ;

	public TextImportFrame (final JFrame parent, final MidiFile midifile) {
	  super (parent, "Import text for " + midifile.getName(), true);

	  contentEditorconfig = new DefaultMidiFileContentEditorConfig();
	  contentEditorconfig.setEditable(false);
	  previewEditor = new MidiFileContentEditor(null, null, contentEditorconfig);

		this.midifile = midifile;
		JScrollPane spImportText = new JScrollPane(txtImport, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane spPreviewEditor = new JScrollPane(previewEditor, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setSize(600, 800);
		setLayout(new GridBagLayout());
		add(spImportText, new GridBagConstraints(0, 0, 2, 1, 1, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets (5, 5, 5, 5), 0, 0));
		add(spPreviewEditor, new GridBagConstraints(0, 1, 2, 1, 1, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets (5, 5, 5, 5), 0, 0));
		add(btnImport, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets (5, 5, 5, 5), 0, 0));
		add(btnCancel, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets (5, 5, 5, 5), 0, 0));
		btnCancel.addActionListener(this);
		btnImport.addActionListener(this);
		txtImport.addKeyListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCancel)) {
			setVisible(false);
		}

		if (e.getSource().equals(btnImport)) {

			MidiPlayerRoot root = MidiPlayerService.getRoot(midifile);
			MidiPlayerService.saveRootObject(root);

			setVisible(false);
		}


	}

	@Override
	public void keyTyped(KeyEvent e) {
	  System.out.println ("keyTyped of " + getClass().getName());



	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String[] split = txtImport.getText().split("\n");
		TextImporterService tis = new TextImporterService(Arrays.asList(split), config);
		tis.importText(midifile);
		previewEditor.sessionItemChanged(midifile);

	}

}
