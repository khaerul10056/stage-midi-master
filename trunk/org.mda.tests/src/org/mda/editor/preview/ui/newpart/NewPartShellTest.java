package org.mda.editor.preview.ui.newpart;

import mda.MidiFile;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;

public class NewPartShellTest {
	
	@Test
	public void build () {
		 InjectServiceMock.initialize();
		 ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
		    session.load(null);
		    Shell shell = new Shell();
		    MidiFile file = (MidiFile) session.getCurrentModel().getGallery().getGalleryItems().get(0);
		    NewPartShell additionalshell = new NewPartShell(shell, file, file.getParts().get(0), new Point (100, 100));
		    additionalshell.dispose();
	}

}
