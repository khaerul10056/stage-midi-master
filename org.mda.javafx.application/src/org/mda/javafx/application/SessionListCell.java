package org.mda.javafx.application;

import javafx.scene.control.ListCell;
import mda.Session;

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
