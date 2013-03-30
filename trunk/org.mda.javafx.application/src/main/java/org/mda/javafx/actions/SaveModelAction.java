package org.mda.javafx.actions;

import javafx.scene.image.Image;

import org.mda.ApplicationSession;
import org.mda.javafx.api.IModelViewAction;

import com.google.inject.Inject;

public class SaveModelAction implements IModelViewAction{
	
	@Inject
	private ApplicationSession appSession;

	public String toString () {
		return "Save";
	}
	
	public Image getIcon() {
		return null;
	}

	public void execute() {
		try {
		appSession.saveModel();
		} catch (Exception e) {
			e.printStackTrace(); //TODO Messagebox
			
		}
	}

}
