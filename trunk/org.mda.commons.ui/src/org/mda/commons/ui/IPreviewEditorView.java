package org.mda.commons.ui;



public interface IPreviewEditorView extends IPreviewView {


  boolean stepToNextLine ();

  boolean stepToPreviousLine ();

  boolean toggleChordline ();

  void splitLine ();

  void mergeLine ();

  void input (final char newchar);

  void deleteCharacter ();


}
