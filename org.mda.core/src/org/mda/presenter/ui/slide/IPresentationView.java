package org.mda.presenter.ui.slide;




@Deprecated
public interface IPresentationView {
  /**
   * ends up the presentation
   */
  void end ();

  /**
   * refresh the view, for example if next slide is shown
   */
  void refresh ();



}
