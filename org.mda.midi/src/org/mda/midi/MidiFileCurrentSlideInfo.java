package org.mda.midi;

import mda.MidiFile;
import mda.MidiFilePart;

public class MidiFileCurrentSlideInfo {
	
	private final MidiFile midifile; 
	
	private final Integer bar;
	
	private final MidiFilePart currentPart;
	
	public MidiFileCurrentSlideInfo (MidiFile sessionItem, Integer bar, MidiFilePart currentPart) {
		this.midifile = sessionItem;
		this.bar = bar;
		this.currentPart = currentPart;
	}

	public MidiFile getMidiFile() {
		return midifile;
	}

	public Integer getBar() {
		return bar;
	}

	public MidiFilePart getCurrentPart() {
		return currentPart;
	}

}
