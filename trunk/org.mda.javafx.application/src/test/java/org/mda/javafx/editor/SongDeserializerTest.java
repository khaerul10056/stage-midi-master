package org.mda.javafx.editor;

import mda.SongPart;

import org.junit.Assert;
import org.junit.Test;

public class SongDeserializerTest {
	
	@Test
	public void deserializeSongPart () {
		String text     = "D                       A                                   " + SongSerializer.NEWLINE +  
	                      "This is the song I sing with which I test the songserializer" + SongSerializer.NEWLINE + 
	    		          "D                              A                                   " + SongSerializer.NEWLINE + 
	                      "This is the second line I sing with which I test the songserializer" + SongSerializer.NEWLINE + 
	                      "                        " + SongSerializer.NEWLINE + 
	                      "and a line without chord";
		
		SongDeserializer deserializer = new SongDeserializer(); 
		SongPart part = deserializer.deserialize(text);
		
		//First line
		Assert.assertEquals ("This is the song I sing ", part.getTextlines().get(0).getChordParts().get(0).getText());
		Assert.assertEquals ("D", part.getTextlines().get(0).getChordParts().get(0).getChord());
		
		Assert.assertEquals ("with which I test the songserializer", part.getTextlines().get(0).getChordParts().get(1).getText());
		Assert.assertEquals ("A", part.getTextlines().get(0).getChordParts().get(1).getChord());
		
		Assert.assertEquals (2, part.getTextlines().get(0).getChordParts().size());
		
		//Second line
		Assert.assertEquals ("This is the second line I sing ", part.getTextlines().get(1).getChordParts().get(0).getText());
		Assert.assertEquals ("D", part.getTextlines().get(1).getChordParts().get(0).getChord());
		
		Assert.assertEquals ("with which I test the songserializer", part.getTextlines().get(1).getChordParts().get(1).getText());
		Assert.assertEquals ("A", part.getTextlines().get(1).getChordParts().get(1).getChord());
		
		Assert.assertEquals (2, part.getTextlines().get(1).getChordParts().size());
		
		//third line
		Assert.assertEquals ("and a line without chord", part.getTextlines().get(2).getChordParts().get(0).getText());
		Assert.assertEquals (null, part.getTextlines().get(2).getChordParts().get(0).getChord());
		
		Assert.assertEquals (1, part.getTextlines().get(2).getChordParts().size());
	}

}
