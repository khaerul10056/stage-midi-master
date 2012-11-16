package org.mda.midi;

import java.util.ArrayList;
import java.util.Collection;

import mda.MidiFile;

public class NoMidiFileFoundException extends Exception {
	
	Collection <MidiFile> filesWithoutMidiFile = new ArrayList<MidiFile>();
	
	public void add (MidiFile midifile) {
		filesWithoutMidiFile.add(midifile);
	}
	
	public boolean mustBeThrown () {
		return filesWithoutMidiFile.size() > 0;
	}

}
