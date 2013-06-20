package org.mda.javafx.editor;

import mda.Song;
import mda.SongPartType;

import org.junit.Assert;
import org.junit.Test;
import org.mda.test.SongCreator;

public class SongSerializerTest {
	
	@Test
	public void serializeSongPart () {
		SongCreator creator = SongCreator.create().part(SongPartType.VERS);
	    creator = creator.line().chordAndText("D", "This is the song I sing ").chordAndText("A", "with which I test the songserializer");
	    creator = creator.line().chordAndText("D", "This is the second line I sing ").chordAndText("A", "with which I test the songserializer");
	    creator = creator.line().text("and a line without chord");
	    Song song = creator.get();
	    
	    SongSerializer serializer = new SongSerializer(); 
	    String real = serializer.serializeSongPart(song.getParts().get(0));
	    String expected = "D                       A                                   " + SongSerializer.NEWLINE +  
	                      "This is the song I sing with which I test the songserializer" + SongSerializer.NEWLINE + 
	    		          "D                              A                                   " + SongSerializer.NEWLINE + 
	                      "This is the second line I sing with which I test the songserializer" + SongSerializer.NEWLINE + 
	                      "                        " + SongSerializer.NEWLINE + 
	                      "and a line without chord";
	    
	    System.out.println ("<" + expected + ">");
	    System.out.println ("<" + real + ">");
	    
	    Assert.assertEquals ("Text not correctly serialized", expected, real);
	}

}
