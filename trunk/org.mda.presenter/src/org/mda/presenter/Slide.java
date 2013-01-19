package org.mda.presenter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.mda.Utils;
import org.mda.presenter.adapter.ColorInfo;
import org.mda.presenter.adapter.FontInfo;
import org.mda.presenter.adapter.SizeInfo;

/** dataobject containing information created for a slide,
 * e.g. the text with all it's layoutdata
 * @author oleym */
public class Slide {

  /** reference to the current modelelement (e.g. midifilepart) */
  private final EObject                                 modelRef;
  private final EObject                                 firstLineModelRef;

  private Integer                                       currentLine = 0;

  private final FontInfo font;

  private final HashMap<Integer, Collection<SlideItem>> items       = new HashMap<Integer, Collection<SlideItem>>();

  private File backgroundImageFile;

  private ColorInfo backgroundColor;

  private ColorInfo foregroundColor;

  private SizeInfo size;

  private final boolean forceNewPage;


  public Slide (EObject modelRef, final EObject firstLineModelRef, final FontInfo font, final boolean forceNewPage) {
    this.modelRef = modelRef;
    this.firstLineModelRef = firstLineModelRef;
    this.font = font;
    this.forceNewPage = forceNewPage;
  }

  /**
   * returns if the current slide is empty.
   * If {@linkplain IMidiFileEditorUIConfig#isSkipEmptySlides()} returns also true, than the current slide is removed
   * @return true: current slide is empty, false: current slide is not empty
   */
  public boolean isEmpty () {
    if (items.size() == 0)
      return true;

    for (Collection <SlideItem>itemList : items.values()) {
      for (SlideItem nextIten: itemList) {
        if (! nextIten.isEmpty())
          return false;
      }
    }
    return true;
  }



  /**
   * adds a slideitem to the slide.
   * Only slides containing any kind of text are added.
   * Empty slideitems are ignored
   *
   * @param newItem
   */
  public void addItem (final SlideItem newItem) {

    Collection<SlideItem> collection = items.get(currentLine);
    if (collection == null)
      collection = new ArrayList<SlideItem>();

    collection.add(newItem);
    items.put(currentLine, collection);
  }

  /**
   * finds Items that equals the given text
   * @param text   text to equal
   * @return items
   */
  public List <SlideItem> findItem (final String text) {
    List <SlideItem> foundItems = new ArrayList<SlideItem>();
    for (SlideItem nextItem: getItems()) {
      if (nextItem.getText().trim().equals(text.trim()))
        foundItems.add(nextItem);
    }

    return foundItems;

  }

  public void addItems (final Collection <SlideItem> newItems) {
    for (SlideItem next: newItems)
      addItem(next);
  }

  public void newLine () {
    currentLine++;
  }

  public void previousLine () {
    currentLine --;
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
    return Utils.trimRight(builder.toString());
  }

  public boolean isNewLineForced (final int line) {
    List<SlideItem> items = getItems(line, SlideType.TEXT);
    if (items.size() == 0)
      return false;
    else
      return items.get(0).isNewSlide();
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

  public List<SlideItem> getItems (final int line, SlideType itemType) {

    List<SlideItem> filteredItems = new ArrayList<SlideItem>();
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

  public List<SlideItem> getItems (final SlideType type) {

    List<SlideItem> filteredItems = new ArrayList<SlideItem>();

    for (Integer keys : items.keySet()) {
      Collection<SlideItem> allItems = items.get(keys);
      for (SlideItem next: allItems)
        if (next.getItemType().equals(type))
          filteredItems.add(next);
    }
    return filteredItems;
  }

  public EObject getModelRef () {
    return modelRef;
  }

  public void setBackgroundImage (final File backgroundImageFile) {
    this.backgroundImageFile = backgroundImageFile;
  }

//  has to be move to ui
//  public Image getBackgroundImage (Size size) {
//    if (backgroundImageFile == null)
//      return null;
//    else {
//      LOGGER.info("Creating new background image for " + backgroundImageFile.getAbsolutePath());
//      long beginning = System.currentTimeMillis();
//      Image scaledImage =  imagecache.getImage(backgroundImageFile, size);
//      duration += (System.currentTimeMillis() - beginning);
//      LOGGER.info("Duration : " + duration);
//
//      return scaledImage;
//    }
//  }


  @Override
public String toString () {
    StringBuilder builder = new StringBuilder();

    builder.append("Part " + modelRef + "\nX: " + getSize().getWidth() + "/" + getSize().getHeight() + "\n");

    for (SlideItem nextItem : getItems()) {
      builder.append(nextItem.toString() + "\n");
    }

    return builder.toString() + "\n";
  }

  public FontInfo getFont () {
    return font;
  }

  public File getBackgroundImageFile () {
    return backgroundImageFile;
  }

  public ColorInfo getBackgroundColor () {
    return backgroundColor;
  }

  public void setBackgroundColor (ColorInfo backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  public ColorInfo getForegroundColor () {
    return foregroundColor;
  }

  public void setForegroundColor (ColorInfo foregroundColor) {
    this.foregroundColor = foregroundColor;
  }


  public boolean isSameSlide (final Slide slide) {
    boolean modelRefEquals = slide.getModelRef().equals(getModelRef());
    boolean firstLineEquals = slide.getFirstLineModelRef() == null ? getFirstLineModelRef() == null : slide.getFirstLineModelRef().equals(getFirstLineModelRef());
    return modelRefEquals && firstLineEquals;
  }


  public EObject getFirstLineModelRef () {
    return firstLineModelRef;
  }

  public SizeInfo getSize () {
    return size;
  }

  public void setSize (SizeInfo size) {
    this.size = size;
  }

  public boolean isForceNewPage () {
    return forceNewPage;
  }



}
