package org.mda;

import org.mda.transpose.Note;


public class ChordRenderToken {

  private final boolean minor;

  private final Note note;

  private final int tokenlength;

  public ChordRenderToken (final boolean minor, Note note, int tokenlength) {
    this.minor = minor;
    this.note = note;
    this.tokenlength = tokenlength;
  }

  public Note getNote () {
    return note;
  }



  public boolean isMinor () {
    return minor;
  }

  public int getTokenlength () {
    return tokenlength;
  }



}
