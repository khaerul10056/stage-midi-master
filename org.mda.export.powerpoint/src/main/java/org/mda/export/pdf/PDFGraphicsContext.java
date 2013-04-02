package org.mda.export.pdf;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.measurement.FontInfo;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.adapter.IGraphicsContext;

import com.lowagie.text.pdf.BaseFont;


public class PDFGraphicsContext implements IGraphicsContext {

  private static final Log LOGGER  = LogFactory.getLogger(PDFGraphicsContext.class);


  /**
   * gets width in pixel
   * @param text
   * @return
   */
  @Override
public SizeInfo getSize (String text, final FontInfo font) {
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
      return new SizeInfo(0, 0);
    }
    float widthPoint = bf.getWidthPoint(text, fontsize);
    float heightPoint = bf.getAscentPoint(text,  fontsize);
//    LOGGER.info("Text <" + text + "> calculated with points: " + widthPoint + "-" + heightPoint);
//    LOGGER.info("Text <" + text + "> calculated with pixel : " + getPixel(widthPoint) + "-" + getPixel(heightPoint));
//    LOGGER.info("Text <" + text + "> calculated with cm    : " + getCm(widthPoint) + "-" + getCm(heightPoint));
    return new SizeInfo((int)widthPoint, (int)heightPoint);
  }





}
