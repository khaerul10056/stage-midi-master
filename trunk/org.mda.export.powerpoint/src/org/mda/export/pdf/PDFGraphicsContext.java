package org.mda.export.pdf;

import org.eclipse.swt.graphics.Point;
import org.mda.commons.ui.IGraphicsContext;
import org.mda.commons.ui.calculator.FontDescriptor;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import com.lowagie.text.pdf.BaseFont;


public class PDFGraphicsContext implements IGraphicsContext {

  private static final Log LOGGER  = LogFactory.getLogger(PDFGraphicsContext.class);


  /**
   * gets width in pixel
   * @param text
   * @return
   */
  public Point getSize (String text, final FontDescriptor font) {
    BaseFont bf;
    int fontsize = font.getFontsizeAsInt();
    try {
      if (font.isBold())
        bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED);
      else
        bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);

    }
    catch (Exception e) {
      LOGGER.error(e.toString(), e);
      return new Point(0, 0);
    }
    float widthPoint = bf.getWidthPoint(text, fontsize);
    float heightPoint = bf.getAscentPoint(text,  fontsize);
//    LOGGER.info("Text <" + text + "> calculated with points: " + widthPoint + "-" + heightPoint);
//    LOGGER.info("Text <" + text + "> calculated with pixel : " + getPixel(widthPoint) + "-" + getPixel(heightPoint));
//    LOGGER.info("Text <" + text + "> calculated with cm    : " + getCm(widthPoint) + "-" + getCm(heightPoint));
    return new Point((int)widthPoint, (int)heightPoint);
  }





}
