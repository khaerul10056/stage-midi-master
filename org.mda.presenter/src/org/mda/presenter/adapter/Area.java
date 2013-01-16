package org.mda.presenter.adapter;

public class Area {
	
	private final Location location; 
	private final Size size;
	

	public Area (final Location location, final Size size) {
		this.location = location; 
		this.size = size;
	}
	
	public Area(final float x, final float y, final Size size) {
		this.location = new Location(x, y); 
		this.size = size;
	}

	public Size getSize() {
		return size;
	}

	public Location getLocation() {
		return location;
	}
	
	public float getX () {
		return location.getX(); 
	}
	
	public float getY () {
		return location.getY();
	}
	
	public float getWidth () {
		return size.getWidth();
	}
	
	public float getHeight () {
		return size.getHeight(); 
	}
	
	public String toString () {
		return location.getX() + "-" + location.getY() + "-" + size.getWidth() + "-" + size.getHeight();
	}
	

}
