package org.mda;

import org.mda.transpose.Pitch;


public class ChordRenderToken {

  private final boolean minor;

  private final Pitch note;

  private final int tokenlength;

  public ChordRenderToken (final boolean minor, Pitch note, int tokenlength) {
    this.minor = minor;
    this.note = note;
    this.tokenlength = tokenlength;
  }

  public Pitch getNote () {
    return note;
  }



  public boolean isMinor () {
    return minor;
  }

  public int getTokenlength () {
    return tokenlength;
  }



}
