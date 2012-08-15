package org.mda.commons.ui;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

/**
 * Processor to handle main screen as fullscreen
 * @author mao
 *
 */
public class FullScreenProcessor {

	@Inject
	private MApplication application;

	@Execute
	public void execute() {
		MWindow mainwindow = application.getChildren().get(0);
		Rectangle bounds = Display.getCurrent().getBounds();
		mainwindow.setX(bounds.x);
		mainwindow.setY(bounds.y);
		mainwindow.setHeight(bounds.height);
		mainwindow.setWidth(bounds.width);
		System.out.println("Hallo");

	}

}
