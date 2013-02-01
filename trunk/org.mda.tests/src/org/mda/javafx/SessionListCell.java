package org.mda.javafx;

import mda.Session;
import javafx.scene.control.ListCell;

public class SessionListCell extends ListCell<Session> {
	
	@Override
    public void updateItem(Session item, boolean empty) {
		super.updateItem(item, empty);
		if (item == null)
			setText("");
		else
		  setText(item.getName());
	}

}
