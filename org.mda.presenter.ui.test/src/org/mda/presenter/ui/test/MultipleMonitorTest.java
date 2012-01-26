package org.mda.presenter.ui.test;

import java.io.File;
import mda.MidiPlayerRoot;
import mda.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.BeamerPresenter;
import org.mda.presenter.ui.DefaultPresentationController;


public class MultipleMonitorTest {

  @Test
  public void test () throws InterruptedException {
    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));

    Session session = root.getSessions().get(0);
    DefaultPresentationController controller = new DefaultPresentationController();
    BeamerPresenter presenter = new BeamerPresenter(Display.getDefault(), session, controller, new DefaultMidiFileContentEditorConfig());


    for (Monitor next: Display.getDefault().getMonitors()) {
      System.out.println ("Monitor " + next.getBounds());
    }

    Thread.sleep(2000);

    System.out.println ("Primary monitor: " + Display.getDefault().getPrimaryMonitor().getBounds());
  }

}
