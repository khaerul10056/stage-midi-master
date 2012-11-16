package org.mda.presenter.ui.test;

import mda.Copyright;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiFileTextLine;
import mda.MidiplayerFactory;


public class MidiFileCreator {

  private MidiFile midifile;
  private MidiFilePart currentPart;
  private MidiFileTextLine currentTextLine;

  private MidiFileCreator () {
    midifile = MidiplayerFactory.eINSTANCE.createMidiFile();
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

  public MidiFileCreator part (MidiFilePartType type) {
    currentPart = MidiplayerFactory.eINSTANCE.createMidiFilePart();
    currentPart.setParttype(type);
    midifile.getParts().add(currentPart);
    currentTextLine = null;
    return this;
  }

  public MidiFileCreator refPart (final int reference) {
    currentPart = MidiplayerFactory.eINSTANCE.createMidiFilePart();
    MidiFilePart refPart = midifile.getParts().get(reference);
    currentPart.setParttype(refPart.getParttype());
    currentPart.setRefPart(refPart);
    midifile.getParts().add(currentPart);
    currentTextLine = null;
    return this;
  }

  public MidiFileCreator line () {
    if (currentPart == null)
      throw new IllegalStateException("You have to add a part before adding a newline");

    currentTextLine = MidiplayerFactory.eINSTANCE.createMidiFileTextLine();
    currentPart.getTextlines().add(currentTextLine);
    return this;
  }

  public MidiFileCreator lineOnNewSlide () {
    if (currentPart == null)
      throw new IllegalStateException("You have to add a part before adding a newline");

    currentTextLine = MidiplayerFactory.eINSTANCE.createMidiFileTextLine();
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

    MidiFileChordPart createMidiFileChordPart = MidiplayerFactory.eINSTANCE.createMidiFileChordPart();
    createMidiFileChordPart.setChord(chord);
    createMidiFileChordPart.setText(text);
    currentTextLine.getChordParts().add(createMidiFileChordPart);
    return this;
  }

  public MidiFile get() {
    return midifile;
  }

}
