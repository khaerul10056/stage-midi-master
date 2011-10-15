package org.mda.commons.ui.calculator;

import java.util.List;
import mda.AbstractSessionItem;
import org.mda.commons.ui.IMidiFileEditorUIConfig;


public interface ISlideCalculator {

  /**
   * calculates the slides for the current item
   * @param sessionitem item of the session, e.g. a song
   * @param precondition like editor-panel-size
   * @return list of slides
   */
  public List <Slide> calculate (final AbstractSessionItem sessionitem, CalculatorPreCondition preCondition);

  /**
   * returns, if this calculator is assigned to the given item
   * @param item item
   * @return true/false
   *
   */
  public boolean isAssigned (AbstractSessionItem item);

  /**
   * set Configuration
   * @param config
   */
  public void setConfig (IMidiFileEditorUIConfig config);

}
