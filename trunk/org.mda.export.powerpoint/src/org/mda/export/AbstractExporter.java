package org.mda.export;

import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;


public abstract class AbstractExporter implements IExport {

  private MidiFileSlideCalculator calculator       = new MidiFileSlideCalculator();
  private CalculatorPreCondition  calcPreCondition = new CalculatorPreCondition();


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
