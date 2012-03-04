package org.mda.presenter.ui.slide;

import mda.AbstractSessionItem;



public interface IPresentationView {
  /**
   * ends up the presentation
   */
  void end ();

  /**
   * refresh the view, for example if next slide is shown
   */
  void refresh ();

  /**
   * change complete item, change song for example
   * @param item
   * @return
   */
  boolean toItem (AbstractSessionItem item);



}
