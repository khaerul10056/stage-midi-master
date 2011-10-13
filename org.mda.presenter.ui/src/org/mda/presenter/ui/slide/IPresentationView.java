package org.mda.presenter.ui.slide;

import mda.MidiFilePart;


public interface IPresentationView {
  /**
   * ends up the presentation
   */
  void end ();

  boolean nextSlide ();

  boolean previousSlide ();

  

}
