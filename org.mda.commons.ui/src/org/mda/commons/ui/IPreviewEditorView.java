package org.mda.commons.ui;



public interface IPreviewEditorView  {

  boolean chordToLeft ();

  boolean chordToRight ();

  boolean stepToNextLine ();

  boolean stepToPreviousLine ();

  void splitLine ();

  void splitPart ();

  void mergeWithPreviousPart ();

  void mergeLine ();



}
