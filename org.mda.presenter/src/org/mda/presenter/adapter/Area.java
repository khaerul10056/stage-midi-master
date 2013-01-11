package org.mda.presenter.adapter;

public class Area {
	
	private final Location location; 
	private final Size size;
	

	public Area (final Location location, final Size size) {
		this.location = location; 
		this.size = size;
	}
	
	public Area(final int x, final int y, final Size size) {
		this.location = new Location(x, y); 
		this.size = size;
	}

	public Size getSize() {
		return size;
	}

	public Location getLocation() {
		return location;
	}
	
	public int getX () {
		return location.getX(); 
	}
	
	public int getY () {
		return location.getY();
	}
	
	public int getWidth () {
		return size.getWidth();
	}
	
	public int getHeight () {
		return size.getHeight(); 
	}
	

}
