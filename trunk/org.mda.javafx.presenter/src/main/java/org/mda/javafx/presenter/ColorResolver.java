package org.mda.javafx.presenter;

import javafx.scene.paint.Color;

import org.mda.measurement.ColorInfo;


public class ColorResolver {
	
	public String getBackground (final ColorInfo backgroundColor) {
		return "-fx-background-color: #" + getColor(backgroundColor) + ";";
	}
	
	private String fillWithNull (final String thing) {
		if (thing.length() == 1) 
			return "0" + thing;
		else
			return thing;
	}
	
	private String getColor (final ColorInfo someColor) {
		String red = Integer.toHexString(someColor.getRed());
		String green = Integer.toHexString(someColor.getGreen());
		String blue = Integer.toHexString(someColor.getBlue());
		return fillWithNull(red) + fillWithNull(green) + fillWithNull(blue);
	}
	
	public Color getFxColor (final ColorInfo someColor) {
		return Color.rgb(someColor.getRed(),  someColor.getGreen(), someColor.getBlue()); 
	}

	
}
