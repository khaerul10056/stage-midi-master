package org.mda.commons.ui.session;


import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;
import org.mda.inject.InjectService;

import com.google.inject.Inject;

public class AddSessionHandler {
	
	@Inject
	private AddSessionShell addsessionshell;
	
	@Execute
	public void execute(Shell mother) {
		InjectService.injectObject(this);
		addsessionshell.build(mother);
	}

}
