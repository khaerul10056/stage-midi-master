package org.mda.presenter.ui.slide;

import mda.AbstractSessionItem;
import org.junit.Assert;
import org.junit.Test;
import org.mda.navigator.ui.PresentationNavigator;
import org.mda.presenter.ui.DefaultPresentationController;
import org.mda.presenter.ui.MdaPresenterModule;
import org.mda.presenter.ui.PresentationContext;


public class PresentationToControllerConnectorTest {

  @Test
  public void testActivate () {

    PresentationToControllerConnector connector = new PresentationToControllerConnector(new IPresentationView() {

      @Override
      public boolean toItem (AbstractSessionItem item) {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public void refresh () {
        // TODO Auto-generated method stub

      }

      @Override
      public void end () {
        // TODO Auto-generated method stub

      }
    });

    PresentationNavigator nav = new PresentationNavigator();
    PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
    DefaultPresentationController controller = new DefaultPresentationController();
    presentationContext.getRegisteredControllers().add(controller);
    int count = controller.getRegisteredViewsCount();
    connector.partActivated(nav);
    Assert.assertEquals (count + 1, controller.getRegisteredViewsCount());

    connector.partBroughtToTop(nav);
    connector.partClosed(nav);
    connector.partDeactivated(nav);
    connector.partOpened(nav);

  }

}
