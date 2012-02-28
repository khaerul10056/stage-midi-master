package org.mda.application;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class PresentationPerspective implements IPerspectiveFactory {

  private static final Log LOGGER  = LogFactory.getLogger(AdminPerspective.class);

  public void createInitialLayout (IPageLayout layout) {
    LOGGER.info("Initialize layout");
    layout.setEditorAreaVisible(false);
    layout.addView("org.mda.navigator.ui.presentation", IPageLayout.LEFT, 0.30f, layout.getEditorArea());
    layout.addView("org.mda.presenter.ui.contentpreview", IPageLayout.RIGHT, 0.70f, layout.getEditorArea());


  }

}
