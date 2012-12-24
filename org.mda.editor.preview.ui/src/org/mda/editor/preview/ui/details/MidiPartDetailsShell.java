package org.mda.editor.preview.ui.details;

import mda.MidiFilePart;
import mda.MidiFilePartType;

import org.eclipse.e4.core.di.annotations.Creatable;
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

@Creatable
public class MidiPartDetailsShell {


  private Combo cmbType;
  
  private Label lblPosition;

  private Shell shell;
  
  public Shell getShell () {
	  return shell;
  }


  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
  }

  public Shell build (final Shell mother, final MidiFilePart part) {
    shell = new Shell (mother);
    shell.setSize(500, 700);
    shell.setText("Details of part " + part.getParttype());

    shell.setLayout(new GridLayout(2, false));

    //Type
    Label lblType = new Label (shell, SWT.NONE);
    lblType.setText("Type:");
    lblType.setLayoutData(getLabelData());
    cmbType = new Combo(shell, SWT.NONE);
    GridData cd = getContentData();
    cmbType.setLayoutData(cd);
    
    //Bar
    Label lblBar = new Label (shell, SWT.NONE);
    lblBar.setText("Bar:");
    lblBar.setLayoutData(getLabelData());
    lblPosition = new Label(shell,  SWT.NONE); 
    lblPosition.setLayoutData(cd);

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
    lblPosition.setText(part.getPosition());
    shell.open ();
    return shell;
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
