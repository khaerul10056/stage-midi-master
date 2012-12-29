package org.mda.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import mda.AbstractSessionItem;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.commons.ui.calculator.SlideType;
import org.mda.export.pdf.PdfExporter;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class TestPdfExporter {

  private final static Log LOG = LogFactory.getLogger(TestPdfExporter.class);

  private File tmpFile = new File ("tmp/export.pdf");

  private static ApplicationSession appSession;

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

  @BeforeClass
  public static void beforeClass () {
	InjectServiceMock.initialize();
	appSession = InjectService.getInstance(ApplicationSession.class);
    appSession.load(null);
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

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setShowChords(true);
    appSession.getGlobalConfs().setDefaultBorder(new Integer (0));

    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
    sessionitems.add(appSession.getCurrentModel().getGallery().getGalleryItems().get(0));

    exporter.export(sessionitems, tmpFile, config);

    List<Slide> lastSlides = exporter.getLastSlides();
    Slide versSlide = lastSlides.get(1);

    LOG.info(versSlide.toString());

    SlideItem alleItem = findItem(versSlide, "Alle", 0);
    Assert.assertEquals (SlideType.TEXT, alleItem.getItemType());
    SlideItem firstChord = findItem(versSlide, "D", 0);
    Assert.assertEquals (SlideType.CHORD, firstChord.getItemType());

    Assert.assertTrue ("Text and chord overlap", firstChord.getYMax() < alleItem.getY());

    SlideItem schoepfungItem = findItem(versSlide, "Schöpfung staunt und", 0);
    SlideItem secondChord = findItem(versSlide, "D", 0);

    Assert.assertEquals (alleItem.getXMax(), schoepfungItem.getX());

    Assert.assertEquals (alleItem.getY(), schoepfungItem.getY());
    Assert.assertEquals (firstChord.getY(), secondChord.getY());

  }

  @Test
  public void checkExportWithoutChords () {
    PdfExporter exporter = getExporter();

    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
    sessionitems.add(appSession.getCurrentModel().getGallery().getGalleryItems().get(0));

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setShowChords(false);

    exporter.export(sessionitems, tmpFile, config);

    List<Slide> lastSlides = exporter.getLastSlides();

    Slide versSlide = lastSlides.get(1);

    LOG.info(versSlide.toString());

    SlideItem alleItem = findItem(versSlide, "Alle", 0);
    Assert.assertEquals (SlideType.TEXT, alleItem.getItemType());
    SlideItem firstChord = findItem(versSlide, "D", 0);
    SlideItem schoepfungItem = findItem(versSlide, "Schöpfung staunt und", 0);
    SlideItem secondChord = findItem(versSlide, "D", 0);
    Assert.assertNull (firstChord);
    Assert.assertNull (secondChord);

    Assert.assertEquals (alleItem.getXMax(), schoepfungItem.getX());
    Assert.assertEquals (alleItem.getY(), schoepfungItem.getY());



  }

}
