package org.mda.javafx.sessionview.actions;

import java.util.ArrayList;
import java.util.List;

import org.mda.ApplicationSession;
import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.api.ISessionHoverActionProvider;

import com.google.inject.Inject;

/**
 * adds action to add new song to a session 
 * @author OleyMa
 *
 */
public class AddNewSongActionProvider implements ISessionHoverActionProvider {

	@Inject
	private ApplicationSession appsession;
	
	@Override
	public List<ISessionHoverAction> get() {
		List<ISessionHoverAction> actions = new ArrayList<ISessionHoverAction>();
		actions.add(new AddNewSongAction(appsession));
		return actions;
	}

}