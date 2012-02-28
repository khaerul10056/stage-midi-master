package org.mda.presenter.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.mda.ApplicationSession;
import org.mda.MdaModule;


public class ContentOverview extends ViewPart{

  private ApplicationSession  appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  @Override
  public void createPartControl (Composite arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }

}
