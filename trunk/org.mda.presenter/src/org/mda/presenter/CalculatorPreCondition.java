package org.mda.presenter;

import org.mda.presenter.adapter.Size;



public class CalculatorPreCondition {

  /**
   * size of to content panel which should be calculated
   * the zoom-factor is derived from this and from the target-screen-size
   */
  private Size calculationsize;

  public void setCalculationsize (Size calculationsize) {
    this.calculationsize = calculationsize;
  }

  public Size getCalculationsize () {
    return calculationsize;
  }




}
