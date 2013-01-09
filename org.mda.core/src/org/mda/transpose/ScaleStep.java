package org.mda.transpose;



public class ScaleStep {

  private final Pitch note1;
  private final Pitch note2;

  public ScaleStep (final Pitch note1) {
    this.note1 = note1;
    this.note2 = null;
  }

  public ScaleStep (final Pitch note1, final Pitch note2) {
    this.note1 = note1;
    this.note2 = note2;
  }

  public Pitch getNote1 () {
    return note1;
  }

  public Pitch getNote2 () {
    return note2;
  }

  public boolean hasNote (Pitch note) {
    return isSharp(note) || isB(note);
  }

  public boolean isSharp (Pitch note) {
    return note1 != null && note1.equals(note);
  }

  public boolean isB (Pitch note) {
    return note2 != null && note2.equals(note);
  }



}
