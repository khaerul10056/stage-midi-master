package org.mda.javafx.songview;

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
import javafx.util.Callback;
import mda.SongPart;

import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.javafx.application.MdaJavaFXApp;
import org.mda.javafx.application.SongPartListCell;
import org.mda.javafx.editor.SongEditorPane;

import com.google.inject.Inject;


public class SongView {

	private TitledPane pane;
	
	@Inject
	private ApplicationSession appSession;

	private ListView<SongPart> lvSongParts;
	
	@Inject
	private SongActionHover hover;
	
	@Inject
	private SongEditorPane songeditorPane;
	
	public void activate () {
		System.out.println ("SongView activated");
		pane.setExpanded(true);
		refresh(true);
		
       	lvSongParts.requestFocus();
       	lvSongParts.getSelectionModel().select(0);
  	
	}
	
	private SongView get () {
		return this;
	}
	
	public void build (final MdaJavaFXApp main) {
	  BorderPane content = new BorderPane(); 
	  pane = new TitledPane("Song", content);
	  
	  lvSongParts = new ListView<SongPart>();
      lvSongParts.setMinWidth(400);
      lvSongParts.setMaxWidth(600);
      content.setLeft(lvSongParts);
      songeditorPane.setMaxWidth(800);
      content.setCenter(songeditorPane);
	  pane = new TitledPane("Session", content);
	  BorderPane.setMargin(lvSongParts, new Insets(10, 10, 20, 10));
	  BorderPane.setMargin(songeditorPane, new Insets(10, 10, 20, 10));
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
				
				if (arg0.getCode().equals(KeyCode.ENTER)) {
					stepToSongPart();
				}
				
				if (lvSongParts.getSelectionModel().isSelected(0) && arg0.getCode().equals(KeyCode.UP)) 
					main.getSessionView().activate();
				
				if (arg0.getText().equals("+")) {
					hover.create(get());
				}
			}
			  
		  });
	  
	  lvSongParts.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                stepToSongPart();
		            }
		        }
		    }
		});
	}
	
	public void stepToSongPart () {
		appSession.setCurrentSongPart((SongPart) lvSongParts.getSelectionModel().getSelectedItem());
		songeditorPane.setEditContent(appSession.getCurrentSongPart());
		
	}

	public TitledPane getPane() {
		return pane;
	}
	
	public void refresh (final boolean withFocus) {
		if (appSession.getCurrentMidifile() != null) {
		  pane.setText("Song - " + MidiPlayerService.getTitle(appSession.getCurrentMidifile()));
		  ObservableList<SongPart> songparts = FXCollections.observableArrayList(appSession.getCurrentMidifile().getParts());
		  lvSongParts.setItems(songparts);
		  songeditorPane.setEditContent(songparts.get(0)); //TODO select the correct
		}
		else {
		  pane.setText("Song");
		  songeditorPane.setEditContent(null);
		}
		
		
		
	}

}
