package org.mda.editor.preview.ui;

import java.util.ArrayList;
import java.util.Collection;
import mda.MidiFilePart;


public class PreviewEditorController {
  
  private final Collection <IPreviewEditorView> views = new ArrayList<IPreviewEditorView>();

  public void connect (IPreviewEditorView view) {
    views.add(view);
  }
  
  /**
   * 
   * @return
   */
  protected Collection <IPreviewEditorView> getRegisteredViews () {
    return views;
  }
  
  
  /**
   * show a specific part 
   * @param part
   */
  public void showPart (final MidiFilePart part) {
    for (IPreviewEditorView nextView: getRegisteredViews()) {
      nextView.showSlide(part);
    }
  }
  
  public boolean stepToNextLine () {
    boolean done = true;
    for (IPreviewEditorView nextView: getRegisteredViews()) {
      if (! nextView.stepToNextLine())
        done = false;
    }

    return done;
  }
  

}
