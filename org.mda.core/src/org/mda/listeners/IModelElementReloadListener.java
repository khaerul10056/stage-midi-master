package org.mda.listeners;


public interface IModelElementReloadListener {
	
	void reload (final Object newObject, final Object oldObject);
	
	Class<? extends Object> isRelevant ();

}
