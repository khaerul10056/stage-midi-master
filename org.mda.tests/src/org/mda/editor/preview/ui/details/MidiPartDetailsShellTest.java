package org.mda.editor.preview.ui.details;

import java.io.File;

import mda.Song;
import mda.MidiPlayerRoot;

import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;

public class MidiPartDetailsShellTest {
	
	@Test
	public void build () {
		ApplicationSession session = new ApplicationSession();
	    session.load(null);
	    Shell shell = new Shell();
	    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
	    Song file = (Song) root.getGallery().getGalleryItems().get(0);
	    MidiPartDetailsShell additionalshell = new MidiPartDetailsShell(); 
	    additionalshell.build(shell, file.getParts().get(0));
	}

}
