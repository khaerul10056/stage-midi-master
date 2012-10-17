package org.mda;

import org.mda.transpose.InvalidChordException;
import org.mda.transpose.Note;
import org.mda.transpose.NoteAddition;
import org.mda.transpose.Scale;

public final class Chord {

  private Note main;
  private Note bass;
  private NoteAddition addition;

  private boolean basepartdividerInserted = false;

  private String chordAsString;

  private boolean minor;

  public Chord (final String chord) throws InvalidChordException {
    chordAsString = chord;
  }

  /**
   * determine mainnote from chordstring
   * @param chordAsString chord as string
   * @return mainnote
   * @throws InvalidChordException
   */
  private ChordRenderToken renderNotePart (final String chordAsString) throws InvalidChordException {

    //For example Am
    for (Note nextNote: Note.values()) {
      if (chordAsString.startsWith(nextNote.getLabel() + "m")) {
        return new ChordRenderToken(true, nextNote, nextNote.getLabel().length() + 1);
      }
    }

    //For example A
    for (Note nextNote: Note.values()) {
      if (chordAsString.startsWith(nextNote.getLabel())) {
        return new ChordRenderToken(false, nextNote, nextNote.getLabel().length());
      }
    }

    //For example a
    for (Note nextNote: Note.values()) {
      if (chordAsString.startsWith(nextNote.getLabel().toLowerCase())) {
        return new ChordRenderToken(true, nextNote, nextNote.getLabel().length());
      }
    }



    throw new InvalidChordException(chordAsString);
  }

  /**
   * determine mainnote from chordstring
   * @param chordAsString chord as string
   * @return mainnote
   * @throws InvalidChordException
   */
  private static NoteAddition getAddition (final String chordAsString) throws InvalidChordException {

    final String additionText = chordAsString.trim();

    if (additionText.length() == 0)
      return null;

    for (NoteAddition nextNote: NoteAddition.values()) {
      if (additionText.startsWith(nextNote.getLabel())) {
        return nextNote;
      }
    }

    throw new InvalidChordException(chordAsString);
  }


  /**
   * Creates a new Chord
   * @param chordAsString
   * @return
   * @throws InvalidChordException
   */
  public void render () throws InvalidChordException {
    ChordRenderToken renderNotePart = renderNotePart(chordAsString);
    minor = renderNotePart.isMinor();
    main = renderNotePart.getNote();

    int basepartBeginning = chordAsString.indexOf("/");
    basepartdividerInserted = basepartBeginning >= 0;

    int fromAddition = renderNotePart.getTokenlength();
    int toAddition = basepartdividerInserted ? basepartBeginning : chordAsString.length();

    setAddition(getAddition(chordAsString.substring(fromAddition, toAddition)));



    if (basepartBeginning >= main.getLabel().length() && basepartBeginning < chordAsString.length() - 1) {
      ChordRenderToken renderedNotePart = renderNotePart(chordAsString.substring(basepartBeginning + 1, chordAsString.length()));
      setBass(renderedNotePart.getNote());
    }


  }

  public Note getMain() {
    return main;
  }

  @Override
public String toString () {

    StringBuilder builder = new StringBuilder();
    builder.append (isMinor() ? getMain().toString().toLowerCase() : getMain().toString());

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

  public boolean isMinor () {
    return minor;
  }

}
