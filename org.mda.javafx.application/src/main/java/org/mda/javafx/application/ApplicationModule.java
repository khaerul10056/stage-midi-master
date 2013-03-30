package org.mda.javafx.application;

import org.mda.javafx.actions.AddExternalVideoAction;
import org.mda.javafx.actions.SaveModelAction;
import org.mda.javafx.api.IModelViewAction;
import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.api.IconRegistry;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;

public class ApplicationModule  implements Module {
	
	private static final Log LOGGER = LogFactory.getLogger(ApplicationModule.class);


	@Override
	public void configure(Binder binder) {
		LOGGER.info("call configure " + getClass().getName() + "-" + System.identityHashCode(this));
		
		
		
		binder.bind(UISession.class).in(Singleton.class);
		binder.bind(IconRegistry.class).in(Singleton.class);
		
		Multibinder<ISessionHoverAction> uriBinder = Multibinder.newSetBinder(binder, ISessionHoverAction.class);
		uriBinder.addBinding().to(AddExternalVideoAction.class);
		
		Multibinder<IModelViewAction> uriBinderModelViewAction = Multibinder.newSetBinder(binder, IModelViewAction.class);
		uriBinderModelViewAction.addBinding().to(SaveModelAction.class);
		
		
		
	}

	
}
