package org.mda.application;

import java.util.logging.Logger;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

  private static final Logger LOGGER  = Logger.getLogger(Perspective.class.getName());

  public void createInitialLayout (IPageLayout layout) {
    LOGGER.info("Initialize layout");

    layout.setEditorAreaVisible(true);
    layout.addView("org.mda.navigator.ui", IPageLayout.LEFT, 0.40f, layout.getEditorArea());
   // layout.addView("org.mda.editor.preview.ui.editors.previeweditor", IPageLayout.LEFT, 0.60f, layout.getEditorArea());
  }

}
