package org.mda.commons.ui;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class UIHandler4Test extends UIHandler {
	private static final Log LOGGER  = LogFactory.getLogger(ApplicationSession.class);
	
	@Override
	public int showMessageBox (final Shell mother, final int style, final String text) {
		MessageBox messageBox = new MessageBox(mother, style);
	    messageBox.setMessage(text);
	    lastShownMessageBox = messageBox;
	    return SWT.NO;
	}
	
	@Override
	public void launchProgram (final File fileToOpen) {
		//Do nothing by default
		LOGGER.info("Calling default launcher for " + fileToOpen.getAbsolutePath());
		
	}

}
