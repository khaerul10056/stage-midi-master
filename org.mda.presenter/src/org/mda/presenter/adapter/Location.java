package org.mda.presenter.adapter;

public class Location {

    private final float x; 
	
	private final float y;
	
	public Location (final float x, final float y) {
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
