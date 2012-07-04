package org.mda.presenter.ui.test;

import java.util.ArrayList;
import java.util.List;
import mda.MidiPlayerRoot;
import mda.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.BeamerPresenter;
import org.mda.presenter.ui.MdaPresenterModule;
import org.mda.presenter.ui.PresentationContext;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;

public class PresenterTester extends Shell {

  final List <Point> sizes = new ArrayList<Point>();

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  public PresenterTester () {
    setLayout(new GridLayout());
    sizes.add(new Point (1400, 1050));
    sizes.add(new Point(1280, 900));
    sizes.add(new Point(1152, 864));
    sizes.add(new Point(1024, 768));
    sizes.add(new Point(800, 600));

    final Combo cmbSession = new Combo(this, SWT.NONE);

    final Button chkWithChords = new Button (this, SWT.CHECK);
    chkWithChords.setText("Show chords");

    final Button chkWithBackground = new Button (this, SWT.CHECK);
    chkWithBackground.setText("Show background");

    final Button chkWithBlocktypes = new Button (this, SWT.CHECK);
    chkWithBlocktypes.setText("Show blocktypes");

    final Combo cmbSize = new Combo(this, SWT.NONE);
    for (Point next: sizes) {
      cmbSize.add(next.toString());
    }
    cmbSize.select(0);

    final Button btnOK = new Button(this, SWT.NONE);
    btnOK.setText("Show");

    ApplicationSession appsession = MdaModule.getInjector().getInstance(ApplicationSession.class);
    appsession.load("../org.mda.core.test/testdata/testmodel.conf");

    final MidiPlayerRoot root = appsession.getCurrentModel();
    for (Session session : root.getSessions()) {
      cmbSession.add(session.getName());
    }
    cmbSession.select(0);


    btnOK.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected (SelectionEvent e) {

        Point size = sizes.get(cmbSize.getSelectionIndex());
        Session currentSession = root.getSessions().get(cmbSession.getSelectionIndex());

        DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
        config.setChordVisible(chkWithChords.getSelection());
        config.setShowBackground(chkWithBackground.getSelection());
        config.setShowBlockType(chkWithBlocktypes.getSelection());

        PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
        presentationContext.setCurrentSession(currentSession, config, size);

        final GlobalKeyRegistryPresentationController globalKeyRegPresentationController = new GlobalKeyRegistryPresentationController(getDisplay());
        presentationContext.registerController(globalKeyRegPresentationController);

        BeamerPresenter beamerPresenter = new BeamerPresenter(Display.getCurrent(), currentSession, false, null);
        presentationContext.registerController(globalKeyRegPresentationController);
        presentationContext.registerView(beamerPresenter);

        beamerPresenter.addDisposeListener(new DisposeListener() {

          @Override
          public void widgetDisposed (DisposeEvent arg0) {
               globalKeyRegPresentationController.close();
          }
        });

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
    new PresenterTester();
  }

}
