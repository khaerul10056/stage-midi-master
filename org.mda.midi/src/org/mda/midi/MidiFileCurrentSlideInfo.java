package org.mda.midi;

import mda.MidiFile;
import mda.MidiFilePart;

public class MidiFileCurrentSlideInfo {
	
	private final MidiFile midifile; 
	
	private final Position position;
	
	private final MidiFilePart currentPart;
	
	public MidiFileCurrentSlideInfo (MidiFile sessionItem, String position, MidiFilePart currentPart) {
		this.midifile = sessionItem;
		this.position = new Position(position);
		this.currentPart = currentPart;
	}

	public MidiFile getMidiFile() {
		return midifile;
	}

	public Position getPosition() {
		return position;
	}

	public MidiFilePart getCurrentPart() {
		return currentPart;
	}

}
