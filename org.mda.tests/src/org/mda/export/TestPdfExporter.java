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

  private void checkConsistency (final Slide slide) {
    for (int line = 0; line < slide.getLineCount(); line ++) {
      int yOfLine = -1;
      int xOfLine = -1;
      Collection <SlideItem> itemsOfLine = slide.getItems(line);
      for (SlideItem next: itemsOfLine) {
        //Assert.assertTrue(next.getText() + "yOfLine = " + yOfLine + ", next.getY() = " + next.getY(), yOfLine == -1 || yOfLine == next.getY());
        //Assert.assertTrue (next.getText() + "next.getY = " + next.getY() + ", next.getYMax = " + next.getYMax(), next.getY() < next.getYMax());
        Assert.assertTrue (next.getText() + "next.getX() = " + next.getX() + ", next.getXMax() = " + next.getXMax(), next.getX() < next.getXMax());
        if (next.getX() > 0)
          Assert.assertTrue (next.getText() + "next.getX() = " + next.getX() + ", xOfLine = " + xOfLine, next.getX() >= xOfLine);
        yOfLine = next.getY();
        xOfLine = next.getXMax();
      }
    }
  }

  @BeforeClass
  public static void beforeClass () {
    appSession.load(null);
    appSession.getGlobalConfs().setShowGrid(true);
  }

  @Test
  public void checkExportWithChords () {
    PdfExporter exporter = new PdfExporter();

    ExportConfiguration config = MidiplayerFactory.eINSTANCE.createExportConfiguration();
    config.setWithChords(true);

    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
    sessionitems.add(appSession.getCurrentModel().getGallery().getGalleryItems().get(0));

    exporter.export(sessionitems, tmpFile, config);

    List<Slide> lastSlides = exporter.getLastSlides();
    for (Slide next: lastSlides) {
      LOG.info(next.toString());
      checkConsistency(next);
    }

    throw new IllegalStateException("Assertions fehlen noch");
  }

  @Test
  public void checkExportWithoutChords () {
    PdfExporter exporter = new PdfExporter();

    ExportConfiguration config = MidiplayerFactory.eINSTANCE.createExportConfiguration();
    config.setWithChords(true);

    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
    sessionitems.add(appSession.getCurrentModel().getGallery().getGalleryItems().get(0));

    exporter.export(sessionitems, tmpFile, config);

    List<Slide> lastSlides = exporter.getLastSlides();
    for (Slide next: lastSlides) {
      LOG.info(next.toString());
      checkConsistency(next);
    }

    throw new IllegalStateException("Assertions fehlen noch");
  }

}
