package org.mda.core;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import java.io.File;
import junit.framework.Assert;
import mda.Gallery;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiPlayerRoot;
import mda.Session;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.test.MidiFileCreator;


public class MidiPlayerServiceTest {

  private static final Log LOGGER  = LogFactory.getLogger(MidiPlayerServiceTest.class);
  private static MidiPlayerRoot loadRootObject;
//1,398


  @BeforeClass
  public static void beforeClass () {
    loadRootObject = MidiPlayerService.loadRootObject(new File ("conf/midiplayer.conf"));
  }
  

  @Test
  public void removeReferences () {
    MidiFile creator = MidiFileCreator.create().setName("Hello").get();
    MidiFile creator2 = MidiFileCreator.create().setName("Hello2").get();
    final String TESTSESSION = "TESTSESSION";

    MidiPlayerRoot root = MidiPlayerService.mf.createMidiPlayerRoot();
    Gallery gallery = MidiPlayerService.mf.createGallery();
    gallery.getGalleryItems().add(creator2);
    gallery.getGalleryItems().add(creator);
    root.setGallery(gallery);

    Session session = MidiPlayerService.mf.createSession();
    session.setName(TESTSESSION);
    session.getItems().add(creator2);
    root.getSessions().add(session);

    Assert.assertEquals (2, root.getGallery().getGalleryItems().size());
    Assert.assertEquals (1, root.getSessions().get(0).getItems().size());

    MidiPlayerService.removeSongAndReferences(root, creator2);


    Assert.assertEquals (1, root.getGallery().getGalleryItems().size());
    Assert.assertEquals (0, root.getSessions().get(0).getItems().size());

  }

  @Test
  public void getReferenced () {

    MidiFile creator = MidiFileCreator.create().setName("Hello").get();
    MidiFile creator2 = MidiFileCreator.create().setName("Hello2").get();
    final String TESTSESSION = "TESTSESSION";

    MidiPlayerRoot root = MidiPlayerService.mf.createMidiPlayerRoot();
    Session session = MidiPlayerService.mf.createSession();
    session.setName(TESTSESSION);
    session.getItems().add(creator2);
    root.getSessions().add(session);

    String referenced1 = MidiPlayerService.getReferenced(root, creator);
    Assert.assertNull (referenced1);

    String referenced2 = MidiPlayerService.getReferenced(root, creator2);
    Assert.assertTrue(referenced2.indexOf(TESTSESSION) >= 0);

  }

  @Test
  public void clonePart () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.VERS).line().chordAndText("D", "This is a testline");
    creator = creator.part(MidiFilePartType.REFRAIN).line().chordAndText("D", "This is a testrefrain");
    creator = creator.refPart(0);
    MidiFile file = creator.get();

    MidiFile fileCloned = EcoreUtil.copy(file);

    //Clone normal part
    MidiPlayerService.clonePart(fileCloned, fileCloned.getParts().get(0));
    String firstString = MidiPlayerService.toString(fileCloned.getParts().get(0));
    String clonedString = MidiPlayerService.toString(fileCloned.getParts().get(1));
    Assert.assertEquals (firstString, clonedString);
    Assert.assertEquals (MidiFilePartType.REFRAIN, fileCloned.getParts().get(2).getParttype());
  }

  @Test
  public void clonePartRef () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.VERS).line().chordAndText("D", "This is a testline");
    creator = creator.refPart(0);
    MidiFile file = creator.get();

    MidiFile fileCloned = EcoreUtil.copy(file);

    //Clone ref part
    MidiPlayerService.clonePart(fileCloned, fileCloned.getParts().get(1));
    String firstString = MidiPlayerService.toString(fileCloned.getParts().get(1));
    String clonedString = MidiPlayerService.toString(fileCloned.getParts().get(2));
    Assert.assertEquals (firstString, clonedString);
    Assert.assertEquals (3, fileCloned.getParts().size());
  }

  @Test
  public void removeLine () {
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.VERS);
    creator = creator.line().chordAndText("D", "This is a testline");
    creator = creator.line().chordAndText("D", "This is another testline");
    MidiFile file = creator.get();
    MidiPlayerService.removeLine(file.getParts().get(0), 0);
    Assert.assertEquals(1, file.getParts().get(0).getTextlines().size());
    Assert.assertTrue (file.getParts().get(0).getTextlines().get(0).getChordParts().get(0).getText().startsWith("This is another"));

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
