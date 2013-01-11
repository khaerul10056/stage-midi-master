package org.mda.presenter.adapter;

public class Location {

    private final int x; 
	
	private final int y;
	
	public Location (final int x, final int y) {
		this.y = y;
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
