package org.mda.commons.ui.session;

import javax.inject.Inject;

import mda.Session;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;

@Creatable
public class AddSessionShell {
	
	@Inject
	private ApplicationSession appsession;
	
	private final String DEFAULT = "<new session>";
	
	private Shell shell;

	public Shell build (final Shell mother) {
		shell = new Shell (mother);
		shell.setText("New session...");
		shell.setLayout(new GridLayout());
		shell.setSize(new Point (300, 100));
		
		final Text txtName = new Text (shell, SWT.NONE);
		txtName.setText(DEFAULT);
		txtName.selectAll();
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		txtName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.character == SWT.CR && txtName.getText().compareTo(DEFAULT) != 0) {
					Session createdSession = MidiPlayerService.createSession (appsession.getCurrentModel(), txtName.getText());
					appsession.setCurrentSession(createdSession);
					appsession.getModelEvents().setCurrentModelElement(Session.class, createdSession);
					getShell().dispose();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
	    
	    
		
		shell.open();
		return shell;
	}
	
	public Shell getShell () {
		return shell;
	}

}
