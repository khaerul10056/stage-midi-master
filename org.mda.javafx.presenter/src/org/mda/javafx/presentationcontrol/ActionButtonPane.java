package org.mda.javafx.presentationcontrol;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Pane;

import org.mda.presenter.controller.DefaultPresentationController;

public class ActionButtonPane {
	
	public Pane build (final DefaultPresentationController defaultController) {
		HBox nextPane = HBoxBuilder.create().alignment(Pos.CENTER).spacing(20).build();
		
		Button btnWhite = createButton("White");
		btnWhite.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.toggleWhite();				
			}
		});
		Button btnBlack = createButton("Black");
		btnBlack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.toggleBlack();				
			}
		});
		Button btnBackground = createButton("Background");
		btnBackground.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.toggleOnlyBackground();				
			}
		});
		Button btnNormal = createButton("Normal");
		btnNormal.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.toggleNormalize();				
			}
		});
		
		nextPane.getChildren().addAll(btnWhite, btnBlack, btnBackground, btnNormal);
		
		
		
		return nextPane;
	}
	
	Button createButton (final String name) {
		Button btn = ButtonBuilder.create().build();
		btn.setFocusTraversable(false);
		btn.setText(name);
		return btn;
		
	}

}
