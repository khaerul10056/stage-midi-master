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
  private final FontDescriptor font;
  private final int indentToChord;


  /**
   * Constructor
   * @param location
   * @param text
   * @param itemType
   * @param refSlideItem  maybe <code>null</code> on text-items. Any chord-item holds a reference to his text-item
   * @param newSlide if a new slide is forces in this line
   */
  public SlideItem (final Rectangle location, final String text, final SlideType itemType, final SlideItem refSlideItem, final boolean newSlide,
                    final FontDescriptor font, final int indentToChord) {
    this.location = location;
    this.text = text;
    this.itemType = itemType;
    this.refSlideItem = refSlideItem;
    this.newSlide = newSlide;
    this.font = font;
    this.indentToChord = indentToChord;
  }



  public String toString () {
    return "<" + getText() + "> (" + getX() + "," + getY() + "," + getXMax() + "," + getYMax() + "-" +
          getWidth() + "-" + getHeight() + "-" + getItemType().toString() + "- Fontsize " + font.getFontsizeAsInt() + ")";
  }

  public boolean isEmpty () {
    return text == null || text.trim().length() == 0;
  }

  public String getText () {
    return text;
  }

  /**
   * returns the height of the current item
   * @return height
   */
  public int getHeight () {
    return location.height;
  }

  /**
   * returns the width of the current item
   * @return width
   */
  public int getWidth () {
    return location.width;
  }

  /**
   * returns the beginning of the current item in x-order
   * @return beginning x
   */
  public int getX () {
    return location.x;
  }

  /**
   * set the x-location
   * @param newX new value of x
   */
  public void setX (int newX) {
    location.x = newX;
  }

  /**
   * set the y-location
   * @param newY new value of y
   */
  public void setY (int newY) {
    location.y = newY;
  }

  /**
   * returns the beginning of the current item in y-order
   * @return beginning y
   */
  public int getY () {
    return location.y;
  }

  /**
   * returns the end of the current item in x-order
   * @return end x
   */
  public int getXMax () {
    return getX() + getWidth();
  }

  /**
   * returns the end of the current item in y-order
   * @return
   */
  public int getYMax () {
    return getY()+ getHeight();
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


  public FontDescriptor getFont () {
    return font;
  }

  public int getIndentToChord () {
    return indentToChord;
  }


}
