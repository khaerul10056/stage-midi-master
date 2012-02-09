package org.mda.editor.preview.ui.details;

import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;

public class MidiFileDetailShellTester {

  /** @param args */
  public static void main (String[] args) throws Exception {
    MdaModule module = new MdaModule();
    ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);
    session.load(null);
    Shell shell = new Shell();
    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    MidiFileDetailsShell additionalshell = new MidiFileDetailsShell(shell, (MidiFile) root.getGallery().getGalleryItems().get(0));

    while (!additionalshell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
