package org.mda.editor.preview.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class PreviewEditor extends EditorPart {

  private MidiFileEditorInput meei;

  @Override
  public void doSave (IProgressMonitor monitor) {
    // TODO Auto-generated method stub

  }

  @Override
  public void doSaveAs () {
    // TODO Auto-generated method stub

  }

  @Override
  public void init (IEditorSite site, IEditorInput input) throws PartInitException {
    setSite(site);
    setInput(input);

    meei = (MidiFileEditorInput) input;
  }

  @Override
  public boolean isDirty () {
    return false;
  }

  @Override
  public boolean isSaveAsAllowed () {
    return false;
  }

  @Override
  public void createPartControl (Composite parent) {
    PreviewEditorContent content = new PreviewEditorContent(parent, meei.getRootObject());

  }

  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }


}
