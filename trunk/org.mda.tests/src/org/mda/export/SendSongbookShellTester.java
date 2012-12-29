package org.mda.export;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.config.SendSongbooksShell;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;

public class SendSongbookShellTester {
	
	  public static void main (String[] args) throws Exception {
		InjectServiceMock.initialize();
	    ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
	    session.load(null);
	    Shell shell = new Shell();
	    SendSongbooksShell additionalshell = InjectService.getInstance(SendSongbooksShell.class);
	    Shell configShell = additionalshell.build(shell);

	    while (!configShell.isDisposed()) {
	      if (!shell.getDisplay().readAndDispatch()) {
	        shell.getDisplay().sleep();
	      }
	    }

	  }

	


}
