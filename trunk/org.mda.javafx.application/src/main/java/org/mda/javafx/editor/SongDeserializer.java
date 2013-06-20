package org.mda.javafx.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import mda.MidiplayerFactory;
import mda.SongPart;

import org.mda.Chord;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.transpose.InvalidChordException;

public class SongDeserializer {
	
	private static final Log LOGGER  = LogFactory.getLogger(SongDeserializer.class);

	
	
	public SongPart deserialize (final String modelAsString) {
		SongPart songpart = MidiplayerFactory.eINSTANCE.createSongPart();
		
		Collection <String> allLines = Arrays.asList(modelAsString.split(SongSerializer.NEWLINE));
		
		Collection <TextAndChordLine> textAndChords = new ArrayList<TextAndChordLine>();
		
		TextAndChordLine currentTextAndChord = null;
		
		for (String next: allLines) {
			
			if (currentTextAndChord == null)
				currentTextAndChord = new TextAndChordLine();
			
			if (isChordline(next))
				currentTextAndChord.setChord(next);
			else {
				currentTextAndChord.setText(next);
				textAndChords.add(currentTextAndChord);
				currentTextAndChord = null;
			}
		}
		
		for (TextAndChordLine nextLine: textAndChords) {
			
			try {
			songpart.getTextlines().add(nextLine.createTextLine());
			} catch (Exception e) {
				LOGGER.error("Error deserializing line " + nextLine.getChord() + "/" + nextLine.getText() + ": " + e.getLocalizedMessage(), e);
				throw e;
			}
		}
		
		return songpart;
	}

	/**
	 * checks if current string is a chordline, 
	 * this is anytime when only parsable chords are in this line
	 * @param text  text
	 * @return true: is a chordline, false: is a textline
	 */
	public boolean isChordline (final String text) {
		String [] chords = text.split(" ");
		for (String nextChord: chords) {
			String trimmedChord = nextChord.trim(); 
			if (trimmedChord.isEmpty())
				continue;
			try {
			  new Chord(trimmedChord).render();
			} catch (InvalidChordException e) {
				return false;
			}
				
		}
		
		return true;
	}
}
