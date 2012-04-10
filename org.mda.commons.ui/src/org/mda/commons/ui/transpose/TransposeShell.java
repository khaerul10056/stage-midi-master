package org.mda.commons.ui.transpose;

import mda.MidiFile;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.transpose.InvalidChordException;
import org.mda.transpose.Note;
import org.mda.transpose.Scale;
import org.mda.transpose.ScaleStep;
import org.mda.transpose.TransposeService;


public class TransposeShell extends Shell {

  private MidiFile midifile;
  private Combo cmbFrom;
  private Combo cmbTo;
  private ComboViewer viewer1;
  private ComboViewer viewer2;


  private static final Log LOGGER  = LogFactory.getLogger(TransposeShell.class);




  public TransposeShell (Shell shell, final MidiFile file) {
    super (shell);
    setSize(400, 300);
    setText("Transpose song");
    this.midifile = file;
    setLayout(new GridLayout(2, false));

    Label lblSong= new Label (this, SWT.NONE);
    lblSong.setText("Song:");
    lblSong.setLayoutData(getLabelData());

    Label lblSongName = new Label (this, SWT.NONE);
    lblSongName.setText(file.getName());
    lblSongName.setLayoutData(getLabelData());

    Label lblFrom = new Label (this, SWT.NONE);
    lblFrom.setText("From key:");
    lblFrom.setLayoutData(getLabelData());

    cmbFrom = new Combo(this, SWT.NONE);
    viewer1 = new ComboViewer(cmbFrom);
    viewer1.setLabelProvider(new ChordLabelProvider());
    viewer1.setContentProvider(new ChordContentProvider());
    Scale scale = new Scale();
    viewer1.setInput(scale);

    Label lblTo = new Label (this, SWT.NONE);
    lblTo.setText("To key:");
    lblTo.setLayoutData(getLabelData());

    cmbTo = new Combo (this, SWT.NONE);
    viewer2 = new ComboViewer(cmbTo);
    viewer2.setLabelProvider(new ChordLabelProvider());
    viewer2.setContentProvider(new ChordContentProvider());
    viewer2.setInput(new Scale());

    if (midifile.getKey() != null) {
    try {
    Note testNote = Note.valueOf(midifile.getKey());
    if (testNote != null) {
      ScaleStep foundStep = scale.findNote(testNote);
      if (foundStep != null)
        viewer1.setSelection(new StructuredSelection(foundStep));
    }
    } catch  (Exception e) {
      LOGGER.error(e.toString(), e);
    }
    }

    createButtonPanel(this);

    setVisible(true);


  }

  private Note getSelectedChor (ComboViewer viewer) {
    StructuredSelection selection = (StructuredSelection) viewer.getSelection();
    ScaleStep step = (ScaleStep) selection.getFirstElement();
    return step.getNote1();
  }

  private void createButtonPanel (Composite composite) {
    Composite buttonPanel = new Composite(composite, SWT.NONE);
    buttonPanel.setLayout(new RowLayout(SWT.HORIZONTAL));
    Button btnOk = new Button(buttonPanel, SWT.NONE);
    btnOk.setText("Ok");
    btnOk.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected (SelectionEvent arg0) {

        Note fromNote = getSelectedChor(viewer1);
        Note toNote = getSelectedChor(viewer2);

        TransposeService transposeService = new TransposeService();
        try {
          transposeService.transpose(midifile, fromNote, toNote);

          LOGGER.info("Transposed song: " + MidiPlayerService.toString(midifile));
        }
        catch (InvalidChordException e) {
          LOGGER.error(e.toString(), e);
        }

        dispose();

      }
    });

    Button btnCancel = new Button(buttonPanel, SWT.NONE);
    btnCancel.setText("Cancel");
    btnCancel.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected (SelectionEvent arg0) {

        dispose();
      }

    });

  }

  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
  }



  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
