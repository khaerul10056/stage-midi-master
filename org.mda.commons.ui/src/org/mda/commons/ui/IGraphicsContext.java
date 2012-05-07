package org.mda.commons.ui;

import org.eclipse.swt.graphics.Point;
import org.mda.commons.ui.calculator.FontDescriptor;


public interface IGraphicsContext {

  public Point getSize (String text, final FontDescriptor fontdesc);

}
