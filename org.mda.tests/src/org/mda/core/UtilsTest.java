package org.mda.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.TreeMap;
import mda.MidiFileChordPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.junit.Assert;
import org.junit.Test;
import org.mda.Utils;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class UtilsTest {

  private static final Log LOGGER  = LogFactory.getLogger(UtilsTest.class);

  @Test
  public void colorToString () {
    Assert.assertEquals ("50x100x75", Utils.colorToString(new Color (Display.getCurrent(), 100, 50, 75)));
  }

  @Test
  public void stringToColor () {
    Color defaultColor = new Color (Display.getCurrent(), 0, 0, 0);
    Assert.assertEquals (new Color (Display.getCurrent(), 100, 50, 75), Utils.stringToColor("50x100x75", null));
    Assert.assertEquals (defaultColor, Utils.stringToColor("ruetzl", defaultColor));
  }

  @Test(expected=IllegalStateException.class)
  public void stringToColorBothNull () {
    Utils.stringToColor(null, null);
  }

  @Test(expected=IllegalStateException.class)
  public void stringToColorInvalidAndDefaultNull () {
    Assert.assertNull (Utils.stringToColor("ruetzl", null));
  }

  @Test
  public void loadImageId  () {
    Assert.assertNull (Utils.loadImageFromProject("unvalid"));
    Assert.assertNotNull (Utils.loadImageFromProject(Utils.ICON_ADD_PART));
  }

  @Test
  public void loadImageFromProject () {
     File splash = new File ("../org.mda.application/splash.bmp");
     Assert.assertNotNull(Utils.loadImageFromProject(splash));
     splash = new File ("../org.mda.application/splash2.bmp");
     Assert.assertNotNull(Utils.loadImageFromProject(splash));
  }

  @Test
  public void trimRight () {
    Assert.assertEquals ("This is a text", Utils.trimRight("This is a text     "));
    Assert.assertEquals ("This is a text", Utils.trimRight("This is a text"));

  }

  @Test
  public void getTextWithoutTagsTrimmed () {
    List<MidiFileChordPart> chordPartsFromText = Utils.getChordPartsFromText( "REFRAIN This is the air I breathe",
                                                                              "        A           D");
    Assert.assertEquals ("A", chordPartsFromText.get(0).getChord());
    Assert.assertEquals ("This is the ", chordPartsFromText.get(0).getText());
    Assert.assertEquals ("D", chordPartsFromText.get(1).getChord());
    Assert.assertEquals ("air I breathe", chordPartsFromText.get(1).getText());
    Assert.assertEquals (2, chordPartsFromText.size());


    chordPartsFromText = Utils.getChordPartsFromText("REFRAIN And without chords","");
    Assert.assertNull (chordPartsFromText.get(0).getChord());
    Assert.assertEquals ("And without chords", chordPartsFromText.get(0).getText());
    Assert.assertEquals (1, chordPartsFromText.size());

    chordPartsFromText = Utils.getChordPartsFromText( "REFRAIN And with chords far away",
                                                      "            D");
    Assert.assertNull (chordPartsFromText.get(0).getChord());
    Assert.assertEquals ("And ", chordPartsFromText.get(0).getText());
    Assert.assertEquals ("D", chordPartsFromText.get(1).getChord());
    Assert.assertEquals ("with chords far away", chordPartsFromText.get(1).getText());
    Assert.assertEquals (2, chordPartsFromText.size());


    chordPartsFromText = Utils.getChordPartsFromText("", "");
    Assert.assertNull (chordPartsFromText.get(0).getChord());
    Assert.assertEquals (" ", chordPartsFromText.get(0).getText());
    Assert.assertEquals (1, chordPartsFromText.size());



    for (MidiFileChordPart nextPart: chordPartsFromText) {
      LOGGER.info("CHORDS   :" + nextPart.getChord());
      LOGGER.info("TEXT     :" + nextPart.getText());
    }
  }




  @Test
  public void getChordPositions () {
    TreeMap<Integer,String> chordPositions = Utils.getChordPositions("A  D  G  Ab");
    Assert.assertEquals(4, chordPositions.size());
    Assert.assertEquals ("A", chordPositions.get(new Integer (0)));
    Assert.assertEquals ("D", chordPositions.get(new Integer (3)));
    Assert.assertEquals ("G", chordPositions.get(new Integer (6)));
    Assert.assertEquals ("Ab", chordPositions.get(new Integer (9)));


    chordPositions = Utils.getChordPositions("");
    Assert.assertEquals (0, chordPositions.size());
  }



  @Test
  public void copyFile () throws Exception {

    File file = new File ("tmp");
    file.createNewFile();
    File fileTo = new File ("tmpTo");
    Utils.copyFile(fileTo, file);

    Assert.assertEquals (file.length(), fileTo.length());

    fileTo.delete();

    File fileNotExisting = new File ("src/org/mda/core/UtilsTest.javaNotExisting");
    try {
    Utils.copyFile(fileTo, fileNotExisting);
    Assert.fail ("Exception was not thrown");
    } catch (FileNotFoundException e) {

    }

    Assert.assertTrue(file.delete());

  }

  @Test
  public void deleteDirectory () throws Exception {
    File path = new File ("tmp/hello/new");
    path.mkdirs();
    File file = new File ("tmp/hello/whatisthis.txt");
    file.createNewFile();

    Assert.assertTrue (path.exists());
    Assert.assertTrue (file.exists());

    File tmp = new File ("tmp");
    Utils.deleteDirectory(tmp);

    Assert.assertFalse (path.exists());
    Assert.assertFalse (file.exists());
    Assert.assertFalse (tmp.exists());
  }


  @Test
  public void splitString () {
    String[] splitString = Utils.splitString("This is a string", 4);
    Assert.assertEquals ("This", splitString [0]);
    Assert.assertEquals (" is a string", splitString [1]);
    Assert.assertEquals (2, splitString.length);
  }

  @Test
  public void getChordFromString () {
    Assert.assertEquals ("", Utils.getChordFromPosition("", 1));
    Assert.assertEquals ("", Utils.getChordFromPosition("", 0));
    Assert.assertEquals ("A", Utils.getChordFromPosition("A   D   G   A", 0));
    Assert.assertEquals ("", Utils.getChordFromPosition("A   D   G   A", 1));
    Assert.assertEquals ("", Utils.getChordFromPosition("A   D   G   A", 3));
    Assert.assertEquals (" D", Utils.getChordFromPosition("A   D   G   A", 4));
    Assert.assertEquals ("", Utils.getChordFromPosition("A   D   G   A", -1));
    Assert.assertEquals ("", Utils.getChordFromPosition("A   D   G   A", 200));
    Assert.assertEquals (" A", Utils.getChordFromPosition("A   D   G   A", 12));

  }

  @Test
  public void removeString () {
    Assert.assertEquals ("this is a test", Utils.removeString("Hello, this is a test", 0, 7));
    Assert.assertEquals ("Heis is a test", Utils.removeString("Hello, this is a test", 2, 7));

    Assert.assertEquals ("this is a test", Utils.removeString("Hello, this is a test", -1, 7));
    Assert.assertEquals ("Hello, ", Utils.removeString("Hello, this is a test", 7, 712));
  }

}
