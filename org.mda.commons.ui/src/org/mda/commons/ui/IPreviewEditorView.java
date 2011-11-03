package org.mda.commons.ui;



public interface IPreviewEditorView extends IPreviewView {


  boolean stepToNextLine ();

  boolean stepToPreviousLine ();

  void splitLine ();

  void mergeLine ();



}
