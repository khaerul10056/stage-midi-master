package org.mda.editor.preview.ui.details;

import mda.MidiFile;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;

public class MidiFileDetailShellTester {

  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = new ApplicationSession();
    session.load(null);
    Shell shell = new Shell();
    MidiFileDetailsShell additionalshell = new MidiFileDetailsShell(); 
    additionalshell.build(shell, (MidiFile) session.getCurrentModel().getGallery().getGalleryItems().get(0));

    while (!additionalshell.getShell().isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
