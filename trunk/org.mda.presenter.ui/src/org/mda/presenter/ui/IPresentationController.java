package org.mda.presenter.ui;

import org.mda.presenter.ui.slide.IPresentationView;



public interface IPresentationController {

  void connect (IPresentationView view);

  void end ();

  boolean nextSlide ();

  public boolean previousSlide ();
}
