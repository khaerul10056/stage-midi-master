package org.mda.presenter.ui;

import static org.mda.commons.ui.calculator.CalculatorRegistry.getCalculator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;
import mda.AbstractSessionItem;
import mda.Session;
import org.eclipse.swt.graphics.Point;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.ISlideCalculator;
import org.mda.commons.ui.calculator.Slide;


public class PresentationContext {

  private static final Logger LOGGER  = Logger.getLogger(PresentationContext.class.getName());


  private Session currentSession;

  private LinkedHashMap<AbstractSessionItem, List <Slide>> slidesPerItem;

  private int currentSessionItemIndex = 0;
  private int currentSlideIndex = 0;

  private CalculatorPreCondition calcPreCondition;
  private IMidiFileEditorUIConfig config;


  private final Collection <IPresentationController> registeredControllers = new ArrayList<IPresentationController>();

  public Session getCurrentSession () {
    return currentSession;
  }

  public void setCurrentSession (Session currentSession, final IMidiFileEditorUIConfig config, Point size) {
    this.currentSession = currentSession;
    this.config = config;
    calcPreCondition = new CalculatorPreCondition();
    calcPreCondition.setCalculationsize(size);
    slidesPerItem = calculateSlides (currentSession);
  }

  public void closeSession () {
    this.currentSession = null;
    this.config = null;
    calcPreCondition = null;
    slidesPerItem = null;
  }

  public Collection <IPresentationController> getRegisteredControllers () {
    return registeredControllers;
  }

  public AbstractSessionItem getCurrentSessionItem () {
    return slidesPerItem.keySet().toArray(new AbstractSessionItem [slidesPerItem.keySet().size()]) [currentSessionItemIndex];
  }

  public Slide getCurrentSlide () {
    return slidesPerItem.get(getCurrentSessionItem()).get(currentSlideIndex);
  }

  private LinkedHashMap<AbstractSessionItem, List<Slide>> calculateSlides (Session session) {
    LinkedHashMap<AbstractSessionItem, List<Slide>> slidesPerItem = new LinkedHashMap<AbstractSessionItem, List<Slide>>();

    for (AbstractSessionItem nextItem: session.getItems()) {
      ISlideCalculator calculator = getCalculator(nextItem);
      calculator.setConfig(config);
      List<Slide> calculate = calculator.calculate(nextItem, calcPreCondition);
      slidesPerItem.put(nextItem, calculate);
    }

    return slidesPerItem;
  }




  public boolean nextSlide () {
    AbstractSessionItem currentSessionItem = getCurrentSessionItem();
    if (currentSlideIndex >= slidesPerItem.get(currentSessionItem).size() - 1) { // last slide of current item reached
      if (currentSessionItemIndex >= slidesPerItem.keySet().toArray().length - 1) { // last slide ever reached
        return false;
      }
      else {
        currentSessionItemIndex ++;
        currentSlideIndex = 0;
      }
    }
    else
      currentSlideIndex ++;

    LOGGER.info("Next to " + currentSessionItemIndex + ", " + currentSlideIndex);
    return true;
  }

  public boolean previousSlide () {
    if (currentSlideIndex == 0) { // first slide of current item reached
      if (currentSessionItemIndex == 0) { // first slide ever reached
        return false;
      }
      else {
        currentSessionItemIndex --;
        currentSlideIndex = slidesPerItem.get(getCurrentSessionItem()).size() - 1;
      }
    }
    else
      currentSlideIndex --;

    LOGGER.info("Previous to " + currentSessionItemIndex + ", " + currentSlideIndex);

    return true;
  }

  public boolean toItem (AbstractSessionItem item) {
    AbstractSessionItem[] array = slidesPerItem.keySet().toArray(new AbstractSessionItem [slidesPerItem.size()]);
    for (int i = 0; i < array.length; i++) {
      if (array [i].equals(item)) {
        currentSessionItemIndex = i;
        currentSlideIndex = 0;
        LOGGER.info("To item " + currentSessionItemIndex + ", " + currentSlideIndex);
        return true;
      }
    }
    LOGGER.info("To item (not found)");
    return false;
  }

}
