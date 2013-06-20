package org.mda.javafx.sessionview.actions;

import javafx.scene.image.Image;
import mda.Song;

import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.javafx.api.ISessionHoverAction;

public class AddNewSongAction extends AbstractSessionAction implements ISessionHoverAction {
		
		private ApplicationSession appsession;
		
		private Song newSong;
		
		public AddNewSongAction (final ApplicationSession appsession) {
			this.appsession = appsession;
			this.newSong = MidiPlayerService.createSong(appsession.getCurrentModel(), "<New song>");
		}

		@Override
		public Image getIcon() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void execute() {
	    	MidiPlayerService.addSessionItem(appsession.getCurrentSession(), getSessionView().getSelectedSessionItem(), newSong);
		}
			
	    @Override
		public String toString () {
			return "Add new song";
		}

}
