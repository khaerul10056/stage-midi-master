package org.mda.javafx.sessionview.actions;

import java.util.ArrayList;
import java.util.List;

import mda.Session;
import mda.Song;

import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.javafx.api.ISessionHoverAction;
import org.mda.javafx.api.ISessionHoverActionProvider;

import com.google.inject.Inject;

/**
 * adds actions to add songs for all songs which are not already added to current session
 * @author OleyMa
 */
public class AddAllOtherSongsActionProvider implements ISessionHoverActionProvider {
	
	@Inject
	private ApplicationSession appsession;

	@Override
	public List<ISessionHoverAction> get() {
		
		List <ISessionHoverAction> actions = new ArrayList<ISessionHoverAction>();
		
		Session session = appsession.getCurrentSession();
		
		List<Song> allSongs = MidiPlayerService.getAllSongs(appsession.getCurrentModel().getGallery());
		for (Song nextSong : allSongs) {
			if (! session.getItems().contains(nextSong)) //fetch all songs that are not already added
				actions.add(new AddSongAction(nextSong, appsession));
		}
		
		return actions;
	}

}
