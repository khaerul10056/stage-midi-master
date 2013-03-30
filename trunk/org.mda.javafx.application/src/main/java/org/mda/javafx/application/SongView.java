package org.mda.javafx.application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import mda.Song;
import mda.SongPart;

import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;

import com.google.inject.Inject;


public class SongView {

	private TitledPane pane;
	
	@Inject
	private ApplicationSession appSession;

	private ListView<SongPart> lvSongParts;
	
	public void activate () {
		System.out.println ("SongView activated");
		pane.setExpanded(true);
		refresh(true);
		
       	lvSongParts.requestFocus();
       	lvSongParts.getSelectionModel().select(0);
  	
	}
	
	public void build (final MdaJavaFXApp main) {
	  BorderPane content = new BorderPane(); 
      content.setCenter(new Text ("Song"));
	  pane = new TitledPane("Song", content);
	  
	  lvSongParts = new ListView<SongPart>();
      lvSongParts.setMinWidth(400);
      lvSongParts.setMaxWidth(600);
      content.setLeft(lvSongParts);
      content.setCenter(new Text ("Song"));
	  pane = new TitledPane("Session", content);
	  BorderPane.setMargin(lvSongParts, new Insets(10, 10, 20, 10));
	  lvSongParts.setCellFactory(new Callback<ListView<SongPart>, ListCell<SongPart>>() {
          @Override 
          public ListCell<SongPart> call(ListView<SongPart> list) {
              return new SongPartListCell();
          }
      });
	  
	  lvSongParts.setOnKeyPressed(new EventHandler<KeyEvent> () {

			@Override
			public void handle(KeyEvent arg0) {
				arg0.consume();
				
				if (lvSongParts.getSelectionModel().isSelected(0) && arg0.getCode().equals(KeyCode.UP)) 
					main.getSessionView().activate();
			}
			  
		  });
	  
	  lvSongParts.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                pane.setExpanded(false);
		                appSession.setCurrentMidifile((Song) lvSongParts.getSelectionModel().getSelectedItem());
		                main.getSongView().refresh(true);
		                main.getSongView().getPane().setExpanded(true);
		            }
		        }
		    }
		});
	}

	public TitledPane getPane() {
		return pane;
	}
	
	public void refresh (final boolean withFocus) {
		if (appSession.getCurrentMidifile() != null) {
		  pane.setText("Song - " + MidiPlayerService.getTitle(appSession.getCurrentMidifile()));
		  ObservableList<SongPart> songparts = FXCollections.observableArrayList(appSession.getCurrentMidifile().getParts());
		  lvSongParts.setItems(songparts);
		}
		else {
		  pane.setText("Song");
		}
		
		
		
	}

}
