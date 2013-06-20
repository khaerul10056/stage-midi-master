package org.mda.test;

import mda.Copyright;
import mda.MidiplayerFactory;
import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongPartType;
import mda.SongTextLine;

public class SongCreator {
	private Song midifile;
	  private SongPart currentPart;
	  private SongTextLine currentTextLine;

	  private SongCreator () {
	    midifile = MidiplayerFactory.eINSTANCE.createSong();
	  }

	  public SongCreator setName (final String name) {
	    midifile.setName(name);
	    return this;
	  }

	  public static SongCreator create () {
	    return new SongCreator();
	  }

	  public SongCreator copyright (final String originalTitle, final String publisher, final String publisherInland, final String writerInlandText,
	                                    final String writerMusic, final String writerText, final Integer year) {
	    Copyright copyright = MidiplayerFactory.eINSTANCE.createCopyright();
	    copyright.setOriginaltitle(originalTitle);
	    copyright.setPublisher(publisher);
	    copyright.setPublisherInland(publisherInland);
	    copyright.setWriterInlandText(writerInlandText);
	    copyright.setWriterMusic(writerMusic);
	    copyright.setWriterText(writerText);
	    if (year != null)
	     copyright.setYear(year);

	    midifile.setCopyright(copyright);
	    return this;
	  }
	  
	  public SongCreator setBar (final int bar) {
		  currentPart.setBar(bar);
		  return this;
	  }

	  public SongCreator part (SongPartType type) {
	    currentPart = MidiplayerFactory.eINSTANCE.createSongPart();
	    currentPart.setParttype(type);
	    midifile.getParts().add(currentPart);
	    currentTextLine = null;
	    return this;
	  }

	  public SongCreator refPart (final int reference) {
	    currentPart = MidiplayerFactory.eINSTANCE.createSongPart();
	    SongPart refPart = midifile.getParts().get(reference);
	    currentPart.setParttype(refPart.getParttype());
	    currentPart.setRefPart(refPart);
	    midifile.getParts().add(currentPart);
	    currentTextLine = null;
	    return this;
	  }

	  public SongCreator line () {
	    if (currentPart == null)
	      throw new IllegalStateException("You have to add a part before adding a newline");

	    currentTextLine = MidiplayerFactory.eINSTANCE.createSongTextLine();
	    currentPart.getTextlines().add(currentTextLine);
	    return this;
	  }

	  public SongCreator lineOnNewSlide () {
	    if (currentPart == null)
	      throw new IllegalStateException("You have to add a part before adding a newline");

	    currentTextLine = MidiplayerFactory.eINSTANCE.createSongTextLine();
	    currentTextLine.setNewSlide(true);
	    currentPart.getTextlines().add(currentTextLine);
	    return this;
	  }

	  public SongCreator text (final String text) {
	    return chordAndText(null, text);
	  }
	  public SongCreator chord (final String chord) {
	    return chordAndText(chord, null);
	  }

	  public SongCreator chordAndText (final String chord, final String text) {
		  
	    if (currentTextLine == null)
	      line();

	    SongChordPart createMidiFileChordPart = MidiplayerFactory.eINSTANCE.createSongChordPart();
	    createMidiFileChordPart.setChord(chord);
	    createMidiFileChordPart.setText(text);
	    currentTextLine.getChordParts().add(createMidiFileChordPart);
	    return this;
	  }

	  public Song get() {
	    return midifile;
	  }

}
