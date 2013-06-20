package org.mda.export;

import javax.inject.Singleton;

import org.mda.presenter.PresentationContext;
import org.mda.presenter.adapter.GraphicsContextNone;
import org.mda.presenter.adapter.IGraphicsContext;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ExportTestModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IGraphicsContext.class).to(GraphicsContextNone.class);
		binder.bind(PresentationContext.class).in(Singleton.class);
	}

}
