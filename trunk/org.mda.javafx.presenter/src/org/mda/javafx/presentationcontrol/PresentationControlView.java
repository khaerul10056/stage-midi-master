package org.mda.javafx.presentationcontrol;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;

import org.mda.javafx.application.UISession;

import com.google.inject.Inject;

/**
 * view to control the presentation 
 * @author oleym
 *
 */
public class PresentationControlView {

	@Inject
    private UISession uiSession;
	
	
	public void build () {
		
		  BorderPane borderPane = new BorderPane();
		  
		  borderPane.setTop(new Button ("Buttons"));
		  borderPane.setCenter(new Button ("Current screen"));
		  borderPane.setLeft(new Button ("Previous"));
		  borderPane.setRight(new Button ("Next"));
		  borderPane.setBottom(new Button ("Previews"));
		
		  Scene scene = new Scene(borderPane); 
		  Stage stage = StageBuilder.create().build();
		  stage.setScene(scene);
		  stage.setFullScreen(true);
		  stage.requestFocus();
		  
		  
		  
		  
		  Scene mainScene = uiSession.getMainStage().getScene();
		  stage.setX(mainScene.getX());
		  stage.setY(mainScene.getY());
		  stage.setWidth(mainScene.getWidth());
		  stage.setHeight(mainScene.getHeight());
		  
		  
		  stage.show();
		  
	}

	

}
