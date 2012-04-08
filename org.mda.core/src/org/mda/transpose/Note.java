package org.mda.transpose;

public enum Note {
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
  H ("H"),

  cis ("c#"),
  des ("db"),
  dis ("d#"),
  es ("eb"),
  fis ("f#"),
  ges ("gb"),
  gis ("g#"),
  aS ("ab"),
  ais ("a#"),
  c ("c"),
  d ("d"),
  e ("e"),
  f ("f"),
  g ("g"),
  a ("a"),
  b ("b"),
  h ("h");


  private Note (final String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  private final String label;


}
