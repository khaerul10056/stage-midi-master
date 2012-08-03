package org.mda.editor.preview.ui;

import java.io.File;
import mda.MidiPlayerRoot;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.config.ConfigShellBuilder;


public class ConfigShellTester {
  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = new ApplicationSession();
    session.load(null);
    Shell shell = new Shell();
    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    ConfigShellBuilder additionalshell = new ConfigShellBuilder();
    Shell configShell = additionalshell.build(shell);

    while (!configShell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
