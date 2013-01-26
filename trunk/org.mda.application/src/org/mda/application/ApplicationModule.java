package org.mda.application;

import org.mda.ApplicationSession;
import org.mda.commons.ui.calculator.SWTGraphicsContext;
import org.mda.presenter.adapter.IGraphicsContext;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.IPresenterConfig;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class ApplicationModule implements Module {

	@Override
	public void configure(Binder binder) {
		
		binder.bind(ApplicationSession.class).in(Singleton.class);
		binder.bind(IGraphicsContext.class).to(SWTGraphicsContext.class);
		binder.bind(IPresenterConfig.class).to(DefaultPresenterConfig.class);
	}

	
}
