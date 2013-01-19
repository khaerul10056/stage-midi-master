package org.mda.presenter;

import org.mda.presenter.adapter.SizeInfo;



public class CalculatorPreCondition {

  /**
   * size of to content panel which should be calculated
   * the zoom-factor is derived from this and from the target-screen-size
   */
  private SizeInfo calculationsize;

  public void setCalculationsize (SizeInfo calculationsize) {
    this.calculationsize = calculationsize;
  }

  public SizeInfo getCalculationsize () {
    return calculationsize;
  }




}
