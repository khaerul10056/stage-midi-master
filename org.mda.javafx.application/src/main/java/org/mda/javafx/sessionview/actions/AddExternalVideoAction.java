package org.mda.javafx.sessionview.actions;

import java.io.File;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import mda.AdditionalType;
import mda.SpecialMedia;

import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.javafx.api.ISessionHoverAction;

import com.google.inject.Inject;

public class AddExternalVideoAction extends AbstractSessionAction implements ISessionHoverAction {
	
	private AdditionalType additionalType;
	
	@Inject
	private ApplicationSession appsession;
	
	public AddExternalVideoAction () {
		this.additionalType = AdditionalType.VIDEO;		
	}
	
	
	

	@Override
	public Image getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute() {
		FileChooser fileChooser = new FileChooser();
		 
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MP4 files (*.mp4)", "*.mp4");
        fileChooser.getExtensionFilters().add(extFilter);
       
        //Show open file dialog
        File chosenFile = fileChooser.showOpenDialog(null);
        
        if (chosenFile != null) {
        	
        	//appsession.getAdditionalsHandler().importFiles(importFiles) TODO 
        	SpecialMedia specialmedia = MidiPlayerService.mf.createSpecialMedia();
        	specialmedia.setPath(chosenFile.getAbsolutePath());
        	specialmedia.setName(chosenFile.getName());
        	
        	appsession.getCurrentModel().getGallery().getGalleryItems().add(specialmedia);
        	MidiPlayerService.addSessionItem(appsession.getCurrentSession(), getSessionView().getSelectedSessionItem(), specialmedia);
        	
        }
        
        
       
        
	}
	
	@Override
	public String toString () {
		return "Add additional media " + additionalType.getName();
	}

}
