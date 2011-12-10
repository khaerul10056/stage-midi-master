package org.mda.commons.ui;

import mda.MidiFile;
import mda.MidiplayerFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class NewSongPanel extends Shell {

  private MidiFile newFile;

  public NewSongPanel () {
    setSize(600, 400);
    setText("Add new song...");
    setLayout(new GridLayout(2, false));
    Label label = new Label (this, SWT.NONE);
    label.setText("Name:");

    final Text text = new Text (this, SWT.NONE);
    text.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));

    Button buttonOK = new Button(this, SWT.NONE);
    buttonOK.setText("Create");
    buttonOK.setLayoutData(new GridData());
    buttonOK.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        setNewFile(MidiplayerFactory.eINSTANCE.createMidiFile());
        getNewSong().setName(text.getText());
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
    text.setFocus();
  }

  @Override
  public void checkSubclass () {

  }

  public MidiFile getNewSong () {
    return newFile;
  }

  private void setNewFile (MidiFile newFile) {
    this.newFile = newFile;
  }

}
