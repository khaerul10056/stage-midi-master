package org.mda;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;


public class MdaModule extends AbstractModule {


  @Override
  protected void configure () {
    bind(ApplicationSession.class).in(Singleton.class);

  }


}
