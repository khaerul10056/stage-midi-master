package org.mda.editor.preview.ui;

import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class AbstractPart extends Composite{

  private static final Log LOGGER  = LogFactory.getLogger(AbstractPart.class);

  private MidiFile midifile;

  private MidiFilePart currentPart;

  private PreviewEditorContent editorContent;



  public AbstractPart (Composite parent) {
    super(parent, SWT.NONE);
    // TODO Auto-generated constructor stub
  }

  public void setMidifile (MidiFile midifile) {
    LOGGER.info("setMidifile called for " + this.getClass().getName());
    this.midifile = midifile;
  }

  public MidiFile getMidifile () {
    return midifile;
  }

  public void setEditorContent (PreviewEditorContent editorContent) {
    this.editorContent = editorContent;
  }

  public PreviewEditorContent getEditorContent () {
    return editorContent;
  }

  public MidiFilePart getCurrentPart () {
    return currentPart;
  }

  public void setCurrentPart (MidiFilePart currentPart) {
    LOGGER.info("setCurrentPart called for " + getClass().getName());
    this.currentPart = currentPart;
  }

}
