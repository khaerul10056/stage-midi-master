package org.mda.core.additionals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.List;
import mda.AdditionalType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mda.Utils;
import org.mda.additionals.Additional;
import org.mda.additionals.AdditionalsHandler;


public class TestAdditionalsHandler {

  private File forTest = new File ("additionalHandlerForTest");

  @Before
  public void setUp () {
    if (forTest.exists())
      Utils.deleteDirectory(forTest);

    assertFalse (forTest.exists());
  }

  @After
  public void tearDown () {
    if (forTest.exists())
      Utils.deleteDirectory(forTest);
  }

  @Test
  public void initialize () throws Exception {
    new AdditionalsHandler(forTest);
    File subdirectory = new File (forTest.getAbsolutePath(), "image");
    assertTrue (subdirectory.exists());
    assertEquals (AdditionalType.values().length, forTest.list().length);
  }

  @Test
  public void readAndRemove () throws Exception {
    AdditionalsHandler handler = new AdditionalsHandler(forTest);
    final String name1 = "This is a crazy song";
    final String suffix1 = "mp3";
    final String suffix2 = "midi";
    File mp3File = new File (handler.getAdditionalsPath().getAbsolutePath() + "/" + AdditionalType.MP3FILE.name().toLowerCase() +"/" + name1 + "." + suffix1);
    assertTrue (mp3File.createNewFile());

    File midifile = new File (handler.getAdditionalsPath().getAbsolutePath() + "/" + AdditionalType.MIDIFILE.name().toLowerCase() +"/" + name1 + "." +  suffix2);
    assertTrue (midifile.createNewFile());

    handler.read();
    assertEquals (2, handler.getAdditionals().size());

    List <Additional> sublistMp3s = handler.getAdditionals(AdditionalType.MP3FILE);
    assertEquals (1, sublistMp3s.size());

    assertEquals (AdditionalType.MP3FILE, sublistMp3s.get(0).getType());
    assertEquals (name1, sublistMp3s.get(0).getName());
    assertEquals (suffix1, sublistMp3s.get(0).getSuffix());

    List <Additional> sublistMidifiles = handler.getAdditionals(AdditionalType.MIDIFILE);
    assertEquals (1, sublistMidifiles.size());
    assertEquals (name1, sublistMidifiles.get(0).getName());
    assertEquals (suffix2, sublistMidifiles.get(0).getSuffix());

    Additional removeMp3s = sublistMp3s.get(0);
    File removeMp3File = removeMp3s.getFile();
    handler.remove(removeMp3s);

    assertEquals (0, handler.getAdditionals(AdditionalType.MP3FILE).size());
    assertFalse (removeMp3File.exists());

  }



}
