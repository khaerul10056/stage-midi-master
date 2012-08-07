package org.mda.commons.ui;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Singleton;

import mda.MidiFile;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.mda.ApplicationSession;


public class SongSelectorPanel extends Shell {

  private final Table table;

  @Singleton
  private ApplicationSession  appSession;

  private Collection <MidiFile> selectedfiles = new ArrayList<MidiFile>();

  public SongSelectorPanel () {
    setLayout(new GridLayout(2, true));
    table = new Table (this, SWT.MULTI);
    setSize(new Point (500, 900));
    getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

    final TableViewer tableviewer = new TableViewer(getTable());
    tableviewer.setContentProvider(new ContentProvider());
    tableviewer.setLabelProvider(new LabelProvider());
    tableviewer.setInput(appSession.getCurrentModel().getGallery());
    setText("Select song from gallery");


    Button buttonOK = new Button(this, SWT.NONE);
    buttonOK.setText("Select");
    buttonOK.setLayoutData(new GridData());
    buttonOK.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        IStructuredSelection selection = (IStructuredSelection) tableviewer.getSelection();
        for (Object next : selection.toArray()) {
          if (next instanceof MidiFile) {
              selectedfiles.add((MidiFile) next);
          }
        }
        dispose();
      }
    });

    Button buttonCancel = new Button(this, SWT.NONE);
    buttonCancel.setText("Cancel");
    buttonCancel.setLayoutData(new GridData());
    buttonCancel.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        dispose();
      }
    });

    setEnabled(true);
    setVisible(true);
    selectedfiles.clear();
  }

  @Override
  public void checkSubclass () {

  }



  public Collection <MidiFile> getSelectedSongs () {
    return selectedfiles;
  }

  public Table getTable () {
    return table;
  }

}
