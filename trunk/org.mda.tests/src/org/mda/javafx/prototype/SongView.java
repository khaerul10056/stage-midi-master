package org.mda.javafx.prototype;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;

import com.google.inject.Inject;


public class SongView {

	private TitledPane pane;
	
	@Inject
	private ApplicationSession appSession;
	
	public void build (final HelloJavaFXWorld main) {
	  BorderPane content = new BorderPane(); 
      content.setCenter(new Text ("Song"));
	  pane = new TitledPane("Song", content);
	}

	public TitledPane getPane() {
		return pane;
	}
	
	public void refresh () {
		if (appSession.getCurrentMidifile() != null) {
		  pane.setText("Song - " + MidiPlayerService.getTitle(appSession.getCurrentMidifile()));
		}
		else {
		  pane.setText("Song");
		  
		}
		
	}

}
