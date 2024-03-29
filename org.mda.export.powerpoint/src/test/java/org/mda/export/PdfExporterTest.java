package org.mda.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import mda.AbstractSessionItem;
import mda.Song;
import mda.SongPartType;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.CoreModule;
import org.mda.Utils;
import org.mda.export.pdf.PdfExporter;
import org.mda.inject.InjectService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.PresenterModule;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideItem;
import org.mda.presenter.SlideType;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.test.SongCreator;

public class PdfExporterTest {
	
	private final static Log LOG = LogFactory.getLogger(PdfExporterTest.class);

	  private File tmpFile = new File ("tmp/export.pdf");
	  private File tmpRoot = new File ("tmp");

	  private static ApplicationSession appSession;


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

	  @BeforeClass
	  public static void beforeClass () {
		InjectService.cachedModules.add(new CoreModule());
		InjectService.cachedModules.add(new PresenterModule());
		InjectService.cachedModules.add(new ExportTestModule());
		appSession = InjectService.getInstance(ApplicationSession.class);
	    appSession.getGlobalConfs().setShowGrid(true);
	    appSession.getGlobalConfs().setDefaultBorder(0);
	  }

	  private SlideItem findItem (final Slide slide, final String text, final int ordinal) {

	    List<SlideItem> findItem = slide.findItem(text);
	    if (findItem.size() > ordinal)
	      return findItem.get(ordinal);
	    else
	      return null;
	  }
	  
	  private PdfExporter getExporter () {
		  return InjectService.getInstance(PdfExporter.class);
	  }
	  @Test
	  public void checkExportWithChords () {
	    PdfExporter exporter = getExporter();

	    DefaultPresenterConfig config = new DefaultPresenterConfig();
	    config.setShowChords(true);
	    appSession.getGlobalConfs().setDefaultBorder(new Integer (0));

	    List <AbstractSessionItem> sessionitems = createTestdata();

	    exporter.export(sessionitems, tmpFile, config);

	    List<Slide> lastSlides = exporter.getLastSlides().getSongSlides();
	    Slide versSlide = lastSlides.get(1);

	    LOG.info(versSlide.toString());

	    SlideItem alleItem = findItem(versSlide, "This is a song", 0);
	    Assert.assertEquals (SlideType.TEXT, alleItem.getItemType());
	    SlideItem firstChord = findItem(versSlide, "A", 0);
	    Assert.assertEquals (SlideType.CHORD, firstChord.getItemType());

	    Assert.assertTrue ("Text and chord overlap", firstChord.getYMax() < alleItem.getY());

	    SlideItem schoepfungItem = findItem(versSlide, "and it makes me amazing", 0);
	    SlideItem secondChord = findItem(versSlide, "D", 0);

	    Assert.assertEquals (alleItem.getXMax(), schoepfungItem.getX(), 0);

	    Assert.assertEquals (alleItem.getY(), schoepfungItem.getY(), 0);
	    Assert.assertEquals (firstChord.getY(), secondChord.getY(), 0);

	  }
	  
	  private List<AbstractSessionItem> createTestdata () {
		  List<AbstractSessionItem> items = new ArrayList<AbstractSessionItem>();
		  SongCreator creator = SongCreator.create().part(SongPartType.INTRO);
		  creator = creator.part(SongPartType.VERS).chordAndText("A", "This is a song").chordAndText("D", "and it makes me amazing"); 
		  Song song = creator.get();
		  items.add(song);
		  
		  return items;
	  }

	  @Test
	  public void checkExportWithoutChords () {
	    PdfExporter exporter = getExporter();

	    List <AbstractSessionItem> sessionitems = createTestdata();

	    DefaultPresenterConfig config = new DefaultPresenterConfig();
	    config.setShowChords(false);

	    exporter.export(sessionitems, tmpFile, config);

	    List<Slide> lastSlides = exporter.getLastSlides().getSongSlides();

	    Slide versSlide = lastSlides.get(1);

	    LOG.info(versSlide.toString());

	    SlideItem alleItem = findItem(versSlide, "This is a song", 0);
	    Assert.assertEquals (SlideType.TEXT, alleItem.getItemType());
	    SlideItem firstChord = findItem(versSlide, "A", 0);
	    SlideItem schoepfungItem = findItem(versSlide, "and it makes me amazing", 0);
	    SlideItem secondChord = findItem(versSlide, "D", 0);
	    Assert.assertNull (firstChord);
	    Assert.assertNull (secondChord);

	    Assert.assertEquals (alleItem.getXMax(), schoepfungItem.getX(), 0);
	    Assert.assertEquals (alleItem.getY(), schoepfungItem.getY(),0 );



	  }

}
