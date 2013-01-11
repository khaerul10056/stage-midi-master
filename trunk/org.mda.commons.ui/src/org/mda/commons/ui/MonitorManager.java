package org.mda.commons.ui;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;

@Creatable
public class MonitorManager {
	
    
	public Monitor getPrimaryMonitor () {
		for (Monitor nextMonitor: Display.getCurrent().getMonitors()) {
	      if (nextMonitor.equals(Display.getCurrent().getPrimaryMonitor())) {
	        return nextMonitor;
	      }
	    }
		
		return null;
		
	}
	
	public Monitor getSecondaryMonitor () {
		for (Monitor nextMonitor: Display.getCurrent().getMonitors()) {
	      if (! nextMonitor.equals(Display.getCurrent().getPrimaryMonitor())) {
	        return nextMonitor;
	      }
	    }
		
		return null;
	}
	
	public boolean isDualMonitorAvailable () {
		return Display.getCurrent().getMonitors().length == 2;
	}
	
	public Rectangle getBeamerOrPreviewBounds () {
		Monitor secondary = getSecondaryMonitor(); 
		if (secondary == null) {
			Rectangle previewBounds = getPrimaryMonitor().getBounds();
			int x = previewBounds.x + (previewBounds.width / 2);
			int y = previewBounds.y + (previewBounds.height / 2);
			int width = previewBounds.width - x;
			int height = previewBounds.height - y;
			return new Rectangle(x, y, width, height);
		}
		else
			return getSecondaryMonitor().getBounds();
		
	}
	
	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder(); 
		builder.append ("Primary monitor       : " + (getPrimaryMonitor() != null ? getPrimaryMonitor().getBounds(): "<null>\n"));
		builder.append ("Secondary monitor     : " + (getSecondaryMonitor() != null ? getSecondaryMonitor().getBounds(): "<null>\n"));
		builder.append ("Beamer/Preview-bounds : " + getBeamerOrPreviewBounds());;
		builder.append ("Dual monitor available: " + isDualMonitorAvailable());
		
		for (Monitor next: Display.getCurrent().getMonitors()) {
			builder.append ("- " + next.getBounds());
		}
		
		return builder.toString();
	}
	
}
