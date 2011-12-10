package org.mda.commons.ui;

import mda.MidiFile;
import mda.MidiplayerFactory;
import mda.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class NewSessionPanel extends Shell {
  private Session newSession;

  public NewSessionPanel () {
    setText("Add new session...");
    setSize(600, 400);
    setLayout(new GridLayout(2, false));
    Label label = new Label (this, SWT.NONE);
    label.setText("Name:");

    final Text text = new Text (this, SWT.NONE);
    text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));


    Button buttonOK = new Button(this, SWT.NONE);
    buttonOK.setText("Create");
    buttonOK.setLayoutData(new GridData());
    buttonOK.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        setNewSession(MidiplayerFactory.eINSTANCE.createSession());
        getNewSession().setName(text.getText());
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

  public Session getNewSession () {
    return newSession;
  }

  private void setNewSession (Session newSession) {
    this.newSession = newSession;
  }


}
