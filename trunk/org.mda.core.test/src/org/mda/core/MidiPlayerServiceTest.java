package org.mda.core;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.logging.Logger;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiPlayerRoot;
import org.junit.Test;
import org.mda.MidiPlayerService;


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
    assertNull(MidiPlayerService.splitPart(file2, firstPartWithText, 3));
  }

  @Test
  public void mergeParts () {
    MidiPlayerRoot loadRootObject = MidiPlayerService.loadRootObject(new File ("../org.mda.core.test/conf/midiplayer.conf"));
    MidiFile file = (MidiFile) loadRootObject.getGallery().getGalleryItems().get(0);
    LOGGER.info(MidiPlayerService.getMidiFileAsString(file));
    int partNumberBefore = file.getParts().size();


    MidiFilePart introPart = file.getParts().get(0);
    MidiFilePart firstPartWithText = file.getParts().get(1);
    MidiFilePart secondPartWithText = file.getParts().get(2);


    //Wrong parameter: First part cannot be merged to previous part
    assertEquals (introPart, MidiPlayerService.mergeWithPreviousPart(file, introPart));
    assertEquals (partNumberBefore, file.getParts().size());

    //Correct merge
    assertEquals (firstPartWithText, MidiPlayerService.mergeWithPreviousPart(file, secondPartWithText));
    assertEquals (partNumberBefore - 1, file.getParts().size());

    int gesamtNumber = firstPartWithText.getTextlines().size() + secondPartWithText.getTextlines().size();
    assertEquals (gesamtNumber, firstPartWithText.getTextlines().size());
    assertTrue (file.getParts().contains(firstPartWithText));
    assertFalse (file.getParts().contains(secondPartWithText));

    //Merge last part to previous
    MidiFilePart prelast = file.getParts().get(file.getParts().size() - 2);
    MidiFilePart last = file.getParts().get(file.getParts().size() - 1);

    int gesamtNumberEnd = prelast.getTextlines().size() + last.getTextlines().size();
    assertEquals (prelast, MidiPlayerService.mergeWithPreviousPart(file, last));
    assertEquals (gesamtNumberEnd, prelast.getTextlines().size());
    assertTrue (file.getParts().contains(prelast));
    assertFalse (file.getParts().contains(last));






  }

}
