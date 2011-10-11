package org.mda.editor.preview.ui;

import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.mda.MidiPlayerService;


public class OpenPreviewEditorHandler implements IHandler {

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
    MidiPlayerRoot playerroot = MidiPlayerService.loadRootObject(new File("/home/oleym/privat/soundOfFaith/stage-midi-master/org.mda.core.test/testdata/testmodel.conf")); //TODO get selected

    IEditorInput editorInput = new MidiFileEditorInput((MidiFile) playerroot.getGallery().getGalleryItems().get(0));
    IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    IWorkbenchPage page = window.getActivePage();


    try {
      final IEditorPart openEditor = page.openEditor(editorInput, "org.mda.editor.preview.ui.editors.previeweditor");
    }
    catch (PartInitException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
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
