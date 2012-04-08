package org.mda.editor.preview.ui;

import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.transpose.TransposeShell;


public class TransposeShellTester {

  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = MdaModule.getInjector().getInstance(ApplicationSession.class);
    session.load(null);
    Shell shell = new Shell();
    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
    TransposeShell additionalshell = new TransposeShell(shell, (MidiFile) root.getGallery().getGalleryItems().get(0));

    while (!additionalshell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
