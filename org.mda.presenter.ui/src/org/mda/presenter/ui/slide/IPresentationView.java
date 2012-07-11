package org.mda.presenter.ui.slide;




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
