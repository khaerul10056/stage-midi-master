package org.mda.commons.ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.mda.IMidiFileEditorConfig;

public interface IMidiFileEditorUIConfig extends IMidiFileEditorConfig{

  Color getBackgroundColor ();

  Color getForegroundColor ();

  Font getFont ();

  /**
   * get default-size of presentation screen
   * @return presentation screen size
   */
  Point getDefaultPresentationScreenSize();




}
