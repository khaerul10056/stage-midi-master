package org.mda.editor.preview.ui;

import mda.MidiFile;
import mda.MidiFilePart;

import org.eclipse.swt.widgets.Composite;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class AbstractPart {

  private static final Log LOGGER  = LogFactory.getLogger(AbstractPart.class);

  private MidiFile midifile;

  private MidiFilePart currentPart;

  private PreviewEditorComposite editorComposite;
  
  protected Composite comp;
  
  public Composite getComp () {
	  return comp;
  }
 

  public void setMidifile (MidiFile midifile) {
    LOGGER.info("setMidifile called for " + this.getClass().getName());
    this.midifile = midifile;
  }

  public MidiFile getMidifile () {
    return midifile;
  }

  public void setEditorComposite (PreviewEditorComposite editorContent) {
    this.editorComposite = editorContent;
  }

  public PreviewEditorComposite getEditorComposite () {
    return editorComposite;
  }

  public MidiFilePart getCurrentPart () {
    return currentPart;
  }

  public void setCurrentPart (MidiFilePart currentPart) {
    LOGGER.info("setCurrentPart called for " + getClass().getName());
    this.currentPart = currentPart;
  }

}
