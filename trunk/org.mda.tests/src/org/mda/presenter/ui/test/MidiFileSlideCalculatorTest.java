package org.mda.presenter.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiPlayerRoot;
import org.eclipse.swt.graphics.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.commons.ui.calculator.SlideType;


public class MidiFileSlideCalculatorTest {




  @Test
  public void createChordRelatedPart () throws Exception {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", " ").get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    Slide calculatePart = calculator.calculatePart(song.getParts().get(0), preCondition);
    assertEquals (1, calculatePart.getTextline(0).length());
  }

  @Test
  public void chordRelatedPartWith2Spaces () throws Exception {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", "  ").get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    Slide calculatePart = calculator.calculatePart(song.getParts().get(0), preCondition);
    assertEquals (2, calculatePart.getTextline(0).length());
  }

  @Test
  public void createLines () {

    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    MidiFilePart midiFilePart = song.getParts().get(1);

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    Slide calculatePart = calculator.calculatePart(midiFilePart, preCondition);

    assertEquals(midiFilePart.getTextlines().size(), calculatePart.getLineCount());

    assertEquals ("Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist, ", calculatePart.getTextline(0));

  }

  private List<Slide> calculate (final MidiFile part, DefaultMidiFileContentEditorConfig config) {
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    return calculator.calculate(part, preCondition);
  }

  @Test
  public void pagePerPart () {

    final String ONE = "This is a";
    final String TWO = "second line";
    final String THREE = "third line";
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.REFRAIN);
    creator.line().text(ONE).chordAndText("D", "test");
    creator.line().text(TWO);
    creator.part(MidiFilePartType.ZWISCHENSPIEL).line().text(THREE);
    MidiFile song = creator.get();
    Assert.assertEquals (2, song.getParts().size());

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(true);
    config.setPagePerPart(true);
    config.setFontsize(80);

    List<Slide> slides = calculate(song, config);
    Assert.assertEquals (2, slides.size());
    Slide slide = slides.get(0);
    Slide slide2 = slides.get(1);

    SlideItem firstLineItem = slide.getItems().get(0);
    SlideItem thirdLineItem = slide2.getItems().get(0);

    Assert.assertEquals (ONE, firstLineItem.getText());
    Assert.assertEquals (THREE, thirdLineItem.getText());

