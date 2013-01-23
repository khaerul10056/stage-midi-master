package org.mda.presenter.ui;

import org.mda.presenter.IPresentationContext;
import org.mda.presenter.IPresentationController;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.controller.DefaultPresentationController;

import com.google.inject.Binder;
import com.google.inject.Module;

public class PresenterUiModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IPresentationController.class).to(DefaultPresentationController.class);
		binder.bind(IPresentationContext.class).to(PresentationContext.class);
	}

}
