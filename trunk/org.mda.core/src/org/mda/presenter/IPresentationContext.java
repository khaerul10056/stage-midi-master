package org.mda.presenter;

import mda.AbstractSessionItem;
import mda.Session;


public interface IPresentationContext {
	
	Session getCurrentSession ();
	
	AbstractSessionItem getCurrentSessionItem ();

}
