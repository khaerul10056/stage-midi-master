package org.mda.presenter;

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

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.DefaultMidiFilePresenterConfig;
import org.mda.presenter.ui.test.MidiFileCreator;


public class MidiFileSlideCalculatorTest {

  private static final Log LOGGER  = LogFactory.getLogger(MidiFileSlideCalculatorTest.class);

  private static ApplicationSession appSession;

  final String PUBLISHER = "PUBLISHER";
  final String PUBLISHERINLAND = "PUBLISHERINLAND";


  @BeforeClass
  public static void beforeClass () {
	InjectServiceMock.initialize(); 
	appSession = InjectService.getInstance(ApplicationSession.class);
    appSession.load(null);
  }



  private void checkConsistency (final Slide slide) {
    for (int line = 0; line < slide.getLineCount(); line ++) {
      float yOfLine = -1;
      float xOfLine = -1;
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

  private int findTokens (final Slide slide) {
    int foundTokens = 0;
    for (SlideItem next: slide.getItems()) {
      if (next.getText().indexOf(PUBLISHER) >= 0)
        foundTokens ++;
      if (next.getText().indexOf(PUBLISHERINLAND) >= 0)
        foundTokens ++;
    }

    return foundTokens;

  }
  
  private MidiFileSlideCalculator getCalculator () {
	  return InjectService.getInstance(MidiFileSlideCalculator.class);
  }

  @Test
  public void copyright () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");

    creator = creator.copyright(null, PUBLISHER, PUBLISHERINLAND, null, null, null, null);
    MidiFile song = creator.get();
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setShowCopyright(true);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = getCalculator();
    calculator.setConfig(config);
    List<Slide> calculateWithoutBorder = calculator.calculate(song, preCondition);
    Slide slide = calculateWithoutBorder.get(0);
    Assert.assertEquals (2, findTokens(slide));
  }

  @Test
  public void noCopyright () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    final String PUBLISHER = "PUBLISHER";
    final String PUBLISHERINLAND = "PUBLISHERINLAND";
    creator = creator.copyright(null, PUBLISHER, PUBLISHERINLAND, null, null, null, null);
    MidiFile song = creator.get();
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setShowCopyright(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = getCalculator();
    calculator.setConfig(config);
    List<Slide> calculateWithoutBorder = calculator.calculate(song, preCondition);
    Slide slide = calculateWithoutBorder.get(0);
    Assert.assertEquals (0, findTokens(slide));
  }


  @Test
  public void skipEmptyText () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    MidiFile song = creator.get();
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setOptimizeLineFilling(false);
    config.setOptimizeEmptyTokens(true);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = getCalculator();
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
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setOptimizeLineFilling(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = getCalculator();
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
        float expectedX = nextItemWithoutBorder.getX() + BORDER;
        float expectedY = nextItemWithoutBorder.getY() + BORDER;

        assertEquals ("x value at " + nextItemWithBorder.getText() + " not correct", expectedX, nextItemWithBorder.getX(), 0.00);
        assertEquals (expectedY, nextItemWithBorder.getY(), 0.00);
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

    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setOptimizeLineFilling(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = getCalculator();
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
    calculator = getCalculator();
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
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setNewPageRespected(false);
    config.setShowTitle(true);
    config.setSkipEmptySlides(false);
    config.setShowChords(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = getCalculator();
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

    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setNewPageRespected(false);
    config.setShowTitle(true);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = getCalculator();
    calculator.setConfig(config);
    List<Slide> calculate = calculator.calculate(song, preCondition);

    SlideItem item1 = calculate.get(0).getItems().get(0);
    SlideItem item2 = calculate.get(0).getItems().get(1);
    assertEquals ("SONGTITLE", item1.getText());
    assertEquals ("First line", item2.getText());
    assertEquals (item1.getX(), item2.getX(), 0.00);
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
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setNewPageRespected(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    MidiFileSlideCalculator calculator = getCalculator();
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
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = getCalculator();
    calculator.setConfig(config);
    List<Slide> calculate = calculator.calculate(song, preCondition);
    assertEquals(1, calculate.size());

    song.getParts().get(0).getTextlines().get(1).setNewSlide(true);

    calculate = calculator.calculate(song, preCondition);
    assertEquals(2, calculate.size());
    assertEquals (calculate.get(0).getItems().get(0).getY(), calculate.get(1).getItems().get(0).getY(), 0.00);
    assertEquals (calculate.get(0).getItems().get(0).getX(), calculate.get(1).getItems().get(0).getX(), 0.00);
  }


  @Test
  public void createChordRelatedPart () throws Exception {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", " ").get();
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    
    MidiFileSlideCalculator calculator = getCalculator();
    calculator.setConfig(config);
    Slide calculatePart = calculator.calculatePart(song.getParts().get(0), preCondition).get(0);
    assertEquals (1, calculatePart.getTextline(0).length());
  }

  @Test
  public void chordRelatedPartWith2Spaces () throws Exception {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", "  ").get();
    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = getCalculator();
    calculator.setConfig(config);
    Slide calculatePart = calculator.calculatePart(song.getParts().get(0), preCondition).get(0);
    assertEquals (2, calculatePart.getTextline(0).length());
  }

  @Test
  public void createLines () {

    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    MidiFilePart midiFilePart = song.getParts().get(1);

    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setAutoWrapToNewPage(false);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = getCalculator();
    calculator.setConfig(config);
    Slide calculatePart = calculator.calculatePart(midiFilePart, preCondition).get(0);

    assertEquals(midiFilePart.getTextlines().size(), calculatePart.getLineCount());

    assertEquals ("Alle Sch�pfung staunt und preist, betet an in Wahrheit und in Geist, ", calculatePart.getTextline(0));

  }

  private List<Slide> calculate (final MidiFile part, DefaultMidiFilePresenterConfig config) {
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = getCalculator();
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

    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setShowChords(false);
    config.setPagePerPart(true);
    config.setFontsize(80);

    List<Slide> slides = calculate(song, config);
    assertEquals (2, slides.size());
    Slide slide = slides.get(0);
    Slide slide2 = slides.get(1);

    SlideItem firstLineItem = slide.getItems().get(0);
    SlideItem secondLineItem = slide.getItems().get(1);
    SlideItem thirdLineItem = slide.getItems().get(2);
    SlideItem nextSideFirstLineItem = slide2.getItems().get(0);

    assertEquals (ONE, firstLineItem.getText());
    assertEquals (TWO, thirdLineItem.getText());
    assertEquals (THREE, nextSideFirstLineItem.getText());
    assertEquals (0, firstLineItem.getY(),  0); 
    assertEquals (0, secondLineItem.getY(), 0); 
    assertEquals (95, thirdLineItem.getY(), 0);
    assertEquals (firstLineItem.getY(), secondLineItem.getY(), 0);
    assertEquals (firstLineItem.getY(), nextSideFirstLineItem.getY(), 0);
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

    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setShowChords(true);
    config.setShowBlockType(true);
    config.setPagePerPart(false);
    config.setAutoWrapToNewPage(false);
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

    assertEquals (parttypeItem.getY(), firstLineItem.getY(), 0.00);
    assertTrue (chordLineItem.getY() < firstLineItem.getY());
    assertTrue (parttypeItem.getX() + parttypeItem.getWidth() < secondLineItem.getX());
    assertEquals(firstLineItem.getX(), secondLineItem.getX(), 0.00);
    assertEquals(firstLineItem.getX(), thirdLineItem.getX(), 0.00);
    assertEquals (parttypeItem.getX(), parttypeItem2.getX(), 0.00);
    assertTrue (parttypeItem2.getY() > secondLineItem.getY());
  }





  @Test
  public void checkConcreteWithChord () {

    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.REFRAIN);
    creator.line().text("This is a").chordAndText("D", "test");
    creator.line().text("second line");
    MidiFile song = creator.get();

    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setShowChords(true);
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

    assertEquals (item1.getY(), item2.getY(), 0.00);

    assertEquals ("D", item3.getText());
    assertEquals (SlideType.CHORD, item3.getItemType());

    assertEquals ("second line", item4.getText());
    assertEquals (SlideType.TEXT, item4.getItemType());
    assertEquals (item4.getX(), item1.getX(), 0.00);
    assertTrue (item4.getY() > item1.getY());
  }

  @Test
  public void checkConcreteWithoutChords () {

    //Text and follow chords

    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.REFRAIN);
    creator.line().text("This is a").chordAndText("D", "test");
    creator.line().text("second line");
    MidiFile song = creator.get();

    DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
    config.setShowChords(false);
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

    assertEquals (item1.getY(), item2.getY(), 0.00);

    assertEquals ("second line", item3.getText());
    assertEquals (SlideType.TEXT, item3.getItemType());
    assertEquals (item3.getX(), item1.getX(), 0.00);
    assertTrue (item3.getY() > item1.getY());
  }

  private void like (final String text, final float first, final float second) {
    if (first + 1 == second || first -1 == second || first == second)
      return;
    else
      fail (text + "first " + first + "->second " + second);

  }

}
