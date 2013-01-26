package org.mda.presenter;

import mda.AbstractSessionItem;
import mda.SongPart;

import org.eclipse.e4.core.di.annotations.Creatable;


/**
 * Defines the functionality of a controller which can control this presentation
 * @author oleym
 *
 */
@Creatable
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
}
