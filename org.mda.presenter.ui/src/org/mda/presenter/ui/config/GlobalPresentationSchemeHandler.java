package org.mda.presenter.ui.config;

import javax.inject.Inject;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

public class GlobalPresentationSchemeHandler {

	@Inject
	private GlobalPresentationSchemeShellBuilder shellbuilder;

	@Execute
	public void execute(Shell parentShell) throws ExecutionException {
		Shell build = shellbuilder.build(parentShell);
	}

}