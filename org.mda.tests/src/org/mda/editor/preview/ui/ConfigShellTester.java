package org.mda.editor.preview.ui;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.config.ConfigShellBuilder;
import org.mda.tests.StandaloneInjector;


public class ConfigShellTester {
  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class);
    session.load(null);
    Shell shell = new Shell();
    ConfigShellBuilder additionalshell = StandaloneInjector.getInstance(ConfigShellBuilder.class);
    Shell configShell = additionalshell.build(shell);

    while (!configShell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
