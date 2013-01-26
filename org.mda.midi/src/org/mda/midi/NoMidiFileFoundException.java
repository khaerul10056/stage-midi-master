package org.mda.midi;

import java.util.ArrayList;
import java.util.Collection;

import mda.Song;

public class NoMidiFileFoundException extends Exception {
	
	Collection <Song> filesWithoutMidiFile = new ArrayList<Song>();
	
	public void add (Song midifile) {
		filesWithoutMidiFile.add(midifile);
	}
	
	public boolean mustBeThrown () {
		return filesWithoutMidiFile.size() > 0;
	}

}
