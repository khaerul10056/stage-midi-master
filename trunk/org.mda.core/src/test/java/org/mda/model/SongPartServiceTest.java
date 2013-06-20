package org.mda.model;

import mda.Song;
import mda.SongPartType;

import org.junit.Assert;
import org.junit.Test;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.test.SongCreator;

/**
 * Tests for the SongPartService
 * 
 * @author OleyMa
 * 
 */
public class SongPartServiceTest {

	private static final Log LOGGER = LogFactory.getLogger(SongPartServiceTest.class);

	private SongPartService songpartservice = new SongPartService();

	@Test
	public void removeLine() {
		SongCreator creator = SongCreator.create().part(SongPartType.VERS);
		creator = creator.line().chordAndText("D", "This is a testline");
		creator = creator.line().chordAndText("D", "This is another testline");
		Song file = creator.get();
		songpartservice.removeLine(file.getParts().get(0), 0);
		Assert.assertEquals(1, file.getParts().get(0).getTextlines().size());
		Assert.assertTrue(file.getParts().get(0).getTextlines().get(0).getChordParts().get(0).getText().startsWith("This is another"));
	}

}
