package org.mda.presenter.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.File;
import java.util.Iterator;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import org.eclipse.swt.graphics.Point;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.commons.ui.calculator.SlideType;


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

  private Slide calculate (final MidiFilePart part, final boolean chordVisible, final int fontsize) {
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setFontsize(fontsize);
    config.setChordVisible(chordVisible);
    CalculatorPreCondition preCondition = new CalculatorPreCondition();
    preCondition.setCalculationsize(config.getDefaultPresentationScreenSize());

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    return calculator.calculatePart(part, preCondition);
  }

  @Test
  public void checkConcreteWithChord () {

    //Text and follow chords

    MidiFile song = MidiplayerFactory.eINSTANCE.createMidiFile();


    MidiFilePart part = MidiplayerFactory.eINSTANCE.createMidiFilePart();
    song.getParts().add(part);

    //           D
    // This is a test
    MidiFileTextLine textLine = MidiplayerFactory.eINSTANCE.createMidiFileTextLine();
    MidiFileChordPart part1 = MidiplayerFactory.eINSTANCE.createMidiFileChordPart();
    part1.setText("This is a");
    textLine.getChordParts().add(part1);
    MidiFileChordPart part2 = MidiplayerFactory.eINSTANCE.createMidiFileChordPart();
    part2.setText("test");
    part2.setChord("D");
    textLine.getChordParts().add(part2);
    part.getTextlines().add(textLine);

    //
    // second line
    MidiFileTextLine textLine2 = MidiplayerFactory.eINSTANCE.createMidiFileTextLine();
    MidiFileChordPart part3 = MidiplayerFactory.eINSTANCE.createMidiFileChordPart();
    part3.setText("second line");
    textLine2.getChordParts().add(part3);
    part.getTextlines().add(textLine2);

    Slide slide = calculate(part, true, 80);

    System.out.println (slide);

    SlideItem item1 = slide.getItems().get(0);
    SlideItem item2 = slide.getItems().get(1);
    SlideItem item3 = slide.getItems().get(2);
    SlideItem item4 = slide.getItems().get(3);

    assertEquals ("This is a", item1.getText());
    assertEquals (SlideType.TEXT, item1.getItemType());

    assertEquals ("test", item2.getText());
    assertEquals (SlideType.TEXT, item2.getItemType());

    assertEquals (item1.getY(), item2.getY());

    assertEquals ("D", item3.getText());
    assertEquals (SlideType.CHORD, item3.getItemType());

    assertEquals ("second line", item4.getText());
    assertEquals (SlideType.TEXT, item4.getItemType());
    assertEquals (item4.getX(), item1.getX());
    assertTrue (item4.getY() > item1.getY());
  }

  @Test
  public void checkConcreteWithoutChords () {

    //Text and follow chords

    MidiFile song = MidiplayerFactory.eINSTANCE.createMidiFile();

    MidiFilePart part = MidiplayerFactory.eINSTANCE.createMidiFilePart();
    song.getParts().add(part);
    MidiFileTextLine textLine = MidiplayerFactory.eINSTANCE.createMidiFileTextLine();

    //           D
    // This is a test
    MidiFileChordPart part1 = MidiplayerFactory.eINSTANCE.createMidiFileChordPart();
    part1.setText("This is a");
    textLine.getChordParts().add(part1);
    MidiFileChordPart part2 = MidiplayerFactory.eINSTANCE.createMidiFileChordPart();
    part2.setText("test");
    part2.setChord("D");
    textLine.getChordParts().add(part2);
    part.getTextlines().add(textLine);

    //
    // second line
    MidiFileTextLine textLine2 = MidiplayerFactory.eINSTANCE.createMidiFileTextLine();
    MidiFileChordPart part3 = MidiplayerFactory.eINSTANCE.createMidiFileChordPart();
    part3.setText("second line");
    textLine2.getChordParts().add(part3);
    part.getTextlines().add(textLine2);

    Slide slide = calculate(part, false, 80);
    System.out.println (slide);

    SlideItem item1 = slide.getItems().get(0);
    SlideItem item2 = slide.getItems().get(1);
    SlideItem item3 = slide.getItems().get(2);

    assertEquals ("This is a", item1.getText());
    assertEquals (SlideType.TEXT, item1.getItemType());

    assertEquals ("test", item2.getText());
    assertEquals (SlideType.TEXT, item2.getItemType());

    assertEquals (item1.getY(), item2.getY());

    assertEquals ("second line", item3.getText());
    assertEquals (SlideType.TEXT, item3.getItemType());
    assertEquals (item3.getX(), item1.getX());
    assertTrue (item3.getY() > item1.getY());
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
      like ("Font of " + nextFull.getText(), slideFullScreen.getFont().getFontData() [0].getHeight(), halfScreen.getFont().getFontData() [0].getHeight() * 2);
    }

    System.out.println ("Full: " + slideFullScreen.toString());
    System.out.println ("Half: " + halfScreen.toString());

  }

  private void like (final String text, final int first, final int second) {
    if (first + 1 == second || first -1 == second || first == second)
      return;
    else
      fail (text + "first " + first + "->second " + second);

  }

}
