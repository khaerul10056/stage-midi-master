package org.mda;

import mda.MidiFileChordPart;

public class MidiFilePartRemoveToken {

  private final MidiFileChordPart part;

  private final int               offsetFrom;

  private final int               offsetTo;

  public MidiFilePartRemoveToken (final MidiFileChordPart part, final int from, final int to) {
    this.part = part;
    this.offsetFrom = from;
    this.offsetTo = to;

  }

  public MidiFileChordPart getPart () {
    return part;
  }

  public int getOffsetFrom () {
    return offsetFrom;
  }

  public int getOffsetTo () {
    return offsetTo;
  }

  public String toString () {
    return part +
      ":" + offsetFrom + ":" + offsetTo;
  }

  public boolean isInSelection (final int selectionfrom, final int selectionTo) {
    return getOffsetTo() >= selectionfrom && getOffsetFrom() < selectionTo;
  }


  public Integer getRemoveFrom (final int selectionfrom, final int selectionTo) {
    if (!isInSelection(selectionfrom, selectionTo))
      return null; //ausserhalb der Selection

    if (selectionfrom > getOffsetFrom()) //faengt nicht mit selektion an
      return new Integer(selectionfrom - getOffsetFrom());
    else
      return new Integer(0);
  }

  public Integer getRemoveTo (final int selectionfrom, final int selectionTo) {
    if (!isInSelection(selectionfrom, selectionTo))
      return null;

    if (getOffsetTo() < selectionTo)
      return new Integer(getPart().getText().length());
    else
      return new Integer(getPart().getText().length() - (getOffsetTo() - selectionTo));
  }

}
