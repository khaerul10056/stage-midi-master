package org.mda.editor.preview.ui.newpart;

import mda.MidiFile;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class NewPartShellTester {

  private static final Log LOGGER  = LogFactory.getLogger(NewPartShellTester.class);

  /** @param args */
  public static void main (String[] args) throws Exception {
	InjectServiceMock.initialize();
    ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
    session.load(null);
    Shell shell = new Shell();
    MidiFile file = (MidiFile) session.getCurrentModel().getGallery().getGalleryItems().get(0);
    NewPartShell additionalshell = new NewPartShell(shell, file, file.getParts().get(0),new Point (100, 100));

    while (!additionalshell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

    LOGGER.info(MidiPlayerService.toString(file));

  }


}
