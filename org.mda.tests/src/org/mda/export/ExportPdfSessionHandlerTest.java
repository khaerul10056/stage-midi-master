package org.mda.export;

import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.tests.StandaloneInjector;

public class ExportPdfSessionHandlerTest {
	
	@Test
	public void call () {
		
		 ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class);
		 session.load(null);
		 
		 session.setCurrentSession(session.getCurrentModel().getSessions().get(0));
		 Shell shell = new Shell();
		    
		 ExportPdfSessionHandler handler = StandaloneInjector.getInstance(ExportPdfSessionHandler.class);
		 handler.execute(shell,  session);
		 
		 Assert.assertNotNull (handler.uihandler.lastShownMessageBox);
		 shell.dispose();

		
	}

}
