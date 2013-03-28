package org.mda.javafx.actions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mda.AdditionalType;

import org.mda.javafx.api.ISessionHoverAction;

public class SessionActionHover {
	
	private TextField txtField;
	
	
	private ListView<ISessionHoverAction> liActions;
	
	public Stage create () {
		final Stage dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.UNDECORATED);
		
		
		
		VBox vbox = new VBox(10);
		vbox.setMinSize(300, 400);
		
		
		txtField = new TextField();
		VBox.setVgrow(txtField, Priority.ALWAYS);
		
		
		liActions = new ListView<ISessionHoverAction>();
		ObservableList<ISessionHoverAction> actions = FXCollections.observableArrayList();
		actions.add(new AddExternalMediaAction(AdditionalType.VIDEO));		
		liActions.setItems(actions);
		
		vbox.getChildren().add(txtField);
		vbox.getChildren().add(liActions);
	
		
		
		
		Scene scene = new Scene(vbox);
		String cssUrl = getClass().getClassLoader().getResource("css/default.css").toExternalForm();
        scene.getStylesheets().add(cssUrl);
		dialogStage.setScene(scene);
		dialogStage.show();
		
		txtField.setOnKeyPressed(new EventHandler<KeyEvent> () {

			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCode().equals(KeyCode.ESCAPE)) {
					dialogStage.close();
				}
				
				if (arg0.getCode().equals(KeyCode.TAB) || arg0.getCode().equals(KeyCode.DOWN)) {
					liActions.requestFocus();
					liActions.getSelectionModel().select(0);
				}
			}
			  
		  });
		
		liActions.setOnKeyPressed(new EventHandler<KeyEvent> () {

			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCode().equals(KeyCode.ESCAPE)) {
					dialogStage.close();
				}
				
				if (arg0.getCode().equals(KeyCode.UP) && liActions.getSelectionModel().getSelectedIndex() == 0) {
					txtField.requestFocus();
				}
			}
			  
		  });
		
		return dialogStage;
	}

}
