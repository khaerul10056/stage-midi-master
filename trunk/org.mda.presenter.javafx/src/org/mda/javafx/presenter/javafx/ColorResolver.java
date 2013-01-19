package org.mda.javafx.presenter.javafx;

import javafx.scene.paint.Color;

import org.mda.presenter.adapter.ColorInfo;

public class ColorResolver {
	
	public String getBackground (final ColorInfo backgroundColor) {
		return "-fx-background-color: #" + getColor(backgroundColor) + ";";
	}
	
	private String getColor (final ColorInfo someColor) {
		String red = String.format("%02d", someColor.getRed());
		String green = String.format("%02d", someColor.getGreen());
		String blue = String.format("%02d",  someColor.getBlue());
		return red + green + blue;
	}
	
	public Color getFxColor (final ColorInfo someColor) {
		return Color.rgb(someColor.getRed(),  someColor.getGreen(), someColor.getBlue()); 
	}

	
}
