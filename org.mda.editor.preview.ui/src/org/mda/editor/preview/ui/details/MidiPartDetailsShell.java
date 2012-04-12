package org.mda.editor.preview.ui.details;

import mda.MidiFilePart;
import mda.MidiFilePartType;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class MidiPartDetailsShell extends Shell {

  private MidiFilePart midifile;

  private Combo cmbType;

  private static final Log LOGGER  = LogFactory.getLogger(MidiFileDetailsShell.class);


  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
  }

  public MidiPartDetailsShell (final Shell shell, final MidiFilePart part) {
    this.midifile = part;
    setSize(500, 700);
    setText("Details of part " + part.getParttype());

    setLayout(new GridLayout(2, false));

    //BackgroundImage
    Label lblPictureText = new Label (this, SWT.NONE);
    lblPictureText.setText("Type:");
    lblPictureText.setLayoutData(getLabelData());

    cmbType = new Combo(this, SWT.NONE);
    GridData cd = getContentData();
    cmbType.setLayoutData(cd);

    final ComboViewer cmbviewer = new ComboViewer(cmbType);
    cmbviewer.setContentProvider(new EnumContentProvider());
    cmbviewer.setLabelProvider(new EnumLabelProvider());
    cmbviewer.setInput(MidiFilePartType.VALUES);
    cmbviewer.setSelection(new StructuredSelection(part.getParttype()));
    cmbviewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged (SelectionChangedEvent arg0) {
        StructuredSelection select = ((StructuredSelection)cmbviewer.getSelection());
        MidiFilePartType selectedType = ((MidiFilePartType)select.getFirstElement());
        part.setParttype(selectedType);

      }
    });



    open ();
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
