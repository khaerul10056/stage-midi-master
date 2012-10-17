 
package org.mda.commons.ui.config;

import javax.inject.Inject;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

public class ConfigHandler {
	
	
	@Inject
	private ConfigShellBuilder builder;
	
	
	
	@Execute
	public void execute(Shell parentShell) throws ExecutionException{
		builder.build(parentShell);
		
	}
		
}