package org.mda.commons.ui.additionals;

import java.io.File;

import mda.AdditionalType;

import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.additionals.AdditionalsHandler;

public class AdditionalShellTest {
	
	@Test
	public void buildOne () {
		AdditionalsHandler handler = new AdditionalsHandler(new File ("tmp"));
		AdditionalShell shell = new AdditionalShell(new Shell (), handler, AdditionalType.AUDIO, true);
		Assert.assertNull (shell.cmbType);
		
	}
	
	@Test
	public void buildAll () {
		AdditionalsHandler handler = new AdditionalsHandler(new File ("tmp"));
		AdditionalShell shell = new AdditionalShell(new Shell (), handler, null, true);
		Assert.assertNotNull (shell.cmbType);
		
	}

}
