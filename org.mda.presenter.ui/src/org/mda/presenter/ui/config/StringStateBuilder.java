package org.mda.presenter.ui.config;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class StringStateBuilder extends AbstractDefaultableWidget implements IDefaultableWidget {
	
	private Text txtValue;
	private Label lblDefaultInfo;
	
	private final Composite comp;
	
	StringStateBuilder (final Composite parent, final String label, String featureID) {
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
		txtValue = new Text(getComp(), SWT.CHECK);
		lblDefaultInfo = new Label (getComp(), SWT.NONE);
		
	}
	
	public void setupDefaultState () {
		if (isDefault()) {
			txtValue.setEnabled(false);
			txtValue.setText("");
			lblDefaultInfo.setText("Default is " + getDefaultValue());
		} else  {
			txtValue.setEnabled(true);
			txtValue.setText(toString(getValue()));
			lblDefaultInfo.setText("");
		}
	}
	
	private String toString (final Object object) {
		if (object instanceof Integer)
			return ((Integer) object).toString();
		throw new IllegalStateException("toString not implemented for type " + object.getClass().getName());
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
		saveImpl(txtValue.getText());
	}

	public Composite getComp() {
		return comp;
	}
	
	@Override
	public void saveImpl (Object object) {
		
		Object newObject = null;
		String newValue = (String) object;
		String name = getFeature().getEType().getName();
		if (name.equals("EIntegerObject") && newValue.trim().length() > 0)
			newObject = new Integer(newValue);
		
		if (newObject != null)
  		  super.saveImpl(newObject);
	}

	

	

}

