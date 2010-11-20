package org.mda;

import java.awt.Color;
import java.awt.Font;

import mda.MidiFilePartType;

public interface MidiFileContentEditorConfigIF {

  /**
   * getter
   * @return true: chordline should be visible, false: chordline is not visible
   */
  boolean isChordVisible();

  /**
   * getter
   * @return true: content is editable, false, it's just shown
   */
  boolean isEditable ();

  /**
   * getter
   * @return true: only the current part is shown (presentationview), false: all parts are shown (editor)
   */
  boolean isShowOnlyCurrentPart ();

  Color getBackgroundColor ();

  Color getForegroundColor ();

  Font getFont ();

  /**
   * some parts can be ignored
   * e.g. for presentation editor no parts without text are shown
   * @param parttype
   * @return
   */
  boolean isPartIgnored (final MidiFilePartType parttype);

}
