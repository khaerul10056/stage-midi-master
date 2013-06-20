package org.mda.javafx.editor;

import org.mda.ApplicationSession;

import com.google.inject.Inject;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mda.SongPart;

public class SongEditorPane extends TextArea  {
	
	private SongSerializer serializer = new SongSerializer();
	
	private SongDeserializer deserializer = new SongDeserializer();
	
	@Inject
	private ApplicationSession appSession;
	
	
	public SongEditorPane () {
		setId("editor");
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCode().equals(KeyCode.S) && arg0.isControlDown()) {
					arg0.consume();
					
					SongPart part = appSession.getCurrentSongPart(); 
					SongPart deserializedPart = deserializer.deserialize(getText());
					part.getTextlines().clear(); 
					part.getTextlines().addAll(deserializedPart.getTextlines());
					appSession.saveModel();
					
				}
				
			}
		});
		
	}
	
	
	public void setEditContent (final SongPart part) {
		setEditable(part != null && part.getRefPart() == null);
		setDisabled(! isEditable());
		
		if (part == null)
		  setText("");
		else {
		  SongPart partToShow = part.getRefPart() != null ? part.getRefPart() : part;
		  setText(serializer.serializeSongPart(partToShow));
		}
	}
	
	
	

	

}
