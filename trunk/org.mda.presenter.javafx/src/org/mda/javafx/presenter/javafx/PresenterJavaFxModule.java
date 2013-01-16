package org.mda.javafx.presenter.javafx;

import org.mda.presenter.adapter.IGraphicsContext;

import com.google.inject.Binder;
import com.google.inject.Module;

public class PresenterJavaFxModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IGraphicsContext.class).to(JavaFXGraphicsContext.class);
	}

}
