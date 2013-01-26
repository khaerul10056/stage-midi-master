package org.mda.presenter;

import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.IPresenterConfig;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class PresenterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IPresenterConfig.class).to(DefaultPresenterConfig.class);
		binder.bind(PresentationContext.class).in(Singleton.class);
	}

}
