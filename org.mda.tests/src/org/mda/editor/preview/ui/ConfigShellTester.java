package org.mda.editor.preview.ui;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.presenter.ui.config.GlobalPresentationPrefsPage;


public class ConfigShellTester {
  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
    GlobalPresentationPrefsPage page = InjectService.getInstance(GlobalPresentationPrefsPage.class);
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
