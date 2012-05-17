package org.mda.commons.ui.calculator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.Utils;
import org.mda.additionals.Additional;
import org.mda.commons.ui.IGraphicsContext;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class MidiFileSlideCalculator extends SlideCalculator {

  private static final Log LOGGER  = LogFactory.getLogger(MidiFileSlideCalculator.class);

  private int currentX;

  private int currentY;



  private File imageFile;

  private Point nullExtend = new Point (0,0);

  private ApplicationSession  appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  private Point testExtend;

  @Override
  public List<Slide> calculate (final AbstractSessionItem sessionitem, final CalculatorPreCondition preCondition) {
    List<Slide> slides = new ArrayList<Slide>();
    MidiFile midifile = (MidiFile) sessionitem;

    currentY = 0;

    init(midifile);

    for (MidiFilePart nextPart : midifile.getParts()) {
      slides.addAll(calculatePart(nextPart, preCondition));
    }
    return slides;
  }


  private void addTitle (Slide slide, final MidiFile midifile, final CalculatorPreCondition preCondition) {
    if (midifile.getName() != null && ! midifile.getName().isEmpty()) {

      String name = midifile.getName().endsWith(".mid") ? midifile.getName().substring(0, midifile.getName().length() - 4) : midifile.getName();

      Point point = new Point (currentX, currentY);
      Point zoomedPoint = calculateZoomedPoint(point, preCondition);

      FontDescriptor descTitle = new FontDescriptor(getConfig().getFont());
      descTitle.setBold(true);

      Point sizeTitle = getGc().getSize(midifile.getName(), descTitle);

      Rectangle titleRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, sizeTitle.x, sizeTitle.y);

      SlideItem titleItem = new SlideItem(titleRectangle, name.toUpperCase(), SlideType.TEXT, null, false, descTitle);
      slide.addItem (titleItem);
      currentY += sizeTitle.y * 2;
    }
  }

  private void init (final MidiFile midifile) {
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("Setting font to size " + getConfig().getFont());

    if (midifile.getPic() != null && midifile.getPic().length() > 0 && getConfig().isShowBackground()) {

      Additional findByKey = appSession.getAdditionalsHandler().findByKey(midifile.getPic());
      if (findByKey != null) {
        File picAsFile = findByKey.getFile();
        if (picAsFile.exists()) {
          LOGGER.info("Load pic from " + picAsFile.getAbsolutePath());
          imageFile = picAsFile;
        }
      }
    }
    else {
      LOGGER.debug("Setting image to null");
      imageFile = null;
    }

  }


  private IGraphicsContext getGc () {
    return getConfig().getGraphicsContext();
  }

  private int getDistanceBetweenLines () {
    return getConfig().isChordPresented() ? 10 : 5;
  }

  private int getIndentBetweenChordAndText () {
    return getConfig().isChordPresented() ? 5 : 0;
  }

  private int getOffsetChordToText (int currentY, Point testExtend) {
    int offset = getConfig().isChordPresented() ? currentY + testExtend.y  : currentY;
    return offset + + getIndentBetweenChordAndText();
  }

  private int getOffsetLongestPartType (final MidiFile file, final CalculatorPreCondition preCondition) {
    int length = 0;
    String longestPart = "";
    for (MidiFilePart nextPart: file.getParts()) {
      Point currentOffset = getGc().getSize(nextPart.getParttype().getName(), getConfig().getFont());
      //currentOffset = calculateZoomedPoint(currentOffset, preCondition);
      if (currentOffset.x > length) {
        length = currentOffset.x;
        longestPart = nextPart.getParttype().getName();
      }
    }

    LOGGER.debug("Longest parttype calculated: " + longestPart + " - " + length);

    return length + 25;
  }

  private Slide newSlide (final MidiFile midifile, final MidiFilePart part, final MidiFileTextLine firstLine,
                          final Font zoomedFont, final CalculatorPreCondition preCondition) {
    Slide slide = new Slide(part, firstLine, zoomedFont);
    slide.setBackgroundImage(imageFile);
    slide.setSize(preCondition.getCalculationsize());

    slide.setBackgroundColor(Utils.stringToColor(midifile.getBackgroundColor(), getConfig().getDefaultBackgroundColor()));
    LOGGER.debug("set background to " + slide.getBackgroundColor());
    slide.setForegroundColor(Utils.stringToColor(midifile.getForegroundColor(), getConfig().getDefaultForegroundColor()));
    LOGGER.debug("set foreground to " + slide.getForegroundColor());

    if (getConfig().isPagePerPart())
      currentY = 0;
    else
      currentY += testExtend.y; //between parts the should be a intend

    return slide;
  }

  /**
   * removes empty slides from the list of slides
   * @param slides all slides, empty items are removed from the list
   */
  public void removeEmptySlides (final List <Slide> slides) {
    Collection<Slide> emptySlides = new ArrayList<Slide>();
    for (Slide next: slides) {
      if (next.isEmpty())
        emptySlides.add(next);
    }

    slides.removeAll(emptySlides);
  }

  public List<Slide> calculatePart (final MidiFilePart part, final CalculatorPreCondition preCondition) {
    MidiFile midifile = (MidiFile) part.eContainer();
    init(midifile);
    List <Slide> slides = new ArrayList<Slide>();

    //TODO centralize fonthandling
    Font font = new Font (Display.getCurrent(), "Arial Alternative", getConfig().getFont().getFontsizeAsInt(), SWT.NONE);
    int longestTypeOffset = getOffsetLongestPartType(midifile, preCondition);

    Font zoomedFont = calculateZoomedFont(font, preCondition);
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("set font to size " + zoomedFont.getFontData() [0].height + " from " + font.getFontData() [0].height);

    testExtend = getGc().getSize("H", getConfig().getFont());

    Slide slide = newSlide(midifile, part, part.getTextlines().size() > 0 ? part.getTextlines().get(0) : null, zoomedFont, preCondition);
    slides.add(slide);

    int leftPosDefault = 0;
    //add title, if configured
    if (midifile.getParts().get(0).equals(part)) {
      currentX = leftPosDefault;

      if (getConfig().isShowTitle()) {
        addTitle(slide, midifile, preCondition);
      }
    }

    normalizeSizeToPresentationSize(preCondition);

    if (getConfig().isShowBlockType()) { //show blocktype (e.g. refrain, chorus..)
      String blockType = part.getParttype().getName() + " ";
      Point parttypeExtend = getGc().getSize(blockType, getConfig().getFont());
      int addToY = getOffsetChordToText(currentY, parttypeExtend);
      Point point = new Point(leftPosDefault, addToY);
      Point zoomedPoint = calculateZoomedPoint(point, preCondition);
      Rectangle textRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, parttypeExtend.x, parttypeExtend.y);

      SlideItem newTextItem = new SlideItem(textRectangle, blockType, SlideType.TEXT, null, false, getConfig().getFont());
      slide.addItem(newTextItem);
      leftPosDefault += longestTypeOffset;
    }

    //Calculate current part

    List <MidiFileTextLine> textlines = part.getRefPart() != null ? part.getRefPart().getTextlines() : part.getTextlines();
    for (MidiFileTextLine nextTextLine : textlines ) {

      if (getConfig().isNewPageRespected() && nextTextLine.isNewSlide()) {
        slide = newSlide(midifile, part, nextTextLine,  zoomedFont, preCondition);
        slides.add(slide);
      }
      currentX = leftPosDefault;


      int height = testExtend.y;
      if (getConfig().isChordPresented())
        height += testExtend.y;
      else
        height += (testExtend.y / 2);


      List <SlideItem> itemsOfCurrentLine = new ArrayList<SlideItem>();

      for (MidiFileChordPart chordPart : nextTextLine.getChordParts()) {

        boolean newSlideForced = nextTextLine.isNewSlide() && chordPart.equals(nextTextLine.getChordParts().get(0));

        String chord = getConfig().isChordPresented() ? chordPart.getChord(): null;
        String text = chordPart.getText();

        Point textExtend = text != null ? getGc().getSize(text, getConfig().getFont()) : nullExtend;

        Point chordExtend = chord != null && getConfig().isChordPresented() ? getGc().getSize(chord, getConfig().getFont()): nullExtend ;

        SlideItem newTextItem = null;

        int biggestXExtend = 0;
        if (chordExtend.x > biggestXExtend)
          biggestXExtend = chordExtend.x;
        if (textExtend.x > biggestXExtend)
          biggestXExtend = textExtend.x;

        if (text != null) {
          int addToY = getOffsetChordToText(currentY, testExtend);
          Point point = new Point(currentX, addToY);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);

          Rectangle textRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, textExtend.x, textExtend.y);
          newTextItem = new SlideItem(textRectangle, text, SlideType.TEXT, null, newSlideForced, getConfig().getFont());
          itemsOfCurrentLine.add(newTextItem);
        }

        if (chord != null && getConfig().isChordPresented()) {
          Point point = new Point (currentX, currentY);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);

          Rectangle chordRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, chordExtend.x, chordExtend.y);
          SlideItem newItem = new SlideItem(chordRectangle, chord, SlideType.CHORD, newTextItem, newSlideForced, getConfig().getFont());
          itemsOfCurrentLine.add(newItem);
        }

        currentX += biggestXExtend;

      }

      boolean movingToPreviousLine = false;
      if (! nextTextLine.equals(textlines.get(0))) {
        movingToPreviousLine = isMovingCurrentItemsToPreviousLineAllowed(slide, itemsOfCurrentLine, preCondition);
        if (movingToPreviousLine) {
          moveCurrentItemsToPreviousLineAllowed(slide, itemsOfCurrentLine); //optimizing current line to previous line
          slide.previousLine();
        }
      }

      slide.addItems(itemsOfCurrentLine);

      if (! movingToPreviousLine) { //not optimizing the current line to the previous line, so prepare stepping to next line
        currentY += height;
        currentY += getDistanceBetweenLines();
      }

      slide.newLine(); //new line always, because if we move current items to previous line we first step back

    }

    if (getConfig().isSkipEmptySlides())
      removeEmptySlides(slides);

    return slides;
  }

  private int getBorder () {
    return 0; //TODO make configurable
  }

  /**
   * move the items of current line to the end of the previous line
   * @param slide         slide
   * @param currentItems  currenItems
   */
  private void moveCurrentItemsToPreviousLineAllowed (final Slide slide, final Collection <SlideItem> currentItems) {
    SlideItem lastSlideItem = slide.getItems().get(slide.getItems().size() - 1);
    int lastY = lastSlideItem.getY();
    int lastX = lastSlideItem.getXMax();

    for (SlideItem item: currentItems) {
      item.setX(item.getX() - getBorder() + lastX);
      item.setY(lastY);
    }
  }

  /**
   * returns if moving the items of current line to the end of the previous is allowed.
   * This is allowed if:
   * - a previous line exists
   * - optimizing is enabled by config
   * - the current line is short enough to fit at the end of the previous line
   *
   * @param slide         slide
   * @param currentItems  items of current line
   * @param preCondition  preCondition
   * @return true/false
   */
  private boolean isMovingCurrentItemsToPreviousLineAllowed (final Slide slide, final List <SlideItem> currentItems, CalculatorPreCondition preCondition) {

    if (! getConfig().isOptimizeLineFilling())
      return false;

    if (slide.getItems().isEmpty())
      return false;


    int firstX = currentItems.get(0).getX();
    int lastXMax = currentItems.get(currentItems.size() - 1).getXMax();

    int spaceAmountOfCurrentItems = lastXMax - firstX;


    SlideItem lastSlideItem = slide.getItems().get(slide.getItems().size() - 1);
    int xMaxOfLast = lastSlideItem.getXMax();

    String logtext = "";
    for (SlideItem next: currentItems) {
      logtext += next.getText();
    }
    boolean optimizing = xMaxOfLast + spaceAmountOfCurrentItems < preCondition.getCalculationsize().x;
    LOGGER.info("Text <" + logtext + "> needs " + spaceAmountOfCurrentItems +
                ", appending at " + xMaxOfLast + "calculcationsize is " + preCondition.getCalculationsize().x + "->optimizing=" + optimizing);
    return optimizing;
  }

  @Override
  public boolean isAssigned (AbstractSessionItem item) {
    return item instanceof MidiFile;
  }



}
