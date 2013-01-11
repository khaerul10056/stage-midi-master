package org.mda.presenter;

import java.math.BigDecimal;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.adapter.Font;
import org.mda.presenter.adapter.Location;
import org.mda.presenter.adapter.Size;
import org.mda.presenter.config.DefaultMidiFilePresenterConfig;
import org.mda.presenter.config.IMidiFilePresenterConfig;



public abstract class SlideCalculator implements ISlideCalculator {

  private static final Log LOGGER  = LogFactory.getLogger(SlideCalculator.class);

  private IMidiFilePresenterConfig config;


  /**
   * set Configuration
   * @param config
   */
  @Override
  public void setConfig (IMidiFilePresenterConfig config) {
    this.config = config;
  }

  public IMidiFilePresenterConfig getConfig () {
    if (config == null)
      return new DefaultMidiFilePresenterConfig();
    else
      return config;
  }

  /**
   * resets the size to both equal zoomfactors horizontally and vertically
   * @param preCondition
   * @return
   */
  protected void normalizeSizeToPresentationSize (final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactorHorizontal = new BigDecimal(preCondition.getCalculationsize().getWidth());
    zoomFactorHorizontal = zoomFactorHorizontal.divide(new BigDecimal (getConfig().getDefaultPresentationScreenSize().getWidth()), 10, BigDecimal.ROUND_UP);

    BigDecimal zoomFactorVertical = new BigDecimal(preCondition.getCalculationsize().getHeight());
    zoomFactorVertical = zoomFactorVertical.divide(new BigDecimal (getConfig().getDefaultPresentationScreenSize().getWidth()), 10, BigDecimal.ROUND_UP);

    BigDecimal min = zoomFactorHorizontal.min(zoomFactorVertical);

    BigDecimal zoomedWidth = new BigDecimal (getConfig().getDefaultPresentationScreenSize().getWidth()).multiply(min);
    BigDecimal zoomedHeight = new BigDecimal (getConfig().getDefaultPresentationScreenSize().getHeight()).multiply(min);

    preCondition.setCalculationsize(new Size (zoomedWidth.intValue(), zoomedHeight.intValue()));
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
  protected Location calculateZoomedLocation (final Location origin, final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactor = getZoomFactor(preCondition);

    BigDecimal zoomedWidth = new BigDecimal (origin.getX()).multiply(zoomFactor);
    BigDecimal zoomedHeight = new BigDecimal (origin.getY()).multiply(zoomFactor);

    return new Location (zoomedWidth.intValue(), zoomedHeight.intValue());
  }
  
  /**
   * calculates a point relative to the originpoint, meanwhile the zoom-factor is
   * the current editor-size / default-presentation-size
   * @param origin
   * @param preCondition
   * @return
   */
  protected Size calculateZoomedSize (final Size origin, final CalculatorPreCondition preCondition) {
    BigDecimal zoomFactor = getZoomFactor(preCondition);

    BigDecimal zoomedWidth = new BigDecimal (origin.getWidth()).multiply(zoomFactor);
    BigDecimal zoomedHeight = new BigDecimal (origin.getHeight()).multiply(zoomFactor);

    return new Size (zoomedWidth.intValue(), zoomedHeight.intValue());
  }

  /**
   * calculates a font relative to the originfont, meanwhile the zoom-factor is the
   * current editor-size / default-presentation-size
   * @param font
   * @param preCondition
   * @return
   */
  protected Font calculateZoomedFont (final Font font, final CalculatorPreCondition preCondition) {

    BigDecimal zoomFactor = getZoomFactor(preCondition);
    BigDecimal zoomedHeight = new BigDecimal (font.getFontsize()).multiply(zoomFactor);
    
    Font newFont = new Font (font);
    newFont.setFontsize(zoomedHeight.intValue());
    return newFont;
  }






}
