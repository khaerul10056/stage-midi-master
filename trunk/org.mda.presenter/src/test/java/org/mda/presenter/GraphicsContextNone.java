package org.mda.presenter;

import org.mda.measurement.FontInfo;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.adapter.IGraphicsContext;

public class GraphicsContextNone implements IGraphicsContext {

	@Override
	public SizeInfo getSize(String text, FontInfo fontdesc) {
		return new SizeInfo(text.length() * fontdesc.getFontsizeAsInt(), 100 * fontdesc.getFontsizeAsInt());
	}

	

}
