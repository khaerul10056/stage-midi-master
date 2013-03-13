package org.mda.presenter;

import mda.AbstractSessionItem;

import org.mda.presenter.config.IPresenterConfig;


/**
 * defines the interface for a slide calculator
 * @author oleym
 *
 */
public interface ISlideCalculator {
  

  /**
   * calculates the slides for the current item
   * @param sessionitem item of the session, e.g. a song
   * @param config configuration
   * @return list of slides
   */
  SlideContainer calculate (final AbstractSessionItem sessionitem, final CalculationParam param, final IPresenterConfig config);

  /**
   * returns, if this calculator is assigned to the given item
   * @param item item
   * @return true/false
   *
   */
  boolean isAssigned (AbstractSessionItem item);
  

}
