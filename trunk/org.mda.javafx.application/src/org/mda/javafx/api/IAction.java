package org.mda.javafx.api;

import javafx.scene.layout.Pane;

public interface IAction {
	
	String getName ();
	
	void execute (final Pane parentPane);

}
