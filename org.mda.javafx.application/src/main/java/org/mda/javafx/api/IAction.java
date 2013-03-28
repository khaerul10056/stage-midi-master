package org.mda.javafx.api;

import javafx.scene.image.Image;

public interface IAction {
	
	String toString ();
	
	Image getIcon ();
	
	void execute ();

}
