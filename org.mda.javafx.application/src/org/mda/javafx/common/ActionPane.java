package org.mda.javafx.common;

import java.util.Set;

import org.mda.javafx.api.IAction;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;



public class ActionPane {

	
	
	private HBox actionpane;

	public ActionPane () {
		actionpane = new HBox();
	    actionpane.setPadding(new Insets(15, 12, 15, 12));
	    actionpane.setSpacing(10);
		
	}
	
	public void addActions (Set<? extends IAction> actions) {
		for (IAction nextAction: actions) {
		  Button btn = new Button(nextAction.getName()); 
		  actionpane.getChildren().add(btn);
		  
		}
	}
	
	public Pane getPane () {
		return actionpane;
	}

}
