package org.mda.commons.ui.navigator;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.navigator.CommonNavigator;


public class ModelNavigator extends CommonNavigator {

  @Override
  protected Object getInitialInput () {
    return new NavigatorRoot();
  }

  @Override
  public void createPartControl (Composite aParent) {
    // TODO Auto-generated method stub
    super.createPartControl(aParent);
  }






}
