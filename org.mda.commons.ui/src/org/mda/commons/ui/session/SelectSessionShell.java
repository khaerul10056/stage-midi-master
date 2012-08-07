package org.mda.commons.ui.session;

import javax.inject.Inject;

import mda.Session;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.SessionsContentProvider;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

@Creatable
public class SelectSessionShell {
	
	@Inject
	private ApplicationSession appsession;
	
	private static final Log LOGGER  = LogFactory.getLogger(SelectSessionShell.class);
	
	private Shell shell;
	private List treModel;

	public Shell build (final Shell mother) {
		shell = new Shell (mother);
		shell.setText("Select session...");
		shell.setLayout(new GridLayout());
		shell.setSize(new Point (300, 200));
		treModel = new List(shell, SWT.NONE);
	    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		final ListViewer treviewer = new ListViewer(treModel);
	    treviewer.setContentProvider(new SessionsContentProvider());
	    treviewer.setLabelProvider(new LabelProvider());
	    treviewer.setInput(appsession.getCurrentModel());
	    treModel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				IStructuredSelection selection = (IStructuredSelection) treviewer.getSelection();
				Session firstElement = (Session) selection.getFirstElement();
				LOGGER.info("Select " + firstElement.getName());
				appsession.getModelEvents().setCurrentModelElement(Session.class, firstElement);
				shell.dispose();				
			}
		});
	    
		shell.open();
		return shell;
	}
	
	public Shell getShell () {
		return shell;
	}

}
