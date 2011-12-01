package org.mda.editor.preview.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import mda.MidiFile;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.mda.ApplicationSession;
import org.mda.commons.ui.MidiFileEditorInput;


public class OpenPreviewEditorHandler implements IHandler {

  private static final Logger LOGGER  = Logger.getLogger(OpenPreviewEditorHandler.class.getName());

  private ApplicationSession session = new ApplicationSession ();

  @Override
  public void addHandlerListener (IHandlerListener handlerListener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void dispose () {
    // TODO Auto-generated method stub

  }

  @Override
  public Object execute (ExecutionEvent event) throws ExecutionException {


    IEditorInput editorInput = new MidiFileEditorInput((MidiFile) session.getCurrentModel().getGallery().getGalleryItems().get(0));
    IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    IWorkbenchPage page = window.getActivePage();
    try {
      page.openEditor(editorInput, "org.mda.editor.preview.ui.editors.previeweditor");
    }
    catch (PartInitException e) {
      LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
    }

    return null;
  }

  @Override
  public boolean isEnabled () {
    return true;
  }

  @Override
  public boolean isHandled () {
    return true;
  }

  @Override
  public void removeHandlerListener (IHandlerListener handlerListener) {
    // TODO Auto-generated method stub

  }

}
