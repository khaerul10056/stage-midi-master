package org.mda.tests;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;

public class TestUtil {
	
	/**
	 * show config page
	 * @param clazz class to show
	 */
	public static void showConfigPage (final Class<? extends IWorkbenchPreferencePage> clazz) {
		InjectServiceMock.initialize();
		ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
		IWorkbenchPreferencePage page = InjectService.getInstance(clazz);
		session.load(null);
		Shell shell = new Shell();
		shell.setLayout(new GridLayout());
		page.createControl(shell);
		shell.setVisible(true);

		while (!shell.isDisposed()) {
			if (!shell.getDisplay().readAndDispatch()) {
				shell.getDisplay().sleep();
			}
		}
	}

}
