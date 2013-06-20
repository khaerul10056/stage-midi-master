package org.mda.javafx.actions;

import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.sessionview.SessionView;

@Deprecated
public abstract class AbstractSessionAction implements ISessionHoverAction {
	
	
	
	private SessionView sessionView;

	protected SessionView getSessionView() {
		return sessionView;
	}

	public void setSessionView(final SessionView sessionView) {
		this.sessionView = sessionView;
	}
	
	

}
