package org.mda.export.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;

import mda.AbstractSessionItem;
import mda.Song;

import org.mda.ApplicationSession;
import org.mda.export.AbstractExporter;
import org.mda.export.ExportException;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.measurement.FontInfo;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.CalculationParam;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideContainer;
import org.mda.presenter.SlideItem;
import org.mda.presenter.SlideType;
import org.mda.presenter.SongSlideCalculator;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.IPresenterConfig;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;



public class PdfExporter extends AbstractExporter {

  private static final Log LOGGER  = LogFactory.getLogger(PdfExporter.class);

  @Inject
  private SongSlideCalculator calculator;
  
  
  @Inject
  private ApplicationSession applicationsession;
  
  private SlideContainer lastSlides;

  @Override
public File export (final Collection<AbstractSessionItem> items, final File exportFile, final IPresenterConfig config) throws ExportException  {
    if (! exportFile.getAbsoluteFile().getParentFile().exists())
      exportFile.getParentFile().mkdirs();
    
    DefaultPresenterConfig configImpl = (DefaultPresenterConfig) config;
    configImpl.setFontsize(new Integer (12));
    configImpl.setGraphicsContext(new PDFGraphicsContext());
    
    Rectangle pagesizeA4 = PageSize.A4;
    Document document = new Document(PageSize.A4);

    PdfWriter writer;
    try {
      writer = PdfWriter.getInstance(document, new FileOutputStream(exportFile));

    document.open();
    float x = pagesizeA4.width();
    float y = pagesizeA4.height();
    LOGGER.info("set size to " + x +","+ y + ")");
    SizeInfo calcSize = new SizeInfo((int)x, (int)y);
    CalculationParam param = new CalculationParam(calcSize); 

    for (AbstractSessionItem next: items) {
      export(document, writer, (Song) next, param, configImpl);
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



  private void export (final Document doc, final PdfWriter writer, final Song nextItem, CalculationParam calcParam, final IPresenterConfig config) throws ExportException {



    setLastSlides(calculator.calculate(nextItem, calcParam, config));

    for (Slide nextInternSlide : getLastSlides().getSongSlides()) {

      if (nextInternSlide.isForceNewPage())  {
      try {
        doc.newPage();
      }
      catch (DocumentException e) {
        throw new ExportException("Error createing new page in document " + doc.toString(), e);
      }
      }
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

  private void showGrid (PdfWriter writer, SizeInfo size) {
    PdfContentByte cb = writer.getDirectContent();
    cb.saveState();
    for (int i = 0; i < size.getWidth(); i += 100) {
      cb.moveTo(i,  0);
      cb.lineTo(i, size.getHeight());
    }

    for (int i = 0; i < size.getHeight(); i += 100) {
      cb.moveTo (0, i);
      cb.lineTo(size.getWidth(), i);
    }

    cb.stroke();
    cb.restoreState();

  }

  private static void absText(final PdfWriter writer, String text, float x, float y, float width, final SlideType slideType, FontInfo fontDescriptor) {
    try {
      PdfContentByte cb = writer.getDirectContent();
      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling
      BaseFont bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling
      BaseFont bfOblique = BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling

      cb.saveState();
      cb.beginText();
      cb.moveText(x, y);
      if (slideType.equals(SlideType.TITLE))
        //cb.setFontAndSize(bfBold, 18);
        cb.setFontAndSize(bfBold, 12);
      else if (slideType.equals(SlideType.CHORD)) //TODO: with fondescriptor
        cb.setFontAndSize(bfBold, 10);
      else if (slideType.equals(SlideType.COPYRIGHT))
        cb.setFontAndSize(bfOblique, 8);
      else {
        if (fontDescriptor.isBold())
          cb.setFontAndSize(bfBold, 12);
        else
          cb.setFontAndSize(bf, 12);
      }

      cb.showText(text);
      cb.endText();

//      cb.setLineWidth(0f);
//
//      cb.moveTo(x, y);
//      cb.lineTo(x+width, y);
//      cb.lineTo(x+width, y+ fontDescriptor.getFontsize());
//      cb.lineTo(x+width, y);
//      cb.lineTo(x, y);
//      cb.stroke();





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



  public SlideContainer getLastSlides () {
    return lastSlides;
  }



  private void setLastSlides (SlideContainer lastSlides) {
    this.lastSlides = lastSlides;
  }




}
