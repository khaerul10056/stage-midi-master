package org.mda.commons.ui.user;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

public class UserTabExt {
	
	private static Collection <Class<? extends IUserTab>> usertabs = new ArrayList<Class<? extends IUserTab>>();
	
	public static void deregisterUserTab (final Class<? extends IUserTab> usertab) {
		for (Class<? extends IUserTab> next: usertabs) {
			if (next.equals(usertab)) {
				usertabs.remove(next);
				return;
			}
		}
	}
	
	public static void registerUserTab (final Class<? extends IUserTab> usertab) {
		try {
			usertabs.add(usertab);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Collection <Class<? extends IUserTab>> getRegisteredUsertabs () {
		return usertabs;
	}
	
	public static Collection <IUserTab> createRegisteredUsertabs (IEclipseContext context) {
		Collection <IUserTab> usertabInstances = new ArrayList<IUserTab>();
		
		for (Class<? extends IUserTab> nextTab: usertabs) {
			IUserTab userTab = ContextInjectionFactory.make(nextTab, context);
			if (userTab == null)
				throw new IllegalStateException("Could not find usertab with class " + nextTab.getName());
			
			usertabInstances.add(userTab);
		}
		
		return usertabInstances;
		
	}

}
