package org.mda.presenter.ui.config;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;



public interface IDefaultableWidget {
	
	void toggleDefault ();
	
	boolean isDefault ();
	
	Object getDefaultValue ();
	
	void load (EObject object, Collection<? extends EObject> defaults);
	
	void save ();
	
	void setFeatureId (String featureID);

}
