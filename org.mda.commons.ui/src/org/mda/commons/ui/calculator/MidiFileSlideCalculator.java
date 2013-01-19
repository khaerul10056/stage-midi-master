package org.mda.commons.ui.calculator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.additionals.Additional;
import org.mda.commons.ui.IGraphicsContext;
import org.mda.copyright.CopyrightSerializer;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.struct.MidiFileStruct;
import org.mda.struct.MidiFileStructItem;


/**
 * @deprecated Use {@linkplain org.mda.presenter.MidiFileSlideCalculator}
 * @author oleym
 *
 */
@Creatable
@Deprecated
public class MidiFileSlideCalculator extends SlideCalculator {

  private static final Log LOGGER  = LogFactory.getLogger(MidiFileSlideCalculator.class);

  private int currentX;

  private int currentY;

  private File imageFile;

  private Point nullExtend = new Point (0,0);

  @Inject
  private ApplicationSession  appSession;

  private CopyrightSerializer copyrightSerializer = new CopyrightSerializer();

  private int height = -1;

  private int maxY = -1;

  @Override
  public List<Slide> calculate (final AbstractSessionItem sessionitem, final CalculatorPreCondition preCondition) {
	  
	LOGGER.info("PreConditionSize: " + preCondition.getCalculationsize() + "- Config " + getConfig().getDefaultPresentationScreenSize());
	  
    List<Slide> slides = new ArrayList<Slide>();
    MidiFile midifile = (MidiFile) sessionitem;

    if (height < 0)
      height = preCondition.getCalculationsize().y;

    init(midifile);

    Collection <SlideItem> copyrightItems = new ArrayList<SlideItem>();

    if (getConfig().isShowCopyright()) {
      int copyrightFontsize = getConfig().getFont().getFontsizeAsInt() - 2;
      Font font = new Font (Display.getCurrent(), "Arial Alternative", copyrightFontsize, SWT.NONE);
      Font zoomedFont = calculateZoomedFont(font, preCondition);
      if (LOGGER.isDebugEnabled())
        LOGGER.debug("set font to size " + zoomedFont.getFontData() [0].height + " from " + font.getFontData() [0].height);

      List<String> serialize = copyrightSerializer.serialize(midifile);

      currentX = getConfiguredBorder();
      currentY = height - (serialize.size() * getLineHeight());
      maxY = currentY;

      for (String nextCopyrightLine : serialize) {
        Point copyrightExtend = getGc().getSize(nextCopyrightLine, getConfig().getFont());
        Point zoomedSize = calculateZoomedPoint(copyrightExtend, preCondition);
        Rectangle newRectangle = new Rectangle(currentX, currentY, zoomedSize.x, zoomedSize.y);
        FontDescriptor fontDesc = new FontDescriptor(copyrightFontsize);
        SlideItem titleItem = new SlideItem(newRectangle, nextCopyrightLine, SlideType.COPYRIGHT, null, false, fontDesc, 0);
        copyrightItems.add(titleItem);

        currentY += zoomedSize.y;
      }

    }
    else
      maxY = height;

    LOGGER.info("Set MaxY to " + maxY);

    currentY = getConfiguredBorder();

    for (MidiFilePart nextPart : midifile.getParts()) {
      List<Slide> calculatePart = calculatePart(nextPart, preCondition);
      slides.addAll(calculatePart);
    }

    for (SlideItem nextCopyright: copyrightItems) {
      Slide lastSlide = slides.get(slides.size() - 1);
      lastSlide.addItem(nextCopyright);
    }
    copyrightItems.clear();

    for (Slide nextSlide: slides) {
      LOGGER.info(nextSlide.toString());
    }

    return slides;
  }

  /**
   * returns the configured border.
   * - Globally configured border, if exists
   * - else API-configured border
   *
   * @return
   */
  private int getConfiguredBorder () {
    if (appSession.getGlobalConfs().getDefaultBorder() != null)
      return appSession.getGlobalConfs().getDefaultBorder().intValue();
    else
      return getConfig().getBorder();
  }



