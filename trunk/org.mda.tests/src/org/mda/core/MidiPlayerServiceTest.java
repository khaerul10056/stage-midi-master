package org.mda.core;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import java.io.File;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiPlayerRoot;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class MidiPlayerServiceTest {

  private static final Log LOGGER  = LogFactory.getLogger(MidiPlayerServiceTest.class);
  private static MidiPlayerRoot loadRootObject;
//1,398


  @BeforeClass
  public static void beforeClass () {
    loadRootObject = MidiPlayerService.loadRootObject(new File ("conf/midiplayer.conf"));
  }

  @Test
  public void moveDown () {
    MidiFile file = (MidiFile) EcoreUtil.copy(loadRootObject.getGallery().getGalleryItems().get(0));

    int lastPartIndex = file.getParts().size() - 1;
    int prelastPartIndex = file.getParts().size() - 2;

    MidiFilePartType type1 = file.getParts().get(lastPartIndex).getParttype();
    MidiFilePartType type2 = file.getParts().get(lastPartIndex - 1).getParttype();

    //Move last part down should do nothing
    MidiFilePart lastPartToMove = file.getParts().get(lastPartIndex);
    MidiFilePart movedPart = MidiPlayerService.movePartDown(file, lastPartToMove);
    assertEquals (movedPart, lastPartToMove);
    assertEquals (type1, file.getParts().get(lastPartIndex).getParttype());
    assertEquals (type2, file.getParts().get(prelastPartIndex).getParttype());

    //Move any other part down should work
    MidiFilePart prelastPartToMove = file.getParts().get(prelastPartIndex);
    movedPart = MidiPlayerService.movePartDown(file, prelastPartToMove);
    assertEquals (movedPart, prelastPartToMove);
    assertEquals (type1, file.getParts().get(prelastPartIndex).getParttype());
    assertEquals (type2, file.getParts().get(lastPartIndex).getParttype());
  }

  @Test
  public void moveUp () {
    MidiFile file = (MidiFile) EcoreUtil.copy(loadRootObject.getGallery().getGalleryItems().get(0));

    MidiFilePartType type1 = file.getParts().get(0).getParttype();
    MidiFilePartType type2 = file.getParts().get(1).getParttype();

    //Move first part up should do nothing
    MidiFilePart firstPartToMove = file.getParts().get(0);
    MidiFilePart movedPart = MidiPlayerService.movePartUp(file, firstPartToMove);
    assertEquals (movedPart, firstPartToMove);
    assertEquals (type1, file.getParts().get(0).getParttype());
    assertEquals (type2, file.getParts().get(1).getParttype());

    //Move any other part up should work
    MidiFilePart secondPartToMove = file.getParts().get(1);
    movedPart = MidiPlayerService.movePartUp(file, secondPartToMove);
    assertEquals (movedPart, secondPartToMove);
    assertEquals (type1, file.getParts().get(1).getParttype());
    assertEquals (type2, file.getParts().get(0).getParttype());
  }


  @Test
  public void removePart () {
    MidiFile file = (MidiFile) EcoreUtil.copy(loadRootObject.getGallery().getGalleryItems().get(0));
    assertEquals (MidiFilePartType.INTRO, file.getParts().get(0).getParttype());
    assertEquals (MidiFilePartType.VERS, file.getParts().get(1).getParttype());
    assertNotSame(MidiFilePartType.ZWISCHENSPIEL, file.getParts().get(2).getParttype());
    int numberOfParts = file.getParts().size();
    MidiPlayerService.removePart(file, file.getParts().get(1));
    assertEquals (MidiFilePartType.INTRO, file.getParts().get(0).getParttype());
    assertNotSame(MidiFilePartType.ZWISCHENSPIEL, file.getParts().get(1).getParttype());
    assertEquals (numberOfParts - 1, file.getParts().size());

    do {
      //LOGGER.info("Remove part " + file.getParts().get(0).getParttype() + ", " + file.getParts().size());
      MidiPlayerService.removePart(file, file.getParts().get(0));
      //LOGGER.info("Removed part " + file.getParts().get(0).getParttype() + ", " + file.getParts().size());
      LOGGER.info("-" + MidiPlayerService.getMidiFileAsString(file));
    }
    while (file.getParts().size() > 0);

    assertEquals (0, file.getParts().size());

  }


  @Test
  public void addNewPartRef () {
    MidiFile file = (MidiFile) EcoreUtil.copy(loadRootObject.getGallery().getGalleryItems().get(0));
    LOGGER.info("Vorher: " + MidiPlayerService.toString(file));
    int numberOfParts = file.getParts().size();
    MidiPlayerService.addPartAfter(file, null , null, file.getParts().get(0));
    MidiFilePart lastPart = file.getParts().get(file.getParts().size() - 1);
    assertEquals (file.getParts().get(0), lastPart.getRefPart());
    assertEquals  (lastPart.getParttype(), lastPart.getRefPart().getParttype());
    assertEquals (file.getParts().size(), numberOfParts +1);
  }

  @Test
  public void addNewPartAfter () {
    MidiFile file = (MidiFile) EcoreUtil.copy(loadRootObject.getGallery().getGalleryItems().get(0));
    LOGGER.info("Vorher: " + MidiPlayerService.toString(file));
    int numberOfParts = file.getParts().size();

    assertEquals (MidiFilePartType.INTRO, file.getParts().get(0).getParttype());
    assertEquals (MidiFilePartType.VERS, file.getParts().get(1).getParttype());
    assertNotSame(MidiFilePartType.ZWISCHENSPIEL, file.getParts().get(file.getParts().size() - 1).getParttype());

    MidiPlayerService.addPartAfter(file, null, MidiFilePartType.ZWISCHENSPIEL, null);

    MidiFilePart lastPart = file.getParts().get(file.getParts().size() - 1);

    assertEquals (MidiFilePartType.INTRO, file.getParts().get(0).getParttype());
    assertEquals (MidiFilePartType.VERS, file.getParts().get(1).getParttype());
    assertEquals (MidiFilePartType.REFRAIN, file.getParts().get(2).getParttype());
    assertEquals (MidiFilePartType.ZWISCHENSPIEL, lastPart.getParttype());
    assertNull (lastPart.getRefPart());

    assertEquals (file.getParts().size(), numberOfParts +1);

  }

  @Test
  public void addNewPartEnd () {
    MidiFile file = (MidiFile) EcoreUtil.copy(loadRootObject.getGallery().getGalleryItems().get(0));
    LOGGER.info("Vorher: " + MidiPlayerService.toString(file));
    int numberOfParts = file.getParts().size();

    assertEquals (MidiFilePartType.INTRO, file.getParts().get(0).getParttype());
    assertEquals (MidiFilePartType.VERS, file.getParts().get(1).getParttype());
    assertEquals (MidiFilePartType.REFRAIN, file.getParts().get(2).getParttype());
    assertEquals (MidiFilePartType.REFRAIN, file.getParts().get(2).getParttype());

    MidiPlayerService.addPartAfter(file, file.getParts().get(0), MidiFilePartType.ZWISCHENSPIEL, null);

    assertEquals (MidiFilePartType.INTRO, file.getParts().get(0).getParttype());
    assertEquals (MidiFilePartType.ZWISCHENSPIEL, file.getParts().get(1).getParttype());
    assertNull (file.getParts().get(1).getRefPart());
    assertEquals (MidiFilePartType.VERS, file.getParts().get(2).getParttype());
    assertEquals (MidiFilePartType.REFRAIN, file.getParts().get(3).getParttype());

    assertEquals (file.getParts().size(), numberOfParts +1);

  }

  @Test
  public void splitPart () {
    MidiFile file = (MidiFile) EcoreUtil.copy(loadRootObject.getGallery().getGalleryItems().get(0));
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
    MidiFile file = (MidiFile) EcoreUtil.copy(loadRootObject.getGallery().getGalleryItems().get(0));
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