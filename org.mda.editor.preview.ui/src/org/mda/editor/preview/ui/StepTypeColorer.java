package org.mda.editor.preview.ui;

import mda.MidiFilePartType;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;


public class StepTypeColorer {



  public static StepTypeColorInfo getColorInfo (MidiFilePartType parttype) {
    StepTypeColorInfo infoRefrain = new StepTypeColorInfo(MidiFilePartType.REFRAIN);
    infoRefrain.setNormal(new Color(Display.getCurrent(), 255, 255, 245));
    infoRefrain.setSelected(new Color(Display.getCurrent(), 255, 245,135));
    return infoRefrain;
  }

}
