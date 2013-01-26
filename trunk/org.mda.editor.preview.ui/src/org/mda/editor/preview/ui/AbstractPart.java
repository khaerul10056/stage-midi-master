package org.mda.editor.preview.ui;

import mda.Song;
import mda.SongPart;

import org.eclipse.swt.widgets.Composite;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class AbstractPart {

  private static final Log LOGGER  = LogFactory.getLogger(AbstractPart.class);

  private Song midifile;

  private SongPart currentPart;

  private PreviewEditorComposite editorComposite;
  
  protected Composite comp;
  
  public Composite getComp () {
	  return comp;
  }
 

  public void setMidifile (Song midifile) {
    LOGGER.info("setMidifile called for " + this.getClass().getName());
    this.midifile = midifile;
  }

  public Song getMidifile () {
    return midifile;
  }

  public void setEditorComposite (PreviewEditorComposite editorContent) {
    this.editorComposite = editorContent;
  }

  public PreviewEditorComposite getEditorComposite () {
    return editorComposite;
  }

  public SongPart getCurrentPart () {
    return currentPart;
  }

  public void setCurrentPart (SongPart currentPart) {
    LOGGER.info("setCurrentPart called for " + getClass().getName());
    this.currentPart = currentPart;
  }

}
