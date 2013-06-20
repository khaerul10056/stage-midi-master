package org.mda.javafx.songview.actions;

import org.mda.javafx.api.ISongHoverAction;
import org.mda.javafx.songview.SongView;

public abstract class AbstractSongHoverAction implements ISongHoverAction{
	
	private SongView songView;

	public SongView getSongView() {
		return songView;
	}

	public void setSongView(SongView songView) {
		this.songView = songView;
	}

	
}
