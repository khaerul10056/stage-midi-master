package org.mda.editor.preview.ui.parts;

import static org.mda.commons.ui.calculator.CalculatorRegistry.getCalculator;
import mda.MidiFilePart;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
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

  private Slide currentSlide = null;
  private CalculatorPreCondition calcPreCondition;
  private MidiFileSlideCalculator calculator;

  public PreviewPart (Composite parent) {
    super(parent);

    //TODO check bounds of presentation display
    width = Display.getCurrent().getBounds().width / 4;
    height = Display.getCurrent().getBounds().height / 4;
    setSize(width, height);

    calcPreCondition = new CalculatorPreCondition();
    calcPreCondition.setCalculationsize(new Point (width, height));
    calculator = (MidiFileSlideCalculator) getCalculator(MidiFileSlideCalculator.class);
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    //config.setChordVisible(false);
    calculator.setConfig(config);

    addPaintListener(new PaintListener() {

      @Override
      public void paintControl (PaintEvent e) {

        if (getCurrentSlide() == null)
          return;

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



  public Slide getCurrentSlide () {
    return currentSlide;
  }


  public void setCurrentPart (MidiFilePart part) {
    super.setCurrentPart(part);
    this.currentSlide = calculator.calculatePart(part, calcPreCondition);
    redraw();
  }

  /**
   * this preview must have a fixed size (1/4 of display for each direction
   */
  public Point computeSize(int wHint, int hHint, boolean bool) {
    return new Point(width, height);
  }


}
