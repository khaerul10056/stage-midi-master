package org.mda.editor.preview.ui.chords;

import junit.framework.Assert;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class ChordHoverTest {

	
	@Test
	public void history () {
		Shell shell = new Shell();
		StyledText styledText = new StyledText(shell, SWT.NONE);
		
		ChordHover hover = new ChordHover(Display.getCurrent().getSystemFont(), styledText, shell.getLocation(), "D");
		hover.save();
		Assert.assertEquals("", hover.getText().trim());
		
		ChordHover hover2 = new ChordHover(Display.getCurrent().getSystemFont(), styledText, shell.getLocation(), "");
		Assert.assertEquals("D", hover2.txtChord.getText().trim());
	}
}
