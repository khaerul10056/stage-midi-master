package org.mda.commons.ui;

import java.io.File;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

@Creatable
public class UIHandler {
	
	public MessageBox lastShownMessageBox;
	
	public int showMessageBox (final Shell mother, final int style, final String text) {
		MessageBox messageBox = new MessageBox(mother, style);
	    messageBox.setMessage(text);
	    lastShownMessageBox = messageBox;
	    return messageBox.open();
	}

	/**
	 * launch the default program for the given file
	 * @param fileToOpen file
	 */
	public void launchProgram (final File fileToOpen) {
		Program.launch(fileToOpen.getAbsolutePath());
	}

}
