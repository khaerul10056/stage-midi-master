package org.mda.presenter.adapter;

public class AreaInfo {
	
	private final LocationInfo location; 
	private final SizeInfo size;
	

	public AreaInfo (final LocationInfo location, final SizeInfo size) {
		this.location = location; 
		this.size = size;
	}
	
	public AreaInfo(final float x, final float y, final SizeInfo size) {
		this.location = new LocationInfo(x, y); 
		this.size = size;
	}

	public SizeInfo getSize() {
		return size;
	}

	public LocationInfo getLocation() {
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
