package org.mda.javafx.application;

import org.mda.javafx.api.IconRegistry;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class ApplicationModule  implements Module {

	@Override
	public void configure(Binder binder) {
		
		binder.bind(UISession.class).in(Singleton.class);
		binder.bind(IconRegistry.class).in(Singleton.class);
		
	}

	
}
