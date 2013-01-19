package org.mda.presenter;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class PresenterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(PresentationContext.class).in(Singleton.class);
	}

}
