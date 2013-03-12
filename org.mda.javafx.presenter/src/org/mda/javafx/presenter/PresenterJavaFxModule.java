package org.mda.javafx.presenter;

import org.mda.javafx.api.ISessionViewAction;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.adapter.IGraphicsContext;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.IPresenterConfig;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;

public class PresenterJavaFxModule implements Module {
	
	private static final Log LOGGER = LogFactory.getLogger(PresenterJavaFxModule.class);
	

	@Override
	public void configure(Binder binder) {
        LOGGER.info("Configure " + getClass().getName());
		
		Multibinder<ISessionViewAction> uriBinder = Multibinder.newSetBinder(binder, ISessionViewAction.class);
		uriBinder.addBinding().to(StartPresentationAction.class);
		
		binder.bind(PresentationContext.class).in(Singleton.class);
		binder.bind(IPresenterConfig.class).to(DefaultPresenterConfig.class);
		binder.bind(IGraphicsContext.class).to(JavaFXGraphicsContext.class);
		
	}

	

}
