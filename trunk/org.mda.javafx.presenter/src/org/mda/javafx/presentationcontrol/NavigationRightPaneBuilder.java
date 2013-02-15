package org.mda.javafx.presentationcontrol;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import org.mda.javafx.presenter.IPresenterIconConst;
import org.mda.presenter.controller.DefaultPresentationController;

public class NavigationRightPaneBuilder extends AbstractControlViewPaneBuilder implements IPresenterIconConst {
	
	public Pane build (final DefaultPresentationController defaultController) {
		VBox nextPane = createVBox(40, 10);
		
		Button btnNextSlide = createButton(null, ICON_NEXT);
		btnNextSlide.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.nextSlide();				
			}
		});
		Button btnNextSong = createButton(null, ICON_NEXT_SONG);
		btnNextSong.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.nextSong();				
			}
		});
		Button btnEnd = createButton(null, ICON_LAST);
		btnEnd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				defaultController.toEnd();				
			}
		});
		nextPane.getChildren().addAll(btnNextSlide, btnNextSong, btnEnd);
		
		
		
		return nextPane;
	}
	
	

}
