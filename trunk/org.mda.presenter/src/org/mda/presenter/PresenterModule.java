package org.mda.presenter;

import org.mda.presenter.config.DefaultMidiFilePresenterConfig;
import org.mda.presenter.config.IMidiFilePresenterConfig;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class PresenterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IMidiFilePresenterConfig.class).to(DefaultMidiFilePresenterConfig.class);
		binder.bind(PresentationContext.class).in(Singleton.class);
	}

}
