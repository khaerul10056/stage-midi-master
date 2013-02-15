package org.mda.javafx.common;

import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import org.mda.javafx.api.IAction;



public class ActionPane {

	
	
	
	private HBox actionpane;

	public ActionPane () {
		actionpane = new HBox();
	    actionpane.setPadding(new Insets(15, 12, 15, 12));
	    actionpane.setSpacing(10);
		
	}
	
	public void addActions (Set<? extends IAction> actions) {
		for (final IAction nextAction: actions) {
		  Button btn = new Button(nextAction.getName());
		  
		  if (nextAction.getIcon() != null) 
			btn.setGraphic(new ImageView(nextAction.getIcon()));
		  
		  actionpane.getChildren().add(btn);
		  btn.setOnAction(new EventHandler<ActionEvent>() {
		        @Override
		        public void handle(ActionEvent event) {
		            nextAction.execute(actionpane);
		        }
		    });
		  
		}
	}
	
	public Pane getPane () {
		return actionpane;
	}

}
