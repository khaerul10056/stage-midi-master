package org.mda.javafx.sessionview.actions;

import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.sessionview.SessionView;

public abstract class AbstractSessionAction implements ISessionHoverAction {
	
	
	
	private SessionView sessionView;

	protected SessionView getSessionView() {
		return sessionView;
	}

	public void setSessionView(SessionView sessionView) {
		this.sessionView = sessionView;
	}
	
	

}
