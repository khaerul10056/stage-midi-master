package org.mda.export;

import javax.inject.Inject;

import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;


public abstract class AbstractExporter implements IExport {

  @Inject
  private MidiFileSlideCalculator calculator;
  
  @Inject
  private CalculatorPreCondition  calcPreCondition;


  protected MidiFileSlideCalculator getCalculator () {
    return calculator;
  }

  protected void setCalculator (MidiFileSlideCalculator calculator) {
    this.calculator = calculator;
  }

  protected CalculatorPreCondition getCalcPreCondition () {
    return calcPreCondition;
  }

  protected void setCalcPreCondition (CalculatorPreCondition calcPreCondition) {
    this.calcPreCondition = calcPreCondition;
  }

}
