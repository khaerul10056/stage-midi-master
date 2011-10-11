package org.mda.presenter.ui;

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
import org.mda.presenter.ui.slide.Slide;
import org.mda.presenter.ui.slide.SlideItem;
import org.mda.presenter.ui.slide.SlideType;

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


    for (MidiFilePart nextPart : midifile.getParts()) {
      slides.add(calculatePart(nextPart, preCondition));
    }
    return slides;
  }

  private void init (final MidiFile midifile) {
    if (midifile.getFontsize() != null && midifile.getFontsize().length() > 0)
      fontsize = Integer.parseInt(midifile.getFontsize());

    font = new Font (Display.getCurrent(), "Arial", fontsize, SWT.NONE);
    gc.setFont(font);

  }

  public Slide calculatePart (final MidiFilePart part, final CalculatorPreCondition preCondition) {

    init((MidiFile) part.eContainer());
    Slide slide = new Slide(part);
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

        if (text != null) {
          Point point = new Point(currentX, currentY + chordExtend.y);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);
          Font zoomedFont = calculateZoomedFont(font, preCondition);
          SlideItem newItem = new SlideItem(zoomedPoint, text, zoomedFont, SlideType.TEXT);
          slide.addItem(newItem);
        }

        if (chord != null) {
          Point point = new Point (currentX, currentY);
          Point zoomedPoint = calculateZoomedPoint(point, preCondition);
          Font zoomedFont = calculateZoomedFont(font, preCondition);
          SlideItem newItem = new SlideItem(zoomedPoint, chord, zoomedFont, SlideType.CHORD);
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
