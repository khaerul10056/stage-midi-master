package org.mda.midi;

import mda.Song;
import mda.SongPart;

public class MidiFileCurrentSlideInfo {
	
	private final Song midifile; 
	
	private final Position position;
	
	private final SongPart currentPart;
	
	public MidiFileCurrentSlideInfo (Song sessionItem, String position, SongPart currentPart) {
		this.midifile = sessionItem;
		this.position = new Position(position);
		this.currentPart = currentPart;
	}

	public Song getMidiFile() {
		return midifile;
	}

	public Position getPosition() {
		return position;
	}

	public SongPart getCurrentPart() {
		return currentPart;
	}

}
