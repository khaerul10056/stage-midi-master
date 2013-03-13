package org.mda.presenter;




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
   * returns, if the component is focused
   */
  boolean isFocused ();



}
