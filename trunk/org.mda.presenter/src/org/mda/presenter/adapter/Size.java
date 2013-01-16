package org.mda.presenter.adapter;

public class Size {
	
	private final float width; 
	
	private final float height;
	
	public Size (final float computeStringWidth, final float computeStringHeight) {
		this.height = computeStringHeight;
		this.width = computeStringWidth;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public String toString () {
		return width + "x" + height;
	}

	

}
