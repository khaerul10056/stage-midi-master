package org.mda.presenter.ui.config;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class AbstractDefaultableWidget implements IDefaultableWidget {
	
	private String featureId;
	
	protected EObject eobject;
	
	protected Collection<? extends EObject> defaultobjects;

	@Override
	public void toggleDefault() {
		if (isDefault()) {
	      eobject.eSet(getFeature(), getDefaultValue());		
		}
		else
   		  eobject.eSet(getFeature(), null);
	}
	
	public boolean isDefault () {
		return ! eobject.eIsSet(getFeature());
	}
	
	
	public Object getDefaultValue () {
		for (EObject scheme: defaultobjects) {
			EStructuralFeature feature = getFeature();
			if (scheme != null && scheme.eIsSet(feature))
			  return scheme.eGet(feature);
		}
		return null;
	}
	
	public Object getValue () {
		return eobject.eGet(getFeature());
	}
	
	
	protected EStructuralFeature getFeature () {
		return eobject.eClass().getEStructuralFeature(featureId);
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureID) {
		this.featureId = featureID;
	}

	@Override
	public void load(EObject object, Collection<? extends EObject> defaultObjects) {
		this.eobject = object;		
		this.defaultobjects = defaultObjects;
	}
	
	public void saveImpl (Object object) {
		if (isDefault())
			eobject.eUnset(getFeature());
		else
		  eobject.eSet(getFeature(), object);
	}

	

}
