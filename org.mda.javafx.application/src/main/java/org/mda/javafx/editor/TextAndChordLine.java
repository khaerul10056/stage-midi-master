package org.mda.javafx.editor;

import java.util.ArrayList;
import java.util.List;

import mda.MidiplayerFactory;
import mda.SongChordPart;
import mda.SongTextLine;

/**
 * class represents a parsed combination of textline and 
 * chordline from text. 
 * 
 * @author OleyMa
 */
public class TextAndChordLine {

	/**
	 * textline
	 */
	private String text;
	
	/**
	 * chordline
	 */
	private String chord;

	/**
	 * getter
	 * @return chordline
	 */
	public String getChord() {
		return chord;
	}

	/**
	 * setter
	 * @param chord new chordline
	 */
	public void setChord(String chord) {
		this.chord = chord;
	}

	/**
	 * getter
	 * @return textline
	 */
	public String getText() {
		return text;
	}

	/**
	 * setter
	 * @param text  new textline
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * creates a model textline from parsed string
	 * @return textline modelelement
	 */
	public SongTextLine createTextLine() {
		SongTextLine textline = MidiplayerFactory.eINSTANCE.createSongTextLine();

		List<Integer> splitPoints = new ArrayList<Integer>();
		
		boolean whitespace = false;
		for (int i = 0; i < chord.length(); i++) {
			boolean whitespaceNow = Character.isWhitespace(chord.charAt(i));
			if (! whitespaceNow && whitespace) //only we had a whitespace before and have now a nonwhitespace
				splitPoints.add(i);
			
			whitespace = whitespaceNow;
		}

		if (splitPoints.isEmpty()) {
			SongChordPart newChordPart = MidiplayerFactory.eINSTANCE.createSongChordPart();
			newChordPart.setText(text);
			textline.getChordParts().add(newChordPart);

		} else {
			
			if (! splitPoints.contains(0))
				splitPoints.add(0,  0);

			for (int i = 0; i < splitPoints.size(); i++) {

				int from = splitPoints.get(i);
				int toChord = (i == splitPoints.size() - 1) ? chord.length() : splitPoints.get(i + 1);
				int toText = (i == splitPoints.size() - 1) ? text.length() : splitPoints.get(i + 1);
				String chordToken = chord.substring(from, toChord);
				if (chordToken.trim().isEmpty())
					chordToken = null;
				else
					chordToken = chordToken.trim();

				String textToken = text.substring(from, toText);

				SongChordPart newChordPart = MidiplayerFactory.eINSTANCE.createSongChordPart();
				newChordPart.setChord(chordToken);
				newChordPart.setText(textToken);
				textline.getChordParts().add(newChordPart);
			}
		}

		return textline;
	}

}
