package org.mda.presenter.ui;

import static org.mda.commons.ui.calculator.CalculatorRegistry.getCalculator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import mda.AbstractSessionItem;
import mda.Session;
import org.eclipse.swt.graphics.Point;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.ISlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.imagecache.ImageCache;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.NavigationRefreshAction;


public class PresentationContext {

  private static final Log LOGGER  = LogFactory.getLogger(PresentationContext.class);

  private ImageCache  imagecache = new ImageCache ();

  private Session currentSession;

  private LinkedHashMap<AbstractSessionItem, List <Slide>> slidesPerItem;

  private int currentSessionItemIndex = 0;
  private int currentSlideIndex = 0;

  private CalculatorPreCondition calcPreCondition;
  private IMidiFileEditorUIConfig config;

  private SpecialSlide specialSlide = null;


  private final List <IPresentationController> registeredControllers = new ArrayList<IPresentationController>();

  public Session getCurrentSession () {
    return currentSession;
  }

  public void setCurrentSession (Session currentSession, final IMidiFileEditorUIConfig config, Point size) {
    LOGGER.info("set current session " + currentSession.getName() + " at presentationcontext");
    this.currentSession = currentSession;
    this.config = config;
    calcPreCondition = new CalculatorPreCondition();
    calcPreCondition.setCalculationsize(size);
    slidesPerItem = calculateSlides (currentSession);
    LOGGER.info("set current session " + currentSession.getName() + " at presentationcontext calculation finished");
  }

  public void closePresentationSession () {
    LOGGER.info("Closing presentationsession");
    this.currentSession = null;
    this.config = null;
    calcPreCondition = null;
    slidesPerItem = null;
    imagecache.clear();
  }

  public void registerController (final IPresentationController controller) {
    LOGGER.info("Register Controller " + controller.getClass().getName());
    boolean replaced = false;
    for (int i = 0; i < registeredControllers.size(); i++) {
      if (registeredControllers.get(i).getClass().equals(controller.getClass())) {
        registeredControllers.set(i, controller);
        replaced = true;
        break;
      }
    }

    if (! replaced)
      registeredControllers.add(controller);

    LOGGER.info("Controllers: " + registeredControllers);
  }

  public Collection <IPresentationController> getRegisteredControllers () {
    return registeredControllers;
  }

  public int getCurrentSessionItemIndex () {
    return currentSessionItemIndex;
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

  public NavigationRefreshAction nextSlide () {
    NavigationRefreshAction action = NavigationRefreshAction.REFRESH_VIEW;
    AbstractSessionItem currentSessionItem = getCurrentSessionItem();
    if (currentSlideIndex >= slidesPerItem.get(currentSessionItem).size() - 1) { // last slide of current item reached
      if (currentSessionItemIndex >= slidesPerItem.keySet().toArray().length - 1) { // last slide ever reached
        return NavigationRefreshAction.NONE;
      }
      else {
        action = NavigationRefreshAction.DIFFERENT_ITEM_START;
        currentSessionItemIndex ++;
        currentSlideIndex = 0;
      }
    }
    else
      currentSlideIndex ++;

    LOGGER.info("Next to " + currentSessionItemIndex + ", " + currentSlideIndex);
    return action;
  }

  public boolean previousSong ()  {
    if (currentSessionItemIndex == 0)
      return false;

    currentSessionItemIndex --;
    return true;
  }

  public boolean nextSong () {
    if (currentSessionItemIndex == getCurrentSession().getItems().size() - 1)
      return false;

    currentSessionItemIndex ++;
    return true;
  }

  public NavigationRefreshAction previousSlide () {
    NavigationRefreshAction action = NavigationRefreshAction.REFRESH_VIEW;
    if (currentSlideIndex == 0) { // first slide of current item reached
      if (currentSessionItemIndex == 0) { // first slide ever reached
        return NavigationRefreshAction.NONE;
      }
      else {
        currentSessionItemIndex --;
        action = NavigationRefreshAction.DIFFERENT_ITEM_END;
        currentSlideIndex = slidesPerItem.get(getCurrentSessionItem()).size() - 1;
      }
    }
    else
      currentSlideIndex --;

    LOGGER.info("Previous to " + currentSessionItemIndex + ", " + currentSlideIndex);

    return action;
  }

  public boolean toItem (AbstractSessionItem item, boolean toEnd) {
    AbstractSessionItem[] array = slidesPerItem.keySet().toArray(new AbstractSessionItem [slidesPerItem.size()]);
    for (int i = 0; i < array.length; i++) {
      if (array [i].equals(item)) {
        currentSessionItemIndex = i;
        int lastIndex = slidesPerItem.get(item).size() - 1;
        currentSlideIndex = toEnd ? lastIndex : 0;
        LOGGER.info("To item " + currentSessionItemIndex + ", " + currentSlideIndex);
        return true;
      }
    }
    LOGGER.info("To item (not found)");
    return false;
  }

  public SpecialSlide getSpecialSlide () {
    return specialSlide;
  }

  public void setSpecialSlide (SpecialSlide specialSlide) {
    this.specialSlide = specialSlide;
  }



}
