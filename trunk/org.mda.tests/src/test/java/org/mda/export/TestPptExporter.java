package org.mda.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import mda.AbstractSessionItem;
import mda.Song;
import mda.SongPartType;

import org.apache.poi.hslf.usermodel.SlideShow;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.export.powerpoint.PptExporter;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.ui.test.MidiFileCreator;


public class TestPptExporter {

  private File tmpFile = new File ("tmp/export.ppt");

  private static ApplicationSession appSession;
  private static DefaultPresenterConfig config;


  @BeforeClass
  public static void beforeClass () {
	InjectServiceMock.initialize();
	appSession = InjectService.getInstance(ApplicationSession.class);
	config = InjectService.getInstance(DefaultPresenterConfig.class);
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


  private PptExporter getExporter () {
	  return InjectService.getInstance(PptExporter.class);
  }

  @Test
  public void testBackgroundImage () {
	  throw new IllegalStateException("Nicht angepasst");

  }

  @Test
  public void foreGroundDefault () {
	  throw new IllegalStateException("Nicht angepasst");
//      final String backgroundImage = "image#05_51_24---Sunset-Worship-Background_web#jpg";
//
//      MidiFileCreator creator = MidiFileCreator.create();
//      creator = creator.part(SongPartType.VERS).line();
//      creator = creator.chordAndText("D", "This is a test").chordAndText("E", "once more");
//      Song file = creator.get();
//      file.setPic(backgroundImage);
//      Color colorWhite = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
//      java.awt.Color colorWhiteAsAwt = Utils.toAwtColor(colorWhite);
//
//      PptExporter exporter = getExporter();
//
//      config.setShowChords(false);
//      config.setShowBackground(true);
//
//
//      List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
//      sessionitems.add(file);
//
//      File export = exporter.export(sessionitems, tmpFile, config);
//      Assert.assertEquals (tmpFile, export);
//
//      SlideShow lastExportedResult = exporter.getLastExportedResult();
//      Assert.assertNotNull (lastExportedResult.getSlides() [0].getBackground().getFill().getPictureData());
//      Assert.assertEquals (colorWhiteAsAwt, ((TextBox)lastExportedResult.getSlides() [0].getShapes () [0]).getTextRun().getRichTextRuns() [0].getFontColor());

      //Check if foreground set
  }

  @Test
  public void testNoBackgroundImage () {
	  throw new IllegalStateException("Nicht angepasst");

//    MidiFileCreator creator = MidiFileCreator.create();
//    creator = creator.part(SongPartType.VERS).line();
//    creator = creator.chordAndText("D", "This is a test").chordAndText("E", "once more");
//    Song file = creator.get();
//
//    PptExporter exporter = getExporter();
//    Color colorBlack = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
//    String colorBlackAsString = Utils.colorToString(colorBlack);
//    file.setBackgroundColor(colorBlackAsString);
//    java.awt.Color colorBlackAsAwt = Utils.toAwtColor(colorBlack);
//
//    config.setShowChords(false);
//
//    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
//    sessionitems.add(file);
//
//    File export = exporter.export(sessionitems, tmpFile, config);
//    Assert.assertEquals (tmpFile, export);
//
//    SlideShow lastExportedResult = exporter.getLastExportedResult();
//    Assert.assertNull (lastExportedResult.getSlides() [0].getBackground().getFill().getPictureData());
//    Assert.assertEquals (colorBlackAsAwt, lastExportedResult.getSlides() [0].getBackground().getFill().getBackgroundColor());
//    Assert.assertEquals (colorBlackAsAwt, lastExportedResult.getSlides() [0].getBackground().getFill().getForegroundColor());
//    Assert.assertEquals (4, lastExportedResult.getSlides() [0].getBackground().getFill().getFillType());

  }


}
