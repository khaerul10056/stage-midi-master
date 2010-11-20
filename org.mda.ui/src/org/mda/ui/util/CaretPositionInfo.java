package org.mda.ui.util;

import mda.MidiFileChordPart;

public class CaretPositionInfo {

  private final MidiFileChordPart part;

  private final int index;

  public CaretPositionInfo (final MidiFileChordPart part, final int index) {
    this.part = part;
    this.index = index;
 }

  public int getIndex() {
    return index;
  }

  public MidiFileChordPart getPart() {
    return part;
  }

}
