package org.mda.presenter.ui.config;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

@Creatable
public class BooleanStateBuilder {
	
	private Boolean thisvalue;
	private Button btnChecked;
	private Boolean defaultvalue;
	
	Composite build (final Composite parent, final String label) {
		
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		comp.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label lbl = new Label (comp, SWT.NONE);
		lbl.setText(label);
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				toggleDefaultState();
			}
		});
		btnChecked = new Button (comp, SWT.CHECK);
		setupDefaultState();
		
		
		return comp;
	}
	
	public void setupDefaultState () {
		if (getThisvalue() == null) {
			btnChecked.setEnabled(false);
		} else  {
			btnChecked.setEnabled(true);
		}
		
		
	}
	
	public void toggleDefaultState () {
		if (getThisvalue() == null) {
			setThisvalue(Boolean.valueOf(! getDefaultvalue().booleanValue()));
		}
		else {
			setThisvalue(null);
		}
		
		setupDefaultState();
	}

	public Boolean getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(Boolean defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public Boolean getThisvalue() {
		return thisvalue;
	}

	public void setThisvalue(Boolean thisvalue) {
		this.thisvalue = thisvalue;
	}

}
