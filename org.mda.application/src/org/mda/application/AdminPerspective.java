package org.mda.application;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class AdminPerspective implements IPerspectiveFactory {

  private static final Log LOGGER  = LogFactory.getLogger(AdminPerspective.class);

  public void createInitialLayout (IPageLayout layout) {
    LOGGER.info("Initialize layout for admin perspective " + System.identityHashCode(this));

    layout.setEditorAreaVisible(true);
    layout.addView("org.mda.navigator.ui.admin", IPageLayout.LEFT, 0.40f, layout.getEditorArea());
  }

}
