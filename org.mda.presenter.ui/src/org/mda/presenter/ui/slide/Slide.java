package org.mda.presenter.ui.slide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

/** dataobject containing information created for a slide,
 * e.g. the text with all it's layoutdata
 * @author oleym */
public class Slide {

  /** reference to the current modelelement (e.g. midifilepart) */
  private final EObject                                 modelRef;

  private Image                                         backgroundImage;

  private Integer                                       currentLine = 0;

  private final HashMap<Integer, Collection<SlideItem>> items       = new HashMap<Integer, Collection<SlideItem>>();

  public Slide (EObject modelRef) {
    this.modelRef = modelRef;
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
      int filler = textRef.getText().length() - next.getText().length(); 
      
      StringBuilder nextChord = new StringBuilder(next.getText()); 
      for (int i = 0; i < filler; i++)
        nextChord = nextChord.append(' ');
          
      builder.append(nextChord);
    }
    return builder.toString();
  }

  public String getTextline (final int line) {
    StringBuilder builder = new StringBuilder();

    Collection<SlideItem> items = getItems(line, SlideType.TEXT);
    for (SlideItem next : items) {
      builder.append(next.getText());
    }
    return builder.toString();
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

  public void setBackgroundImage (Image backgroundImage) {
    this.backgroundImage = backgroundImage;
  }

  public Image getBackgroundImage () {
    return backgroundImage;
  }

  public String toString () {
    StringBuilder builder = new StringBuilder();

    builder.append("Part " +
      modelRef);

    for (SlideItem nextItem : getItems()) {
      builder.append("- " +
        nextItem.getText() + " / " + nextItem.getX() + " / " + nextItem.getY() + " / " + nextItem.getFont().getFontData()[0].getHeight() + " / " +
        nextItem.getItemType().toString() + "\n");
    }

    return builder.toString();
  }

}
