package org.mda.editor.preview.ui;

import mda.MidiFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.mda.ApplicationSession;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.MidiFileEditorInput;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class PreviewEditor extends EditorPart {

  private static final Log LOGGER  = LogFactory.getLogger(PreviewEditor.class);

  private MidiFileEditorInput meei;

  private LabelProvider provider = new LabelProvider();

  private ApplicationSession  appSession = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  private PreviewEditorContent previewEditorContent;

  @Override
  public void doSave (IProgressMonitor monitor) {
    LOGGER.info("doSave()");
    previewEditorContent.getContentpanel().saveToModel();
    appSession.saveModel();
  }

  @Override
  public void doSaveAs () {
    LOGGER.info("doSaveAs()");
    previewEditorContent.getContentpanel().saveToModel();
  }

  @Override
  public void init (IEditorSite site, IEditorInput input) throws PartInitException {
    setSite(site);
    setInput(input);

    meei = (MidiFileEditorInput) input;
    //setContentDescription(meei.getName());
    setPartName(meei.getName());
    setTitleImage(provider.getImage(meei.getEObject()));
  }

  @Override
  public boolean isDirty () {
    return true;
  }

  @Override
  public boolean isSaveAsAllowed () {
    return false;
  }

  @Override
  public void createPartControl (Composite parent) {
    previewEditorContent = new PreviewEditorContent(parent, (MidiFile) meei.getEObject());

  }

  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }


}
