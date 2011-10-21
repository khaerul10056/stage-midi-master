package org.mda.commons.ui.calculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

public class MidiFileSlideCalculator extends SlideCalculator {

  private int currentX;

  private int currentY;

  private int fontsize = 40;

  private Font font;

  private Image image;

  private Point nullExtend = new Point (0,0);

  private final GC gc = new GC(Display.getDefault());

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
    if (midifile.getFontsize() != null && midifile.getFontsize().length() > 0)
      fontsize = Integer.parseInt(midifile.getFontsize());

    font = new Font (Display.getCurrent(), "Arial Alternative", fontsize, SWT.NONE);
    gc.setFont(font);

    if (midifile.getPic() != null && midifile.getPic().length() > 0) {
      File picAsFile = new File (midifile.getPic());
      if (picAsFile.exists()) {
        FileInputStream fis;
        try {
          fis = new FileInputStream(picAsFile);
          image = new Image(Display.getDefault(), fis);
        }
        catch (FileNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    else
      image = null;

  }

  public Slide calculatePart (final MidiFilePart part, final CalculatorPreCondition preCondition) {

    init((MidiFile) part.eContainer());
    Font zoomedFont = calculateZoomedFont(font, preCondition);
    Slide slide = new Slide(part, zoomedFont);
    slide.setBackgroundImage(image);

    currentY = 0;

    normalizeSizeToPresentationSize(preCondition);

    for (MidiFileTextLine nextTextLine : part.getTextlines()) {
      currentX = 0;

      Point testExtend = gc.textExtent("H");
      int height = testExtend.y;
      if (getConfig().isChordVisible())
        height += testExtend.y;

      for (MidiFileChordPart chordPart : nextTextLine.getChordParts()) {
        String chord = getConfig().isChordVisible() ? chordPart.getChord(): null;
        String text = chordPart.getText();

        Point textExtend = text != null ? gc.textExtent(text) : nullExtend;
        Point chordExtend = chord != null && getConfig().isChordVisible() ? gc.textExtent(chord): nullExtend ;

        SlideItem newTextItem = null;
        if (text != null) {
          Point point = new Point(currentX, currentY + chordExtend.y);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);

          newTextItem = new SlideItem(zoomedPoint, text, SlideType.TEXT, null);
          slide.addItem(newTextItem);
        }

        if (chord != null) {
          Point point = new Point (currentX, currentY);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);
          SlideItem newItem = new SlideItem(zoomedPoint, chord, SlideType.CHORD, newTextItem);
          slide.addItem(newItem);
        }

        int biggestXExtend = 0;
        if (chordExtend.x > biggestXExtend)
          biggestXExtend = chordExtend.x;
        if (textExtend.x > biggestXExtend)
          biggestXExtend = textExtend.x;

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
