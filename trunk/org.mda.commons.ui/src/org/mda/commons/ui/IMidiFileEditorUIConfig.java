package org.mda.commons.ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.mda.IMidiFileEditorConfig;
import org.mda.commons.ui.calculator.FontDescriptor;

public interface IMidiFileEditorUIConfig extends IMidiFileEditorConfig{


  IGraphicsContext getGraphicsContext ();

  Color getDefaultBackgroundColor ();

  Color getDefaultForegroundColor ();

  FontDescriptor getFont ();

  /**
   * get default-size of presentation screen
   * @return presentation screen size
   */
  Point getDefaultPresentationScreenSize();

  /**
   * returns if the background image should be shown
   * @return true/false
   */
  boolean isShowBackground ();

  /**
   * returns if the blocktype at the beginning of an block (e.g. refrain) is shown
   * If the blocktype is shown all following lines are indented after this type
   * @return
   */
  boolean isShowBlockType ();

  /**
   * returns if a page should not contain more content than a part.
   * Enabled e.g. for presentation on screen.
   * Disabled e.g. for exporting to a songbook
   * Parts can also be divided by the attribute isNewSlide () at the MidiFileTextLine.
   * @return
   */
  boolean isPagePerPart ();

  /**
   * returns if the attribute isNewSlie() at the MidiFileTextLine is respected.
   * Enabled e.g. for presentation on screen, splitting a too large part in different screens,
   * Disabled e.g. for exporting to a songbook or the editor
   * @return
   */
  boolean isNewPageRespected ();

  /**
   * returns is a title should be shown above
   * @return true/false
   */
  boolean isShowTitle();

  /**
   * returns if copyright-information should be should at the bottom of every song
   * @return true/false
   */
  boolean isShowCopyright ();

  /**
   * returns if empty slides should be skipped
   * @return true/false
   */
  boolean isSkipEmptySlides ();

  /**
   * returns if lines, that fit on one line should be merged automatically
   * to need less space on the page
   * @return true/false
   */
  boolean isOptimizeLineFilling ();

  /**
   * returns the border round a slide
   * @return border, cannot be <code>null</code>
   */
  Integer getBorder ();

  /**
   * returns if parts, which are shown multiple times are optimized
   *
   * REFRAIN  ...
   * VERS1    ...
   * VERS1    ...
   * REFRAIN  ...
   *
   * gets to
   * REFRAIN  ...
   * VERS1 2x ...
   * REFRAIN
   *
   * @return true/false
   */
  boolean isOptimizeEqualParts ();
  /**
   * returns, if empty tokens should be shown (false) or should be set to <code>null</code>
   * In second case they have no influence on layout at all
   * In editors this feature should be disabled because it has negative impact on split/merge lines
   * @return true/false
   */
  boolean isOptimizeEmptyTokens ();

  boolean isAutoWrapToNewPage ();

  void setDefaultPresentationScreenSize (Point calcSize);


}
