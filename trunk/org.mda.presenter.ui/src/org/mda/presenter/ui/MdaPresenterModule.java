package org.mda.presenter.ui;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;


public class MdaPresenterModule extends AbstractModule {

  private static Injector injector;

  @Override
  protected void configure () {
    bind(PresentationContext.class).in(Singleton.class);

  }

  public static Injector getInjector() {
    if (injector == null)
      injector = Guice.createInjector(new MdaPresenterModule());
    return injector;
  }

}
