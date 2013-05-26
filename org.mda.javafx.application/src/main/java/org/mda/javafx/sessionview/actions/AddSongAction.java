package org.mda.javafx.sessionview.actions;

import javafx.scene.image.Image;
import mda.Song;

import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.javafx.api.ISessionHoverAction;

public class AddSongAction extends AbstractSessionAction implements ISessionHoverAction {
	
	private Song song;
	private ApplicationSession appsession;
	
	public AddSongAction (final Song song, final ApplicationSession appsession) {
		this.song = song;		
		this.appsession = appsession;
	}

	@Override
	public Image getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute() {
    	MidiPlayerService.addSessionItem(appsession.getCurrentSession(), getSessionView().getSelectedSessionItem(), song);
	}
		
    @Override
	public String toString () {
		return "Add song " + MidiPlayerService.getTitle(song);
	}
	
}