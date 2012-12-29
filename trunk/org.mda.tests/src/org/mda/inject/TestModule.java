package org.mda.inject;



import javax.inject.Singleton;

import org.mda.ApplicationSession;
import org.mda.commons.ui.UIHandler;
import org.mda.commons.ui.UIHandler4Test;
import org.mda.export.MailingAdapter;
import org.mda.export.MailingAdapter4Test;
import org.mda.presenter.IPresentationContext;
import org.mda.presenter.IPresentationController;
import org.mda.presenter.ui.DefaultPresentationController;
import org.mda.presenter.ui.PresentationContext;

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
      binder.bind(IPresentationContext.class).to(PresentationContext.class);
    }
}
  
  
  