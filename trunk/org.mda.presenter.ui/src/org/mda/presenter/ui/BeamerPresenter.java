package org.mda.presenter.ui;

import static org.mda.commons.ui.calculator.CalculatorRegistry.getCalculator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;
import mda.AbstractSessionItem;
import mda.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.ISlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.presenter.ui.slide.IPresentationView;


public class BeamerPresenter extends Shell implements IPresentationView {

  private static final Logger LOGGER  = Logger.getLogger(BeamerPresenter.class.getName());

  private final IMidiFileEditorUIConfig config;



  private final LinkedHashMap<AbstractSessionItem, List <Slide>> slidesPerItem;

  private int currentSessionItemIndex = 0;
  private int currentSlideIndex = 0;

  private Image currentShownImage = null;

  private CalculatorPreCondition calcPreCondition;

  private Monitor getPreferredExternalMonitor (Display display) {
    for (Monitor nextMonitor: display.getMonitors()) {
      if (! nextMonitor.equals(Display.getCurrent().getPrimaryMonitor()))
        return nextMonitor;
    }

    return Display.getCurrent().getPrimaryMonitor();

  }

  public BeamerPresenter (Display display, Session session, IPresentationController controller, IMidiFileEditorUIConfig config) {
    super (display, SWT.ON_TOP);
    calcPreCondition = new CalculatorPreCondition();

    Monitor preferredMonitor = getPreferredExternalMonitor(display);
    if (! preferredMonitor.equals(Display.getCurrent().getPrimaryMonitor())) {
      Rectangle bounds = getPreferredExternalMonitor(display).getBounds();
      LOGGER.info("Set beamer-size to " + bounds.width + "x" + bounds.height);
      setBounds(bounds);
      //1400x1050 =0,75   ->preview: 770x262 = 0,34
    }

    LOGGER.info("Bounds of Display: " + Display.getCurrent().getBounds());
    LOGGER.info("ClientArea of Display: " + Display.getCurrent().getClientArea());

    for (Shell shell: Display.getCurrent().getShells()) {
      LOGGER.info ("Shell " + shell.getText() + "-" + shell.getBounds());
    }

    setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
    calcPreCondition.setCalculationsize(new Point (getBounds().width, getBounds().height));
    this.config = config;
    controller.connect(this);

    open();
    setFocus();

    slidesPerItem = calculateSlides (session);

    addPaintListener(new PaintListener() {

      @Override
      public void paintControl (PaintEvent e) {
        Font font = getFont();
        e.gc.setFont(font);

        if (getCurrentSlide().getBackgroundImage(getSize()) != null) {
          if (currentShownImage == null || getCurrentSlide().getBackgroundImage(getSize()) != currentShownImage) {
            setBackgroundImage(getCurrentSlide().getBackgroundImage(getSize()));
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

    LOGGER.info("Next to " + currentSessionItemIndex + ", " + currentSlideIndex);

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

    LOGGER.info("Previous to " + currentSessionItemIndex + ", " + currentSlideIndex);

    redraw();
    return true;
  }

  @Override
  public boolean toItem (AbstractSessionItem item) {
    AbstractSessionItem[] array = slidesPerItem.keySet().toArray(new AbstractSessionItem [slidesPerItem.size()]);
    for (int i = 0; i < array.length; i++) {
      if (array [i].equals(item)) {
        currentSessionItemIndex = i;
        currentSlideIndex = 0;
        redraw();
        LOGGER.info("To item " + currentSessionItemIndex + ", " + currentSlideIndex);
        return true;
      }
    }
    LOGGER.info("To item (not found)");
    return false;
  }


}
