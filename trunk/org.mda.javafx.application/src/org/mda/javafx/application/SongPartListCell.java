package org.mda.javafx.application;

import javafx.scene.control.ListCell;
import mda.SongPart;

public class SongPartListCell extends ListCell<SongPart> {
	
	@Override
    public void updateItem(SongPart item, boolean empty) {
		super.updateItem(item, empty);
		if (item == null)
			setText("");
		else {
		  setText (item.getParttype().getName() + "(" + item.getBar() + ")");
		}
	}

}
