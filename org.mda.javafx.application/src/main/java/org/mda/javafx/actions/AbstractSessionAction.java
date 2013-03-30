package org.mda.javafx.actions;

import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.application.SessionView;

public abstract class AbstractSessionAction implements ISessionHoverAction {
	
	
	
	private SessionView sessionView;

	protected SessionView getSessionView() {
		return sessionView;
	}

	public void setSessionView(SessionView sessionView) {
		this.sessionView = sessionView;
	}
	
	

}
