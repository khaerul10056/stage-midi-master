package org.mda.export.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import mda.MidiFile;
import org.eclipse.swt.graphics.Point;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.commons.ui.calculator.SlideType;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;


public class PdfExporter {

  private static final Log LOGGER  = LogFactory.getLogger(PdfExporter.class);

  private MidiFileSlideCalculator calculator       = new MidiFileSlideCalculator();
  private CalculatorPreCondition  calcPreCondition = new CalculatorPreCondition();

  public void export (final Collection<AbstractSessionItem> items, final File exportFile) throws IOException, DocumentException {
    if (! exportFile.getAbsoluteFile().getParentFile().exists())
      exportFile.getParentFile().mkdirs();


    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(true);
    config.setShowBlockType(true);
    config.setPagePerPart(false);
    config.setFontsize(new Integer (12));
    config.setGraphicsContext(new PDFGraphicsContext());
    calculator.setConfig(config);

    Rectangle pagesizeA4 = PageSize.A4;
    Document document = new Document(PageSize.A4);

    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(exportFile));
    document.open();
    float x = pagesizeA4.width();
    float y = pagesizeA4.height();
    LOGGER.info("set size to " + x + "(" + getPixel(x) + ") x" +  + y + "(" + getPixel(y) + ") ");
    calcPreCondition.setCalculationsize(new Point(getPixel(x), getPixel(y)));

    for (AbstractSessionItem next: items) {
      export(document, writer, (MidiFile) next);
    }

    document.close();
  }

  private float getCm (final int pixel) {
    BigDecimal ergebnis = new BigDecimal (pixel).multiply(new BigDecimal(2.54)).divide(new BigDecimal (72), BigDecimal.ROUND_DOWN);
    return ergebnis.floatValue();
  }

  private int getPixel (final float cm) {
    BigDecimal ergebnis = new BigDecimal (cm).multiply(new BigDecimal(72)).divide(new BigDecimal (2.54), BigDecimal.ROUND_DOWN);
    return ergebnis.intValue();
  }

  private void export (final Document doc, final PdfWriter writer, final MidiFile nextItem) throws DocumentException {

    doc.newPage();

    List<Slide> calculate = calculator.calculate(nextItem, calcPreCondition);

    for (Slide nextInternSlide : calculate) {
      exportSlide(doc, writer, nextInternSlide);
    }


  }

  private void exportSlide (final Document doc, final PdfWriter writer, Slide song) {

    for (SlideItem nextItem: song.getItems()) {

      boolean chord = nextItem.getItemType().equals(SlideType.CHORD);
      float cmX = getCm(nextItem.getX());
      float cmWidth = getCm(nextItem.getWidth());
      float cmY = doc.getPageSize().height() - getCm(nextItem.getY());
      LOGGER.info("Add text " + nextItem.getText() + " to X " + nextItem.getX() + "(" + cmX + ") " + ", Y " + nextItem.getY() + "(" + cmY + ")");
      absText(writer, nextItem.getText(), cmX, cmY, cmWidth, chord);
    }


  }

  private static void absText(final PdfWriter writer, String text, float x, float y, float width, final boolean chord) {
    try {
      PdfContentByte cb = writer.getDirectContent();
      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling
      BaseFont bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling

      int widthReal = bf.getWidth(text);
      LOGGER.info(widthReal + "<->" + width);
      cb.saveState();
      cb.beginText();
      cb.moveText(x, y);
      if (chord)
        cb.setFontAndSize(bfBold, 10);
      else
        cb.setFontAndSize(bf, 14);

      cb.showText(text);
      cb.endText();
      cb.restoreState();
    } catch (DocumentException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
