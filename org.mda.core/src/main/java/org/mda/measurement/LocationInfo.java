package org.mda.measurement;

public class LocationInfo {

    private final float x; 
	
	private final float y;
	
	public LocationInfo (final float x, final float y) {
		this.y = y;
		this.x = x;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

}
