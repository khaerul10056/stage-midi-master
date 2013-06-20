package org.mda.javafx.editor;

import mda.SongTextLine;

import org.junit.Assert;
import org.junit.Test;

public class TextAndChorLineTest {
	
	@Test
	public void serializeWithTextAfterChord () {
		TextAndChordLine chordline = new TextAndChordLine(); 
		chordline.setText ("thats really cool if we have a long line");
		chordline.setChord("                        E");
        SongTextLine textline = chordline.createTextLine();
        Assert.assertEquals (2, textline.getChordParts().size());
        Assert.assertNull (textline.getChordParts().get(0).getChord());
        Assert.assertEquals ("thats really cool if we ", textline.getChordParts().get(0).getText());
        Assert.assertEquals ("E", textline.getChordParts().get(1).getChord());
        Assert.assertEquals ("have a long line", textline.getChordParts().get(1).getText());
	}
	
	@Test
	public void serializeWithMultiCharChords () {
		TextAndChordLine chordline = new TextAndChordLine(); 
		chordline.setText ("Cool text");
		chordline.setChord("Eb/D     ");
        SongTextLine textline = chordline.createTextLine();
        Assert.assertEquals (1, textline.getChordParts().size());
        Assert.assertNull ("Eb/D", textline.getChordParts().get(0).getChord());
        Assert.assertEquals ("Cool text", textline.getChordParts().get(0).getText());
	}

}
