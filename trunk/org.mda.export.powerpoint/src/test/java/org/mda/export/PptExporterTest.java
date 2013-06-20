package org.mda.export;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import mda.AbstractSessionItem;
import mda.Song;
import mda.SongPartType;

import org.apache.poi.hslf.model.TextBox;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.CoreModule;
import org.mda.Utils;
import org.mda.export.powerpoint.PptExporter;
import org.mda.inject.InjectService;
import org.mda.measurement.ColorInfo;
import org.mda.presenter.PresenterModule;
import org.mda.presenter.PresenterTestModule;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.test.SongCreator;

public class PptExporterTest {
	
	private File tmpRoot = new File ("tmp");
	private File tmpFile = new File ("tmp/export.ppt");

	  private static DefaultPresenterConfig config;


	  @BeforeClass
	  public static void beforeClass () {
		InjectService.cachedModules.add(new CoreModule());
		InjectService.cachedModules.add(new PresenterModule());
		InjectService.cachedModules.add(new PresenterTestModule());

		config = InjectService.getInstance(DefaultPresenterConfig.class);
	  }


	  @Before
	  public void before() {
		Utils.deleteDirectory(tmpRoot);
	  }

	  @After
	  public void after() {
		Utils.deleteDirectory(tmpRoot);
	  }

	  
	  @AfterClass
	  public static void afterClass () {
		  InjectService.dispose();
	  }


	  private PptExporter getExporter () {
		  return InjectService.getInstance(PptExporter.class);
	  }

	  @Test
	  public void foreGroundDefault () {
		  
	      final String backgroundImage = "image#05_51_24---Sunset-Worship-Background_web#jpg";
	
	      SongCreator creator = SongCreator.create();
	      creator = creator.part(SongPartType.VERS).line();
	      creator = creator.chordAndText("D", "This is a test").chordAndText("E", "once more");
	      Song file = creator.get();
	      file.setPic(backgroundImage);
	      Color colorWhiteAsAwt = PptExporter.toAwtColor(ColorInfo.WHITE);
	
	      PptExporter exporter = getExporter();
	
	      config.setShowChords(false);
	      config.setShowBackground(true);
	
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
		  

	    SongCreator creator = SongCreator.create();
	    creator = creator.part(SongPartType.VERS).line();
	    creator = creator.chordAndText("D", "This is a test").chordAndText("E", "once more");
	    Song file = creator.get();
	
	    PptExporter exporter = getExporter();
	    String colorBlackAsString = ColorInfo.BLACK.toString();
	    file.setBackgroundColor(colorBlackAsString);
	    java.awt.Color colorBlackAsAwt = PptExporter.toAwtColor(ColorInfo.BLACK);
	
	    config.setShowChords(false);
	
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
