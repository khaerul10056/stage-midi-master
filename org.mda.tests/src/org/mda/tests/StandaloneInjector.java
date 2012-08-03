package org.mda.tests;

import javax.inject.Singleton;
import org.mda.ApplicationSession;
import org.mda.presenter.ui.ContentOverview;
import org.mda.presenter.ui.PresentationContext;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;




public class StandaloneInjector {
  
  private static Injector injector;
  
  static {
    injector = Guice.createInjector(new MdaModule());
  }
  
  
  private static class MdaModule implements Module {
    @Override
    public void configure (Binder binder) {
      binder.bind(ApplicationSession.class).in(Singleton.class);
      binder.bind(PresentationContext.class).in(Singleton.class);
      binder.bind(ContentOverview.class).in(Singleton.class);
    }
  }
  
  public static void inject (final Object object) {
    injector.injectMembers(object);
  }
  

}
