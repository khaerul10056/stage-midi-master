package org.mda.export;

import javax.inject.Inject;

import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;


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
