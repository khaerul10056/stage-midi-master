package org.mda.commons.ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.mda.IMidiFileEditorConfig;

public interface IMidiFileEditorUIConfig extends IMidiFileEditorConfig{


  IGraphicsContext getGraphicsContext ();

  Color getDefaultBackgroundColor ();

  Color getDefaultForegroundColor ();

  Font getFont ();


  Integer getFontsize ();

  /**
   * get default-size of presentation screen
   * @return presentation screen size
   */
  Point getDefaultPresentationScreenSize();

  boolean isShowBackground ();

  /**
   * returns if the blocktype at the beginning of an block (e.g. refrain) is shown
   * If the blocktype is shown all following lines are indented after this type
   * @return
   */
  boolean isShowBlockType ();

  boolean isPagePerPart ();




}
