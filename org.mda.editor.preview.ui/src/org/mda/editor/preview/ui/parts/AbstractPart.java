package org.mda.editor.preview.ui.parts;

import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.mda.editor.preview.ui.PreviewEditorContent;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class AbstractPart extends Composite{

  private static final Log LOGGER  = LogFactory.getLogger(AbstractPart.class);

  private MidiFile midifile;

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

}
