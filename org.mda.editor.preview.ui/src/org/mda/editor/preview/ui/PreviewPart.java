package org.mda.editor.preview.ui;

import java.io.File;

import javax.inject.Inject;

import mda.MidiFilePart;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
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

@Creatable
public class PreviewPart extends AbstractPart {

  private static final Log LOGGER  = LogFactory.getLogger(PreviewPart.class);

  private int width;
  private int height;

  private Image currentShownImage = null;
  private File currentShownImageAsFile = null;

  private Slide currentSlide = null;
  
  @Inject
  private CalculatorPreCondition calcPreCondition;
  
  @Inject
  private MidiFileSlideCalculator calculator;

  private Point lastSize;

  private DefaultMidiFileContentEditorConfig config;

  
  private boolean sizeHasChanged (final Point size1, final Point size2) {
    return size1 == null || ((size1.x != size2.x) || (size1.y != size2.y));
  }

  public void setSize (final int weight, final int height) {
    LOGGER.info("set size of previewpart to " + weight + "x" + height);
    
    comp.setSize(weight, height);
    calcPreCondition.setCalculationsize(new Point (comp.getBounds().width, comp.getBounds().height));
  }

  public Composite build (PreviewEditorComposite parent, int width, int height) {
	comp = new Composite(parent.getComp(), SWT.NONE);
	setEditorComposite(parent);
    
    //TODO check bounds of presentation display
    LOGGER.info("set Size of preview-part to " + width + "x" + height);

    //calcPreCondition = new CalculatorPreCondition(); //TODO mach wech
    config = new DefaultMidiFileContentEditorConfig();
    config.setShowBackground(true);

    comp.setBackground(config.getDefaultBackgroundColor());
    comp.setForeground(config.getDefaultForegroundColor());
    setSize(width, height); // after initializing calcPreCondition



    comp.addPaintListener(new PaintListener() {

      @Override
      public void paintControl (PaintEvent e) {
        LOGGER.info("paintControl was called " + e.x + "-" + e.y + "-" + e.width + "-" + e.height + "-" + e.count);

        Point newSize = comp.getSize();
        if (sizeHasChanged(lastSize, newSize) && getCurrentPart() != null) {
          lastSize = newSize;
        setSize(newSize.x, newSize.y);

        //config.setChordVisible(false);
        calculator.setConfig(config);
        currentSlide = calculator.calculatePart(getCurrentPart(), calcPreCondition).get(0);
        }


        if (getCurrentSlide() == null)
          return;

        Font font = comp.getFont();
        e.gc.setFont(font);
        e.gc.setForeground(getCurrentSlide().getForegroundColor());

        if (getCurrentSlide().getBackgroundImageFile() != null) {
          if (currentShownImage == null ||
              ! currentShownImageAsFile.equals(getCurrentSlide().getBackgroundImageFile()) ||   //image has changed
              currentShownImage.getBounds().width != comp.getBounds().width ||                       // size has changed
              currentShownImage.getBounds().height != comp.getBounds().height) {
            LOGGER.info("Repaint background image: " + (currentShownImage != null ? currentShownImage.getBounds() : "<null>") +  comp.getBounds());
            setBackgroundImage(getCurrentSlide().getBackgroundImage(comp.getSize()));
            currentShownImage = comp.getBackgroundImage();
            currentShownImageAsFile = getCurrentSlide().getBackgroundImageFile();
          }
        }
        else {
          setBackgroundImage(null);
          comp.setBackground(getCurrentSlide().getBackgroundColor());
          currentShownImage = null;
          currentShownImageAsFile = null;
        }


        for (SlideItem nextItem: getCurrentSlide().getItems()) {
          e.gc.setFont(getCurrentSlide().getFont());

          e.gc.drawText(nextItem.getText(), nextItem.getX(), nextItem.getY(), true);
        }

      }
    });

    comp.redraw();
    
    return comp;
  }

  public void setBackgroundImage(Image newImage) {
    /**if (currentShownImage != null)
      currentShownImage.dispose();**/
    comp.setBackgroundImage(newImage);
  }




  public Slide getCurrentSlide () {
    return currentSlide;
  }


  public void setCurrentPart (MidiFilePart part) {
    super.setCurrentPart(part);
    this.currentSlide = calculator.calculatePart(part, calcPreCondition).get(0);
    comp.redraw();
  }

  /**
   * this preview must have a fixed size (1/4 of display for each direction
   */
  public Point computeSize(int wHint, int hHint, boolean bool) {
    return new Point(width, height);
  }


}
