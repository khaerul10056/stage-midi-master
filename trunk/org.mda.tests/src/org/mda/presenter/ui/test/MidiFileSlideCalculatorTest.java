package org.mda.presenter.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import org.eclipse.swt.graphics.Point;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.commons.ui.calculator.SlideType;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class MidiFileSlideCalculatorTest {

  private static final Log LOGGER  = LogFactory.getLogger(MidiFileSlideCalculatorTest.class);

  private static ApplicationSession appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);


  @BeforeClass
  public static void beforeClass () {
    appSession.load(null);
  }



  private void checkConsistency (final Slide slide) {
    for (int line = 0; line < slide.getLineCount(); line ++) {
      int yOfLine = -1;
      int xOfLine = -1;
      Collection <SlideItem> itemsOfLine = slide.getItems(line);
      for (SlideItem next: itemsOfLine) {
        assertTrue(next.getText() + "yOfLine = " + yOfLine + ", next.getY() = " + next.getY(), yOfLine == -1 || yOfLine == next.getY());
        assertTrue (next.getText() + "next.getY = " + next.getY() + ", next.getYMax = " + next.getYMax(), next.getY() < next.getYMax());
        assertTrue (next.getText(), next.getX() < next.getXMax());
        assertTrue (next.getText(), next.getX() >= xOfLine);
        yOfLine = next.getY();
        xOfLine = next.getXMax();
      }
    }
  }

  @Test
  public void copyright () {
    throw new IllegalStateException("NYI");

  }


  @Test
  public void skipEmptyText () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    MidiFile song = creator.get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setOptimizeLineFilling(false);
    config.setOptimizeEmptyTokens(true);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    List<Slide> calculateWithoutBorder = calculator.calculate(song, preCondition);
    Slide firstSlide = calculateWithoutBorder.get(0);
    LOGGER.info("->" + firstSlide.toString());
    Assert.assertEquals (2, firstSlide.getItems().size());
    Assert.assertEquals (SlideType.CHORD, firstSlide.getItems().get(0).getItemType());
    Assert.assertEquals (SlideType.CHORD, firstSlide.getItems().get(1).getItemType());

  }

  @Test
  public void border () {
    final int BORDER = 60;
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.REFRAIN);
    creator = creator.line().text("This is the first refrain").text("still");
    creator = creator.line().text("and this is the second line of the refrain");
    creator = creator.part(MidiFilePartType.VERS);
    creator = creator.line().text("This is the first vers").text("still");
    MidiFile song = creator.get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setOptimizeLineFilling(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    List<Slide> calculateWithoutBorder = calculator.calculate(song, preCondition);

    config.setBorder(new Integer (BORDER));
    List<Slide> calculateWithBorder = calculator.calculate(song, preCondition);

    assertEquals (calculateWithoutBorder.size(), calculateWithBorder.size());
    for (int i = 0; i < calculateWithBorder.size(); i++) {
      Slide currentSlideWithoutBorder = calculateWithoutBorder.get(i);
      Slide currentSlideWithBorder = calculateWithBorder.get(i);

      assertEquals (currentSlideWithBorder.getItems().size(), currentSlideWithoutBorder.getItems().size());

      for (int j = 0; j < currentSlideWithBorder.getItems().size(); j++) {
        SlideItem nextItemWithoutBorder = currentSlideWithoutBorder.getItems().get(j);
        SlideItem nextItemWithBorder = currentSlideWithBorder.getItems().get(j);
        int expectedX = nextItemWithoutBorder.getX() + BORDER;
        int expectedY = nextItemWithoutBorder.getY() + BORDER;

        assertEquals (expectedX, nextItemWithBorder.getX());
        assertEquals (expectedY, nextItemWithBorder.getY());
      }
    }
  }


  @Test
  public void optimizeLineFilling () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.REFRAIN);
    creator = creator.line().text("This is the first line").text("still");
    creator = creator.line().text("and this is the second line that is too long to be merged to the first line");

    creator = creator.part(MidiFilePartType.VERS);
    creator = creator.line().text("First line").text("still");
    creator = creator.line().text("second merged");
    creator = creator.line().text("third line, which should definitively not be merged to previous line");
    MidiFile song = creator.get();

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setOptimizeLineFilling(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    List<Slide> calculate = calculator.calculate(song, preCondition);

    Slide firstSlide = calculate.get(0);
    assertEquals (2, firstSlide.getItems(0).size());   //First case: second line too long, optimizing is disabled
    assertEquals (1, firstSlide.getItems(1).size());
    checkConsistency(firstSlide);

    Slide secondSlide = calculate.get(1);
    assertEquals (2, secondSlide.getItems(0).size());  //Second case: second line can be optimized, but optimizing is disabled
    assertEquals (1, secondSlide.getItems(1).size());
    checkConsistency(secondSlide);


    config.setOptimizeLineFilling(true);
    calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    calculate = calculator.calculate(song, preCondition);
    firstSlide = calculate.get(0);
    assertEquals (2, firstSlide.getItems(0).size());          //First case: second line too long, optimizing is enabled
    assertEquals (1, firstSlide.getItems(1).size());
    checkConsistency(firstSlide);

    secondSlide = calculate.get(1);
    LOGGER.info(secondSlide.toString());
    assertEquals (3, secondSlide.getItems(0).size());  //Second case: second line can be optimized, optimizing is enabled
    assertEquals (1, secondSlide.getItems(1).size());
    checkConsistency(secondSlide);
  }

  @Test
  public void skipEmptySlides () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.INTRO).line().chordAndText("D", null);
    creator = creator.part(MidiFilePartType.INTRO).line().chordAndText("D", "");
    creator = creator.part(MidiFilePartType.INTRO).line().chordAndText("D", "Hallo");
    MidiFile song = creator.get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setNewPageRespected(false);
    config.setShowTitle(true);
    config.setSkipEmptySlides(false);
    config.setChordVisible(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    List<Slide> calculate = calculator.calculate(song, preCondition);
    assertEquals (3, calculate.size());

    config.setSkipEmptySlides(true);
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    calculator.setConfig(config);
    calculate = calculator.calculate(song, preCondition);
    assertEquals (1, calculate.size());
  }
  @Test
  public void showTitle () {
    final String TITLE = "Songtitle.mid";
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.VERS);
    creator = creator.line().chordAndText("D", "First line");
    creator = creator.line().chordAndText("F", "second line");
    creator = creator.line().chordAndText("G", "thir line on a new slide");
    MidiFile song = creator.get();
    song.setName(TITLE);

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setNewPageRespected(false);
    config.setShowTitle(true);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    List<Slide> calculate = calculator.calculate(song, preCondition);

    SlideItem item1 = calculate.get(0).getItems().get(0);
    SlideItem item2 = calculate.get(0).getItems().get(1);
    assertEquals ("SONGTITLE", item1.getText());
    assertEquals ("First line", item2.getText());
    assertEquals (item1.getX(), item2.getX());
    assertTrue (item1.getY() < item2.getY());

  }

  /**
   * Tests if the new slide - attribute at the {@link MidiFileTextLine} is handled while calculating
   * a slide
   *
   * @throws Exception Exception
   */
  @Test
  public void newSlideAtLineisInactive () throws Exception {
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.VERS);
    creator = creator.line().chordAndText("D", " ");
    creator = creator.line().chordAndText("F", "second line");
    creator = creator.line().chordAndText("G", "thir line on a new slide");
    MidiFile song = creator.get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setNewPageRespected(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    List<Slide> calculate = calculator.calculate(song, preCondition);
    assertEquals(1, calculate.size());

    song.getParts().get(0).getTextlines().get(1).setNewSlide(true);



    calculate = calculator.calculate(song, preCondition);

    assertEquals(1, calculate.size());

  }

  /**
   * Tests if the new slide - attribute at the {@link MidiFileTextLine} is handled while calculating
   * a slide
   *
   * @throws Exception Exception
   */
  @Test
  public void newSlideAtLineIsActive () throws Exception {
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.VERS);
    creator = creator.line().chordAndText("D", " ");
    creator = creator.line().chordAndText("F", "second line");
    creator = creator.line().chordAndText("G", "thir line on a new slide");
    MidiFile song = creator.get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    List<Slide> calculate = calculator.calculate(song, preCondition);
    assertEquals(1, calculate.size());

    song.getParts().get(0).getTextlines().get(1).setNewSlide(true);

    calculate = calculator.calculate(song, preCondition);
    assertEquals(2, calculate.size());
    assertEquals (calculate.get(0).getItems().get(0).getY(), calculate.get(1).getItems().get(0).getY());
    assertEquals (calculate.get(0).getItems().get(0).getX(), calculate.get(1).getItems().get(0).getX());
  }


  @Test
  public void createChordRelatedPart () throws Exception {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", " ").get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    Slide calculatePart = calculator.calculatePart(song.getParts().get(0), preCondition).get(0);
    assertEquals (1, calculatePart.getTextline(0).length());
  }

  @Test
  public void chordRelatedPartWith2Spaces () throws Exception {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", "  ").get();
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    Slide calculatePart = calculator.calculatePart(song.getParts().get(0), preCondition).get(0);
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
    Slide calculatePart = calculator.calculatePart(midiFilePart, preCondition).get(0);

    assertEquals(midiFilePart.getTextlines().size(), calculatePart.getLineCount());

    assertEquals ("Alle Sch�pfung staunt und preist, betet an in Wahrheit und in Geist, ", calculatePart.getTextline(0));

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
    assertEquals (2, song.getParts().size());

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(true);
    config.setPagePerPart(true);
    config.setFontsize(80);

    List<Slide> slides = calculate(song, config);
    assertEquals (2, slides.size());
    Slide slide = slides.get(0);
    Slide slide2 = slides.get(1);

    SlideItem firstLineItem = slide.getItems().get(0);
    SlideItem thirdLineItem = slide2.getItems().get(0);

    assertEquals (ONE, firstLineItem.getText());
    assertEquals (THREE, thirdLineItem.getText());

    assertEquals (firstLineItem.getY(), thirdLineItem.getY());
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
    assertEquals (2, song.getParts().size());

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(true);
    config.setShowBlockType(true);
    config.setPagePerPart(false);
    config.setFontsize(80);

    List<Slide> slides = calculate(song, config);
    assertEquals (2, slides.size());
    Slide slide = slides.get(0);
    Slide slide2 = slides.get(1);

    SlideItem parttypeItem = slide.getItems().get(0);
    SlideItem firstLineItem = slide.getItems().get(1);
    SlideItem chordLineItem = slide.getItems().get(3);
    SlideItem secondLineItem = slide.getItems().get(4);
    SlideItem parttypeItem2 = slide2.getItems().get(0);
    SlideItem thirdLineItem = slide2.getItems().get(1);

    assertEquals ("REFRAIN ", parttypeItem.getText());
    assertEquals (ONE, firstLineItem.getText());
    assertEquals (TWO, secondLineItem.getText());

    assertEquals (parttypeItem.getY(), firstLineItem.getY());
    assertTrue (chordLineItem.getY() < firstLineItem.getY());
    assertTrue (parttypeItem.getX() + parttypeItem.getWidth() < secondLineItem.getX());
    assertEquals(firstLineItem.getX(), secondLineItem.getX());
    assertEquals(firstLineItem.getX(), thirdLineItem.getX());
    assertEquals (parttypeItem.getX(), parttypeItem2.getX());
    assertTrue (parttypeItem2.getY() > secondLineItem.getY());
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
    Slide slideFullScreen = calculator.calculatePart(midiFilePart, preCondition).get(0);


    Point half = new Point (config.getDefaultPresentationScreenSize().x / 2, config.getDefaultPresentationScreenSize().y / 2);
    preCondition.setCalculationsize(half);
    Slide halfScreen = calculator.calculatePart(midiFilePart, preCondition).get(0);

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
