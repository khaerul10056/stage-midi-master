package org.mda.export;

import javax.inject.Inject;

import org.mda.presenter.CalculatorPreCondition;
import org.mda.presenter.MidiFileSlideCalculator;



public abstract class AbstractExporter implements IExport {

  @Inject
  MidiFileSlideCalculator calculator;
  
  @Inject
  CalculatorPreCondition  calcPreCondition;


  protected MidiFileSlideCalculator getCalculator () {
    return calculator;
  }

  protected CalculatorPreCondition getCalcPreCondition () {
    return calcPreCondition;
  }


}
