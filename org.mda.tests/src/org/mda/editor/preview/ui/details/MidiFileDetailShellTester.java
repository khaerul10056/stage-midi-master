package org.mda.editor.preview.ui.details;

import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;

public class MidiFileDetailShellTester {

  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = new ApplicationSession();
    session.load(null);
    Shell shell = new Shell();
    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
    MidiFileDetailsShell additionalshell = new MidiFileDetailsShell(); 
    additionalshell.build(shell, (MidiFile) root.getGallery().getGalleryItems().get(0));

    while (!additionalshell.getShell().isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
