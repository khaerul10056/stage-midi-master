package org.mda.commons.ui.calculator;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;


/**
 * item on a slide
 * @author oleym
 *
 */
public class SlideItem {

  private final String text;
  private final Point location;


  private final SlideType itemType;

  private final SlideItem refSlideItem;


  /**
   * Constructor
   * @param location
   * @param text
   * @param itemType
   * @param refSlideItem  maybe <code>null</code> on text-items. Any chord-item holds a reference to his text-item
   */
  public SlideItem (final Point location, final String text, final SlideType itemType, final SlideItem refSlideItem) {
    this.location = location;
    this.text = text;
    this.itemType = itemType;
    this.refSlideItem = refSlideItem;
  }


  public String getText () {
    return text;
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


}