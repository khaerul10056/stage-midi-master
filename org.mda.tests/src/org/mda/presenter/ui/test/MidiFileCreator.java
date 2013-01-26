package org.mda.presenter.ui.test;

import mda.Copyright;
import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongPartType;
import mda.SongTextLine;
import mda.MidiplayerFactory;


public class MidiFileCreator {

  private Song midifile;
  private SongPart currentPart;
  private SongTextLine currentTextLine;

  private MidiFileCreator () {
    midifile = MidiplayerFactory.eINSTANCE.createSong();
  }

  public MidiFileCreator setName (final String name) {
    midifile.setName(name);
    return this;
  }

  public static MidiFileCreator create () {
    return new MidiFileCreator();
  }

  public MidiFileCreator copyright (final String originalTitle, final String publisher, final String publisherInland, final String writerInlandText,
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
  
  public MidiFileCreator setBar (final int bar) {
	  currentPart.setBar(bar);
	  return this;
  }

  public MidiFileCreator part (SongPartType type) {
    currentPart = MidiplayerFactory.eINSTANCE.createSongPart();
    currentPart.setParttype(type);
    midifile.getParts().add(currentPart);
    currentTextLine = null;
    return this;
  }

  public MidiFileCreator refPart (final int reference) {
    currentPart = MidiplayerFactory.eINSTANCE.createSongPart();
    SongPart refPart = midifile.getParts().get(reference);
    currentPart.setParttype(refPart.getParttype());
    currentPart.setRefPart(refPart);
    midifile.getParts().add(currentPart);
    currentTextLine = null;
    return this;
  }

  public MidiFileCreator line () {
    if (currentPart == null)
      throw new IllegalStateException("You have to add a part before adding a newline");

    currentTextLine = MidiplayerFactory.eINSTANCE.createSongTextLine();
    currentPart.getTextlines().add(currentTextLine);
    return this;
  }

  public MidiFileCreator lineOnNewSlide () {
    if (currentPart == null)
      throw new IllegalStateException("You have to add a part before adding a newline");

    currentTextLine = MidiplayerFactory.eINSTANCE.createSongTextLine();
    currentTextLine.setNewSlide(true);
    currentPart.getTextlines().add(currentTextLine);
    return this;
  }

  public MidiFileCreator text (final String text) {
    return chordAndText(null, text);
  }
  public MidiFileCreator chord (final String chord) {
    return chordAndText(chord, null);
  }

  public MidiFileCreator chordAndText (final String chord, final String text) {
	  
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
