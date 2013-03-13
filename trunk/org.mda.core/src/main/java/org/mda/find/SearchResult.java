package org.mda.find;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class SearchResult {
	
	private final String foundString;
	private final EClass clazz;
	private final EObject eobject;

	public SearchResult (EClass clazz, EObject eobject, String foundString) {
		this.clazz = clazz;
		this.eobject = eobject;
		this.foundString = foundString;
		
	}

	public EClass getClazz() {
		return clazz;
	}

	public EObject getEobject() {
		return eobject;
	}

	public String getFoundString() {
		return foundString;
	}

}
