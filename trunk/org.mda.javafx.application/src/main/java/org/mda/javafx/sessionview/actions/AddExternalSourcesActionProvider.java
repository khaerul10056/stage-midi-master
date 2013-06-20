package org.mda.javafx.sessionview.actions;

import java.util.ArrayList;
import java.util.List;

import org.mda.ApplicationSession;
import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.api.ISessionHoverActionProvider;

import com.google.inject.Inject;

/**
 * addes actions to add external sources (e.g. videos) 
 * to a session
 * @author OleyMa
 *
 */
public class AddExternalSourcesActionProvider implements ISessionHoverActionProvider {
	
	@Inject
	private ApplicationSession appsession;

	@Override
	public List<ISessionHoverAction> get() {
		List<ISessionHoverAction> actions = new ArrayList<ISessionHoverAction>();
		actions.add(new AddExternalVideoAction(appsession));
		return actions;
	}

}
