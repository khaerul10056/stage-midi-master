package org.mda;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;


public class MdaModule extends AbstractModule {

  private static Injector injector;

  @Override
  protected void configure () {
    bind(ApplicationSession.class).in(Singleton.class);
  }

  public static Injector getInjector() {
    if (injector == null)
      injector = Guice.createInjector(new MdaModule());
    return injector;
  }


}
