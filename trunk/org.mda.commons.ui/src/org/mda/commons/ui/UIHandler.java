package org.mda.commons.ui;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

@Creatable
public class UIHandler {
	
	public MessageBox showMessageBox (final Shell mother, final int style, final String text) {
		MessageBox messageBox = new MessageBox(mother, style);
	    messageBox.setMessage(text);
	    messageBox.open();
	    return messageBox;
	}

}
