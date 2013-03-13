package org.mda.transpose;

import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongTextLine;
import org.mda.Chord;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class TransposeService {

  private static final Log LOGGER  = LogFactory.getLogger(TransposeService.class);

  private Scale scale = new Scale ();

  /**
   * Transpose a complete song from one key to another
   * @param song song
   * @param from from key
   * @param to to key
   * @throws InvalidChordException
   */
  public void transpose (Song song, Pitch from, Pitch to) throws InvalidChordException {
    for (SongPart nextPart : song.getParts())
      for (SongTextLine nextLine: nextPart.getTextlines())
        for (SongChordPart nextChordPart: nextLine.getChordParts())
          transpose(nextChordPart, from, to);

    song.setKey(to.getLabel());
  }

  private int getDiff (final Pitch from, final Pitch to) {
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
  private void transpose (SongChordPart chordPart, Pitch from, Pitch to) throws InvalidChordException {
    if (chordPart.getChord() == null)
      return;

    int diff = getDiff(from, to);

    Chord chord = new Chord(chordPart.getChord());
    chord.render();
    chord.transpose (scale, diff, to);

    LOGGER.info("Transpose Chord " + chordPart.getChord() + " -> " + chord.toString());

    chordPart.setChord(chord.toString());


  }

}
