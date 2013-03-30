package org.mda.javafx.application;

import javafx.scene.control.ListCell;
import mda.AbstractSessionItem;
import mda.Song;

import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class AbstractSessionItemListCell extends ListCell<AbstractSessionItem> {
	
	private static final Log LOGGER = LogFactory.getLogger(AbstractSessionItemListCell.class);

		
		@Override
	    public void updateItem(AbstractSessionItem item, boolean empty) {
			super.updateItem(item, empty);
			LOGGER.info("item " + item + ": " + (item != null ? item.getName(): null));
			if (item == null)
				setText("");
			else {
			  if (item instanceof Song) {
			    setText(MidiPlayerService.getTitle((Song) item));
			  }					  
			  else
				  setText(item.getName());
			}
		}

	}


