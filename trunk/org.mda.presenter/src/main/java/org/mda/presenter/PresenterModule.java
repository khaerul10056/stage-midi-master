package org.mda.presenter;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.multibindings.Multibinder;

public class PresenterModule  implements Module {

	@Override
	public void configure(Binder binder) {
		
		Multibinder<ISlideCalculator> uriBinderModelViewAction = Multibinder.newSetBinder(binder, ISlideCalculator.class);
		uriBinderModelViewAction.addBinding().to(SongSlideCalculator.class);
		uriBinderModelViewAction.addBinding().to(SpecialMediaSlideCalculator.class);
		
	}

}
