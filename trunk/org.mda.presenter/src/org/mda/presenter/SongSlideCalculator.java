package org.mda.presenter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import mda.AbstractSessionItem;
import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongTextLine;

import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.additionals.Additional;
import org.mda.copyright.CopyrightSerializer;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.adapter.AreaInfo;
import org.mda.presenter.adapter.FontInfo;
import org.mda.presenter.adapter.IGraphicsContext;
import org.mda.presenter.adapter.LocationInfo;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.IPresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.struct.SongStruct;
import org.mda.struct.SongStructItem;


public class SongSlideCalculator extends SlideCalculator {

  private static final Log LOGGER  = LogFactory.getLogger(SongSlideCalculator.class);

  private float currentX;

  private float currentY;

  private File imageFile;

  private SizeInfo nullExtend = new SizeInfo (0,0);

  @Inject
  private ApplicationSession  appSession;

  private CopyrightSerializer copyrightSerializer = new CopyrightSerializer();
  
  private float height = -1;

  private float maxY = -1;
  
  
  private int getOptimizedFontSize (final List <Slide> slides,  IPresenterConfig config) {
	  
	  int fontSizeCurrent = slides.get(0).getFont().getFontsizeAsInt();
	  float currentMaxX = 0.0f; 
	  for (Slide next: slides) {
		  if (next.getMostRightItem().getXMax() > currentMaxX)
			  currentMaxX = next.getMostRightItem().getXMax();
	  }
      float expectedMaxX = slides.get(0).getSize().getWidth() * config.getAutoSizingPercent() / 100 ;
      float expectedSize = fontSizeCurrent * expectedMaxX / currentMaxX;
      
      LOGGER.info("Calculation of optimized fontsize");
      LOGGER.info("- current fontsize " + fontSizeCurrent); 
      LOGGER.info("- currentMaxX      " + currentMaxX);
      LOGGER.info("- expectedMaxX     " + expectedMaxX);
      LOGGER.info("- width            " + slides.get(0).getSize().getWidth());
      LOGGER.info("- optimal size     " + expectedSize);
      return (int) expectedSize;
  }
  
  
  @Override
  public SlideContainer calculate (final AbstractSessionItem sessionitem, final CalculationParam param, final IPresenterConfig config) {
	  
	List <Slide> slides = new ArrayList<Slide>();
	
	setConfig(config);
    Song midifile = (Song) sessionitem;
    
    if (height < 0)
      height = param.getPresentationSize().getHeight();

    init(midifile);

    Collection <SlideItem> copyrightItems = new ArrayList<SlideItem>();
    
    if (getConfig().isShowCopyright() && getConfig().getAutoSizingPercent() != null)
    	throw new IllegalStateException("Autosizing and showing copyright is not yet supported together");

    if (getConfig().isShowCopyright()) {
      int copyrightFontsize = getConfig().getFont().getFontsizeAsInt() - 2;
      FontInfo font = new FontInfo ("Arial Alternative", copyrightFontsize);
      FontInfo zoomedFont = calculateZoomedFont(font, param);
      if (LOGGER.isDebugEnabled())
        LOGGER.debug("set font to size " + zoomedFont.getFontsizeAsInt() + " from " + font.getFontsizeAsInt());

      List<String> serialize = copyrightSerializer.serialize(midifile);

      currentX = getConfiguredBorder();
      currentY = height - (serialize.size() * getLineHeight());
      maxY = currentY;

      for (String nextCopyrightLine : serialize) {
        SizeInfo copyrightExtend = getGc().getSize(nextCopyrightLine, getConfig().getFont());
        SizeInfo zoomedSize = calculateZoomedSize(copyrightExtend, param);
        AreaInfo newRectangle = new AreaInfo(currentX, currentY, zoomedSize);
        FontInfo fontDesc = new FontInfo(copyrightFontsize);
        SlideItem titleItem = new SlideItem(newRectangle, nextCopyrightLine, SlideType.COPYRIGHT, null, false, fontDesc, 0);
        copyrightItems.add(titleItem);

        currentY += zoomedSize.getHeight();
      }

    }
    else
      maxY = height;

    LOGGER.info("Set MaxY to " + maxY);

    currentY = getConfiguredBorder();
    
    
    //first calculation
    for (SongPart nextPart : midifile.getParts())
      slides.addAll(calculatePart(nextPart, param, config));
    
    if (! slides.isEmpty() && getConfig().getAutoSizingPercent() != null) {
      int newSize = getOptimizedFontSize(slides, config);
  	  LOGGER.info("Setting size of item " + sessionitem.getName() + " to " + newSize + ", before " + config.getFont().getFontsizeAsInt());
  	  ((DefaultPresenterConfig)config).setFontsize(newSize);
  	  slides.clear();
  	  
  	  for (SongPart nextPart : midifile.getParts()) {
        slides.addAll(calculatePart(nextPart, param, config));
  	  }
  	  
  	  ((DefaultPresenterConfig)config).setFontsize(null);
    }
    
    for (SlideItem nextCopyright: copyrightItems) {
      Slide lastSlide = slides.get(slides.size() - 1);
      lastSlide.addItem(nextCopyright);
    }
    copyrightItems.clear();

    SlideContainer container = new SlideContainer();
    container.addSlides(midifile, slides);

    return container;
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



  private void addTitle (Slide slide, final Song midifile, final CalculationParam calcParam) {
    if (midifile.getName() != null && ! midifile.getName().isEmpty()) {

      String name = MidiPlayerService.getTitle(midifile);

      LocationInfo point = new LocationInfo(currentX, currentY);
      LocationInfo zoomedPoint = calculateZoomedLocation(point, calcParam);

      FontInfo descTitle = new FontInfo(getConfig().getFont());
      descTitle.setBold(true);

      SizeInfo sizeTitle = getGc().getSize(midifile.getName(), descTitle);
      AreaInfo titleRectangle = new AreaInfo(zoomedPoint, sizeTitle);

      SlideItem titleItem = new SlideItem(titleRectangle, name.toUpperCase(), SlideType.TITLE, null, false, descTitle, 0);
      slide.addItem (titleItem);
      currentY += sizeTitle.getHeight() * 2;
    }
  }

  private void init (final Song midifile) {
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

  private float getOffsetChordToText (float currentY, float lineheight) {
    float offset = getConfig().isChordPresented() ? currentY + lineheight  : currentY;
    return offset + + getIndentBetweenChordAndText();
  }

  private float getOffsetLongestPartType (final Song file) {
    float length = 0;
    String longestPart = "";
    SongStruct struct = new SongStruct(file);
    for (SongPart nextPart: file.getParts()) {
      String label = struct.getItem(nextPart).getLabel();
      if (label != null) {
        SizeInfo currentOffset = getGc().getSize(label, getConfig().getFont());
        if (currentOffset.getWidth() > length) {
          length = currentOffset.getWidth();
          longestPart = label;
        }
      }
    }

    LOGGER.debug("Longest parttype calculated: " + longestPart + " - " + length);

    return length + 25;
  }

  private Slide newSlide (final Song midifile, final SongPart part, final SongTextLine firstLine,
                          final FontInfo zoomedFont, final CalculationParam calcParam, final boolean forceNewPage) {
    Slide slide = new Slide(part, firstLine, zoomedFont, forceNewPage);
    slide.setBackgroundImage(imageFile);
    slide.setSize(calcParam.getPresentationSize());

    slide.setBackgroundColor(PresentationConfigurator.getColorOrDefaultColor(midifile.getBackgroundColor(), getConfig().getDefaultBackgroundColor()));
    LOGGER.debug("set background to " + slide.getBackgroundColor());
    slide.setForegroundColor(PresentationConfigurator.getColorOrDefaultColor(midifile.getForegroundColor(), getConfig().getDefaultForegroundColor()));
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

  private float getLineHeight () {
    return getGc().getSize("H", getConfig().getFont()).getWidth();
  }



  public List<Slide> calculatePart (final SongPart part, final CalculationParam calcParam, final IPresenterConfig config) {
	setConfig(config);
    Song midifile = (Song) part.eContainer();
    init(midifile);
    List <Slide> slides = new ArrayList<Slide>();
    SongStruct struct = new SongStruct(midifile);
    SongStructItem structItem = struct.getItem(part);

    boolean isFirstPartInSong = part.equals(midifile.getParts().get(0));

    if (! structItem.isVisible() && getConfig().isOptimizeEqualParts())
      return slides;

    //TODO centralize fonthandling
    FontInfo font = new FontInfo ("Arial Alternative", getConfig().getFont().getFontsize());
    float longestTypeOffset = getOffsetLongestPartType(midifile);

    FontInfo zoomedFont = calculateZoomedFont(font, calcParam);
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("set font to size " + zoomedFont.getFontsize() + " from " + font.getFontsize());

    float height = getLineHeight();
    if (getConfig().isChordPresented())
      height += getLineHeight();
    else
      height += (getLineHeight() / 2);

    Slide slide = newSlide(midifile, part, part.getTextlines().size() > 0 ? part.getTextlines().get(0) : null, zoomedFont, calcParam, isFirstPartInSong);
    slides.add(slide);

    int leftPosDefault = getConfiguredBorder();
    //add title, if configured
    if (midifile.getParts().get(0).equals(part)) {
      currentX = leftPosDefault;

      if (getConfig().isShowTitle()) {
        addTitle(slide, midifile, calcParam);
      }
    }

    if (getConfig().isShowBlockType()) { //show blocktype (e.g. refrain, chorus..)

      String blockType = structItem.getLabel();
      if (blockType != null) {

        SizeInfo parttypeExtend = getGc().getSize(blockType, getConfig().getFont());
        float addToY = getOffsetChordToText(currentY, getLineHeight());
        LocationInfo point = new LocationInfo(leftPosDefault, addToY);

        LocationInfo zoomedPoint = calculateZoomedLocation(point, calcParam);
        SizeInfo zoomedPartTypeExtend = calculateZoomedSize(parttypeExtend, calcParam);

        AreaInfo textRectangle = new AreaInfo (zoomedPoint, zoomedPartTypeExtend);
        SlideItem newTextItem = new SlideItem(textRectangle, blockType, SlideType.TEXT, null, false, getConfig().getFont(), 0);
        slide.addItem(newTextItem);
      }
      leftPosDefault += longestTypeOffset;
    }

    //Calculate current part

    if (! getConfig().isOptimizeEqualParts() || structItem.isContentShown()) {

    List <SongTextLine> textlines = part.getRefPart() != null ? part.getRefPart().getTextlines() : part.getTextlines();
    for (SongTextLine nextTextLine : textlines ) {


      if (getConfig().isNewPageRespected() && nextTextLine.isNewSlide()) {
        slide = newSlide(midifile, part, nextTextLine,  zoomedFont, calcParam, false);
        slides.add(slide);
      }

      currentX = leftPosDefault;

      List <SlideItem> itemsOfCurrentLine = new ArrayList<SlideItem>();

      for (SongChordPart chordPart : nextTextLine.getChordParts()) {

        boolean newSlideForced = nextTextLine.isNewSlide() && chordPart.equals(nextTextLine.getChordParts().get(0));

        String chord = getConfig().isChordPresented() ? chordPart.getChord(): null;
        String text = chordPart.getText();

        if (getConfig().isOptimizeEmptyTokens()) {
          if (text != null && text.trim().isEmpty())
            text = null;
        }


        SizeInfo textExtend = text != null ? getGc().getSize(text, getConfig().getFont()) : nullExtend;
        SizeInfo chordExtend = chord != null && getConfig().isChordPresented() ? getGc().getSize(chord, getConfig().getFont()): nullExtend ;

        SlideItem newTextItem = null;

        float biggestXExtend = 0;
        if (chordExtend.getWidth() > biggestXExtend)
          biggestXExtend = chordExtend.getWidth();
        if (textExtend.getWidth() > biggestXExtend)
          biggestXExtend = textExtend.getWidth();

        if (text != null) {
          float addToY = getOffsetChordToText(currentY, getLineHeight());
          float indentToChord = currentY - addToY; //indent between chord and text
          LocationInfo point = new LocationInfo(currentX, addToY);
          LocationInfo zoomedPoint = calculateZoomedLocation(point, calcParam);
          SizeInfo zoomedTextExtend = calculateZoomedSize(textExtend, calcParam);
          LocationInfo zoomedIndent = calculateZoomedLocation(new LocationInfo (indentToChord, 0), calcParam);

          AreaInfo textRectangle = new AreaInfo(zoomedPoint, zoomedTextExtend);
          newTextItem = new SlideItem(textRectangle, text, SlideType.TEXT, null, newSlideForced, getConfig().getFont(), zoomedIndent.getX());
          itemsOfCurrentLine.add(newTextItem);
        }

        if (chord != null && getConfig().isChordPresented()) {
          LocationInfo point = new LocationInfo (currentX, currentY);
          LocationInfo zoomedPoint = calculateZoomedLocation(point, calcParam);
          SizeInfo zoomedChordExtend = calculateZoomedSize(chordExtend, calcParam);

          AreaInfo  chordRectangle = new AreaInfo(zoomedPoint, zoomedChordExtend);
          SlideItem newItem = new SlideItem(chordRectangle, chord, SlideType.CHORD, newTextItem, newSlideForced, getConfig().getFont(), 0);
          itemsOfCurrentLine.add(newItem);
        }

        currentX += biggestXExtend;

      }

      boolean movingToPreviousLine = false;
      if (! nextTextLine.equals(textlines.get(0))) {
        movingToPreviousLine = isMovingCurrentItemsToPreviousLineAllowed(slide, itemsOfCurrentLine, calcParam);
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

      if (isYOutOfPageSize(calcParam) && getConfig().isAutoWrapToNewPage()) {
        slide = newSlide(midifile, part, nextTextLine,  zoomedFont, calcParam, true);
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

  private boolean isYOutOfPageSize (CalculationParam calcParam) {
    float zoomedCurrentY = calculateZoomedLocation(new LocationInfo (currentY, 0), calcParam).getX(); //TODO check, if this is OK
    return zoomedCurrentY > maxY;
  }

  /**
   *
   * @param height
   * @return
   */
  private void stepCurrentYToNextLine (final float height) {
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
    float lastX = lastTextItem.getXMax();
    float lastY = lastTextItem.getY();

    if (! lastTextItem.getText().endsWith(" "))
      lastX += getGc().getSize(" ", getConfig().getFont()).getWidth();

    SlideItem lastChordItem = null;
    List<SlideItem> chordItems = slide.getItems(SlideType.CHORD);
    if (chordItems.size() > 0 ) {
      lastChordItem = chordItems.get(chordItems.size() - 1);
      lastX = Math.max(lastX, lastChordItem.getXMax());
    }

    float firstX = currentItems.get(0).getX();

    for (SlideItem item: currentItems) {
      float newY = lastY;
      if (item.getItemType().equals(SlideType.CHORD))
        newY += lastTextItem.getIndentToChord();

      item.setX(item.getX() + lastX - firstX);
      item.setY(newY);
    }
  }

  private float getMaxX (final Collection <SlideItem> items) {
    float maxX = 0;
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
   * @param calcParam  preCondition
   * @return true/false
   */
  private boolean isMovingCurrentItemsToPreviousLineAllowed (final Slide slide, final List <SlideItem> currentItems, CalculationParam calcParam) {

    if (! getConfig().isOptimizeLineFilling())
      return false;

    if (slide.getItems().isEmpty())
      return false;

    if (currentItems.size() == 0)
      return false;

    float firstX = currentItems.get(0).getX();
    float lastXMax = getMaxX(currentItems);

    float spaceAmountOfCurrentItems = lastXMax - firstX;

    List<SlideItem> textitems = slide.getItems(SlideType.TEXT);
    SlideItem lastSlideItem = textitems.get(textitems.size() - 1);
    float xMaxOfLast = lastSlideItem.getXMax();

    String logtext = "";
    for (SlideItem next: currentItems) {
      logtext += next.getText();
    }
    boolean optimizing = xMaxOfLast + spaceAmountOfCurrentItems < calcParam.getPresentationSize().getWidth() - getConfiguredBorder();
    if (LOGGER.isDebugEnabled())
    LOGGER.debug("Text <" + logtext + "> needs " + spaceAmountOfCurrentItems +
                ", appending at " + xMaxOfLast + "calculcationsize is " + calcParam.getPresentationSize().getWidth() + "->optimizing=" + optimizing);
    return optimizing;
  }

  @Override
  public boolean isAssigned (AbstractSessionItem item) {
    return item instanceof Song;
  }



}
