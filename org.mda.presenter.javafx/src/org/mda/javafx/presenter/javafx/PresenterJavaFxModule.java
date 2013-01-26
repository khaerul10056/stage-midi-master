package org.mda.javafx.presenter.javafx;

import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.IPresenterConfig;

import com.google.inject.Binder;
import com.google.inject.Module;

public class PresenterJavaFxModule implements Module {

	@Override
	public void configure(Binder binder) {
		
		binder.bind(IPresenterConfig.class).to(DefaultPresenterConfig.class);
	}

}
