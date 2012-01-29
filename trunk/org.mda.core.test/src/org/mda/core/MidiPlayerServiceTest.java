package org.mda.core;

import java.io.File;
import java.util.logging.Logger;
import junit.framework.Assert;
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
    MidiFilePart splitPart = MidiPlayerService.splitPart(file, firstPartWithText, 2);

    assertNotNull (splitPart);
    assertEquals (partNumberBefore + 1, file.getParts().size());
    assertEquals (file.getParts().get(1).getParttype(), file.getParts().get(2).getParttype());

    LOGGER.info(MidiPlayerService.getMidiFileAsString(file));

    MidiFilePart secondPart = file.getParts().get(2);
    assertEquals (2, firstPartWithText.getTextlines().size());
    assertEquals (2, secondPart.getTextlines().size());

    //Wrong parameter: Part of another song
    MidiFile file2 = (MidiFile) loadRootObject.getGallery().getGalleryItems().get(1);
    Assert.assertNull(MidiPlayerService.splitPart(file2, firstPartWithText, 3));
  }

}
