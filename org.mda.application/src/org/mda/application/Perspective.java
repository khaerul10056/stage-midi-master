package org.mda.application;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

  public void createInitialLayout (IPageLayout layout) {

    layout.setEditorAreaVisible(true);
    layout.addView("org.mda.views.modelnavigator", IPageLayout.LEFT, 0.40f, layout.getEditorArea());
    layout.addView("org.mda.editor.preview.ui.editors.previeweditor", IPageLayout.LEFT, 0.60f, layout.getEditorArea());

  }

}
