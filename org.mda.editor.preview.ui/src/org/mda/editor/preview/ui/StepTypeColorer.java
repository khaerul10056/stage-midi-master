package org.mda.editor.preview.ui;

import mda.SongPartType;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;


public class StepTypeColorer {



  public static StepTypeColorInfo getColorInfo (SongPartType parttype) {
    StepTypeColorInfo infoRefrain = new StepTypeColorInfo(SongPartType.REFRAIN);
    infoRefrain.setNormal(new Color(Display.getCurrent(), 255, 255, 245));
    infoRefrain.setSelected(new Color(Display.getCurrent(), 255, 245,135));
    return infoRefrain;
  }

}
