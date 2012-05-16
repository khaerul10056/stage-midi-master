package org.mda.commons.ui.calculator;

import java.util.ArrayList;
import java.util.List;
import mda.AbstractSessionItem;


public class CalculatorRegistry {

  private static final List <ISlideCalculator> slideCalculators = new ArrayList<ISlideCalculator>();

  static {
    slideCalculators.add(new MidiFileSlideCalculator());
  }


  public static ISlideCalculator getCalculator (final Class <? extends ISlideCalculator> classname) {
    for (ISlideCalculator next: slideCalculators) {
      if (next.getClass().equals(classname)) {
        return next;
      }
    }

    throw new RuntimeException("No slidecalculator found for classname " + classname.getName());

  }

  public static ISlideCalculator getCalculator (final AbstractSessionItem sessionitem) {
    for (ISlideCalculator next: slideCalculators) {
      if (next.isAssigned(sessionitem)) {
        return next;
      }
    }

    throw new RuntimeException("No slidecalculator found for sessionitem " + sessionitem);

  }

}
