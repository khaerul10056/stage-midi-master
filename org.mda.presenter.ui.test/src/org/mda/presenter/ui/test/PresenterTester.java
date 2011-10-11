package org.mda.presenter.ui.test;

import java.io.File;
import mda.MidiPlayerRoot;
import mda.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.BeamerPresenter;

public class PresenterTester extends Shell {

  public PresenterTester () {



    setLayout(new GridLayout());
    final Combo cmbSession = new Combo(this, SWT.NONE);
    final Button chkWithChords = new Button (this, SWT.CHECK);
    chkWithChords.setText("Show chords");
    final Button btnOK = new Button(this, SWT.NONE);
    btnOK.setText("Show");

    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    for (Session session : root.getSessions()) {
      cmbSession.add(session.getName());
    }
    cmbSession.select(0);

    final KeyController controller = new KeyController();
    btnOK.addKeyListener(controller);
    btnOK.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected (SelectionEvent e) {
        Session currentSession = root.getSessions().get(cmbSession.getSelectionIndex());

        DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
        config.setChordVisible(chkWithChords.getSelection());

        new BeamerPresenter(Display.getCurrent(), SWT.NONE, currentSession, controller, config);
        btnOK.setFocus();
      }
    });



    setSize(new Point(300, 300));
    setVisible(true);
    setLocation(0, 0);
    open();

    while (!isDisposed()) {
      if (!getDisplay().readAndDispatch()) {
        getDisplay().sleep();
      }
    }
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

  public static void main (String[] args) throws Exception {

    for (Monitor nextMonitor: Display.getDefault().getMonitors()) {
      System.out.println ("Monitor " + nextMonitor.toString() + " - Bounds: " + nextMonitor.getBounds());
    }
    new PresenterTester();
  }

}
