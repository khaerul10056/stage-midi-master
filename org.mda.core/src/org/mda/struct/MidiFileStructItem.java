package org.mda.struct;

import mda.MidiFilePart;
import mda.MidiFilePartType;


public class MidiFileStructItem {

  private MidiFilePartType type;

  /**
   * E.g. the second refrain is shown as 2
   */
  private Integer index = 1;

  /**
   * the times, this part is shown after itself
   */
  private Integer cumulation = 1;

  /**
   * if the current part was shown before, the content of the current part
   * can be skipped, and only the struct-tag is shown, e.g.
   * REFRAIN
   * .........
   */
  private boolean isContentShown = true;

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

}
