package org.mda.imports;




import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.imports.ImportShell;


public class ImportShellTester {
  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = new ApplicationSession();
    session.load(null);
    MidiPlayerRoot model = session.getCurrentModel();

    Shell shell = new Shell();
    ImportShell additionalshell = new ImportShell(shell, (MidiFile) model.getGallery().getGalleryItems().get(0));

    while (!additionalshell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }



}

