package org.mda.application;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class Perspective implements IPerspectiveFactory {

  private static final Log LOGGER  = LogFactory.getLogger(Perspective.class);

  public void createInitialLayout (IPageLayout layout) {
    LOGGER.info("Initialize layout");


    layout.setEditorAreaVisible(true);
    layout.addView("org.mda.navigator.ui", IPageLayout.LEFT, 0.40f, layout.getEditorArea());
   // layout.addView("org.mda.editor.preview.ui.editors.previeweditor", IPageLayout.LEFT, 0.60f, layout.getEditorArea());
  }

}
