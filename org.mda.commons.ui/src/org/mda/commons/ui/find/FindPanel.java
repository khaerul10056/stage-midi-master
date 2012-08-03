package org.mda.commons.ui.find;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FindPanel extends Shell {
	
	public FindPanel (final Shell shell, Composite comp) {
		super (Display.getCurrent().getActiveShell(), SWT.NO_TRIM | SWT.ON_TOP);
		
		setBounds(comp.getBounds().x + comp.getBounds().width -  300, comp.getBounds().y + 100, 500, 200);
		
		
		setLayout(new GridLayout());
		
		setText("Suche...");
		
		
		Text txt = new Text (getShell(), SWT.NONE);
		txt.setText("Suchtext");
		txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		
		addKeyListener(new KeyAdapter() {
			  public void keyPressed(KeyEvent e) {
				  
				  if (e.character == SWT.ESC) {
				    dispose();
				  }
				  
			  }
		  });
		
		setVisible(true);
		forceActive();
		txt.setFocus();
		txt.selectAll();

		
	}

	@Override
	protected void checkSubclass() {
	}
	
	

}
