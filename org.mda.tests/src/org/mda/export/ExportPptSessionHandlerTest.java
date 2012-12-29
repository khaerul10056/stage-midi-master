package org.mda.export;

import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;

public class ExportPptSessionHandlerTest {
	
	@Test
	public void call () {
		 InjectServiceMock.initialize();
		
		 ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
		 session.load(null);
		 
		 session.setCurrentSession(session.getCurrentModel().getSessions().get(0));
		 Shell shell = new Shell();
		    
		 ExportPptSessionHandler handler = InjectService.getInstance(ExportPptSessionHandler.class);
		 handler.execute(shell);
		 
		 Assert.assertNotNull (handler.getUiHandler().lastShownMessageBox);
		 shell.dispose();

		
	}

}
