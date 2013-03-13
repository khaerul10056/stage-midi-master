package org.mda.midi.mapping;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class MappingService {
	
	/**
	 * 
	 * @param korgSequence
	 * @param toFile
	 * @param revert  false: from Korg to GM / true: from GM to Korg
	 * @return
	 * @throws InvalidMidiDataException
	 * @throws IOException
	 */
	public Sequence convert (final Sequence korgSequence, final File toFile, final boolean revert) throws InvalidMidiDataException, IOException {
		
		Sequence toSequence = new Sequence(korgSequence.getDivisionType(), korgSequence.getResolution());
		for (Track nextTrack: korgSequence.getTracks()) {
			Track newTrack = toSequence.createTrack(); 
			for (int i = 0; i < nextTrack.size(); i++) {
				MidiEvent nextMidievent = nextTrack.get(i); 
				newTrack.add(nextMidievent);
			}
		}
		
		int[] midiFileTypes = MidiSystem.getMidiFileTypes(toSequence);
		
		MidiSystem.write(toSequence, midiFileTypes [0], toFile);
		
		return toSequence;
		
	}

	

}
