package org.mda.presenter.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.File;
import java.util.Iterator;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiPlayerRoot;
import org.eclipse.swt.graphics.Point;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;


public class MidiFileSlideCalculatorTest {

  @Test
  public void createLines () {

    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    MidiFilePart midiFilePart = song.getParts().get(1);

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    Slide calculatePart = calculator.calculatePart(midiFilePart, preCondition);

    assertEquals(midiFilePart.getTextlines().size(), calculatePart.getLineCount());

    assertEquals ("Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist, ", calculatePart.getTextline(0));

  }

  @Test
  public void zoom () {

    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    MidiFilePart midiFilePart = song.getParts().get(1);

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    Slide slideFullScreen = calculator.calculatePart(midiFilePart, preCondition);


    Point half = new Point (config.getDefaultPresentationScreenSize().x / 2, config.getDefaultPresentationScreenSize().y / 2);
    preCondition.setCalculationsize(half);
    Slide halfScreen = calculator.calculatePart(midiFilePart, preCondition);

    Iterator<SlideItem> halfIterator = halfScreen.getItems().iterator();

    for (SlideItem nextFull : slideFullScreen.getItems()) {
      SlideItem nextHalf = halfIterator.next();

      like ("X-Coordinate of " + nextFull.getText(), nextFull.getX(), nextHalf.getX() * 2);
      like ("Y-Coordinate of " + nextFull.getText(), nextFull.getY(), nextHalf.getY() * 2);
      like ("Font of " + nextFull.getText(), slideFullScreen.getFont().getFontData() [0].getHeight(), slideFullScreen.getFont().getFontData() [0].getHeight() * 2);
    }

    System.out.println ("Full: " + slideFullScreen.toString());
    System.out.println ("Half: " + halfScreen.toString());

  }

  private void like (final String text, final int first, final int second) {
    if (first + 1 == second || first -1 == second || first == second)
      return;
    else
      fail (text);

  }

}
