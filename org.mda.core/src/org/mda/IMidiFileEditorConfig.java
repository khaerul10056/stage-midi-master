package org.mda;

import mda.MidiFilePartType;


public interface IMidiFileEditorConfig {

  /**
   * getter
   * @return true: chordline should be visible, false: chordline is not visible
   */
  boolean isChordPresented();

  /**
   * getter
   * @return true: content is editable, false, it's just shown
   */
  boolean isEditable ();

  /**
   * some parts can be ignored
   * e.g. for presentation editor no parts without text are shown
   * @param parttype
   * @return
   */
  boolean isPartIgnored (final MidiFilePartType parttype);



}
