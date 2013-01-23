package org.mda.commons.ui.calculator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.mda.presenter.adapter.FontInfo;
import org.mda.presenter.adapter.IGraphicsContext;
import org.mda.presenter.adapter.SizeInfo;


public class SWTGraphicsContext implements IGraphicsContext {

  private final GC gc = new GC(Display.getDefault());

  @Override
  public SizeInfo getSize (String text, final FontInfo fontdesc) {
    //TODO centralize fonthandling
    Font font;
    if (fontdesc.isBold())
      font = new Font (Display.getCurrent(), "Arial Alternative", fontdesc.getFontsizeAsInt(), SWT.BOLD);
    else
      font = new Font (Display.getCurrent(), "Arial Alternative", fontdesc.getFontsizeAsInt(), SWT.NONE);
    gc.setFont(font);
    Point textExtent = gc.textExtent(text);
    return new SizeInfo(textExtent.x, textExtent.y);
  }


}
