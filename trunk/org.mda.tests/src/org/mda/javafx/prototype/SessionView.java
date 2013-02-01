package org.mda.javafx.prototype;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import mda.AbstractSessionItem;
import mda.Session;
import mda.Song;

import org.mda.ApplicationSession;
import org.mda.javafx.SessionListCell;
import org.mda.javafx.AbstractSessionItemListCell;

import com.google.inject.Inject;

public class SessionView  {

	private TitledPane pane;
	
	@Inject
	private ApplicationSession appSession;
	
	private ListView <AbstractSessionItem> lvSessionItems;
	
	public void build (final HelloJavaFXWorld main) {
	  BorderPane content = new BorderPane();
	  
      lvSessionItems = new ListView<AbstractSessionItem>();
      lvSessionItems.setMinWidth(400);
      lvSessionItems.setMaxWidth(600);
      content.setLeft(lvSessionItems);
      content.setCenter(new Text ("Song"));
	  pane = new TitledPane("Session", content);
	  lvSessionItems.setCellFactory(new Callback<ListView<AbstractSessionItem>, ListCell<AbstractSessionItem>>() {
          @Override 
          public ListCell<AbstractSessionItem> call(ListView<AbstractSessionItem> list) {
              return new AbstractSessionItemListCell();
          }
      });
	  lvSessionItems.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                pane.setExpanded(false);
		                appSession.setCurrentMidifile((Song) lvSessionItems.getSelectionModel().getSelectedItem());
		                main.getSongView().getPane().setExpanded(true);
		                main.getSongView().refresh();
		            }
		        }
		    }
		});
	}
	
	public void refresh () {
		
		if (appSession.getCurrentSession() != null) {
		  pane.setText("Session - " + appSession.getCurrentSession().getName());
		  lvSessionItems.setItems(FXCollections.observableArrayList(appSession.getCurrentSession().getItems()));
		}
		else {
		  pane.setText("Session");
		  
		}
		
	}

	public TitledPane getPane() {
		return pane;
	}
	 

}
