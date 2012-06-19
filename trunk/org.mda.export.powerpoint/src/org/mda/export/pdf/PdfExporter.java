package org.mda.export.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import mda.ExportConfiguration;
import mda.MidiFile;
import org.eclipse.swt.graphics.Point;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.FontDescriptor;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.commons.ui.calculator.SlideType;
import org.mda.export.AbstractExporter;
import org.mda.export.ExportException;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;


public class PdfExporter extends AbstractExporter {

  private static final Log LOGGER  = LogFactory.getLogger(PdfExporter.class);

  private MidiFileSlideCalculator calculator       = new MidiFileSlideCalculator();
  private CalculatorPreCondition  calcPreCondition = new CalculatorPreCondition();

  private ApplicationSession applicationsession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  private List <Slide> lastSlides = new ArrayList<Slide>();

  public File export (final Collection<AbstractSessionItem> items, final File exportFile, final ExportConfiguration exportconfig) throws ExportException  {
    if (! exportFile.getAbsoluteFile().getParentFile().exists())
      exportFile.getParentFile().mkdirs();

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(exportconfig.isWithChords());
    config.setShowBlockType(true);
    config.setPagePerPart(false);
    config.setNewPageRespected(false);
    config.setShowTitle(true);
    config.setFontsize(new Integer (12));
    config.setGraphicsContext(new PDFGraphicsContext());
    config.setOptimizeLineFilling(true);
    config.setOptimizeEqualParts(true);
    config.setOptimizeEmptyTokens(true);
    config.setShowCopyright(true);
    config.setBorder(30);
    calculator.setConfig(config);

    Rectangle pagesizeA4 = PageSize.A4;
    Document document = new Document(PageSize.A4);

    PdfWriter writer;
    try {
      writer = PdfWriter.getInstance(document, new FileOutputStream(exportFile));

    document.open();
    float x = pagesizeA4.width();
    float y = pagesizeA4.height();
    LOGGER.info("set size to " + x +","+ y + ")");
    calcPreCondition.setCalculationsize(new Point ((int)x, (int)y)); //new Point(getPixel(x), getPixel(y)));

    for (AbstractSessionItem next: items) {
      export(document, writer, (MidiFile) next);
    }

    document.close();

    }
    catch (FileNotFoundException e) {
      throw new ExportException("Erroring creating document " + exportFile.getAbsolutePath(), e);
    }
    catch (DocumentException e) {
      throw new ExportException("Erroring creating document " + exportFile.getAbsolutePath(), e);
    }
    return exportFile;
  }



  private void export (final Document doc, final PdfWriter writer, final MidiFile nextItem) throws ExportException {

    try {
      doc.newPage();
    }
    catch (DocumentException e) {
      throw new ExportException("Error createing new page in document " + doc.toString(), e);
    }

    setLastSlides(calculator.calculate(nextItem, calcPreCondition));

    for (Slide nextInternSlide : getLastSlides()) {
      exportSlide(doc, writer, nextInternSlide);
    }


  }

  private void exportSlide (final Document doc, final PdfWriter writer, Slide song) {

    if (LOGGER.isDebugEnabled())
      LOGGER.debug("In PdfExporter: \n" + song.toString());

    for (SlideItem nextItem: song.getItems()) {
      float y = doc.getPageSize().height() - nextItem.getY();

      if (LOGGER.isDebugEnabled())
        LOGGER.debug("Add text <" + nextItem.getText() + "> to X " + nextItem.getX() + ", Y " + nextItem.getY());

      absText(writer, nextItem.getText(), nextItem.getX(), y, nextItem.getWidth(), nextItem.getItemType(), nextItem.getFont());
    }

    if (applicationsession != null && applicationsession.getGlobalConfs().isShowGrid())
      showGrid (writer, song.getSize());


  }

  private void showGrid (PdfWriter writer, Point size) {
    PdfContentByte cb = writer.getDirectContent();
    cb.saveState();
    for (int i = 0; i < size.x; i += 100) {
      cb.moveTo(i,  0);
      cb.lineTo(i, size.y);
    }

    for (int i = 0; i < size.y; i += 100) {
      cb.moveTo (0, i);
      cb.lineTo(size.x, i);
    }

    cb.stroke();
    cb.restoreState();

  }

  private static void absText(final PdfWriter writer, String text, float x, float y, float width, final SlideType slideType, FontDescriptor fontDescriptor) {
    try {
      PdfContentByte cb = writer.getDirectContent();
      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling
      BaseFont bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling
      BaseFont bfOblique = BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling

      cb.saveState();
      cb.beginText();
      cb.moveText(x, y);
      if (slideType.equals(SlideType.CHORD)) //TODO: with fondescriptor
        cb.setFontAndSize(bfBold, 10);
      else if (slideType.equals(SlideType.COPYRIGHT))
        cb.setFontAndSize(bfOblique, 8);
      else {
        if (fontDescriptor.isBold())
          cb.setFontAndSize(bfBold, 14);
        else
          cb.setFontAndSize(bf, 14);
      }

      cb.showText(text);

      cb.endText();

      cb.restoreState();
    } catch (DocumentException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getSuffix () {
    return ".pdf";
  }



  public List <Slide> getLastSlides () {
    return lastSlides;
  }



  private void setLastSlides (List <Slide> lastSlides) {
    this.lastSlides = lastSlides;
  }




}
