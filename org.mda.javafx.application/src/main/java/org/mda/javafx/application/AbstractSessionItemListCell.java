package org.mda.javafx.application;

import org.mda.MidiPlayerService;

import javafx.scene.control.ListCell;
import mda.AbstractSessionItem;
import mda.Song;

public class AbstractSessionItemListCell extends ListCell<AbstractSessionItem> {
		
		@Override
	    public void updateItem(AbstractSessionItem item, boolean empty) {
			super.updateItem(item, empty);
			if (item == null)
				setText("");
			else {
			  if (item instanceof Song) {
			    setText(MidiPlayerService.getTitle((Song) item));
			  }					  
			  else
				  setText ("unsupported type " + item.getClass().getSimpleName());
			}
		}

	}


