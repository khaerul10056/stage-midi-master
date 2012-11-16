package org.mda.application;

import org.mda.ApplicationSession;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class ApplicationModule implements Module {

	@Override
	public void configure(Binder binder) {
		
		binder.bind(ApplicationSession.class).to(ApplicationSession.class).in(Singleton.class);
	}

	
}
