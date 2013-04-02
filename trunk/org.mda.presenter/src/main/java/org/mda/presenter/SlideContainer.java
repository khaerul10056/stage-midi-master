package org.mda.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import mda.AbstractSessionItem;

/**
 * holds all slides of a session together 
 * @author oleym
 *
 */
public class SlideContainer {
	
	private final HashMap<AbstractSessionItem, List<ISlide>> slidesPerItem = new LinkedHashMap<AbstractSessionItem, List<ISlide>>();
	
	public void addContainer (final SlideContainer container) {
		HashMap<AbstractSessionItem, List<ISlide>> containerParam = container.getSlidesPerItem(); 
		for (AbstractSessionItem nextKey : containerParam.keySet()) {
			List<ISlide> slidesParam = containerParam.get(nextKey);
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
	  public ISlide getSlide (final Slide currentEqualsSlide) {
		  for (ISlide next: getSlides()) {
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
		  for (ISlide nextSlide: getSlides()) {
			  allItems.addAll(nextSlide.getItems());
		  }
		  
		  return allItems;
	  }
	
	public void addSlide (final AbstractSessionItem item, ISlide slide) {
		List<ISlide> collection = slidesPerItem.get(item);
		if (collection == null)
			collection = new ArrayList<ISlide>();
		
		collection.add(slide);
		
		slidesPerItem.put(item, collection);
	}
	
	public void addSlides (final AbstractSessionItem item, Collection<? extends ISlide> slides) {
		List<ISlide> collection = slidesPerItem.get(item);
		if (collection == null)
			collection = new ArrayList<ISlide>();
		
		collection.addAll(slides);
		
		slidesPerItem.put(item, collection);
	}

	public HashMap<AbstractSessionItem, List<ISlide>> getSlidesPerItem() {
		return slidesPerItem;
	}
	
	public List <ISlide> getSlides (final AbstractSessionItem sessionItem) {
		List <ISlide> slide = slidesPerItem.get(sessionItem);
		if (slide == null)
			return Collections.emptyList();
		
		return slide;
	}
	
	
	public boolean isSlideAssignedToItem (Slide slide, AbstractSessionItem sessionitem) {
		List <ISlide> slides = slidesPerItem.get(sessionitem);
		return slides.contains(slide);
	}
	
	
	public List<? extends ISlide> getSlides () {
		ArrayList<ISlide> completeListe = new ArrayList<ISlide>();
		for (Collection <ISlide> nextSlideList : slidesPerItem.values()) {
			completeListe.addAll(nextSlideList);
		}
		return completeListe;
	}
	
	public List<Slide> getSongSlides () {
		ArrayList<Slide> completeListe = new ArrayList<Slide>();
		for (Collection <ISlide> nextSlideList : slidesPerItem.values()) {
			for (ISlide nextSlide : nextSlideList)
			  if (nextSlide instanceof Slide)
			  completeListe.add((Slide) nextSlide);
		}
		return completeListe;
	}


	

}
