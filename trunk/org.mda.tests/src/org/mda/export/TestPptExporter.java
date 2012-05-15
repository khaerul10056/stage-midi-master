package org.mda.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mda.AbstractSessionItem;
import mda.ExportConfiguration;
import mda.MidiFile;
import mda.MidiFilePartType;
import mda.MidiplayerFactory;
import org.apache.poi.hslf.model.TextBox;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.Utils;
import org.mda.export.powerpoint.PptExporter;
import org.mda.presenter.ui.test.MidiFileCreator;


public class TestPptExporter {

  private File tmpFile = new File ("tmp/export.ppt");

  private static ApplicationSession appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);


  @BeforeClass
  public static void beforeClass () {
    appSession.load(null);
  }

  @Before
  public void before () {
    if (tmpFile.exists())
      Assert.assertTrue (tmpFile.delete());
  }

  @After
  public void after () {
    if (tmpFile.exists())
      Assert.assertTrue (tmpFile.delete());
  }



  @Test
  public void testBackgroundImage () {
    final String backgroundImage = "image#05_51_24---Sunset-Worship-Background_web#jpg";

    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.VERS).line();
    creator = creator.chordAndText("D", "This is a test").chordAndText("E", "once more");
    MidiFile file = creator.get();
    file.setPic(backgroundImage);
    Color colorBlack = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
    String colorBlackAsString = Utils.colorToString(colorBlack);
    file.setForegroundColor(colorBlackAsString);

    java.awt.Color colorBlackAsAwt = Utils.toAwtColor(colorBlack);

    PptExporter exporter = new PptExporter();

    ExportConfiguration config = MidiplayerFactory.eINSTANCE.createExportConfiguration();
    config.setWithChords(false);

    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
    sessionitems.add(file);

    File export = exporter.export(sessionitems, tmpFile, config);
    Assert.assertEquals (tmpFile, export);

    SlideShow lastExportedResult = exporter.getLastExportedResult();
    Assert.assertNotNull (lastExportedResult.getSlides() [0].getBackground().getFill().getPictureData());
    Assert.assertEquals (colorBlackAsAwt, ((TextBox)lastExportedResult.getSlides() [0].getShapes () [0]).getTextRun().getRichTextRuns() [0].getFontColor());

  }

  @Test
  public void foreGroundDefault () {
      final String backgroundImage = "image#05_51_24---Sunset-Worship-Background_web#jpg";

      MidiFileCreator creator = MidiFileCreator.create();
      creator = creator.part(MidiFilePartType.VERS).line();
      creator = creator.chordAndText("D", "This is a test").chordAndText("E", "once more");
      MidiFile file = creator.get();
      file.setPic(backgroundImage);
      Color colorWhite = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
      java.awt.Color colorWhiteAsAwt = Utils.toAwtColor(colorWhite);


      PptExporter exporter = new PptExporter();

      ExportConfiguration config = MidiplayerFactory.eINSTANCE.createExportConfiguration();
      config.setWithChords(false);

      List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
      sessionitems.add(file);

      File export = exporter.export(sessionitems, tmpFile, config);
      Assert.assertEquals (tmpFile, export);

      SlideShow lastExportedResult = exporter.getLastExportedResult();
      Assert.assertNotNull (lastExportedResult.getSlides() [0].getBackground().getFill().getPictureData());
      Assert.assertEquals (colorWhiteAsAwt, ((TextBox)lastExportedResult.getSlides() [0].getShapes () [0]).getTextRun().getRichTextRuns() [0].getFontColor());

      //Check if foreground set
  }

  @Test
  public void testNoBackgroundImage () {

    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(MidiFilePartType.VERS).line();
    creator = creator.chordAndText("D", "This is a test").chordAndText("E", "once more");
    MidiFile file = creator.get();

    PptExporter exporter = new PptExporter();
    Color colorBlack = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
    String colorBlackAsString = Utils.colorToString(colorBlack);
    file.setBackgroundColor(colorBlackAsString);
    java.awt.Color colorBlackAsAwt = Utils.toAwtColor(colorBlack);

    ExportConfiguration config = MidiplayerFactory.eINSTANCE.createExportConfiguration();
    config.setWithChords(false);

    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
    sessionitems.add(file);

    File export = exporter.export(sessionitems, tmpFile, config);
    Assert.assertEquals (tmpFile, export);

    SlideShow lastExportedResult = exporter.getLastExportedResult();
    Assert.assertNull (lastExportedResult.getSlides() [0].getBackground().getFill().getPictureData());
    Assert.assertEquals (colorBlackAsAwt, lastExportedResult.getSlides() [0].getBackground().getFill().getBackgroundColor());
    Assert.assertEquals (colorBlackAsAwt, lastExportedResult.getSlides() [0].getBackground().getFill().getForegroundColor());
    Assert.assertEquals (4, lastExportedResult.getSlides() [0].getBackground().getFill().getFillType());

  }


}

