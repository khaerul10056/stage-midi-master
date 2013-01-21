package org.mda.javafx.presenter.javafx;

import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import org.mda.presenter.adapter.AreaInfo;
import org.mda.presenter.adapter.SizeInfo;


public class MonitorManager {
	
    
	public AreaInfo getPrimaryMonitorBounds () {
		Screen primaryScreen = Screen.getPrimary(); 
		Rectangle2D rect = primaryScreen.getBounds(); 
		return createAreaInfo(rect);
	}
	
	private AreaInfo createAreaInfo (final Rectangle2D rect) {
		return new AreaInfo((float)rect.getMinX(), (float)rect.getMinY(), new SizeInfo((float)rect.getWidth(), (float)rect.getHeight()));
	}
	
	public AreaInfo getSecondaryMonitorBounds () {
		ObservableList<Screen> screens = Screen.getScreens();
		if (screens.size() > 2)
			throw new IllegalStateException("More than 2 monitors are not supported yet");
		
		Screen secondary = null; 
		
		for (Screen nextScreen : screens) {
			if (! nextScreen.equals(Screen.getPrimary()))
				secondary = nextScreen; 
		}
		
		return secondary == null ? null : createAreaInfo(secondary.getBounds()); 
	}
	
	public boolean isDualMonitorAvailable () {
		return Screen.getScreens().size() == 2;
	}
	
	public AreaInfo getBeamerOrPreviewBounds () {
		AreaInfo secondary = getSecondaryMonitorBounds(); 
		if (secondary == null) {
			AreaInfo previewBounds = getPrimaryMonitorBounds();
			float x = previewBounds.getX() + (previewBounds.getWidth() / 2);
			float y = previewBounds.getY() + (previewBounds.getHeight() / 2);
			float width = previewBounds.getWidth() - x;
			float height = previewBounds.getHeight() - y;
			return new AreaInfo(x,  y,  new SizeInfo(width, height));
		}
		else
			return getSecondaryMonitorBounds();
		
	}
	
	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder(); 
		builder.append ("Primary monitor       : " + (getPrimaryMonitorBounds() != null ? getPrimaryMonitorBounds(): "<null>\n"));
		builder.append ("Secondary monitor     : " + (getSecondaryMonitorBounds() != null ? getSecondaryMonitorBounds(): "<null>\n"));
		builder.append ("Beamer/Preview-bounds : " + getBeamerOrPreviewBounds());;
		builder.append ("Dual monitor available: " + isDualMonitorAvailable());
		
		for (Screen next: Screen.getScreens()) {
			builder.append ("- " + next.getBounds());
		}
		
		return builder.toString();
	}
	
}
