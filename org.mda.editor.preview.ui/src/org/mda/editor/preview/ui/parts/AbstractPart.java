package org.mda.editor.preview.ui.parts;

import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.mda.editor.preview.ui.PreviewEditorContent;


public class AbstractPart extends Composite{

  private MidiFile midifile;

  private PreviewEditorContent editorContent;



  public AbstractPart (Composite parent) {
    super(parent, SWT.NONE);
    // TODO Auto-generated constructor stub
  }

  public void setMidifile (MidiFile midifile) {
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
