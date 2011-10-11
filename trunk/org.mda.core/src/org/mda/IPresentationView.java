package org.mda;

import mda.MidiFilePart;


public interface IPresentationView {

  /**
   * ends up the presentation
   */
  void end ();

  boolean nextSlide ();

  boolean previousSlide ();

  void showSlide (final MidiFilePart part);

}
