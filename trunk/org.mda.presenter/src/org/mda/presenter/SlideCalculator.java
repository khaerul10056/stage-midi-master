package org.mda.presenter;

import java.math.BigDecimal;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.adapter.FontInfo;
import org.mda.presenter.adapter.LocationInfo;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.IPresenterConfig;



public abstract class SlideCalculator implements ISlideCalculator {

  private static final Log LOGGER  = LogFactory.getLogger(SlideCalculator.class);

  private IPresenterConfig config;


  /**
   * set Configuration
   * @param config
   */
  protected void setConfig (IPresenterConfig config) {
    this.config = config;
  }

  public IPresenterConfig getConfig () {
    return config;
  }
  

  /**
   * getter
   * @param preCondition preCondition
   * @return zoomfactor derived
   */
  private BigDecimal getZoomFactor (final CalculationParam calcParam) {
    BigDecimal zoomFactor = new BigDecimal(calcParam.getPresentationSize().getWidth());
    BigDecimal zoomedFactor = zoomFactor.divide(new BigDecimal (calcParam.getPresentationSize().getWidth()), 10, BigDecimal.ROUND_UP);
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("set zoom factor " + zoomFactor.toString() + ", " + calcParam.getPresentationSize() + "-> " + zoomedFactor.toString());
    return zoomedFactor;
  }

  /**
   * calculates a point relative to the originpoint, meanwhile the zoom-factor is
   * the current editor-size / default-presentation-size
   * @param origin
   * @param calcParam
   * @return
   */
  protected LocationInfo calculateZoomedLocation (final LocationInfo origin, final CalculationParam calcParam) {
    BigDecimal zoomFactor = getZoomFactor(calcParam);

    BigDecimal zoomedWidth = new BigDecimal (origin.getX()).multiply(zoomFactor);
    BigDecimal zoomedHeight = new BigDecimal (origin.getY()).multiply(zoomFactor);

    return new LocationInfo (zoomedWidth.intValue(), zoomedHeight.intValue());
  }
  
  /**
   * calculates a point relative to the originpoint, meanwhile the zoom-factor is
   * the current editor-size / default-presentation-size
   * @param origin
   * @param preCondition
   * @return
   */
  protected SizeInfo calculateZoomedSize (final SizeInfo origin, final CalculationParam calcParam) {
    BigDecimal zoomFactor = getZoomFactor(calcParam);

    BigDecimal zoomedWidth = new BigDecimal (origin.getWidth()).multiply(zoomFactor);
    BigDecimal zoomedHeight = new BigDecimal (origin.getHeight()).multiply(zoomFactor);

    return new SizeInfo (zoomedWidth.intValue(), zoomedHeight.intValue());
  }

  /**
   * calculates a font relative to the originfont, meanwhile the zoom-factor is the
   * current editor-size / default-presentation-size
   * @param font
   * @param calcParam
   * @return
   */
  protected FontInfo calculateZoomedFont (final FontInfo font, final CalculationParam calcParam) {

    BigDecimal zoomFactor = getZoomFactor(calcParam);
    BigDecimal zoomedHeight = new BigDecimal (font.getFontsize()).multiply(zoomFactor);
    
    FontInfo newFont = new FontInfo (font);
    newFont.setFontsize(zoomedHeight.intValue());
    return newFont;
  }






}
