package org.mda.export;

import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;

public class ExportPdfSessionHandlerTest {
	
	@Test
	public void call () {
		
		 InjectServiceMock.initialize(); 
		 
		
		 ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
		 session.load(null);
		 
		 session.setCurrentSession(session.getCurrentModel().getSessions().get(0));
		 Shell shell = new Shell();
		    
		 ExportPdfSessionHandler handler = InjectService.getInstance(ExportPdfSessionHandler.class);
		 handler.execute(shell);
		 
		 Assert.assertNotNull (handler.getUiHandler().lastShownMessageBox);
		 shell.dispose();

		
	}

}
