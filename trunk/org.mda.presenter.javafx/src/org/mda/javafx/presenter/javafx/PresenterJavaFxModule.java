package org.mda.javafx.presenter.javafx;

import org.mda.presenter.adapter.IGraphicsContext;
import org.mda.presenter.config.DefaultMidiFilePresenterConfig;
import org.mda.presenter.config.IMidiFilePresenterConfig;

import com.google.inject.Binder;
import com.google.inject.Module;

public class PresenterJavaFxModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IGraphicsContext.class).to(JavaFXGraphicsContext.class);
		binder.bind(IMidiFilePresenterConfig.class).to(DefaultMidiFilePresenterConfig.class);
	}

}
