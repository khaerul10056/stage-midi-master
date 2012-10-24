package org.mda.editor.preview.ui;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.presenter.ui.config.GlobalPresentationPrefsPage;
import org.mda.tests.StandaloneInjector;


public class ConfigShellTester {
  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class);
    GlobalPresentationPrefsPage page = StandaloneInjector.getInstance(GlobalPresentationPrefsPage.class);
    session.load(null);
    Shell shell = new Shell();
    page.createControl(shell);
    shell.setVisible(true);
    
    while (!shell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
