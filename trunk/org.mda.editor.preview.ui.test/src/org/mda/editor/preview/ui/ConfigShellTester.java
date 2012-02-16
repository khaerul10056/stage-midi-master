package org.mda.editor.preview.ui;

import java.io.File;
import mda.MidiPlayerRoot;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.config.ConfigShell;


public class ConfigShellTester {
  /** @param args */
  public static void main (String[] args) throws Exception {
    MdaModule module = new MdaModule();
    ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);
    session.load(null);
    Shell shell = new Shell();
    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    ConfigShell additionalshell = new ConfigShell(shell, root.getConfig());

    while (!additionalshell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
