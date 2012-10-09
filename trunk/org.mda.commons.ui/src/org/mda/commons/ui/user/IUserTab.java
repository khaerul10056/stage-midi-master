package org.mda.commons.ui.user;

import java.awt.Component;

import mda.User;

import org.eclipse.swt.widgets.TabFolder;

public interface IUserTab {
	
	Component build (final TabFolder shell);
	
	void save (final User user);
	
	void load (final User user);
	
	boolean hasChanged ();
	

}
