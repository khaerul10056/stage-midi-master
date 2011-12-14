package org.mda.editor.session.ui;

import java.util.logging.Logger;
import mda.Session;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.mda.commons.ui.ContentProvider;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.MidiFileEditorInput;


public class SessionEditor extends EditorPart {

    private static final Logger LOGGER  = Logger.getLogger(SessionEditor.class.getName());

    private Session session;



    @Override
    public void doSave (IProgressMonitor monitor) {
      LOGGER.info("doSave()");
    }

    @Override
    public void doSaveAs () {
      LOGGER.info("doSaveAs()");
    }

    @Override
    public void init (IEditorSite site, IEditorInput input) throws PartInitException {
      setSite(site);
      setInput(input);
      MidiFileEditorInput editorinput = (MidiFileEditorInput) input;
      session = (Session) editorinput.getEObject();
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

      Table tblSongs = new Table (parent, SWT.NONE);
      TableViewer tblViewer = new TableViewer(tblSongs);
      tblViewer.setContentProvider(new ContentProvider());
      tblViewer.setLabelProvider(new LabelProvider());
      tblViewer.setInput(session);

    }

    @Override
    public void setFocus () {
      // TODO Auto-generated method stub

    }

}
