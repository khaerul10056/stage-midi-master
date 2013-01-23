package org.mda.inject;



import javax.inject.Singleton;

import org.mda.ApplicationSession;
import org.mda.commons.ui.UIHandler;
import org.mda.commons.ui.UIHandler4Test;
import org.mda.export.MailingAdapter;
import org.mda.export.MailingAdapter4Test;
import org.mda.javafx.presenter.javafx.JavaFXGraphicsContext;
import org.mda.presenter.IPresentationContext;
import org.mda.presenter.IPresentationController;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.adapter.IGraphicsContext;
import org.mda.presenter.controller.DefaultPresentationController;

import com.google.inject.Binder;
import com.google.inject.Module;

public class TestModule implements Module {
    @Override
    public void configure (Binder binder) {
      binder.bind(ApplicationSession.class).in(Singleton.class);
      binder.bind(PresentationContext.class).in(Singleton.class);
      binder.bind(UIHandler.class).to(UIHandler4Test.class);
      binder.bind(MailingAdapter.class).to(MailingAdapter4Test.class);
      binder.bind(IPresentationController.class).to(DefaultPresentationController.class);
      binder.bind(IGraphicsContext.class).to(JavaFXGraphicsContext.class);
      binder.bind(IPresentationContext.class).to(PresentationContext.class);
       
    }
}
  
  
  