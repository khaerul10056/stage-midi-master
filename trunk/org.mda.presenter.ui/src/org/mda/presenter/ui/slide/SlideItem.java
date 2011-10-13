package org.mda.presenter.ui.slide;

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


  private final Font font;

  private final SlideType itemType;
  
  private final SlideItem refSlideItem;


  /**
   * Constructor
   * @param location
   * @param text
   * @param font
   * @param itemType
   * @param refSlideItem  maybe <code>null</code> on text-items. Any chord-item holds a reference to his text-item
   */
  public SlideItem (final Point location, final String text, final Font font, final SlideType itemType, final SlideItem refSlideItem) {
    this.font = font;
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


  public Font getFont () {
    return font;
  }


  public SlideType getItemType () {
    return itemType;
  }


  public SlideItem getRefSlideItem () {
    return refSlideItem;
  }


}
