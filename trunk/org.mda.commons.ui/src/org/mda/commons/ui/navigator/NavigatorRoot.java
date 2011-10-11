package org.mda.commons.ui.navigator;

import java.io.File;
import mda.MidiPlayerRoot;
import org.eclipse.core.runtime.PlatformObject;
import org.mda.MidiPlayerService;


public class NavigatorRoot extends PlatformObject {

  private MidiPlayerRoot root;

  public NavigatorRoot () {

    root = MidiPlayerService.loadRootObject(new File("/home/oleym/privat/soundOfFaith/stage-midi-master/org.mda.core.test/testdata/testmodel.conf")); //TODO

  }

  public MidiPlayerRoot getRoot () {
    return root;
  }



}
