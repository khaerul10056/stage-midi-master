package org.mda.commons.ui.calculator;

import java.math.BigDecimal;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;



public abstract class SlideCalculator implements ISlideCalculator {

  private static final Log LOGGER  = LogFactory.getLogger(SlideCalculator.class);

  private IMidiFileEditorUIConfig config;


  /**
   * set Configuration
   * @param config
   */
  public void setConfig (IMidiFileEditorUIConfig config) {
    this.config = config;
  }

  public IMidiFileEditorUIConfig getConfig () {
    if (config == null)
      return new DefaultMidiFileContentEditorConfig();
    else
      return config;
  }

  /**
   * resets the size to both equal zoomfactors horizontally and vertically
   * @param preCondition
   * @return
   */
  protected void normalizeSizeToPresentationSize (final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactorHorizontal = new BigDecimal(preCondition.getCalculationsize().x);
    zoomFactorHorizontal = zoomFactorHorizontal.divide(new BigDecimal (getConfig().getDefaultPresentationScreenSize().x), 10, BigDecimal.ROUND_UP);

    BigDecimal zoomFactorVertical = new BigDecimal(preCondition.getCalculationsize().y);
    zoomFactorVertical = zoomFactorVertical.divide(new BigDecimal (getConfig().getDefaultPresentationScreenSize().y), 10, BigDecimal.ROUND_UP);

    BigDecimal min = zoomFactorHorizontal.min(zoomFactorVertical);

    BigDecimal zoomedWidth = new BigDecimal (getConfig().getDefaultPresentationScreenSize().x).multiply(min);
    BigDecimal zoomedHeight = new BigDecimal (getConfig().getDefaultPresentationScreenSize().y).multiply(min);

    preCondition.setCalculationsize(new Point (zoomedWidth.intValue(), zoomedHeight.intValue()));
  }

  /**
   * getter
   * @param preCondition preCondition
   * @return zoomfactor derived
   */
  private BigDecimal getZoomFactor (final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactor = new BigDecimal(preCondition.getCalculationsize().x);
    BigDecimal zoomedFactor = zoomFactor.divide(new BigDecimal (getConfig().getDefaultPresentationScreenSize().x), 10, BigDecimal.ROUND_UP);
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("set zoom factor " + zoomFactor.toString() + ", " + getConfig().getDefaultPresentationScreenSize() + "-> " + zoomedFactor.toString());
    return zoomedFactor;
  }

  /**
   * calculates a point relative to the originpoint, meanwhile the zoom-factor is
   * the current editor-size / default-presentation-size
   * @param origin
   * @param preCondition
   * @return
   */
  protected Point calculateZoomedPoint (final Point origin, final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactor = getZoomFactor(preCondition);

    BigDecimal zoomedWidth = new BigDecimal (origin.x).multiply(zoomFactor);
    BigDecimal zoomedHeight = new BigDecimal (origin.y).multiply(zoomFactor);

    return new Point (zoomedWidth.intValue(), zoomedHeight.intValue());
  }

  /**
   * calculates a font relative to the originfont, meanwhile the zoom-factor is the
   * current editor-size / default-presentation-size
   * @param font
   * @param preCondition
   * @return
   */
  protected Font calculateZoomedFont (final Font font, final CalculatorPreCondition preCondition) {

    FontData nextData = font.getFontData() [0];
    int height = nextData.getHeight();
    BigDecimal zoomFactor = getZoomFactor(preCondition);
    BigDecimal zoomedHeight = new BigDecimal (height).multiply(zoomFactor);
    nextData.setHeight(zoomedHeight.intValue());

    return new Font(font.getDevice(), nextData);

  }






}
