package org.mda.editor.preview.ui;

import mda.MidiFilePart;


public interface IPreviewEditorView {
  void showSlide (final MidiFilePart part);

  boolean stepToNextLine ();
  
  boolean stepToPreviousLine ();


}
