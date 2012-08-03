package org.mda.commons.ui.find;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.mda.commons.ui.Util;

@Creatable
public class SearchEnginePanel  {
	
	public Shell build () {
		final Shell shell = new Shell (Display.getCurrent().getActiveShell(), SWT.NO_TRIM | SWT.ON_TOP);
		shell.setSize(700, 400);
		shell.setLocation(new Point (20, 120));
		
		shell.setLayout(new GridLayout());
		
		Color colorGrey = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY);
		
		shell.setText("Suche...");
		shell.setBackground(colorGrey);
		
		Text txt = new Text (shell, SWT.NONE);
		txt.setText("Suchtext");
		txt.setBackground(colorGrey);
		txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		
		shell.addKeyListener(new KeyAdapter() {
			  public void keyPressed(KeyEvent e) {
				  
				  if (e.character == SWT.ESC) {
					  shell.dispose();
				  }
				  
			  }
		  });
		
		shell.setVisible(true);
		shell.forceActive();
		txt.setFocus();
		txt.selectAll();
		
		return shell;
	}

}
