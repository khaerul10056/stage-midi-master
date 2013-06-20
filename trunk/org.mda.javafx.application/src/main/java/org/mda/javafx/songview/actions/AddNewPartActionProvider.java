package org.mda.javafx.songview.actions;

import java.util.ArrayList;
import java.util.List;

import mda.SongPartType;

import org.mda.ApplicationSession;
import org.mda.javafx.api.ISongHoverAction;
import org.mda.javafx.api.ISongHoverActionProvider;

import com.google.inject.Inject;

public class AddNewPartActionProvider implements ISongHoverActionProvider {
	
	@Inject
	private ApplicationSession appsession;

	@Override
	public List<ISongHoverAction> get() {
		List<ISongHoverAction> actions = new ArrayList<ISongHoverAction>();
		
		for (SongPartType nextType : SongPartType.values()) {
		  actions.add(new AddNewPartAction(appsession, nextType));
		}
		return actions;
	}

}