  private void addTitle (Slide slide, final MidiFile midifile, final CalculatorPreCondition preCondition) {
    if (midifile.getName() != null && ! midifile.getName().isEmpty()) {

      String name = MidiPlayerService.getTitle(midifile);

      Point point = new Point (currentX, currentY);
      Point zoomedPoint = calculateZoomedPoint(point, preCondition);

      FontDescriptor descTitle = new FontDescriptor(getConfig().getFont());
      descTitle.setBold(true);

      Point sizeTitle = getGc().getSize(midifile.getName(), descTitle);

      Rectangle titleRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, sizeTitle.x, sizeTitle.y);

      SlideItem titleItem = new SlideItem(titleRectangle, name.toUpperCase(), SlideType.TITLE, null, false, descTitle, 0);
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

  private int getOffsetChordToText (int currentY, int lineheight) {
    int offset = getConfig().isChordPresented() ? currentY + lineheight  : currentY;
    return offset + + getIndentBetweenChordAndText();
  }

  private int getOffsetLongestPartType (final MidiFile file, final CalculatorPreCondition preCondition) {
    int length = 0;
    String longestPart = "";
    MidiFileStruct struct = new MidiFileStruct(file);
    for (MidiFilePart nextPart: file.getParts()) {
      String label = struct.getItem(nextPart).getLabel();
      if (label != null) {
        Point currentOffset = getGc().getSize(label, getConfig().getFont());
        if (currentOffset.x > length) {
          length = currentOffset.x;
          longestPart = label;
        }
      }
    }

    LOGGER.debug("Longest parttype calculated: " + longestPart + " - " + length);

    return length + 25;
  }

  private Slide newSlide (final MidiFile midifile, final MidiFilePart part, final MidiFileTextLine firstLine,
                          final Font zoomedFont, final CalculatorPreCondition preCondition, final boolean forceNewPage) {
    Slide slide = new Slide(part, firstLine, zoomedFont, forceNewPage);
    slide.setBackgroundImage(imageFile);
    slide.setSize(preCondition.getCalculationsize());

    slide.setBackgroundColor(Utils.stringToColor(midifile.getBackgroundColor(), getConfig().getDefaultBackgroundColor()));
    LOGGER.debug("set background to " + slide.getBackgroundColor());
    slide.setForegroundColor(Utils.stringToColor(midifile.getForegroundColor(), getConfig().getDefaultForegroundColor()));
    LOGGER.debug("set foreground to " + slide.getForegroundColor());

    if (getConfig().isPagePerPart() || forceNewPage)
      currentY = getConfiguredBorder();
    else
      currentY += getLineHeight(); //between parts the should be a intend

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

  private int getLineHeight () {
    return getGc().getSize("H", getConfig().getFont()).y;
  }



  public List<Slide> calculatePart (final MidiFilePart part, final CalculatorPreCondition preCondition) {
    MidiFile midifile = (MidiFile) part.eContainer();
    init(midifile);
    List <Slide> slides = new ArrayList<Slide>();
    MidiFileStruct struct = new MidiFileStruct(midifile);
    MidiFileStructItem structItem = struct.getItem(part);

    boolean isFirstPartInSong = part.equals(midifile.getParts().get(0));

    if (! structItem.isVisible() && getConfig().isOptimizeEqualParts())
      return slides;

    //TODO centralize fonthandling
    Font font = new Font (Display.getCurrent(), "Arial Alternative", getConfig().getFont().getFontsizeAsInt(), SWT.NONE);
    int longestTypeOffset = getOffsetLongestPartType(midifile, preCondition);

    Font zoomedFont = calculateZoomedFont(font, preCondition);
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("set font to size " + zoomedFont.getFontData() [0].height + " from " + font.getFontData() [0].height);

    int height = getLineHeight();
    if (getConfig().isChordPresented())
      height += getLineHeight();
    else
      height += (getLineHeight() / 2);

    Slide slide = newSlide(midifile, part, part.getTextlines().size() > 0 ? part.getTextlines().get(0) : null, zoomedFont, preCondition, isFirstPartInSong);
    slides.add(slide);

    int leftPosDefault = getConfiguredBorder();
    //add title, if configured
    if (midifile.getParts().get(0).equals(part)) {
      currentX = leftPosDefault;

      if (getConfig().isShowTitle()) {
        addTitle(slide, midifile, preCondition);
      }
    }

    normalizeSizeToPresentationSize(preCondition);

    if (getConfig().isShowBlockType()) { //show blocktype (e.g. refrain, chorus..)

      String blockType = structItem.getLabel();
      if (blockType != null) {

        Point parttypeExtend = getGc().getSize(blockType, getConfig().getFont());
        int addToY = getOffsetChordToText(currentY, getLineHeight());
        Point point = new Point(leftPosDefault, addToY);

        Point zoomedPoint = calculateZoomedPoint(point, preCondition);
        Point zoomedPartTypeExtend = calculateZoomedPoint(parttypeExtend, preCondition);

        Rectangle textRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, zoomedPartTypeExtend.x, zoomedPartTypeExtend.y);

        SlideItem newTextItem = new SlideItem(textRectangle, blockType, SlideType.TEXT, null, false, getConfig().getFont(), 0);
        slide.addItem(newTextItem);
      }
      leftPosDefault += longestTypeOffset;
    }

    //Calculate current part

    if (! getConfig().isOptimizeEqualParts() || structItem.isContentShown()) {

    List <MidiFileTextLine> textlines = part.getRefPart() != null ? part.getRefPart().getTextlines() : part.getTextlines();
    for (MidiFileTextLine nextTextLine : textlines ) {


      if (getConfig().isNewPageRespected() && nextTextLine.isNewSlide()) {
        slide = newSlide(midifile, part, nextTextLine,  zoomedFont, preCondition, false);
        slides.add(slide);
      }

      currentX = leftPosDefault;

      List <SlideItem> itemsOfCurrentLine = new ArrayList<SlideItem>();

      for (MidiFileChordPart chordPart : nextTextLine.getChordParts()) {

        boolean newSlideForced = nextTextLine.isNewSlide() && chordPart.equals(nextTextLine.getChordParts().get(0));

        String chord = getConfig().isChordPresented() ? chordPart.getChord(): null;
        String text = chordPart.getText();

        if (getConfig().isOptimizeEmptyTokens()) {
          if (text != null && text.trim().isEmpty())
            text = null;
        }


        Point textExtend = text != null ? getGc().getSize(text, getConfig().getFont()) : nullExtend;

        Point chordExtend = chord != null && getConfig().isChordPresented() ? getGc().getSize(chord, getConfig().getFont()): nullExtend ;

        SlideItem newTextItem = null;

        int biggestXExtend = 0;
        if (chordExtend.x > biggestXExtend)
          biggestXExtend = chordExtend.x;
        if (textExtend.x > biggestXExtend)
          biggestXExtend = textExtend.x;

        if (text != null) {
          int addToY = getOffsetChordToText(currentY, getLineHeight());
          int indentToChord = currentY - addToY; //indent between chord and text
          Point point = new Point(currentX, addToY);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);
          Point zoomedTextExtend = calculateZoomedPoint(textExtend, preCondition);
          Point zoomedIndent = calculateZoomedPoint(new Point (indentToChord, 0), preCondition);

          Rectangle textRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, zoomedTextExtend.x, zoomedTextExtend.y);
          newTextItem = new SlideItem(textRectangle, text, SlideType.TEXT, null, newSlideForced, getConfig().getFont(), zoomedIndent.x);
          itemsOfCurrentLine.add(newTextItem);
        }

        if (chord != null && getConfig().isChordPresented()) {
          Point point = new Point (currentX, currentY);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);
          Point zoomedChordExtend = calculateZoomedPoint(chordExtend, preCondition);

          Rectangle chordRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, zoomedChordExtend.x, zoomedChordExtend.y);
          SlideItem newItem = new SlideItem(chordRectangle, chord, SlideType.CHORD, newTextItem, newSlideForced, getConfig().getFont(), 0);
          itemsOfCurrentLine.add(newItem);
        }

        currentX += biggestXExtend;

      }

