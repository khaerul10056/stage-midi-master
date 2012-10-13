package org.mda.presenter.ui.config;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;


public class BooleanStateBuilder extends AbstractDefaultableWidget implements IDefaultableWidget {
	
	private Button btnChecked;
	private Label lblDefaultState;
	
	private final Composite comp;
	
	BooleanStateBuilder (final Composite parent, final String label, String featureID) {
		super.setFeatureId(featureID);
		
		comp = new Composite(parent, SWT.NONE);
		getComp().setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		getComp().setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label lbl = new Label (getComp(), SWT.NONE);
		lbl.setText(label);
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			  toggleDefaultState();
			}
		});
		btnChecked = new Button (getComp(), SWT.CHECK);
 	    lblDefaultState = new Label (getComp(), SWT.NONE);
	}
	
	public void setupDefaultState () {
		if (isDefault()) {
			btnChecked.setEnabled(false);
			btnChecked.setSelection(false);
 		    lblDefaultState.setText("Default = " + getDefaultValue());
		} else  {
			btnChecked.setEnabled(true);
			btnChecked.setSelection((Boolean) getValue());
			  lblDefaultState.setText("");
		}
	}
	
	public void toggleDefaultState () {
		super.toggleDefault();
		setupDefaultState();
	}

	
	
	@Override
	public void load(EObject object, Collection<? extends EObject> defaultObject) {
		super.load(object, defaultObject);
        setupDefaultState();		
	}

	@Override
	public void save() {
		saveImpl(btnChecked.getSelection());
	}

	public Composite getComp() {
		return comp;
	}

	

	

}
