package org.mda.presenter;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.measurement.AreaInfo;
import org.mda.measurement.FontInfo;



/**
 * item on a slide
 * @author oleym
 *
 */
public class SlideItem {
	
	private static final Log LOGGER  = LogFactory.getLogger(SlideItem.class);

  private final String text;
  private AreaInfo area;


  private final SlideType itemType;

  private final SlideItem refSlideItem;
  private final boolean newSlide;
  private final FontInfo font;
  private final int indentToChord;


  /**
   * Constructor
   * @param location
   * @param text
   * @param itemType
   * @param refSlideItem  maybe <code>null</code> on text-items. Any chord-item holds a reference to his text-item
   * @param newSlide if a new slide is forces in this line
   */
  public SlideItem (final AreaInfo location, final String text, final SlideType itemType, final SlideItem refSlideItem, final boolean newSlide,
                    final FontInfo font, final float indentToChord) {
	LOGGER.info("Creating SlideItem " + text + "-" + location);
    this.area = location;
    this.text = text;
    this.itemType = itemType;
    this.refSlideItem = refSlideItem;
    this.newSlide = newSlide;
    this.font = font;
    this.indentToChord = (int) indentToChord;
  }



  @Override
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
  public float getHeight () {
    return area.getHeight();
  }

  /**
   * returns the width of the current item
   * @return width
   */
  public float getWidth () {
    return area.getWidth();
  }

  /**
   * returns the beginning of the current item in x-order
   * @return beginning x
   */
  public float getX () {
    return area.getX();
  }

  /**
   * set the x-location
   * @param newX new value of x
   */
  public void setX (float newX) {
    area = new AreaInfo(newX, area.getY(), area.getSize());
  }

  /**
   * set the y-location
   * @param newY new value of y
   */
  public void setY (float newY) {
    area = new AreaInfo (area.getX(), newY, area.getSize());
  }

  /**
   * returns the beginning of the current item in y-order
   * @return beginning y
   */
  public float getY () {
    return area.getY();
  }

  /**
   * returns the end of the current item in x-order
   * @return end x
   */
  public float getXMax () {
    return getX() + getWidth();
  }

  /**
   * returns the end of the current item in y-order
   * @return
   */
  public float getYMax () {
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


  public FontInfo getFont () {
    return font;
  }

  public int getIndentToChord () {
    return indentToChord;
  }


}
