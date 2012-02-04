package org.mda.editor.preview.ui;

import org.eclipse.swt.graphics.Color;
import mda.MidiFilePartType;


public class StepTypeColorInfo {

  private final MidiFilePartType parttype;

  private Color selected;

  private Color normal;

  public StepTypeColorInfo (final MidiFilePartType parttype) {
    this.parttype = parttype;
  }

  public MidiFilePartType getParttype () {
    return parttype;
  }

  public Color getSelected () {
    return selected;
  }

  public void setSelected (Color selected) {
    this.selected = selected;
  }

  public Color getNormal () {
    return normal;
  }

  public void setNormal (Color normal) {
    this.normal = normal;
  }

}
