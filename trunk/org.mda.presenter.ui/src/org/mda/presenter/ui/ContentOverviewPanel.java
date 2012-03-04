package org.mda.presenter.ui;

import static org.mda.commons.ui.calculator.CalculatorRegistry.getCalculator;
import java.io.File;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class ContentOverviewPanel extends Composite  {

  private static final Log LOGGER  = LogFactory.getLogger(ContentOverviewPanel.class);

   private int width;
  private int height;

  private Image currentShownImage = null;
  private File currentShownImageAsFile = null;

  private Slide currentSlide = null;
  private CalculatorPreCondition calcPreCondition;
  private MidiFileSlideCalculator calculator;

  private Point lastSize;

  private final MidiFilePart currentPart;

  private DefaultMidiFileContentEditorConfig config;

  private boolean selected;



  public void setSelected (final boolean selected) {
    boolean mustRepaint = this.selected != selected;
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("setSelected called for " + this + " is " + selected);
    this.selected = selected;

    if (mustRepaint)
      redraw();

  }


  public int calculateWeight3to4 (final int height) {
    return height * 3 / 4;
  }

  private boolean sizeHasChanged (final Point size1, final Point size2) {
    return size1 == null || ((size1.x != size2.x) || (size1.y != size2.y));
  }

  public void setSize (final int weight, final int height) {

    super.setSize(weight, height);
    LOGGER.info("set size of Contentoverviewpanel to " + getSize().x + "x" + getSize().y);
    calcPreCondition.setCalculationsize(new Point (getBounds().width, getBounds().height));
  }

  public ContentOverviewPanel (Composite parent, MidiFilePart part) {
    super(parent, SWT.NONE);
    this.currentPart = part;

    //TODO check bounds of presentation display
    LOGGER.info("set Size of preview-part to " + width + "x" + height);

    calculator = (MidiFileSlideCalculator) getCalculator(MidiFileSlideCalculator.class);
    calcPreCondition = new CalculatorPreCondition();
    config = new DefaultMidiFileContentEditorConfig();

    setBackground(config.getDefaultBackgroundColor());
    setForeground(config.getDefaultForegroundColor());

    addPaintListener(new PaintListener() {

      @Override
      public void paintControl (PaintEvent e) {
        LOGGER.info("paintControl was called " + e.x + "-" + e.y + "-" + e.width + "-" + e.height + "-" + e.count);

        Point newSize = getSize();
        if (sizeHasChanged(lastSize, newSize)) {
          lastSize = newSize;

        //config.setChordVisible(false);
        calculator.setConfig(config);
        currentSlide = calculator.calculatePart(getCurrentPart(), calcPreCondition);
        }




        if (getCurrentSlide() == null)
          return;

        Font font = getFont();
        e.gc.setFont(font);
        e.gc.setForeground(getCurrentSlide().getForegroundColor());

        if (getCurrentSlide().getBackgroundImageFile() != null) {
          if (currentShownImage == null ||
              ! currentShownImageAsFile.equals(getCurrentSlide().getBackgroundImageFile()) ||   //image has changed
              currentShownImage.getBounds().width != getBounds().width ||                       // size has changed
              currentShownImage.getBounds().height != getBounds().height) {
            LOGGER.info("Repaint background image: " + (currentShownImage != null ? currentShownImage.getBounds() : "<null>") +  getBounds());
            setBackgroundImage(getCurrentSlide().getBackgroundImage(getSize()));
            currentShownImage = getBackgroundImage();
            currentShownImageAsFile = getCurrentSlide().getBackgroundImageFile();
          }
        }
        else {
          setBackgroundImage(null);
          setBackground(getCurrentSlide().getBackgroundColor());
          currentShownImage = null;
          currentShownImageAsFile = null;
        }


        for (SlideItem nextItem: getCurrentSlide().getItems()) {
          e.gc.setFont(getCurrentSlide().getFont());

          e.gc.drawText(nextItem.getText(), nextItem.getX(), nextItem.getY(), true);
        }

        if (selected) {

          Color red = new Color(Display.getCurrent(), 255, 0, 0);
          Rectangle rect1 = new Rectangle(0, 0, getSize().x -1 , getSize().y - 1);
          LOGGER.info("Paint a border at " + rect1);
          e.gc.setForeground(red);
          e.gc.drawRectangle(rect1);
        }

      }
    });

    layout();
  }

  public void setBackgroundImage(Image newImage) {
    if (currentShownImage != null)
      currentShownImage.dispose();
    super.setBackgroundImage(newImage);
  }




  private Slide getCurrentSlide () {
    return currentSlide;
  }



  /**
   * this preview must have a fixed size (1/4 of display for each direction
   */
  public Point computeSize(int wHint, int hHint, boolean bool) {
    int x = (getParent().getSize().x / 4) - 5;
    Point newSize = new Point(x, calculateWeight3to4(x));

    LOGGER.info("computeSize " + newSize);
    return newSize;
  }

  public MidiFilePart getCurrentPart () {
    return currentPart;
  }


}

