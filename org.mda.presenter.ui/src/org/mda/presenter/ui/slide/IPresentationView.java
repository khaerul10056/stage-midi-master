package org.mda.presenter.ui.slide;

import mda.AbstractSessionItem;



public interface IPresentationView {
  /**
   * ends up the presentation
   */
  void end ();

  boolean nextSlide ();

  boolean previousSlide ();

  /**
   * steps to session item
   * @param item item
   * @return true/false
   */
  boolean toItem (final AbstractSessionItem item);



}
