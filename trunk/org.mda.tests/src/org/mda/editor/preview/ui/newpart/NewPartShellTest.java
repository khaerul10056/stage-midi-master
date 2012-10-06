package org.mda.editor.preview.ui.newpart;

import mda.MidiFile;

import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.tests.StandaloneInjector;

public class NewPartShellTest {
	
	@Test
	public void build () {
		 ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class);
		    session.load(null);
		    Shell shell = new Shell();
		    MidiFile file = (MidiFile) session.getCurrentModel().getGallery().getGalleryItems().get(0);
		    NewPartShell additionalshell = new NewPartShell(shell, file, file.getParts().get(0));
		    additionalshell.dispose();
	}

}
