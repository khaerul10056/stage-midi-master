package org.mda.javafx.application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import mda.Session;

import org.mda.ApplicationSession;

import com.google.inject.Inject;


public class ModelView {

	@Inject
	public ApplicationSession appSession;

	private TitledPane pane;

	private ListView <Session> lvFavourites;

	public void build (final MdaJavaFXApp main) {
	  BorderPane content = new BorderPane();
      ObservableList<Session> favourites = FXCollections.observableArrayList(appSession.getCurrentModel().getSessions());
      lvFavourites = new ListView<Session>(favourites);
      lvFavourites.setMaxHeight(200);
      lvFavourites.setMaxWidth(600);
      BorderPane.setMargin(lvFavourites, new Insets(10, 10, 10, 10));
      
      content.setTop(lvFavourites);
      content.setCenter(new Text ("Model"));
      content.setBottom(new Button("Default"));
	  pane = new TitledPane("Client", content);
	  lvFavourites.setCellFactory(new Callback<ListView<Session>, ListCell<Session>>() {
          @Override 
          public ListCell<Session> call(ListView<Session> list) {
              return new SessionListCell();
          }
      });
	  
	  lvFavourites.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                pane.setExpanded(false);
		                appSession.setCurrentSession(lvFavourites.getSelectionModel().getSelectedItem());
		                
		                main.getSessionView().refresh(true);
		                main.getSongView().refresh(false);
		                main.getSessionView().getPane().setExpanded(true);
		            }
		        }
		    }
		});
	  
	  
  
	}

	public TitledPane getPane() {
		return pane;
	}

}