      boolean movingToPreviousLine = false;
      if (! nextTextLine.equals(textlines.get(0))) {
        movingToPreviousLine = isMovingCurrentItemsToPreviousLineAllowed(slide, itemsOfCurrentLine, preCondition);
        if (movingToPreviousLine) {
          moveCurrentItemsToPreviousLine(slide, itemsOfCurrentLine); //optimizing current line to previous line
          slide.previousLine();
        }
      }

      slide.addItems(itemsOfCurrentLine);

      if (! movingToPreviousLine) { //not optimizing the current line to the previous line, so prepare stepping to next line
        stepCurrentYToNextLine(height);
      }

      slide.newLine(); //new line always, because if we move current items to previous line we first step back

      if (isYOutOfPageSize(preCondition) && getConfig().isAutoWrapToNewPage()) {
        slide = newSlide(midifile, part, nextTextLine,  zoomedFont, preCondition, true);
        slides.add(slide);
      }

    }

    }
    else
      stepCurrentYToNextLine(height);




    if (getConfig().isSkipEmptySlides())
      removeEmptySlides(slides);

    return slides;
  }

  private boolean isYOutOfPageSize (CalculatorPreCondition preCondition) {
    int zoomedCurrentY = calculateZoomedPoint(new Point (currentY, 0), preCondition).x;
    return zoomedCurrentY > maxY;
  }

  /**
   *
   * @param height
   * @return
   */
  private void stepCurrentYToNextLine (final int height) {
    currentY += height;
    currentY += getDistanceBetweenLines();
  }


  /**
   * move the items of current line to the end of the previous line
   * @param slide         slide
   * @param currentItems  currenItems
   */
  private void moveCurrentItemsToPreviousLine (final Slide slide, final List <SlideItem> currentItems) {
    List<SlideItem> textItems = slide.getItems(SlideType.TEXT);
    SlideItem lastTextItem = textItems.get(textItems.size() - 1);
    int lastX = lastTextItem.getXMax();
    int lastY = lastTextItem.getY();

    if (! lastTextItem.getText().endsWith(" "))
      lastX += getGc().getSize(" ", getConfig().getFont()).x;

    SlideItem lastChordItem = null;
    List<SlideItem> chordItems = slide.getItems(SlideType.CHORD);
    if (chordItems.size() > 0 ) {
      lastChordItem = chordItems.get(chordItems.size() - 1);
      lastX = Math.max(lastX, lastChordItem.getXMax());
    }

    int firstX = currentItems.get(0).getX();

    for (SlideItem item: currentItems) {
      int newY = lastY;
      if (item.getItemType().equals(SlideType.CHORD))
        newY += lastTextItem.getIndentToChord();

      item.setX(item.getX() + lastX - firstX);
      item.setY(newY);
    }
  }

  private int getMaxX (final Collection <SlideItem> items) {
    int maxX = 0;
    for (SlideItem next: items) {
      if (next.getXMax() > maxX)
        maxX = next.getXMax();
    }

    return maxX;
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

    if (currentItems.size() == 0)
      return false;

    int firstX = currentItems.get(0).getX();
    int lastXMax = getMaxX(currentItems);

    int spaceAmountOfCurrentItems = lastXMax - firstX;

    List<SlideItem> textitems = slide.getItems(SlideType.TEXT);
    SlideItem lastSlideItem = textitems.get(textitems.size() - 1);
    int xMaxOfLast = lastSlideItem.getXMax();

    String logtext = "";
    for (SlideItem next: currentItems) {
      logtext += next.getText();
    }
    boolean optimizing = xMaxOfLast + spaceAmountOfCurrentItems < preCondition.getCalculationsize().x - getConfiguredBorder();
    if (LOGGER.isDebugEnabled())
    LOGGER.debug("Text <" + logtext + "> needs " + spaceAmountOfCurrentItems +
                ", appending at " + xMaxOfLast + "calculcationsize is " + preCondition.getCalculationsize().x + "->optimizing=" + optimizing);
    return optimizing;
  }

  @Override
  public boolean isAssigned (AbstractSessionItem item) {
    return item instanceof MidiFile;
  }



}
