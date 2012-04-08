package org.mda.transpose;



public class ScaleStep {

  private final Note note1;
  private final Note note2;

  public ScaleStep (final Note note1) {
    this.note1 = note1;
    this.note2 = null;
  }

  public ScaleStep (final Note note1, final Note note2) {
    this.note1 = note1;
    this.note2 = note2;
  }

  public Note getNote1 () {
    return note1;
  }

  public Note getNote2 () {
    return note2;
  }

  public boolean hasNote (Note note) {
    return isSharp(note) || isB(note);
  }

  public boolean isSharp (Note note) {
    return note1 != null && note1.equals(note);
  }

  public boolean isB (Note note) {
    return note2 != null && note2.equals(note);
  }



}
