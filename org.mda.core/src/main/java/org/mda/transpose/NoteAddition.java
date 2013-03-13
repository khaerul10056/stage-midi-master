package org.mda.transpose;

public enum NoteAddition {
  maj ("maj"),
  min ("min"),
  sus ("sus");

  private NoteAddition (final String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  private final String label;

}
