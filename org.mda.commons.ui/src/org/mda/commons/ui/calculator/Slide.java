package org.mda.commons.ui.calculator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import static org.mda.Utils.trimRight;

/** dataobject containing information created for a slide,
 * e.g. the text with all it's layoutdata
 * @author oleym */
public class Slide {

  private static final Logger LOGGER  = Logger.getLogger(Slide.class.getName());

  /** reference to the current modelelement (e.g. midifilepart) */
  private final EObject                                 modelRef;

  private ImageData                                         backgroundImage;

  private Integer                                       currentLine = 0;

  private final Font font;

  private final HashMap<Integer, Collection<SlideItem>> items       = new HashMap<Integer, Collection<SlideItem>>();

  private File backgroundImageFile;

  public Slide (EObject modelRef, final Font font) {
    this.modelRef = modelRef;
    this.font = font;
  }

  public void addItem (final SlideItem newItem) {

    Collection<SlideItem> collection = items.get(currentLine);
    if (collection == null)
      collection = new ArrayList<SlideItem>();

    collection.add(newItem);

    items.put(currentLine, collection);
  }

  public void newLine () {
    currentLine++;
  }

  public int getLineCount () {
    return currentLine;
  }

  public String getChordline (final int line) {
    Collection<SlideItem> items = getItems(line, SlideType.CHORD);
    if (items == null || items.size() == 0)
      return "";

    StringBuilder builder = new StringBuilder();
    for (SlideItem next : items) {
      SlideItem textRef = next.getRefSlideItem();
      int filler = textRef != null ? textRef.getText().length() - next.getText().length() : 0;

      StringBuilder nextChord = new StringBuilder(next.getText());
      for (int i = 0; i < filler; i++)
        nextChord = nextChord.append(' ');

      builder.append(nextChord);
    }
    return trimRight(builder.toString());
  }

  public String getTextline (final int line) {
    StringBuilder builder = new StringBuilder();

    Collection<SlideItem> items = getItems(line, SlideType.TEXT);
    for (SlideItem next : items) {
      builder.append(next.getText());
    }
    return trimRight(builder.toString());
  }

  public Collection<SlideItem> getItems (final int line) {
    return getItems(line, null);
  }

  public Collection<SlideItem> getItems (final int line, SlideType itemType) {

    Collection<SlideItem> filteredItems = new ArrayList<SlideItem>();
    Collection<SlideItem> allItemsOfLine = items.get(line);
    if (allItemsOfLine != null) {
      for (SlideItem next : allItemsOfLine) {
        if (itemType == null ||
          next.getItemType().equals(itemType))
          filteredItems.add(next);
      }
    }
    return filteredItems;
  }

  public List<SlideItem> getItems () {

    List<SlideItem> allItems = new ArrayList<SlideItem>();

    for (Integer keys : items.keySet()) {
      allItems.addAll(items.get(keys));
    }
    return allItems;
  }

  public EObject getModelRef () {
    return modelRef;
  }

  public void setBackgroundImage (ImageData backgroundImage, final File backgroundImageFile) {
    this.backgroundImage = backgroundImage;
    this.backgroundImageFile = backgroundImageFile;
  }

  public Image getBackgroundImage (Point point) {
    if (backgroundImage == null)
      return null;
    else {
      LOGGER.info("Creating new background image for " + backgroundImageFile.getAbsolutePath());
      return new Image (Display.getCurrent(), backgroundImage.scaledTo(point.x, point.y));
    }
  }

  public ImageData getBackgroundImageData () {
    return backgroundImage;
  }

  public String toString () {
    StringBuilder builder = new StringBuilder();

    builder.append("Part " +
      modelRef);

    for (SlideItem nextItem : getItems()) {
      builder.append("- " +
        nextItem.getText() + " / " + nextItem.getX() + " / " + nextItem.getY() + " / " + nextItem.getItemType().toString() + "\n");
    }

    return builder.toString();
  }

  public Font getFont () {
    return font;
  }

  public File getBackgroundImageFile () {
    return backgroundImageFile;
  }



}
