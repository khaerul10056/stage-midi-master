package org.mda.javafx.presentationcontrol;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import org.mda.javafx.presenter.IPresenterIconConst;
import org.mda.presenter.controller.DefaultPresentationController;

public class NavigationLeftPaneBuilder extends AbstractControlViewPaneBuilder implements IPresenterIconConst {
	
	
	
	public Pane build (final DefaultPresentationController defaultController) {
		VBox nextPane = createVBox(10, 40);
		
		Button btnNextSlide = createButton(null, ICON_PREVIOUS);
		btnNextSlide.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.previousSlide();				
			}
		});
		Button btnNextSong = createButton(null, ICON_PREVIOUS_SONG);
		btnNextSong.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.previousSong();				
			}
		});
		Button btnBeginning = createButton(null, ICON_FIRST);
		btnBeginning.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.toBeginning();				
			}
		});
		nextPane.getChildren().addAll(btnNextSlide, btnNextSong, btnBeginning);
		
		
		
		return nextPane;
	}
	

}
