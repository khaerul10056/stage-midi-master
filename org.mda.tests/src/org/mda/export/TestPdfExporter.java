package org.mda.export;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import mda.ExportConfiguration;
import mda.MidiplayerFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.export.pdf.PdfExporter;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class TestPdfExporter {

  private final static Log LOG = LogFactory.getLogger(TestPdfExporter.class);

  private File tmpFile = new File ("tmp/export.pdf");

  private static ApplicationSession appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  private final int X_ITEM1 = 130;
  private final int X_ITEM2 = 157;
  private final int X_ITEM3 = 299;
  private final int X_ITEM4 = 364;
  private final int X_ITEM5 = 434;


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
    appSession.load(null);
    appSession.getGlobalConfs().setShowGrid(true);
    appSession.getGlobalConfs().setDefaultBorder(0);
  }

  private void assertText (final Slide slide, final String text, final int x, final int y) {
    Collection<SlideItem> findItem = slide.findItem(text);
    for (SlideItem next: findItem) {
      if (next.getX() == x && next.getY() == y)
        return;
    }

    Assert.fail ("Position " + x + "," + y + " of text <" + text + "> not found");
  }
  @Test
  public void checkExportWithChords () {
    PdfExporter exporter = new PdfExporter();

    ExportConfiguration config = MidiplayerFactory.eINSTANCE.createExportConfiguration();
    config.setWithChords(true);
    appSession.getGlobalConfs().setDefaultBorder(new Integer (0));

    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
    sessionitems.add(appSession.getCurrentModel().getGallery().getGalleryItems().get(0));

    exporter.export(sessionitems, tmpFile, config);

    List<Slide> lastSlides = exporter.getLastSlides();
    Slide versSlide = lastSlides.get(1);

    final int FIRSTLINE_CHORD = 74;
    final int FIRSTLINE_TEXT = 86;
    LOG.info(versSlide.toString());



    assertText(versSlide, "Alle", X_ITEM1, FIRSTLINE_TEXT);
    assertText(versSlide, "D", X_ITEM1, FIRSTLINE_CHORD);
    assertText(versSlide, "Schöpfung staunt und", X_ITEM2, FIRSTLINE_TEXT);
    assertText(versSlide, "G", X_ITEM2, FIRSTLINE_CHORD);
    assertText(versSlide, "preist, und", X_ITEM3, FIRSTLINE_TEXT);
    assertText(versSlide, "A", X_ITEM3, FIRSTLINE_CHORD);
    assertText(versSlide, "betet an in", X_ITEM4, FIRSTLINE_TEXT);
    assertText(versSlide, "D", X_ITEM4, FIRSTLINE_CHORD);
    assertText(versSlide, "Wahrheit und in", X_ITEM5, FIRSTLINE_TEXT);
  }

  @Test
  public void checkExportWithoutChords () {
    PdfExporter exporter = new PdfExporter();

    ExportConfiguration config = MidiplayerFactory.eINSTANCE.createExportConfiguration();
    config.setWithChords(false);

    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
    sessionitems.add(appSession.getCurrentModel().getGallery().getGalleryItems().get(0));

    exporter.export(sessionitems, tmpFile, config);

    List<Slide> lastSlides = exporter.getLastSlides();

    Slide versSlide = lastSlides.get(1);

    final int FIRSTLINE_TEXT = 66;
    LOG.info(versSlide.toString());

    assertText(versSlide, "Alle", X_ITEM1, FIRSTLINE_TEXT);
    assertText(versSlide, "Schöpfung staunt und", X_ITEM2, FIRSTLINE_TEXT);
    assertText(versSlide, "preist, und", X_ITEM3, FIRSTLINE_TEXT);
    assertText(versSlide, "betet an in", X_ITEM4, FIRSTLINE_TEXT);
    assertText(versSlide, "Wahrheit und in", X_ITEM5, FIRSTLINE_TEXT);

  }

}
