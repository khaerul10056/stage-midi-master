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
  @Override
  public void setConfig (IPresenterConfig config) {
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
  private BigDecimal getZoomFactor (final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactor = new BigDecimal(preCondition.getCalculationsize().getWidth());
    BigDecimal zoomedFactor = zoomFactor.divide(new BigDecimal (getConfig().getDefaultPresentationScreenSize().getWidth()), 10, BigDecimal.ROUND_UP);
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
  protected LocationInfo calculateZoomedLocation (final LocationInfo origin, final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactor = getZoomFactor(preCondition);

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
  protected SizeInfo calculateZoomedSize (final SizeInfo origin, final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactor = getZoomFactor(preCondition);

    BigDecimal zoomedWidth = new BigDecimal (origin.getWidth()).multiply(zoomFactor);
    BigDecimal zoomedHeight = new BigDecimal (origin.getHeight()).multiply(zoomFactor);

    return new SizeInfo (zoomedWidth.intValue(), zoomedHeight.intValue());
  }

  /**
   * calculates a font relative to the originfont, meanwhile the zoom-factor is the
   * current editor-size / default-presentation-size
   * @param font
   * @param preCondition
   * @return
   */
  protected FontInfo calculateZoomedFont (final FontInfo font, final CalculatorPreCondition preCondition) {

    BigDecimal zoomFactor = getZoomFactor(preCondition);
    BigDecimal zoomedHeight = new BigDecimal (font.getFontsize()).multiply(zoomFactor);
    
    FontInfo newFont = new FontInfo (font);
    newFont.setFontsize(zoomedHeight.intValue());
    return newFont;
  }






}
