package org.mda.editor.preview.ui;

import org.eclipse.swt.graphics.Color;
import mda.SongPartType;


public class StepTypeColorInfo {

  private final SongPartType parttype;

  private Color selected;

  private Color normal;

  public StepTypeColorInfo (final SongPartType parttype) {
    this.parttype = parttype;
  }

  public SongPartType getParttype () {
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
