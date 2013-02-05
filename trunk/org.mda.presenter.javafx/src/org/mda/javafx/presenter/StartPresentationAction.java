package org.mda.javafx.presenter;

import javafx.scene.layout.Pane;

import org.mda.javafx.api.ISessionViewAction;

public class StartPresentationAction implements ISessionViewAction {

	@Override
	public String getName() {
		return "Start";
	}

	@Override
	public void execute(Pane parentPane) {
		System.out.println ("Execute");

	}

	

}
