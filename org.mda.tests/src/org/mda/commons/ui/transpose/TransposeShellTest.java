package org.mda.commons.ui.transpose;

import mda.Song;
import mda.MidiPlayerRoot;

import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;

public class TransposeShellTest {
	
	@Test
	public void build () {
		
		ApplicationSession session = new ApplicationSession();
	    session.load(null);
	    MidiPlayerRoot model = session.getCurrentModel();
	    
	    Song midifile = ((Song)model.getGallery().getGalleryItems().get(0));
	    midifile.setKey("A");

	    Shell shell = new Shell();
	    TransposeShell additionalshell = new TransposeShell(shell, midifile);
	    
	    
	    Assert.assertEquals ("Defaultvalue cmbFrom invalid", "A", additionalshell.cmbFrom.getText());
	    
	    additionalshell.dispose();
		
	}

}
