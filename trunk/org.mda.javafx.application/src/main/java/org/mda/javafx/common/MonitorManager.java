package org.mda.javafx.common;

import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.measurement.AreaInfo;
import org.mda.measurement.SizeInfo;


public class MonitorManager {
	
	private final static Log LOG = LogFactory.getLogger(MonitorManager.class);
	
	
	
	
	public void layout (final Stage stage, final AreaInfo primaryMonitorBounds){
		stage.setX(primaryMonitorBounds.getX());
		stage.setY(primaryMonitorBounds.getY());
		stage.setWidth(primaryMonitorBounds.getWidth());
		stage.setHeight(primaryMonitorBounds.getHeight());
	}
    
	public AreaInfo getPrimaryMonitorBounds () {
		Screen primaryScreen = Screen.getPrimary(); 
		Rectangle2D rect = primaryScreen.getBounds(); 
		return createAreaInfo(rect, "primary monitor bounds");
	}
	
	private AreaInfo createAreaInfo (final Rectangle2D rect, String logmessage) {
		LOG.info(logmessage + ":  x=" + rect.getMinX() + ", y=" + rect.getMinY() + ", width=" + rect.getWidth() + ", height=" + rect.getHeight());
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
		
		return secondary == null ? null : createAreaInfo(secondary.getBounds(), "secondary monitor bounds"); 
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
	
	public AreaInfo getMainBounds () {
		if (isDualMonitorAvailable())
			return getPrimaryMonitorBounds(); 
		else {
			AreaInfo previewBounds = getPrimaryMonitorBounds();
			float x = 0;
			float y = 0;
			float width = previewBounds.getWidth() / 2;
			float height = previewBounds.getHeight() / 2;
			return new AreaInfo(x,  y,  new SizeInfo(width, height));
		}
		
		
	}
	
	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder();
		builder.append ("Monitormanager"); 
		builder.append ("\n - Primary monitor       : " + (getPrimaryMonitorBounds() != null ? getPrimaryMonitorBounds(): "<null>"));
		builder.append ("\n - Secondary monitor     : " + (getSecondaryMonitorBounds() != null ? getSecondaryMonitorBounds(): "<null>"));
		builder.append ("\n - Beamer/Preview-bounds : " + getBeamerOrPreviewBounds());;
		builder.append ("\n - Dual monitor available: " + isDualMonitorAvailable());
		
		for (Screen next: Screen.getScreens()) {
			builder.append ("- " + next.getBounds());
		}
		
		return builder.toString();
	}
	
}
