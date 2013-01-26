package org.mda.export;

import javax.inject.Inject;

import org.mda.presenter.CalculatorPreCondition;
import org.mda.presenter.SongSlideCalculator;



public abstract class AbstractExporter implements IExport {

  @Inject
  SongSlideCalculator calculator;
  
  @Inject
  CalculatorPreCondition  calcPreCondition;


  protected SongSlideCalculator getCalculator () {
    return calculator;
  }

  protected CalculatorPreCondition getCalcPreCondition () {
    return calcPreCondition;
  }


}