    Assert.assertEquals (firstLineItem.getY(), thirdLineItem.getY());
  }
  @Test
  public void checkWithType () {

    final String ONE = "This is a";
    final String TWO = "second line";
    final String THREE = "third line";
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.REFRAIN);
    creator.line().text(ONE).chordAndText("D", "test");
    creator.line().text(TWO);
    creator.part(MidiFilePartType.ZWISCHENSPIEL).line().text(THREE);
    MidiFile song = creator.get();
    Assert.assertEquals (2, song.getParts().size());

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(true);
    config.setShowBlockType(true);
    config.setPagePerPart(false);
    config.setFontsize(80);

    List<Slide> slides = calculate(song, config);
    Assert.assertEquals (2, slides.size());
    Slide slide = slides.get(0);
    Slide slide2 = slides.get(1);

    SlideItem parttypeItem = slide.getItems().get(0);
    SlideItem firstLineItem = slide.getItems().get(1);
    SlideItem chordLineItem = slide.getItems().get(3);
    SlideItem secondLineItem = slide.getItems().get(4);
    SlideItem parttypeItem2 = slide2.getItems().get(0);
    SlideItem thirdLineItem = slide2.getItems().get(1);

    Assert.assertEquals ("REFRAIN ", parttypeItem.getText());
    Assert.assertEquals (ONE, firstLineItem.getText());
    Assert.assertEquals (TWO, secondLineItem.getText());

    Assert.assertEquals (parttypeItem.getY(), firstLineItem.getY());
    Assert.assertTrue (chordLineItem.getY() < firstLineItem.getY());
    Assert.assertTrue (parttypeItem.getX() + parttypeItem.getWidth() < secondLineItem.getX());
    Assert.assertEquals(firstLineItem.getX(), secondLineItem.getX());
    Assert.assertEquals(firstLineItem.getX(), thirdLineItem.getX());
    Assert.assertEquals (parttypeItem.getX(), parttypeItem2.getX());
    Assert.assertTrue (parttypeItem2.getY() > secondLineItem.getY());
  }





  @Test
  public void checkConcreteWithChord () {

    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.REFRAIN);
    creator.line().text("This is a").chordAndText("D", "test");
    creator.line().text("second line");
    MidiFile song = creator.get();

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(true);
    config.setFontsize(80);

    Slide slide = calculate(song, config).get(0);
    System.out.println (slide);

    SlideItem item1 = slide.getItems().get(0);
    SlideItem item2 = slide.getItems().get(1);
    SlideItem item3 = slide.getItems().get(2);
    SlideItem item4 = slide.getItems().get(3);

    assertEquals ("This is a", item1.getText());
    assertEquals (SlideType.TEXT, item1.getItemType());

    assertEquals ("test", item2.getText());
    assertEquals (SlideType.TEXT, item2.getItemType());

    assertEquals (item1.getY(), item2.getY());

    assertEquals ("D", item3.getText());
    assertEquals (SlideType.CHORD, item3.getItemType());

    assertEquals ("second line", item4.getText());
    assertEquals (SlideType.TEXT, item4.getItemType());
    assertEquals (item4.getX(), item1.getX());
    assertTrue (item4.getY() > item1.getY());
  }

  @Test
  public void checkConcreteWithoutChords () {

    //Text and follow chords

    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.REFRAIN);
    creator.line().text("This is a").chordAndText("D", "test");
    creator.line().text("second line");
    MidiFile song = creator.get();

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(false);
    config.setFontsize(80);
    Slide slide = calculate(song, config).get(0);
    System.out.println (slide);

    SlideItem item1 = slide.getItems().get(0);
    SlideItem item2 = slide.getItems().get(1);
    SlideItem item3 = slide.getItems().get(2);

    assertEquals ("This is a", item1.getText());
    assertEquals (SlideType.TEXT, item1.getItemType());

    assertEquals ("test", item2.getText());
    assertEquals (SlideType.TEXT, item2.getItemType());

    assertEquals (item1.getY(), item2.getY());

    assertEquals ("second line", item3.getText());
    assertEquals (SlideType.TEXT, item3.getItemType());
    assertEquals (item3.getX(), item1.getX());
    assertTrue (item3.getY() > item1.getY());
  }

  @Test
  public void zoom () {

    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    MidiFilePart midiFilePart = song.getParts().get(1);

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    Slide slideFullScreen = calculator.calculatePart(midiFilePart, preCondition);


    Point half = new Point (config.getDefaultPresentationScreenSize().x / 2, config.getDefaultPresentationScreenSize().y / 2);
    preCondition.setCalculationsize(half);
    Slide halfScreen = calculator.calculatePart(midiFilePart, preCondition);

    Iterator<SlideItem> halfIterator = halfScreen.getItems().iterator();

    for (SlideItem nextFull : slideFullScreen.getItems()) {
      SlideItem nextHalf = halfIterator.next();

      like ("X-Coordinate of " + nextFull.getText(), nextFull.getX(), nextHalf.getX() * 2);
      like ("Y-Coordinate of " + nextFull.getText(), nextFull.getY(), nextHalf.getY() * 2);
      like ("Font of " + nextFull.getText(), slideFullScreen.getFont().getFontData() [0].getHeight(), halfScreen.getFont().getFontData() [0].getHeight() * 2);
    }

    System.out.println ("Full: " + slideFullScreen.toString());
    System.out.println ("Half: " + halfScreen.toString());

  }

  private void like (final String text, final int first, final int second) {
    if (first + 1 == second || first -1 == second || first == second)
      return;
    else
      fail (text + "first " + first + "->second " + second);

  }

}
