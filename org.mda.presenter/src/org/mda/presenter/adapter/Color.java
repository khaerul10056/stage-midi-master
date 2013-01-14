package org.mda.presenter.adapter;

import org.mda.presenter.utils.ColorNotFoundException;


/**
 * Generic class for a color
 * @author oleym
 *
 */
public class Color {
	
	private final int red; 
	
	private final int green; 
	
	private final int blue;

	public final static Color BLACK = new Color (0, 0, 0);
	public final static Color WHITE = new Color (255, 255, 255);
	
	public Color (final String colorAsString) throws ColorNotFoundException {
		String [] colorAspects = colorAsString != null ? colorAsString.split("x") : new String [0];
	    if (colorAspects.length != 3)
	        throw new ColorNotFoundException(colorAsString);
	    
	    this.green = Integer.valueOf(colorAspects [0]);
		this.red = Integer.valueOf(colorAspects [1]);
		this.blue = Integer.valueOf(colorAspects [2]);
	}
	
	public Color (int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;		
	}
	
	public String toString () {
	    return getGreen() + "x" + getRed() + "x" + getBlue();
	}

	public int getBlue() {
		return blue;
	}

	public int getGreen() {
		return green;
	}

	public int getRed() {
		return red;
	}

}