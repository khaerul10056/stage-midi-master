package org.mda.javafx.songview.actions;

import javafx.scene.image.Image;
import mda.SongPartType;

import org.mda.ApplicationSession;
import org.mda.model.SongService;

public class AddNewPartAction extends AbstractSongHoverAction {
	
	private SongPartType type;
	
	private ApplicationSession applicationsession;
	
	/**
	 * constructor
	 * @param type type
	 */
	public AddNewPartAction (final ApplicationSession session, SongPartType type) {
		this.applicationsession = session;
		this.type = type;
	}

	@Override
	public Image getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute() {
		SongService service = new SongService(); 
		service.addPartAfter(applicationsession.getCurrentMidifile(), applicationsession.getCurrentSongPart(), type, null);
	}

	@Override
	public String toString() {
		return "Add part " + type.getName();
	}

}
