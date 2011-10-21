package org.mda.presenter.ui;

import static org.mda.commons.ui.calculator.CalculatorRegistry.getCalculator;
import java.util.LinkedHashMap;
import java.util.List;
import mda.AbstractSessionItem;
import mda.Session;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.ISlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.presenter.ui.slide.IPresentationView;


public class BeamerPresenter extends Shell implements IPresentationView {

  private final Session session;

  private final IPresentationController controller;
  private final IMidiFileEditorUIConfig config;



  private final LinkedHashMap<AbstractSessionItem, List <Slide>> slidesPerItem;

  private int currentSessionItemIndex = 0;
  private int currentSlideIndex = 0;

  private Image currentShownImage = null;

  private CalculatorPreCondition calcPreCondition;

  public BeamerPresenter (Display display, int style, Session session, IPresentationController controller, IMidiFileEditorUIConfig config) {
    super (display, style);

    calcPreCondition = new CalculatorPreCondition();
    calcPreCondition.setCalculationsize(config.getDefaultPresentationScreenSize());
    this.session = session;
    this.controller = controller;
    this.config = config;
    controller.connect(this);

    setBounds(Display.getCurrent().getMonitors() [0].getBounds()); //TODO configure multi monitors
    //setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
    open();
    setFocus();


    slidesPerItem = calculateSlides (session);

    addPaintListener(new PaintListener() {

      @Override
      public void paintControl (PaintEvent e) {
        Font font = getFont();
        e.gc.setFont(font);

        if (getCurrentSlide().getBackgroundImage() != null) {
          if (currentShownImage == null || getCurrentSlide().getBackgroundImage() != currentShownImage) {
            setBackgroundImage(getCurrentSlide().getBackgroundImage());
            currentShownImage = getBackgroundImage();
          }
        }
        else {
          setBackgroundImage(null);
          currentShownImage = null;
        }


        for (SlideItem nextItem: getCurrentSlide().getItems()) {
          e.gc.setFont(getCurrentSlide().getFont());
          e.gc.drawText(nextItem.getText(), nextItem.getX(), nextItem.getY(), true);
        }
      }
    });

    redraw();
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


  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

  @Override
  public void end () {
    dispose();
  }

  public AbstractSessionItem getCurrentSessionItem () {
    return slidesPerItem.keySet().toArray(new AbstractSessionItem [slidesPerItem.keySet().size()]) [currentSessionItemIndex];
  }

  public Slide getCurrentSlide () {
    return slidesPerItem.get(getCurrentSessionItem()).get(currentSlideIndex);
  }

  @Override
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

    redraw();
    return true;
  }

  @Override
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

    redraw();
    return true;
  }


}
