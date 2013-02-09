package org.mda.javafx.api;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public interface IAction {
	
	String getName ();
	
	Image getIcon ();
	
	void execute (final Pane parentPane);

}
