package org.mda.commons.ui;



public interface IPreviewEditorView  {


  boolean stepToNextLine ();

  boolean stepToPreviousLine ();

  void splitLine ();

  void splitPart ();

  void mergeWithPreviousPart ();

  void mergeLine ();



}
