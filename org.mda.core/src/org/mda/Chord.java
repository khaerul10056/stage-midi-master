package org.mda;

import org.mda.transpose.InvalidChordException;
import org.mda.transpose.Note;
import org.mda.transpose.NoteAddition;
import org.mda.transpose.Scale;

public final class Chord {

  //private Note [] stepsMax = {Note.C, Note.CIS, Note.D, Note.DIS, Note.E,Note.F, Note.FIS, Note.G, Note.GIS, Note.A, Note.AIS, Note.H};
  //private Note [] stepsMin = {Note.C, Note.DES, Note.D, Note.ES, Note.E,Note.F, Note.GES, Note.G, Note.AS, Note.A, Note.B, Note.H};

  private Note main;
  private Note bass;
  private NoteAddition addition;

  private boolean basepartdividerInserted = false;

  private String chordAsString;

  public Chord (final String chord) throws InvalidChordException {
    chordAsString = chord;
    //render(chord);
  }

  /**
   * determine mainnote from chordstring
   * @param chordAsString chord as string
   * @return mainnote
   * @throws InvalidChordException
   */
  private static Note getMainNote (final String chordAsString) throws InvalidChordException {

    for (Note nextNote: Note.values()) {
      if (chordAsString.startsWith(nextNote.getLabel())) {
        return nextNote;
      }
    }

    throw new InvalidChordException();
  }

  /**
   * determine mainnote from chordstring
   * @param chordAsString chord as string
   * @return mainnote
   * @throws InvalidChordException
   */
  private static NoteAddition getAddition (final String chordAsString) throws InvalidChordException {

    if (chordAsString.length() == 0)
      return null;

    for (NoteAddition nextNote: NoteAddition.values()) {
      if (chordAsString.startsWith(nextNote.getLabel())) {
        return nextNote;
      }
    }

    throw new InvalidChordException();
  }


  /**
   * Creates a new Chord
   * @param chordAsString
   * @return
   * @throws InvalidChordException
   */
  public void render () throws InvalidChordException {
    main = getMainNote(chordAsString);


    int basepartBeginning = chordAsString.indexOf("/");
    basepartdividerInserted = basepartBeginning >= 0;

    int fromAddition = main.getLabel().length();
    int toAddition = basepartdividerInserted ? basepartBeginning : chordAsString.length();

    setAddition(getAddition(chordAsString.substring(fromAddition, toAddition)));



    if (basepartBeginning >= main.getLabel().length() && basepartBeginning < chordAsString.length() - 1) {
      setBass(getMainNote(chordAsString.substring(basepartBeginning + 1, chordAsString.length())));
    }


  }

  public Note getMain() {
    return main;
  }

  public String toString () {

    StringBuilder builder = new StringBuilder();
    builder.append (getMain().toString());

    if (getAddition() != null)
      builder.append(getAddition().toString());

    if (getBass() != null)
      builder.append ("/" + getBass().toString());

    return builder.toString();
  }

  public void setAddition(NoteAddition addition) {
    this.addition = addition;
  }

  public NoteAddition getAddition() {
    return addition;
  }

  public void setBass(Note bass) {
    this.bass = bass;
  }

  public Note getBass() {
    return bass;
  }

  public void transpose (final Scale scale, int diff, Note to) {
    if (getBass() != null)
      bass = scale.transpose(getBass(), diff, to);

    if (getMain() != null)
      main = scale.transpose(getMain(), diff, to);
  }

}
