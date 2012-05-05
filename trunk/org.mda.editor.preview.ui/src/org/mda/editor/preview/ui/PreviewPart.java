package org.mda.editor.preview.ui;

import static org.mda.commons.ui.calculator.CalculatorRegistry.getCalculator;
import java.io.File;
import mda.MidiFilePart;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class PreviewPart extends AbstractPart {

  private static final Log LOGGER  = LogFactory.getLogger(PreviewPart.class);

  private int width;
  private int height;

  private Image currentShownImage = null;
  private File currentShownImageAsFile = null;

  private Slide currentSlide = null;
  private CalculatorPreCondition calcPreCondition;
  private MidiFileSlideCalculator calculator;

  private Point lastSize;

  private DefaultMidiFileContentEditorConfig config;

  public int calculateWeight4to3 (final int height) {
    return height * 4 / 3;
  }

  private boolean sizeHasChanged (final Point size1, final Point size2) {
    return size1 == null || ((size1.x != size2.x) || (size1.y != size2.y));
  }

  public void setSize (final int weight, final int height) {
    LOGGER.info("set size of previewpart to " + weight + "x" + height);
    super.setSize(weight, height);
    calcPreCondition.setCalculationsize(new Point (getBounds().width, getBounds().height));
  }

  public PreviewPart (Composite parent, int width, int height) {
    super(parent);

    //TODO check bounds of presentation display
    LOGGER.info("set Size of preview-part to " + width + "x" + height);

    calculator = (MidiFileSlideCalculator) getCalculator(MidiFileSlideCalculator.class);
    calcPreCondition = new CalculatorPreCondition();
    config = new DefaultMidiFileContentEditorConfig();
    config.setShowBackground(true);

    setBackground(config.getDefaultBackgroundColor());
    setForeground(config.getDefaultForegroundColor());
    setSize(width, height); // after initializing calcPreCondition



    addPaintListener(new PaintListener() {

      @Override
      public void paintControl (PaintEvent e) {
        LOGGER.info("paintControl was called " + e.x + "-" + e.y + "-" + e.width + "-" + e.height + "-" + e.count);

        Point newSize = getSize();
        if (sizeHasChanged(lastSize, newSize) && getCurrentPart() != null) {
          lastSize = newSize;
        setSize(calculateWeight4to3(newSize.y), newSize.y);

        //config.setChordVisible(false);
        calculator.setConfig(config);
        currentSlide = calculator.calculatePart(getCurrentPart(), calcPreCondition).get(0);
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

      }
    });

    redraw();
  }

  public void setBackgroundImage(Image newImage) {
    if (currentShownImage != null)
      currentShownImage.dispose();
    super.setBackgroundImage(newImage);
  }




  public Slide getCurrentSlide () {
    return currentSlide;
  }


  public void setCurrentPart (MidiFilePart part) {
    super.setCurrentPart(part);
    this.currentSlide = calculator.calculatePart(part, calcPreCondition).get(0);
    redraw();
  }

  /**
   * this preview must have a fixed size (1/4 of display for each direction
   */
  public Point computeSize(int wHint, int hHint, boolean bool) {
    return new Point(width, height);
  }


}
