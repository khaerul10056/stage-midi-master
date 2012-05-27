package org.mda.struct;

import mda.MidiFilePart;
import mda.MidiFilePartType;


public class MidiFileStructItem {

  private MidiFilePartType type;

  /**
   * E.g. the second refrain is shown as 2
   */
  private Integer index = new Integer(1);

  /**
   * the times, this part is shown after itself
   */
  private Integer cumulation = 1;

  /**
   * if the current part was shown before (but not directly before), the content of the current part
   * can be skipped, and only the struct-tag is shown, e.g.
   * ->REFRAIN1 ....
   * VERS ....
   * ->REFRAIN1
   * .........
   */
  private boolean isContentShown = true;

  /**
   * if the current part was shown directory before
   * VERS
   * REFRAIN 1
   * REFRAIN 1
   *
   * gets to VERS
   *         REFRAIN 2x
   *         (REFRAIN not visible)
   */
  private boolean isVisible = true;

  private MidiFilePart part;

  public boolean isContentShown () {
    return isContentShown;
  }

  public void setContentShown (boolean isContentShown) {
    this.isContentShown = isContentShown;
  }

  public Integer getIndex () {
    return index;
  }

  public void setIndex (Integer index) {
    this.index = index;
  }

  /**
   * returns the tag-label to be shown for the current structitem
   * @return label
   */
  public String getLabel () {
    if (! isVisible())
      return null;

    StringBuilder builder = new StringBuilder();
    builder.append(getType().getName());
    if (getIndex() != null)
      builder.append(getIndex());

    if (getCumulation() != null && getCumulation().intValue() > 1) {
      builder.append (" " + getCumulation() + "x");
    }

    return builder.toString() + " ";
  }

  public MidiFilePartType getType () {
    return type;
  }

  public void setType (MidiFilePartType type) {
    this.type = type;
  }

  public MidiFilePart getPart () {
    return part;
  }

  public void setPart (MidiFilePart part) {
    this.part = part;
  }

  public void increaseCumulation () {
    cumulation ++;

  }

  public Integer getCumulation () {
    return cumulation;
  }

  public boolean isVisible () {
    return isVisible;
  }

  public void setVisible (boolean isVisible) {
    this.isVisible = isVisible;
  }

}
