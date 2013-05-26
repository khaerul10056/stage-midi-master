package org.mda.javafx.sessionview;

import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.api.ISessionHoverActionProvider;

import com.google.inject.Inject;

public class SessionActionHover {
	
	private TextField txtField;
	
	@Inject
	private Set<ISessionHoverActionProvider> sessionActionProviders;
	
	
	private ListView<ISessionHoverAction> liActions;

	private Stage dialogStage;

	private SessionView sessionView;

	private ObservableList<ISessionHoverAction> allActions;
	
	
	  public void search(String oldVal, String newVal) {
		    if (oldVal != null && (newVal.length() < oldVal.length())) {
		      liActions.setItems(allActions);
		    }
		    String value = newVal.toUpperCase();
		    ObservableList<ISessionHoverAction> subentries = FXCollections.observableArrayList();
		    for (ISessionHoverAction entry : liActions.getItems()) {
		      String entryText = entry.toString();
		      if (entryText.toUpperCase().contains(value)) 
		    	subentries.add(entry);
		    }
		    liActions.setItems(subentries);
		  }
	
	
	public Stage create (SessionView sessionView) {
		this.sessionView = sessionView;
		dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.UNDECORATED);
		
		
		
		VBox vbox = new VBox(10);
		vbox.setMinSize(600, 400);
		
		
		txtField = new TextField();
		VBox.setVgrow(txtField, Priority.ALWAYS);
		txtField.setId("hover-textfield");
		
		txtField.textProperty().addListener(new ChangeListener() {
		      public void changed(ObservableValue observable, Object oldVal,
		          Object newVal) {
		        search((String) oldVal, (String) newVal);
		      }
		    });
		
		
		liActions = new ListView<ISessionHoverAction>();
		
		//get all available actions
		allActions = FXCollections.observableArrayList();
		for (ISessionHoverActionProvider nextProvider: sessionActionProviders) 
			allActions.addAll(nextProvider.get());	
		
				
		liActions.setItems(allActions);
		liActions.setId("hover-list-view");
		
		vbox.setId("hover");
		
		
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
				else if (arg0.getCode().equals(KeyCode.TAB) || arg0.getCode().equals(KeyCode.DOWN)) {
					liActions.requestFocus();
					liActions.getSelectionModel().select(0);
				} 
				else { //filter actions
					
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
				
				if (arg0.getCode().equals(KeyCode.ENTER)) {
					execute();
				}
			}
			  
		  });
		
		liActions.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					execute();
				}
				
			}
		});
		
		return dialogStage;
	}
	
	private void execute () {
		liActions.getSelectionModel().getSelectedItem().setSessionView(sessionView);
		liActions.getSelectionModel().getSelectedItem().execute();
		dialogStage.close();
		sessionView.refresh(true);
	}

}
