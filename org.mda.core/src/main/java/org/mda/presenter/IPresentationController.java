package org.mda.presenter;

import mda.AbstractSessionItem;
import mda.SongPart;


/**
 * Defines the functionality of a controller which can control this presentation
 * @author oleym
 *
 */

public interface IPresentationController {
	
  /**
   * goto part
   * @param part part
   * @return true 
   */
  boolean toPart(SongPart part);

  /**
   * finish presentation
   */
  void end ();

  /**
   * go to next slide
   * @return true if next slide exists, false elsewhere
   */
  boolean nextSlide ();

  /**
   * go to previous line
   * @return true, if previous slide exists, false elsewhere
   */
  boolean previousSlide ();

  /**
   * go to a specific session item
   * @param sessionItem item
   * @return true if item was found in session, false elsewhere
   */
  public boolean toItem (final AbstractSessionItem sessionItem);
  
  /**
   * plays media of current slide if not yet played and 
   * stops playing media, if any media is currently playing
   */
  void toggleMediaPlaying ();
  
 
}
