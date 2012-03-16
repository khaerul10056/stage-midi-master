package org.mda.editor.preview.ui.newpart;

import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;


public class NewPartShellTester {

  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = MdaModule.getInjector().getInstance(ApplicationSession.class);
    session.load(null);
    Shell shell = new Shell();
    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    MidiFile file = (MidiFile) root.getGallery().getGalleryItems().get(0);
    NewPartShell additionalshell = new NewPartShell(shell, file, file.getParts().get(0));

    while (!additionalshell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

    System.out.println (MidiPlayerService.toString(file));

  }


}
