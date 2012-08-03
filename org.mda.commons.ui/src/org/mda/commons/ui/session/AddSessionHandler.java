package org.mda.commons.ui.session;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

public class AddSessionHandler {
	
	@Inject
	private AddSessionShell addsessionshell;
	
	@Execute
	public void execute(Shell mother) {
		addsessionshell.build(mother);
	}

}
