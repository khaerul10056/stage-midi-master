package org.mda.presenter.ui;


import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.mda.presenter.adapter.ColorInfo;

public class ColorResolver {

	public Color getColor (final ColorInfo someColor) {
		Display display = Display.getCurrent();
		return new Color(display, someColor.getRed(), someColor.getGreen(), someColor.getBlue());
	}
}
