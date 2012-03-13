package org.mda.commons.ui.calculator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.Utils;
import org.mda.additionals.Additional;
import org.mda.commons.ui.imagecache.ImageCache;

public class MidiFileSlideCalculator extends SlideCalculator {

  private static final Logger LOGGER  = Logger.getLogger(MidiFileSlideCalculator.class.getName());

  private int currentX;

  private int currentY;


  private Font font;


  private ImageCache imageCache = new ImageCache();

  private File imageFile;

  private Point nullExtend = new Point (0,0);

  private final GC gc = new GC(Display.getDefault());

  private ApplicationSession  appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  @Override
  public List<Slide> calculate (final AbstractSessionItem sessionitem, final CalculatorPreCondition preCondition) {
    List<Slide> slides = new ArrayList<Slide>();
    MidiFile midifile = (MidiFile) sessionitem;

    init(midifile);

    for (MidiFilePart nextPart : midifile.getParts()) {
      slides.add(calculatePart(nextPart, preCondition));
    }
    return slides;
  }

  private void init (final MidiFile midifile) {
    LOGGER.info("Setting font to size " + getConfig().getFontsize());

    font = new Font (Display.getCurrent(), "Arial Alternative", getConfig().getFontsize(), SWT.NONE);
    gc.setFont(font);

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



  private int getOffsetChordToText (int currentY, Point testExtend) {
    return getConfig().isChordPresented() ? currentY + testExtend.y : currentY;
  }

  public Slide calculatePart (final MidiFilePart part, final CalculatorPreCondition preCondition) {
    MidiFile midifile = (MidiFile) part.eContainer();
    init(midifile);
    Font zoomedFont = calculateZoomedFont(font, preCondition);
    LOGGER.info("set font to size " + zoomedFont.getFontData() [0].height + " from " + font.getFontData() [0].height);
    Slide slide = new Slide(part, zoomedFont);
    slide.setBackgroundImage(imageFile);

    slide.setBackgroundColor(Utils.stringToColor(midifile.getBackgroundColor(), getConfig().getDefaultBackgroundColor()));
    LOGGER.info("set background to " + slide.getBackgroundColor());
    slide.setForegroundColor(Utils.stringToColor(midifile.getForegroundColor(), getConfig().getDefaultForegroundColor()));
    LOGGER.info("set foreground to " + slide.getForegroundColor());

    currentY = 0; //TODO part per slide

    Point testExtend = gc.textExtent("H");

    normalizeSizeToPresentationSize(preCondition);

    int leftPosDefault = 0;

    if (getConfig().isShowBlockType()) { //show blocktype (e.g. refrain, chorus..)
      String blockType = part.getParttype().getName() + " ";
      Point textExtent = gc.textExtent(blockType);
      int addToY = getOffsetChordToText(currentY, testExtend);
      SlideItem newTextItem = new SlideItem(new Rectangle(leftPosDefault, addToY, textExtent.x, textExtent.y), blockType, SlideType.TEXT, null);
      slide.addItem(newTextItem);
      leftPosDefault += textExtent.x;
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

        Point textExtend = text != null ? gc.textExtent(text) : nullExtend;

        Point chordExtend = chord != null && getConfig().isChordPresented() ? gc.textExtent(chord): nullExtend ;

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
