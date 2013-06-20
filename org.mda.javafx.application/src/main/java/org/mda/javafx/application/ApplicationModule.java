package org.mda.javafx.application;

import org.mda.javafx.actions.SaveModelAction;
import org.mda.javafx.api.IModelViewAction;
import org.mda.javafx.api.ISessionHoverActionProvider;
import org.mda.javafx.api.ISongHoverActionProvider;
import org.mda.javafx.api.IconRegistry;
import org.mda.javafx.sessionview.actions.AddAllOtherSongsActionProvider;
import org.mda.javafx.sessionview.actions.AddExternalSourcesActionProvider;
import org.mda.javafx.sessionview.actions.AddNewSongActionProvider;
import org.mda.javafx.songview.actions.AddNewPartActionProvider;
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
		
		Multibinder<ISessionHoverActionProvider> uriBinderHoverActionProvider = Multibinder.newSetBinder(binder, ISessionHoverActionProvider.class);
		uriBinderHoverActionProvider.addBinding().to(AddNewSongActionProvider.class);
		uriBinderHoverActionProvider.addBinding().to(AddAllOtherSongsActionProvider.class);
		uriBinderHoverActionProvider.addBinding().to(AddExternalSourcesActionProvider.class);
		
		Multibinder<ISongHoverActionProvider> uriBinderSongHoverActionProvider = Multibinder.newSetBinder(binder, ISongHoverActionProvider.class);
		uriBinderSongHoverActionProvider.addBinding().to(AddNewPartActionProvider.class);
		
		Multibinder<IModelViewAction> uriBinderModelViewAction = Multibinder.newSetBinder(binder, IModelViewAction.class);
		uriBinderModelViewAction.addBinding().to(SaveModelAction.class);
		
		
		
	}

	
}
