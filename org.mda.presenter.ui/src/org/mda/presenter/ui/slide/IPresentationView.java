package org.mda.presenter.ui.slide;



public interface IPresentationView {
  /**
   * ends up the presentation
   */
  void end ();

  boolean nextSlide ();

  boolean previousSlide ();



}
