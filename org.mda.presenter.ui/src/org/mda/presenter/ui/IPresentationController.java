package org.mda.presenter.ui;

import mda.AbstractSessionItem;



public interface IPresentationController {

  void end ();

  boolean nextSlide ();

  public boolean previousSlide ();

  public boolean toItem (final AbstractSessionItem sessionItem);
}
