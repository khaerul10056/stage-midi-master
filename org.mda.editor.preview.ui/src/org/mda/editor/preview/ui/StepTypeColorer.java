package org.mda.editor.preview.ui;

import java.util.HashMap;
import mda.MidiFilePartType;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;


public class StepTypeColorer {

  private static HashMap<MidiFilePartType, StepTypeColorInfo> colorinfos = new HashMap<MidiFilePartType, StepTypeColorInfo>();

  static {
    StepTypeColorInfo infoRefrain = new StepTypeColorInfo(MidiFilePartType.REFRAIN);
    infoRefrain.setNormal(new Color(Display.getCurrent(), 232, 232, 255));
    infoRefrain.setSelected(new Color(Display.getCurrent(), 105, 105, 255));
    colorinfos.put(MidiFilePartType.REFRAIN, infoRefrain);

    StepTypeColorInfo infoVers = new StepTypeColorInfo(MidiFilePartType.VERS);
    infoVers.setNormal(new Color(Display.getCurrent(), 255, 255, 232));
    infoVers.setSelected(new Color(Display.getCurrent(), 255, 255,105));
    colorinfos.put(MidiFilePartType.VERS, infoVers);
  }

  public static StepTypeColorInfo getColorInfo (MidiFilePartType parttype) {
    StepTypeColorInfo colorInfoFromMap = colorinfos.get(parttype);
    if (colorInfoFromMap == null) {
      colorInfoFromMap = new StepTypeColorInfo(null);
      colorInfoFromMap.setNormal(new Color(Display.getCurrent(), 245, 245, 245));
      colorInfoFromMap.setSelected(new Color(Display.getCurrent(), 155, 155, 155));
    }

    return colorInfoFromMap;


  }

}
