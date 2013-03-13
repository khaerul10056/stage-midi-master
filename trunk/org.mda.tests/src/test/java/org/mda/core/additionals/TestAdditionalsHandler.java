package org.mda.core.additionals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.AdditionalType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mda.Utils;
import org.mda.additionals.Additional;
import org.mda.additionals.AdditionalSuffix;
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
  public void twoPointsInName () throws Exception {
    AdditionalsHandler handler = new AdditionalsHandler(forTest);

    final String FILENAME1 = "This is a test.mp3.wav";
    File from1 = new File (handler.getAdditionalsPath().getAbsolutePath() + File.separator + FILENAME1);
    from1.createNewFile();

    Collection <File> files = new ArrayList<File>();
    files.add(from1);
    handler.importFiles(files);
    assertEquals (AdditionalSuffix.WAV, handler.getAdditionals().iterator().next().getSuffix());

  }

  @Test
  public void importFiles () throws Exception {
    AdditionalsHandler handler = new AdditionalsHandler(forTest);

    final String FILENAME1 = "This is a test.mp3";
    File from1 = new File (handler.getAdditionalsPath().getAbsolutePath() + File.separator + FILENAME1);
    from1.createNewFile();
    final String FILENAME2 = "This is a test2.png";
    File from2 = new File (handler.getAdditionalsPath().getAbsolutePath() + File.separator + FILENAME2);
    from2.createNewFile();
    final String FILENAME3 = "This is a test2.txt";
    File from3 = new File (handler.getAdditionalsPath().getAbsolutePath() + File.separator + FILENAME3);
    from3.createNewFile();

    Collection <File> allFiles = new ArrayList<File>();
    allFiles.add(from1);
    allFiles.add(from2);
    allFiles.add(from3);

    String importFiles = handler.importFiles(allFiles);
    assertTrue (importFiles.indexOf("txt") > 0);

    assertEquals (2, handler.getAdditionals().size());
    assertEquals (1, handler.getAdditionals(AdditionalType.AUDIO).size());
    assertEquals (FILENAME1, handler.getAdditionals(AdditionalType.AUDIO).get(0).toString());

    assertEquals (1, handler.getAdditionals(AdditionalType.IMAGE).size());
    assertEquals (FILENAME2, handler.getAdditionals(AdditionalType.IMAGE).get(0).toString());

    assertEquals (0, handler.getAdditionals(AdditionalType.VIDEO).size());



  }

  @Test
  public void readAndRemove () throws Exception {
    AdditionalsHandler handler = new AdditionalsHandler(forTest);
    final String name1 = "This is a crazy song";
    final AdditionalSuffix suffix1 = AdditionalSuffix.MP3;
    final AdditionalSuffix suffix2 = AdditionalSuffix.MID;
    File AUDIO = new File (handler.getAdditionalsPath().getAbsolutePath() + "/" + AdditionalType.AUDIO.name().toLowerCase() +"/" + name1 + "." + suffix1);
    assertTrue (AUDIO.createNewFile());

    File midifile = new File (handler.getAdditionalsPath().getAbsolutePath() + "/" + AdditionalType.MIDIFILE.name().toLowerCase() +"/" + name1 + "." +  suffix2);
    assertTrue (midifile.createNewFile());

    assertEquals (2, handler.getAdditionals().size());

    List <Additional> sublistMp3s = handler.getAdditionals(AdditionalType.AUDIO);
    assertEquals (1, sublistMp3s.size());

    assertEquals (AdditionalType.AUDIO, sublistMp3s.get(0).getType());
    assertEquals (name1, sublistMp3s.get(0).getName());
    assertEquals (suffix1, sublistMp3s.get(0).getSuffix());

    List <Additional> sublistMidifiles = handler.getAdditionals(AdditionalType.MIDIFILE);
    assertEquals (1, sublistMidifiles.size());
    assertEquals (name1, sublistMidifiles.get(0).getName());
    assertEquals (suffix2, sublistMidifiles.get(0).getSuffix());

    Additional removeMp3s = sublistMp3s.get(0);
    File removeAUDIO = removeMp3s.getFile();
    handler.remove(removeMp3s);

    assertEquals (0, handler.getAdditionals(AdditionalType.AUDIO).size());
    assertFalse (removeAUDIO.exists());

  }



}
