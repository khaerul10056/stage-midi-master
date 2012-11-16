 
package org.mda.commons.ui.session;


import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;
import org.mda.inject.InjectService;

import com.google.inject.Inject;

public class SelectSessionHandler {
	
	@Inject
	private SelectSessionShell selectsessionshell;
	
	@Execute
	public void execute(Shell mother) {
		InjectService.injectObject(this);
		selectsessionshell.build(mother);
	}
		
}