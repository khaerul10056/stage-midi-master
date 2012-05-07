package org.mda.commons.ui.calculator;

import java.io.File;
import java.util.ArrayList;
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

  private Slide newSlide (final MidiFile midifile, final MidiFilePart part, final MidiFileTextLine firstLine, final Font zoomedFont) {
    Slide slide = new Slide(part, firstLine, zoomedFont);
    slide.setBackgroundImage(imageFile);

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

    Slide slide = newSlide(midifile, part, part.getTextlines().size() > 0 ? part.getTextlines().get(0) : null, zoomedFont);
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
    for (MidiFileTextLine nextTextLine : part.getRefPart() != null ? part.getRefPart().getTextlines() : part.getTextlines()) {

      if (getConfig().isNewPageRespected() && nextTextLine.isNewSlide()) {
        slide = newSlide(midifile, part, nextTextLine,  zoomedFont);
        slides.add(slide);
      }
      currentX = leftPosDefault;


      int height = testExtend.y;
      if (getConfig().isChordPresented())
        height += testExtend.y;
      else
        height += (testExtend.y / 2);

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
          slide.addItem(newTextItem);
        }

        if (chord != null && getConfig().isChordPresented()) {
          Point point = new Point (currentX, currentY);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);

          Rectangle chordRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, chordExtend.x, chordExtend.y);
          SlideItem newItem = new SlideItem(chordRectangle, chord, SlideType.CHORD, newTextItem, newSlideForced, getConfig().getFont());
          slide.addItem(newItem);
        }





        currentX += biggestXExtend;

      }
      currentY += getDistanceBetweenLines();

      slide.newLine();

      currentY = currentY + height;


    }
    return slides;
  }

  @Override
  public boolean isAssigned (AbstractSessionItem item) {
    return item instanceof MidiFile;
  }



}
