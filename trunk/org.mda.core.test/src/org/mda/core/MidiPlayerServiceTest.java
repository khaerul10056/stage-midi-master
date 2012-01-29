package org.mda.core;

import java.io.File;
import java.util.logging.Logger;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiPlayerRoot;
import org.junit.Test;
import org.mda.MidiPlayerService;
import static junit.framework.Assert.*;


public class MidiPlayerServiceTest {

  private static final Logger LOGGER  = Logger.getLogger(MidiPlayerServiceTest.class.getName());

  @Test
  public void splitPart () {
    MidiPlayerRoot loadRootObject = MidiPlayerService.loadRootObject(new File ("../org.mda.core.test/conf/midiplayer.conf"));
    MidiFile file = (MidiFile) loadRootObject.getGallery().getGalleryItems().get(0);
    LOGGER.info(MidiPlayerService.getMidiFileAsString(file));
    int partNumberBefore = file.getParts().size();

    MidiFilePart firstPartWithText = file.getParts().get(1);
    MidiPlayerService.splitPart(file, firstPartWithText, 2);

    assertEquals (partNumberBefore + 1, file.getParts().size());
    assertEquals (file.getParts().get(1).getParttype(), file.getParts().get(2).getParttype());

    LOGGER.info(MidiPlayerService.getMidiFileAsString(file));

    //TODO Check content



  }

}
