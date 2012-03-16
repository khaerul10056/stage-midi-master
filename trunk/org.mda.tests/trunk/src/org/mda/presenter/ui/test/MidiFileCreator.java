package org.mda.presenter.ui.test;

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

  public static MidiFileCreator create () {
    return new MidiFileCreator();
  }

  public MidiFileCreator part (MidiFilePartType type) {
    currentPart = MidiplayerFactory.eINSTANCE.createMidiFilePart();
    currentPart.setParttype(type);
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

  public MidiFileCreator text (final String text) {
    return chordAndText(null, text);
  }
  public MidiFileCreator chord (final String chord) {
    return chordAndText(chord, null);
  }

  public MidiFileCreator chordAndText (final String chord, final String text) {
    if (currentTextLine == null)
      throw new IllegalStateException("You have to add a textline before adding a chordpart");

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
