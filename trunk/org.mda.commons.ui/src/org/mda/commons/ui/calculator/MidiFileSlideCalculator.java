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

  @Override
  public List<Slide> calculate (final AbstractSessionItem sessionitem, final CalculatorPreCondition preCondition) {
    List<Slide> slides = new ArrayList<Slide>();
    MidiFile midifile = (MidiFile) sessionitem;

    init(midifile);

    currentY = 0;

    for (MidiFilePart nextPart : midifile.getParts()) {
      slides.add(calculatePart(nextPart, preCondition));
    }
    return slides;
  }

  private void init (final MidiFile midifile) {
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("Setting font to size " + getConfig().getFontsize());


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
      LOGGER.info("Setting image to null");
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
      Point currentOffset = getGc().getSize(nextPart.getParttype().getName(), getConfig());
      //currentOffset = calculateZoomedPoint(currentOffset, preCondition);
      if (currentOffset.x > length) {
        length = currentOffset.x;
        longestPart = nextPart.getParttype().getName();
      }
    }

    LOGGER.info("Longest parttype calculated: " + longestPart + " - " + length);

    return length + 25;
  }

  public Slide calculatePart (final MidiFilePart part, final CalculatorPreCondition preCondition) {
    MidiFile midifile = (MidiFile) part.eContainer();
    init(midifile);

    //TODO centralize fonthandling
    Font font = new Font (Display.getCurrent(), "Arial Alternative", getConfig().getFontsize().intValue(), SWT.NONE);
    int longestTypeOffset = getOffsetLongestPartType(midifile, preCondition);

    Font zoomedFont = calculateZoomedFont(font, preCondition);
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("set font to size " + zoomedFont.getFontData() [0].height + " from " + font.getFontData() [0].height);
    Slide slide = new Slide(part, zoomedFont);
    slide.setBackgroundImage(imageFile);

    slide.setBackgroundColor(Utils.stringToColor(midifile.getBackgroundColor(), getConfig().getDefaultBackgroundColor()));
    LOGGER.info("set background to " + slide.getBackgroundColor());
    slide.setForegroundColor(Utils.stringToColor(midifile.getForegroundColor(), getConfig().getDefaultForegroundColor()));
    LOGGER.info("set foreground to " + slide.getForegroundColor());

    Point testExtend = getGc().getSize("H", getConfig());

    if (getConfig().isPagePerPart())
      currentY = 0;
    else
      currentY += testExtend.y; //between parts the should be a intend

    normalizeSizeToPresentationSize(preCondition);

    int leftPosDefault = 0;

    if (getConfig().isShowBlockType()) { //show blocktype (e.g. refrain, chorus..)
      String blockType = part.getParttype().getName() + " ";
      Point parttypeExtend = getGc().getSize(blockType, getConfig());
      int addToY = getOffsetChordToText(currentY, parttypeExtend);
      Point point = new Point(leftPosDefault, addToY);
      Point zoomedPoint = calculateZoomedPoint(point, preCondition);
      Rectangle textRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, parttypeExtend.x, parttypeExtend.y);

      SlideItem newTextItem = new SlideItem(textRectangle, blockType, SlideType.TEXT, null);
      slide.addItem(newTextItem);
      leftPosDefault += longestTypeOffset;
    }

    //Calculate current part
    for (MidiFileTextLine nextTextLine : part.getRefPart() != null ? part.getRefPart().getTextlines() : part.getTextlines()) {
      currentX = leftPosDefault;



      int height = testExtend.y;
      if (getConfig().isChordPresented())
        height += testExtend.y;
      else
        height += (testExtend.y / 2);

      for (MidiFileChordPart chordPart : nextTextLine.getChordParts()) {
        String chord = getConfig().isChordPresented() ? chordPart.getChord(): null;
        String text = chordPart.getText();

        Point textExtend = text != null ? getGc().getSize(text, getConfig()) : nullExtend;

        Point chordExtend = chord != null && getConfig().isChordPresented() ? getGc().getSize(chord, getConfig()): nullExtend ;

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
          newTextItem = new SlideItem(textRectangle, text, SlideType.TEXT, null);
          slide.addItem(newTextItem);
        }

        if (chord != null && getConfig().isChordPresented()) {
          Point point = new Point (currentX, currentY);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);

          Rectangle chordRectangle = new Rectangle(zoomedPoint.x, zoomedPoint.y, chordExtend.x, chordExtend.y);
          SlideItem newItem = new SlideItem(chordRectangle, chord, SlideType.CHORD, newTextItem);
          slide.addItem(newItem);
        }





        currentX += biggestXExtend;

      }
      currentY += getDistanceBetweenLines();

      slide.newLine();

      currentY = currentY + height;


    }
    return slide;
  }

  @Override
  public boolean isAssigned (AbstractSessionItem item) {
    return item instanceof MidiFile;
  }



}
