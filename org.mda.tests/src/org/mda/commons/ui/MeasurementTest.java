package org.mda.commons.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import org.mda.export.pdf.PDFGraphicsContext;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;


public class MeasurementTest {


  private static BigDecimal cmToPixel (final BigDecimal mm) {
    return mm.multiply(new BigDecimal (2.8352707));
  }

  private static BigDecimal pixelToCm (final BigDecimal pixel) {
    return pixel.divide(new BigDecimal (2.8352707), BigDecimal.ROUND_HALF_UP);
  }

  public static void main (final String [] args) throws Exception{
    Rectangle pagesizeA4 = PageSize.A4;
    Document document = new Document(PageSize.A4);

    PdfWriter writer;
    writer = PdfWriter.getInstance(document, new FileOutputStream(new File ("/tmp/testMeasurement.pdf")));
    document.open();

    PdfContentByte cb = writer.getDirectContent();
    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling
    BaseFont bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling
    BaseFont bfOblique = BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE, BaseFont.CP1252, BaseFont.EMBEDDED); //centralize fonthandling

    cb.saveState();

    cb.beginText();

    cb.moveText(50, 50);
    PDFGraphicsContext pdf = new PDFGraphicsContext();
    final String TEST = "DIes ist ein Test";
    int y = 20;
    for (int i = 12; i < 30; i+=2) {
      float widthPoint = bf.getWidthPoint(TEST, i);
      cb.moveText(0, i);
      cb.setFontAndSize(bf, i);
      cb.showText(TEST);
      System.out.println ("mit " + i + ": " + widthPoint + ", cm: " + pixelToCm(new BigDecimal (widthPoint)));
    }
    cb.endText();

    cb.setLineWidth(0f);
    for (int i = 0; i < 1000; i+=100) {
      System.out.println (i + " mm      = " + cmToPixel(new BigDecimal (i)).setScale(3, BigDecimal.ROUND_DOWN).toString());

    }

    System.out.println ("Width Pixel: " + cmToPixel(new BigDecimal ("210")));
    System.out.println ("Height Pixel: " + cmToPixel(new BigDecimal ("297")));

    System.out.println ("Border: " + document.getPageSize().border());
    System.out.println ("Height:" + document.getPageSize().height());
    System.out.println ("Width :" + document.getPageSize().width());

    float out = 0f;
    float in = 283.5271f;
    //10cm
    cb.moveTo(out, out);
    cb.lineTo(in, out);
    cb.lineTo(in, in);
    cb.lineTo(out, in);
    cb.lineTo(out, out);
    cb.stroke();
    cb.restoreState();

    document.close();



  }

}
