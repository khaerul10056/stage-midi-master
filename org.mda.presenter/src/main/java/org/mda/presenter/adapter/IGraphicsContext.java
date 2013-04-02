package org.mda.presenter.adapter;

import org.mda.measurement.FontInfo;
import org.mda.measurement.SizeInfo;

public interface IGraphicsContext {

  public SizeInfo getSize (String text, final FontInfo fontdesc);

}
