package org.mda.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModelEvents {

	private List<IModelElementReloadListener> modelElementReloadListeners = new ArrayList<IModelElementReloadListener>();

	private HashMap<Class<? extends Object>, Object> currentObjects = new HashMap<Class<? extends Object>, Object>();

	public void addReloadListener(final IModelElementReloadListener listener) {
		modelElementReloadListeners.add(listener);
	}

	public void removeReloadListener(final IModelElementReloadListener listener) {
		modelElementReloadListeners.remove(listener);
	}

	public void setCurrentModelElement(final Class<? extends Object> clazz, final Object newObject) {
		
		Object oldObject = currentObjects.get(clazz);
		currentObjects.put(clazz, newObject);
		
		for (IModelElementReloadListener nextListener: modelElementReloadListeners) {
			if (clazz.equals(nextListener.isRelevant())) {
				nextListener.reload(newObject, oldObject);
			}
		}
	}
	
	public Object getCurrentModelElement (final Class<? extends Object> clazz) {
		return currentObjects.get(clazz);
	}

}
