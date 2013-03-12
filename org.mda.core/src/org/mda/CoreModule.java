package org.mda;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class CoreModule implements Module {

	

	@Override
	public void configure(Binder binder) {
		binder.bind(ApplicationSession.class).in(Singleton.class);
		
	}

}
