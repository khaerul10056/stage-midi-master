package org.mda.javafx.sessionview.actions;

import java.util.ArrayList;
import java.util.List;

import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.api.ISessionHoverActionProvider;

/**
 * addes actions to add external sources (e.g. videos) 
 * to a session
 * @author OleyMa
 *
 */
public class AddExternalSourcesActionProvider implements ISessionHoverActionProvider {

	@Override
	public List<ISessionHoverAction> get() {
		List<ISessionHoverAction> actions = new ArrayList<ISessionHoverAction>();
		actions.add(new AddExternalVideoAction());
		return actions;
	}

}
