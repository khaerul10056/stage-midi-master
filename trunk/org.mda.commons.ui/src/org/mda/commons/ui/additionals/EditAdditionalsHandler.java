 
package org.mda.commons.ui.additionals;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.additionals.AdditionalsHandler;

public class EditAdditionalsHandler {
	@Execute
	public void execute(ApplicationSession appsession) {
		AdditionalsHandler handler = appsession.getAdditionalsHandler();
		new AdditionalShell(new Shell (), handler, null, true);
	}
		
}