package org.mda.javafx.actions;

import javafx.scene.image.Image;
import mda.AdditionalType;

import org.mda.javafx.api.ISessionHoverAction;

public class AddExternalMediaAction implements ISessionHoverAction {
	
	private AdditionalType additionalType;
	
	public AddExternalMediaAction (final AdditionalType type) {
		this.additionalType = type;		
	}
	
	
	

	@Override
	public Image getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString () {
		return "Add additional media " + additionalType.getName();
	}

}
