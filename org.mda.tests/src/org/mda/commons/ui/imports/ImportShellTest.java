package org.mda.commons.ui.imports;

import mda.MidiFile;
import mda.MidiPlayerRoot;

import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import org.mda.ApplicationSession;

public class ImportShellTest {
	
	@Test
	public void create () {
		
		ApplicationSession session = new ApplicationSession();
	    session.load(null);
	    MidiPlayerRoot model = session.getCurrentModel();

	    Shell shell = new Shell();
	    ImportShell additionalshell = new ImportShell(shell, (MidiFile) model.getGallery().getGalleryItems().get(0));
   	    //TODO checks
	    
	    additionalshell.dispose();
	    
	    
	    
	    

		

		
	}
	
	

}
