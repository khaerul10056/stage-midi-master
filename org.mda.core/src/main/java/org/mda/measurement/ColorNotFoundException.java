package org.mda.measurement;

public class ColorNotFoundException extends Exception{
	
	public ColorNotFoundException (final String colorDescription) {
		super ("Color <" + colorDescription + "> not found");
	}

}
