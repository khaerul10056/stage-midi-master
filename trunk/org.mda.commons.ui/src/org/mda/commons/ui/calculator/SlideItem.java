package org.mda.commons.ui.calculator;

import org.eclipse.swt.graphics.Rectangle;


/**
 * item on a slide
 * @author oleym
 *
 */
public class SlideItem {

  private final String text;
  private final Rectangle location;


  private final SlideType itemType;

  private final SlideItem refSlideItem;
  private final boolean newSlide;


  /**
   * Constructor
   * @param location
   * @param text
   * @param itemType
   * @param refSlideItem  maybe <code>null</code> on text-items. Any chord-item holds a reference to his text-item
   * @param newSlide if a new slide is forces in this line
   */
  public SlideItem (final Rectangle location, final String text, final SlideType itemType, final SlideItem refSlideItem, final boolean newSlide) {
    this.location = location;
    this.text = text;
    this.itemType = itemType;
    this.refSlideItem = refSlideItem;
    this.newSlide = newSlide;
  }


  public String getText () {
    return text;
  }

  public int getHeight () {
    return location.height;
  }

  public int getWidth () {
    return location.width;
  }

  public int getX () {
    return location.x;
  }

  public int getY () {
    return location.y;
  }



  public SlideType getItemType () {
    return itemType;
  }


  public SlideItem getRefSlideItem () {
    return refSlideItem;
  }


  public boolean isNewSlide () {
    return newSlide;
  }


}
