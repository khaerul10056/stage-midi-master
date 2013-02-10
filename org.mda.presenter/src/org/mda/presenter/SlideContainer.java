package org.mda.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import mda.AbstractSessionItem;

/**
 * holds all slides of a session together 
 * @author oleym
 *
 */
public class SlideContainer {
	
	private final HashMap<AbstractSessionItem, List<Slide>> slidesPerItem = new HashMap<AbstractSessionItem, List<Slide>>();
	
	public void addContainer (final SlideContainer container) {
		HashMap<AbstractSessionItem, List<Slide>> containerParam = container.getSlidesPerItem(); 
		for (AbstractSessionItem nextKey : containerParam.keySet()) {
			List<Slide> slidesParam = containerParam.get(nextKey);
			slidesPerItem.put(nextKey, slidesParam);	
		}
	}
	
	/**
	   * getter gets item which ends most right
	   * @return item 
	   */
	  public SlideItem getMostRightItem () {
		  SlideItem chosen = null; 
		  
		  for (SlideItem next: getAllSlideItems()) {
			  if (chosen == null || next.getXMax() > chosen.getXMax())
				  chosen = next; 
		  }
		  
		  return chosen;
		  
	  }
	  
	  /**
	   * finds the current slide by a slide which is calculated by 
	   * another SongSlideCalculator (must equal the modelref)
	   * @param currentEqualsSlide  slide which is equaled
	   * @return  slide
	   */
	  public Slide getSlide (final Slide currentEqualsSlide) {
		  for (Slide next: getSlides()) {
			  if (next.getModelRef().equals(currentEqualsSlide.getModelRef()))
				  return next;
		  }
		  
		  return null;
	  }
	  
	  
	  /**
	   * gets all items of all slides in the container
	   * @return all items as list
	   */
	  public List <SlideItem> getAllSlideItems () {
		  List <SlideItem> allItems = new ArrayList<SlideItem>();
		  for (Slide nextSlide: getSlides()) {
			  allItems.addAll(nextSlide.getItems());
		  }
		  
		  return allItems;
	  }
	
	public void addSlide (final AbstractSessionItem item, Slide slide) {
		List<Slide> collection = slidesPerItem.get(item);
		if (collection == null)
			collection = new ArrayList<Slide>();
		
		collection.add(slide);
		
		slidesPerItem.put(item, collection);
	}
	
	public void addSlides (final AbstractSessionItem item, Collection<Slide> slides) {
		List<Slide> collection = slidesPerItem.get(item);
		if (collection == null)
			collection = new ArrayList<Slide>();
		
		collection.addAll(slides);
		
		slidesPerItem.put(item, collection);
	}

	public HashMap<AbstractSessionItem, List<Slide>> getSlidesPerItem() {
		return slidesPerItem;
	}
	
	public List <Slide> getSlides (final AbstractSessionItem sessionItem) {
		List <Slide> slide = slidesPerItem.get(sessionItem);
		if (slide == null)
			return Collections.emptyList();
		
		return slide;
	}
	
	
	
	public List<Slide> getSlides () {
		ArrayList<Slide> completeListe = new ArrayList<Slide>();
		for (Collection <Slide> nextSlideList : slidesPerItem.values()) {
			completeListe.addAll(nextSlideList);
		}
		return completeListe;
	}

	

}
