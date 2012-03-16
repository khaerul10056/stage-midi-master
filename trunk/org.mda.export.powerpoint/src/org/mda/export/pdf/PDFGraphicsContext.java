package org.mda.export.pdf;

import java.math.BigDecimal;
import org.eclipse.swt.graphics.Point;
import org.mda.commons.ui.IGraphicsContext;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
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
  public Point getSize (String text, final IMidiFileEditorUIConfig config) {
    BaseFont bf;
    int fontsize = config.getFontsize().intValue();
    try {
      bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);
      bf.setForceWidthsOutput(true);
    }
    catch (Exception e) {
      LOGGER.error(e.toString(), e);
      return new Point(0, 0);
    }
    float widthPoint = bf.getWidthPoint(text, fontsize);
    float heightPoint = bf.getAscentPoint(text,  fontsize);
    return new Point(getPixel(widthPoint), getPixel(heightPoint));
  }

  private int getPixel (final float point) {
    return new BigDecimal (point).multiply(new BigDecimal (2.54)).intValue();
  }

}
