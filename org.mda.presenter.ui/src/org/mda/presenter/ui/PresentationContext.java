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
import org.mda.presenter.ui.slide.IPresentationView;
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

  private final List <IPresentationView> registeredViews = new ArrayList<IPresentationView>();

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

  public void selectItem (final AbstractSessionItem item) {
    for (IPresentationController next: registeredControllers) {
      next.toItem(item);
    }
  }

  public void closePresentationSession () {
    LOGGER.info("Closing presentationsession");
    this.currentSession = null;
    this.config = null;
    calcPreCondition = null;
    slidesPerItem = null;
    imagecache.clear();

    for (IPresentationView nextView: getRegisteredViews()) {
      nextView.end();
    }
  }

  public void deregisterController (final Class <? extends IPresentationController> clazz) {
    for (int i = 0; i < registeredControllers.size(); i++) {
      if (registeredControllers.get(i).getClass().equals(clazz)) {
        registeredControllers.remove(i);
        LOGGER.info("Deregistered controller " + clazz.getName());
        return;
      }
    }
  }

  public void registerController (final IPresentationController controller) {
    LOGGER.info("Register Controller " + controller.getClass().getName());
    boolean replaced = false;
    for (int i = 0; i < registeredControllers.size(); i++) {
      if (registeredControllers.get(i).getClass().equals(controller.getClass())) {
        registeredControllers.set(i, controller);
        LOGGER.info("Replaced Controller on index " + i);
        replaced = true;
        break;
      }
    }

    if (! replaced) {
      registeredControllers.add(controller);
      LOGGER.info("Added new controller");
    }

    LOGGER.info("Controllers: " + registeredControllers);
  }


  public void deregisterView (final Class<? extends IPresentationView> clazz) {
    for (int i = 0; i < registeredViews.size(); i++) {
      if (registeredViews.get(i).getClass().equals(clazz)) {
        LOGGER.info("Deregistered view " + clazz.getName());
        registeredViews.remove(i);
        return;
      }
    }
  }

  public void registerView (final IPresentationView view) {
    LOGGER.info("Register view " + view.getClass().getName());
    boolean replaced = false;
    for (int i = 0; i < registeredViews.size(); i++) {
      if (registeredViews.get(i).getClass().equals(view.getClass())) {
        registeredViews.set(i, view);
        LOGGER.info("Replaced view on index " + i + " " + view.getClass());
        replaced = true;
        break;
      }
    }

    if (! replaced) {
      registeredViews.add(view);
      LOGGER.info("Added new view " + view.getClass());
    }

    LOGGER.info("Controllers: " + registeredControllers);
  }

  public Collection <IPresentationController> getRegisteredControllers () {
    return registeredControllers;
  }

  public Collection <IPresentationView> getRegisteredViews () {
    return registeredViews;
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
    boolean itemFound = false;

    for (int i = 0; i < array.length; i++) {
      if (array [i].equals(item)) {
        currentSessionItemIndex = i;
        int lastIndex = slidesPerItem.get(item).size() - 1;
        currentSlideIndex = toEnd ? lastIndex : 0;
        LOGGER.info("To item " + currentSessionItemIndex + ", " + currentSlideIndex);
        itemFound = true;
      }
    }

    LOGGER.info("To item (not found)");

    if (itemFound) {
      for (IPresentationView nextView : getRegisteredViews()) {
        LOGGER.info("Dispatch toItem to " + nextView.getClass().getName() + "-" + System.identityHashCode(nextView));
        if (!nextView.toItem(item))
          itemFound = false;
      }
    }
    return itemFound;
  }

  public SpecialSlide getSpecialSlide () {
    return specialSlide;
  }

  public void setSpecialSlide (SpecialSlide specialSlide) {
    this.specialSlide = specialSlide;
  }



}
