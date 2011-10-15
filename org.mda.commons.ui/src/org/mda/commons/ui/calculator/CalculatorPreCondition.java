package org.mda.commons.ui.calculator;

import org.eclipse.swt.graphics.Point;


public class CalculatorPreCondition {

  /**
   * size of to content panel which should be calculated
   * the zoom-factor is derived from this and from the target-screen-size
   */
  private Point calculationsize;

  public void setCalculationsize (Point calculationsize) {
    this.calculationsize = calculationsize;
  }

  public Point getCalculationsize () {
    return calculationsize;
  }




}
