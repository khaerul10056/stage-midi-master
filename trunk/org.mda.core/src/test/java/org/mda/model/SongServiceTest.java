package org.mda.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import mda.Song;
import mda.SongPart;
import mda.SongPartType;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.test.SongCreator;

/**
 * tests from {@link SongService}
 * @author OleyMa
 */
public class SongServiceTest {

	private static final Log LOGGER = LogFactory.getLogger(SongServiceTest.class);

	private final SongService songservice = new SongService();

	/**
	 * creates song for test
	 * 
	 * @return song
	 */
	private Song createSong() {
		SongCreator creator = SongCreator.create();
		creator = creator.part(SongPartType.INTRO).line().chord("D").chord("G").chord("D");
		creator = creator.part(SongPartType.VERS).line().chordAndText("D", "This is the first part");
		creator = creator.part(SongPartType.REFRAIN).line().chordAndText("D", "This is the second part");
		return creator.get();
	}
	
	@Test
	  public void clonePart () {
	    SongCreator creator = SongCreator.create();
	    creator = creator.part(SongPartType.VERS).line().chordAndText("D", "This is a testline");
	    creator = creator.part(SongPartType.REFRAIN).line().chordAndText("D", "This is a testrefrain");
	    creator = creator.refPart(0);
	    Song file = creator.get();

	    Song fileCloned = EcoreUtil.copy(file);

	    //Clone normal part
	    MidiPlayerService.clonePart(fileCloned, fileCloned.getParts().get(0));
	    String firstString = MidiPlayerService.toString(fileCloned.getParts().get(0));
	    String clonedString = MidiPlayerService.toString(fileCloned.getParts().get(1));
	    Assert.assertEquals (firstString, clonedString);
	    Assert.assertEquals (SongPartType.REFRAIN, fileCloned.getParts().get(2).getParttype());
	  }

	  @Test
	  public void clonePartRef () {
	    Song file = createSong();

	    //Clone ref part
	    MidiPlayerService.clonePart(file, file.getParts().get(1));
	    String firstString = MidiPlayerService.toString(file.getParts().get(1));
	    String clonedString = MidiPlayerService.toString(file.getParts().get(2));
	    Assert.assertEquals (firstString, clonedString);
	    Assert.assertEquals (4, file.getParts().size());
	  }
	  
	

	  @Test
	  public void splitPart () {
		Song file = createSong();

	    LOGGER.info(MidiPlayerService.getMidiFileAsString(file));
	    int partNumberBefore = file.getParts().size();

	    SongPart firstPartWithText = file.getParts().get(1);
	    SongPart splitPart = MidiPlayerService.splitPart(file, firstPartWithText, 2);

	    assertNotNull (splitPart);
	    assertEquals (partNumberBefore + 1, file.getParts().size());
	    assertEquals (file.getParts().get(1).getParttype(), file.getParts().get(2).getParttype());

	    LOGGER.info(MidiPlayerService.getMidiFileAsString(file));

	    SongPart secondPart = file.getParts().get(2);
	    assertEquals (1, firstPartWithText.getTextlines().size());
	    assertEquals (0, secondPart.getTextlines().size());

	    //Wrong parameter: Part of another song
	    Song file2 = createSong();
	    assertNull(MidiPlayerService.splitPart(file2, firstPartWithText, 3));
	  }

	  @Test
	  public void mergeParts () {
	    Song file = createSong();
	    LOGGER.info(MidiPlayerService.getMidiFileAsString(file));
	    int partNumberBefore = file.getParts().size();

	    SongPart introPart = file.getParts().get(0);
	    SongPart firstPartWithText = file.getParts().get(1);
	    SongPart secondPartWithText = file.getParts().get(2);

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
	    SongPart prelast = file.getParts().get(file.getParts().size() - 2);
	    SongPart last = file.getParts().get(file.getParts().size() - 1);

	    int gesamtNumberEnd = prelast.getTextlines().size() + last.getTextlines().size();
	    assertEquals (prelast, MidiPlayerService.mergeWithPreviousPart(file, last));
	    assertEquals (gesamtNumberEnd, prelast.getTextlines().size());
	    assertTrue (file.getParts().contains(prelast));
	    assertFalse (file.getParts().contains(last));
	  }

	@Test
	public void moveDownAny() {
		Song file = createSong();
		int lastPartIndex = file.getParts().size() - 1;
		int prelastPartIndex = file.getParts().size() - 2;
		SongPartType type1 = file.getParts().get(lastPartIndex).getParttype();
		SongPartType type2 = file.getParts().get(lastPartIndex - 1)
				.getParttype();

		// Move any other part down should work
		SongPart prelastPartToMove = file.getParts().get(prelastPartIndex);
		SongPart movedPart = songservice.movePartDown(file, prelastPartToMove);
		assertEquals(movedPart, prelastPartToMove);
		assertEquals(type1, file.getParts().get(prelastPartIndex).getParttype());
		assertEquals(type2, file.getParts().get(lastPartIndex).getParttype());

	}

