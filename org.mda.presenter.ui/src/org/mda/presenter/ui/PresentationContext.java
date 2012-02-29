package org.mda.presenter.ui;

import java.util.ArrayList;
import java.util.Collection;
import mda.Session;


public class PresentationContext {

  private Session currentSession;



  private final Collection <IPresentationController> registeredControllers = new ArrayList<IPresentationController>();

  public Session getCurrentSession () {
    return currentSession;
  }

  public void setCurrentSession (Session currentSession) {
    this.currentSession = currentSession;
  }

  public Collection <IPresentationController> getRegisteredControllers () {
    return registeredControllers;
  }

}
