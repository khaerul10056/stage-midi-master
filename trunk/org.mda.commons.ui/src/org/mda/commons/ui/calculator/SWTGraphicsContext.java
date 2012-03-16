package org.mda.commons.ui.calculator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.mda.commons.ui.IGraphicsContext;
import org.mda.commons.ui.IMidiFileEditorUIConfig;


public class SWTGraphicsContext implements IGraphicsContext {

  private final GC gc = new GC(Display.getDefault());

  @Override
  public Point getSize (String text, final IMidiFileEditorUIConfig config) {
    //TODO centralize fonthandling
    Font font = new Font (Display.getCurrent(), "Arial Alternative", config.getFontsize().intValue(), SWT.NONE);
    gc.setFont(font);
    Point textExtent = gc.textExtent(text);
    return textExtent;
  }


}
