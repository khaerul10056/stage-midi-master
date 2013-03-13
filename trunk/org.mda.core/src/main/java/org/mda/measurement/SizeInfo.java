package org.mda.measurement;

public class SizeInfo {
	
	private final float width; 
	
	private final float height;
	
	public SizeInfo (final float computeStringWidth, final float computeStringHeight) {
		this.height = computeStringHeight;
		this.width = computeStringWidth;
	}

	public float getWidth() {
		return width;
	}
	
	public int getWidthAsInt () {
		return (int) width;
	}
	
	public int getHeightAsInt () {
		return (int) height;
	}

	public float getHeight() {
		return height;
	}
	
	public String toString () {
		return width + "x" + height;
	}
	
	public boolean equals (final Object object) {
		if (!(object instanceof SizeInfo))
			return false;
		SizeInfo sizeinfoCompare = (SizeInfo) object;
		return sizeinfoCompare.height == height && sizeinfoCompare.width == width;
	}

	

}
