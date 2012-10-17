package org.mda.commons.ui;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Processor to handle main screen as fullscreen
 * @author mao
 *
 */
public class FullScreenProcessor {

	@Inject
	private MApplication application;
	
	@Inject
	private MonitorManager monitormanager;

	@Execute
	public void execute() {
		MWindow mainwindow = application.getChildren().get(0);
		Rectangle bounds = monitormanager.getPrimaryMonitor().getBounds();
		mainwindow.setX(bounds.x);
		mainwindow.setY(bounds.y);
		mainwindow.setHeight(bounds.height);
		mainwindow.setWidth(bounds.width);
	}

}
