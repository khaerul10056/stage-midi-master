package org.mda.presenter;

import mda.AbstractSessionItem;
import mda.Session;

import org.eclipse.e4.core.di.annotations.Creatable;

@Creatable
public interface IPresentationContext {
	
	Session getCurrentSession ();
	
	AbstractSessionItem getCurrentSessionItem ();

}
