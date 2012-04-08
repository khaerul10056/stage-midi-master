package org.mda.transpose;

import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import org.mda.Chord;


public class TransposeService {


  private Scale scale = new Scale ();

  /**
   * Transpose a complete song from one key to another
   * @param song song
   * @param from from key
   * @param to to key
   * @throws InvalidChordException
   */
  public void transpose (MidiFile song, Note from, Note to) throws InvalidChordException {
    for (MidiFilePart nextPart : song.getParts())
      for (MidiFileTextLine nextLine: nextPart.getTextlines())
        for (MidiFileChordPart nextChordPart: nextLine.getChordParts())
          transpose(nextChordPart, from, to);
  }

  private int getDiff (final Note from, final Note to) {
    int fromPos = scale.getNoteOffset(from);
    int toPos = scale.getNoteOffset(to);

    return toPos - fromPos;
  }

  /**
   * Transpose a single chordpart from one key to another
   * @param chordPart  chordpart
   * @param from  from key
   * @param to  to key
   * @throws InvalidChordException
   */
  private void transpose (MidiFileChordPart chordPart, Note from, Note to) throws InvalidChordException {
    if (chordPart.getChord() == null)
      return;

    int diff = getDiff(from, to);

    Chord chord = new Chord(chordPart.getChord());
    chord.render();
    chord.transpose (scale, diff, to);
    chordPart.setChord(chord.toString());

    int max = Note.values().length;





  }

}
