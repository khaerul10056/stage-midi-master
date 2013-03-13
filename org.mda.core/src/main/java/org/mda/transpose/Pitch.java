package org.mda.transpose;

public enum Pitch {
  CIS ("C#"),
  DES ("Db"),
  DIS ("D#"),
  ES ("Eb"),
  FIS ("F#"),
  GES ("Gb"),
  GIS ("G#"),
  AS ("Ab"),
  AIS ("A#"),
  C ("C"),
  D ("D"),
  E ("E"),
  F ("F"),
  G ("G"),
  A ("A"),
  B ("B"),
  Bb ("Bb"),
  HES ("Hes"),
  H ("H");

  private Pitch (final String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  private final String label;


}