	@Test
	public void moveDownLast() {
		Song file = createSong();
		int lastPartIndex = file.getParts().size() - 1;
		int prelastPartIndex = file.getParts().size() - 2;
		SongPartType type1 = file.getParts().get(lastPartIndex).getParttype();
		SongPartType type2 = file.getParts().get(lastPartIndex - 1)
				.getParttype();

		// Move last part down should do nothing
		SongPart lastPartToMove = file.getParts().get(lastPartIndex);
		SongPart movedPart = songservice.movePartDown(file, lastPartToMove);
		assertEquals(movedPart, lastPartToMove);
		assertEquals(type1, file.getParts().get(lastPartIndex).getParttype());
		assertEquals(type2, file.getParts().get(prelastPartIndex).getParttype());
	}

	@Test
	public void moveUpFirst() {
		Song file = createSong();
		SongPartType type1 = file.getParts().get(0).getParttype();
		SongPartType type2 = file.getParts().get(1).getParttype();

		// Move first part up should do nothing
		SongPart firstPartToMove = file.getParts().get(0);
		SongPart movedPart = songservice.movePartUp(file, firstPartToMove);
		assertEquals(movedPart, firstPartToMove);
		assertEquals(type1, file.getParts().get(0).getParttype());
		assertEquals(type2, file.getParts().get(1).getParttype());
	}

	@Test
	public void moveUpNonFirst() {
		Song file = createSong();
		SongPartType type1 = file.getParts().get(0).getParttype();
		SongPartType type2 = file.getParts().get(1).getParttype();

		// Move any other part up should work
		SongPart secondPartToMove = file.getParts().get(1);
		SongPart movedPart = songservice.movePartUp(file, secondPartToMove);
		assertEquals(movedPart, secondPartToMove);
		assertEquals(type1, file.getParts().get(1).getParttype());
		assertEquals(type2, file.getParts().get(0).getParttype());
	}

	@Test
	public void removePart() {
		Song file = createSong();
		assertEquals(SongPartType.INTRO, file.getParts().get(0).getParttype());
		assertEquals(SongPartType.VERS, file.getParts().get(1).getParttype());
		assertNotSame(SongPartType.ZWISCHENSPIEL, file.getParts().get(2)
				.getParttype());
		int numberOfParts = file.getParts().size();
		songservice.removePart(file, file.getParts().get(1));
		assertEquals(SongPartType.INTRO, file.getParts().get(0).getParttype());
		assertNotSame(SongPartType.ZWISCHENSPIEL, file.getParts().get(1)
				.getParttype());
		assertEquals(numberOfParts - 1, file.getParts().size());

		do {
			songservice.removePart(file, file.getParts().get(0));
		} while (file.getParts().size() > 0);

		assertEquals(0, file.getParts().size());

	}
	
	@Test
	public void addNewPartRef() {
		Song file = createSong();
		LOGGER.info("Vorher: " + MidiPlayerService.toString(file));
		int numberOfParts = file.getParts().size();
		songservice.addPartAfter(file, null, null, file.getParts().get(0));
		SongPart lastPart = file.getParts().get(file.getParts().size() - 1);
		assertEquals(file.getParts().get(0), lastPart.getRefPart());
		assertEquals(lastPart.getParttype(), lastPart.getRefPart()
				.getParttype());
		assertEquals(file.getParts().size(), numberOfParts + 1);
	}

	@Test
	public void addNewPartAfter() {
		Song file = createSong();
		LOGGER.info("Vorher: " + MidiPlayerService.toString(file));
		int numberOfParts = file.getParts().size();

		assertEquals(SongPartType.INTRO, file.getParts().get(0).getParttype());
		assertEquals(SongPartType.VERS, file.getParts().get(1).getParttype());
		assertNotSame(SongPartType.ZWISCHENSPIEL,
				file.getParts().get(file.getParts().size() - 1).getParttype());

		songservice.addPartAfter(file, null, SongPartType.ZWISCHENSPIEL, null);

		SongPart lastPart = file.getParts().get(file.getParts().size() - 1);

		assertEquals(SongPartType.INTRO, file.getParts().get(0).getParttype());
		assertEquals(SongPartType.VERS, file.getParts().get(1).getParttype());
		assertEquals(SongPartType.REFRAIN, file.getParts().get(2).getParttype());
		assertEquals(SongPartType.ZWISCHENSPIEL, lastPart.getParttype());
		assertNull(lastPart.getRefPart());

		assertEquals(file.getParts().size(), numberOfParts + 1);

	}

	@Test
	public void addNewPartEnd() {
		Song file = createSong();
		LOGGER.info("Vorher: " + MidiPlayerService.toString(file));
		int numberOfParts = file.getParts().size();

		assertEquals(SongPartType.INTRO, file.getParts().get(0).getParttype());
		assertEquals(SongPartType.VERS, file.getParts().get(1).getParttype());
		assertEquals(SongPartType.REFRAIN, file.getParts().get(2).getParttype());
		assertEquals(SongPartType.REFRAIN, file.getParts().get(2).getParttype());

		songservice.addPartAfter(file, file.getParts().get(0),SongPartType.ZWISCHENSPIEL, null);

		assertEquals(SongPartType.INTRO, file.getParts().get(0).getParttype());
		assertEquals(SongPartType.ZWISCHENSPIEL, file.getParts().get(1)
				.getParttype());
		assertNull(file.getParts().get(1).getRefPart());
		assertEquals(SongPartType.VERS, file.getParts().get(2).getParttype());
		assertEquals(SongPartType.REFRAIN, file.getParts().get(3).getParttype());

		assertEquals(file.getParts().size(), numberOfParts + 1);

	}

}
