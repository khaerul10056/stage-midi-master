package org.mda.presenter.ui.slide;

import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.IPresentationController;
import org.mda.presenter.ui.MdaPresenterModule;
import org.mda.presenter.ui.PresentationContext;


public class PresentationToControllerConnector implements IPartListener {

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  private static final Log LOGGER  = LogFactory.getLogger(PresentationToControllerConnector.class);
  private IPresentationView view;

  public PresentationToControllerConnector (IPresentationView view) {
    this.view = view;
  }

  @Override
  public void partOpened (IWorkbenchPart arg0) {


  }

  @Override
  public void partDeactivated (IWorkbenchPart arg0) {
    LOGGER.info("partDeactivated" + arg0.getClass().getName());
  }

  @Override
  public void partClosed (IWorkbenchPart arg0) {
    LOGGER.info("partClosed" + arg0.getClass().getName());

  }

  @Override
  public void partBroughtToTop (IWorkbenchPart arg0) {
    LOGGER.info("partBroughtToTop" + arg0.getClass().getName());

  }

  @Override
  public void partActivated (IWorkbenchPart arg0) {
    LOGGER.info("partActivated " + arg0.getClass().getName());
    if (arg0.getClass().getName().equals("org.mda.navigator.ui.PresentationNavigator")) {
      for (IPresentationController controller : presentationContext.getRegisteredControllers()) {
        controller.connect(view);
      }
    }
  }

}
