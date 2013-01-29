package org.mda.presenter.ui;

import java.io.File;

import javax.inject.Inject;

import mda.SongPart;

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
import org.mda.commons.ui.Util;
import org.mda.commons.ui.imagecache.ImageCache;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideItem;
import org.mda.presenter.config.IPresenterConfig;


public class ContentOverviewPanel extends Composite  {

  private static final Log LOGGER  = LogFactory.getLogger(ContentOverviewPanel.class);

   private int width;
  private int height;

  private Image currentShownImage = null;
  private File currentShownImageAsFile = null;

  private Slide currentSlide = null;
  
  private ColorResolver colorresolver = new ColorResolver();

  private Point lastSize;

  private final SongPart currentPart;

  private boolean selected;
  
  @Inject
  private ImageCache imageCache;



  public void setSelected (final boolean selected) {
    boolean mustRepaint = this.selected != selected;
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("setSelected called for " + this + " is " + selected);
    this.selected = selected;

    if (mustRepaint)
      redraw();

  }

  public boolean isSelected () {
    return selected;
  }


  public int calculateWeight3to4 (final int height) {
    return height * 3 / 4;
  }

  private boolean sizeHasChanged (final Point size1, final Point size2) {
    return size1 == null || ((size1.x != size2.x) || (size1.y != size2.y));
  }

  @Override
public void setSize (final int weight, final int height) {

    super.setSize(weight, height);
    LOGGER.debug("set size of Contentoverviewpanel to " + getSize().x + "x" + getSize().y);
    //calcPreCondition.setCalculationsize(new SizeInfo (getBounds().width, getBounds().height));
  }

  public ContentOverviewPanel (Composite parent, SongPart part, Slide calculatedSlide, IPresenterConfig config) {
    super(parent, SWT.NONE);
    this.currentPart = part;
    this.currentSlide = calculatedSlide;

    //TODO check bounds of presentation display
    LOGGER.debug("set Size of preview-part to " + width + "x" + height);
    Util.disableEscOnComponent(this);

    setBackground(colorresolver.getColor(config.getDefaultBackgroundColor()));
    setForeground(colorresolver.getColor(config.getDefaultForegroundColor()));

    addPaintListener(new PaintListener() {

      @Override
      public void paintControl (PaintEvent e) {
        LOGGER.debug("paintControl was called " + e.x + "-" + e.y + "-" + e.width + "-" + e.height + "-" + e.count);

        Point newSize = getSize();
        if (sizeHasChanged(lastSize, newSize)) {
          lastSize = newSize;

        //config.setChordVisible(false);

        }

        if (getCurrentSlide() == null)
          return;

        Font font = getFont();
        e.gc.setFont(font);
        e.gc.setForeground(colorresolver.getColor(getCurrentSlide().getForegroundColor()));

        if (getCurrentSlide().getBackgroundImageFile() != null) {
          if (currentShownImage == null ||
              ! currentShownImageAsFile.equals(getCurrentSlide().getBackgroundImageFile()) ||   //image has changed
              currentShownImage.getBounds().width != getBounds().width ||                       // size has changed
              currentShownImage.getBounds().height != getBounds().height) {
            LOGGER.info("Repaint background image: " + (currentShownImage != null ? currentShownImage.getBounds() : "<null>") +  getBounds());
            Image image = imageCache.getImage(getCurrentSlide().getBackgroundImageFile(), getSize());
            setBackgroundImage(image);
            currentShownImage = getBackgroundImage();
            currentShownImageAsFile = getCurrentSlide().getBackgroundImageFile();
          }
        }
        else {
          setBackgroundImage(null);
          setBackground(colorresolver.getColor(getCurrentSlide().getBackgroundColor()));
          currentShownImage = null;
          currentShownImageAsFile = null;
        }


        for (SlideItem nextItem: getCurrentSlide().getItems()) {
          Font font2 = new Font(getDisplay(), getCurrentSlide().getFont().getFontname(), getCurrentSlide().getFont().getFontsizeAsInt(), getCurrentSlide().getFont().isBold() ? SWT.BOLD : SWT.NORMAL);
          e.gc.setFont(font2);

          e.gc.drawText(nextItem.getText(), (int) nextItem.getX(), (int) nextItem.getY(), true);
        }

        if (selected) {

          Color red = new Color(Display.getCurrent(), 255, 0, 0);
          e.gc.setForeground(red);
          LOGGER.debug("Paint a border");
          for (int i = 0; i < 5; i++) {
            Rectangle rect1 = new Rectangle(i, i, getSize().x - (2*i) , getSize().y - (2*i));
            e.gc.drawRectangle(rect1);

          }




        }

      }
    });

    layout();
  }






  public Slide getCurrentSlide () {
    return currentSlide;
  }





  /**
   * this preview must have a fixed size (1/4 of display for each direction
   */
  @Override
public Point computeSize(int wHint, int hHint, boolean bool) {
    int x = (getParent().getSize().x / 4) - 5;
    Point newSize = new Point(x, calculateWeight3to4(x));

    LOGGER.info("computeSize " + newSize);
    return newSize;
  }

  public SongPart getCurrentPart () {
    return currentPart;
  }


}

