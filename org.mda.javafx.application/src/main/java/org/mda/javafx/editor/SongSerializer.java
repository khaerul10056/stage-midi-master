package org.mda.javafx.editor;

import mda.SongChordPart;
import mda.SongPart;
import mda.SongTextLine;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class SongSerializer {
	
	public final static String NEWLINE = System.getProperty("line.separator");
	
	  private static final Log LOGGER  = LogFactory.getLogger(SongSerializer.class);

	
	public String serializeSongPart (final SongPart songPart) {
		
		String completeText = "";
		int linenumber = 0;
		for (SongTextLine nextTextLine : songPart.getTextlines()) {
			String textLine = ""; 
			String chordLine = "";
			
			for (SongChordPart nextChorPart: nextTextLine.getChordParts()) {
				String text = nextChorPart.getText();
				String chord = nextChorPart.getChord() != null ? nextChorPart.getChord() : "";
				int difference = text.length() - chord.length(); 
				for (int i = 0; i < difference; i++)
					chord += " ";
				textLine += text;
				chordLine += chord;
			}
			
			chordLine += NEWLINE;
			if (linenumber < songPart.getTextlines().size() - 1 ) 
			  textLine += NEWLINE;
			
			linenumber ++;
			
			completeText = completeText + chordLine + textLine;
		}
		
		LOGGER.info("Serialized songpart: \n" + completeText);
		
		
		return completeText;
	    
	}
	
	

}
