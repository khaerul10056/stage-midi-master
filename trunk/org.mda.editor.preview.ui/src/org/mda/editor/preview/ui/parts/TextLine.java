package org.mda.editor.preview.ui.parts;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;


public class TextLine extends StyledText{

  private final boolean newSlide;

  public TextLine (boolean newSlide, Composite parent, int style) {
    super(parent, style);
    this.newSlide = newSlide;
  }

  public boolean isNewSlide () {
    return newSlide;
  }

}
