package org.mda.javafx.presentationcontrol;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;

import org.mda.presenter.controller.DefaultPresentationController;

public class NavigationRightPane {
	
	
	
	public Pane build (final DefaultPresentationController defaultController) {
		VBox nextPane = VBoxBuilder.create().build();
		VBox.setMargin(nextPane, new Insets (10, 10, 10, 10));
		
		Button btnNextSlide = createButton("Next slide");
		btnNextSlide.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.nextSlide();				
			}
		});
		Button btnNextSong = createButton("Next song");
		btnNextSong.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.nextSong();				
			}
		});
		Button btnEnd = createButton("End");
		btnEnd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.toEnd();				
			}
		});
		nextPane.getChildren().addAll(btnNextSlide, btnNextSong, btnEnd);
		
		
		
		return nextPane;
	}
	
	Button createButton (final String name) {
		Button btn = ButtonBuilder.create().build();
		btn.setFocusTraversable(false);
		btn.setText(name);
		return btn;
	}

}
