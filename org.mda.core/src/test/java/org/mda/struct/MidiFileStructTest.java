package org.mda.struct;

import java.util.List;

import mda.Song;
import mda.SongPartType;

import org.junit.Assert;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.test.SongCreator;

public class MidiFileStructTest {
	private static final Log LOGGER  = LogFactory.getLogger(MidiFileStructTest.class);

	  @Test
	  public void partCounts () {

	    SongCreator creator = SongCreator.create();
	    creator = creator.part(SongPartType.INTRO);
	    creator = creator.part(SongPartType.REFRAIN);
	    creator = creator.part(SongPartType.VERS);
	    creator = creator.part(SongPartType.VERS);
	    creator = creator.refPart(1);
	    creator = creator.part(SongPartType.VERS);
	    creator = creator.refPart(5);
	    creator = creator.refPart(5);

	    Song file = creator.get();
	    SongStruct struct = new SongStruct(file);

	    LOGGER.info(MidiPlayerService.toString(file));

	    List<SongStructItem> items = struct.getItems();

	    //Intro 1
	    Assert.assertNull (items.get(0).getIndex()); // because its the only INTRO
	    Assert.assertEquals (1, items.get(0).getCumulation().intValue());
	    Assert.assertTrue (items.get(0).isContentShown());
	    Assert.assertEquals (file.getParts().get(0), items.get(0).getPart());
	    Assert.assertEquals (file.getParts().get(0).getParttype(), items.get(0).getType());

	    //Refrain 1
	    Assert.assertNull (items.get(1).getIndex()); //because its the only REFRAIN
	    Assert.assertEquals (1, items.get(1).getCumulation().intValue());
	    Assert.assertTrue (items.get(1).isContentShown());
	    Assert.assertEquals (file.getParts().get(1), items.get(1).getPart());
	    Assert.assertEquals (file.getParts().get(1).getParttype(), items.get(1).getType());

	    //Vers 1
	    Assert.assertEquals (1, items.get(2).getIndex().intValue());
	    Assert.assertEquals (1, items.get(2).getCumulation().intValue());
	    Assert.assertTrue (items.get(2).isContentShown());
	    Assert.assertEquals (file.getParts().get(2), items.get(2).getPart());
	    Assert.assertEquals (file.getParts().get(2).getParttype(), items.get(2).getType());

	    //Vers 2
	    Assert.assertEquals (2, items.get(3).getIndex().intValue());
	    Assert.assertEquals (1, items.get(3).getCumulation().intValue());
	    Assert.assertTrue (items.get(3).isContentShown());
	    Assert.assertEquals (file.getParts().get(3), items.get(3).getPart());
	    Assert.assertEquals (file.getParts().get(3).getParttype(), items.get(3).getType());

	    //Ref to Refrain 1
	    Assert.assertNull (items.get(4).getIndex()); //-1 because its the only REFRAIN
	    Assert.assertEquals (1, items.get(4).getCumulation().intValue());
	    Assert.assertFalse (items.get(4).isContentShown());
	    Assert.assertEquals (file.getParts().get(4), items.get(4).getPart());
	    Assert.assertEquals (file.getParts().get(4).getParttype(), items.get(4).getType());

	    //Vers 3 3x
	    Assert.assertEquals (3, items.get(5).getIndex().intValue());
	    Assert.assertEquals (3, items.get(5).getCumulation().intValue());
	    Assert.assertTrue (items.get(5).isContentShown());
	    Assert.assertEquals (file.getParts().get(5), items.get(5).getPart());
	    Assert.assertEquals (file.getParts().get(5).getParttype(), items.get(5).getType());

	    Assert.assertEquals (8, items.size());

	    Assert.assertEquals ("INTRO ", items.get(0).getLabel());
	    Assert.assertEquals ("REFRAIN ", items.get(1).getLabel());
	    Assert.assertEquals ("VERS1 ", items.get(2).getLabel());
	    Assert.assertEquals ("VERS2 ", items.get(3).getLabel());
	    Assert.assertEquals ("REFRAIN ", items.get(4).getLabel());
	    Assert.assertEquals ("VERS3 3x ", items.get(5).getLabel());
	    Assert.assertNull (items.get(6).getLabel());
	    Assert.assertNull (items.get(7).getLabel());
	  }

	  @Test
	  public void productiveExample () {
	    SongCreator creator = SongCreator.create();
	    creator = creator.part(SongPartType.INTRO);
	    creator = creator.part(SongPartType.VERS);
	    creator = creator.part(SongPartType.REFRAIN);
	    creator = creator.part(SongPartType.REFRAIN);
	    creator = creator.refPart(1);
	    creator = creator.refPart(2);
	    creator = creator.refPart(3);
	    creator = creator.part(SongPartType.SOLO);
	    creator = creator.refPart(2);
	    creator = creator.part(SongPartType.REFRAIN);
	    creator = creator.part(SongPartType.REFRAIN);

	    Song file = creator.get();
	    SongStruct struct = new SongStruct(file);
	    for (SongStructItem nextStructItem: struct.getItems()) {
	      LOGGER.info(nextStructItem.getLabel());
	    }

	    Assert.assertEquals("INTRO ", struct.getItems().get(0).getLabel());
	    Assert.assertEquals("VERS ", struct.getItems().get(1).getLabel());
	    Assert.assertEquals("REFRAIN1 ", struct.getItems().get(2).getLabel());
	    Assert.assertEquals("REFRAIN2 ", struct.getItems().get(3).getLabel());
	    Assert.assertEquals("VERS ", struct.getItems().get(4).getLabel());
	    Assert.assertEquals("REFRAIN1 ", struct.getItems().get(5).getLabel());
	    Assert.assertEquals("REFRAIN2 ", struct.getItems().get(6).getLabel());
	    Assert.assertEquals("SOLO ", struct.getItems().get(7).getLabel());
	    Assert.assertEquals("REFRAIN1 ", struct.getItems().get(8).getLabel());
	    Assert.assertEquals("REFRAIN3 ", struct.getItems().get(9).getLabel());
	    Assert.assertEquals("REFRAIN4 ", struct.getItems().get(10).getLabel());
	    Assert.assertEquals(11, struct.getItems().size());




	  }

}
