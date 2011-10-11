package org.mda.editor.xtext.ui;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.internal.resources.Resource;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput;
import org.mda.MidiPlayerService;
import com.google.inject.Inject;


public class OpenEditorHandler implements IHandler {




  @Override
  public void addHandlerListener (IHandlerListener handlerListener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void dispose () {
    // TODO Auto-generated method stub

  }

  private MidiFile normalize (MidiFile midifile) {
    for (MidiFilePart nextPart: midifile.getParts()) {
      nextPart.setRefPart(null);
      for (MidiFileTextLine nextTextLine: nextPart.getTextlines()) {
        for (MidiFileChordPart chordPart: nextTextLine.getChordParts()) {
          if (chordPart.getText() == null)
            chordPart.setText("");
        }
      }
    }



    return midifile;
  }

  @Override
  public Object execute (ExecutionEvent event) throws ExecutionException {
    System.out.println ("Execute");


    //TODO
    MidiPlayerRoot playerroot = MidiPlayerService.loadRootObject(new File("/home/oleym/privat/soundOfFaith/stage-midi-master/org.mda.core.test/testdata/testmodel.conf")); //TODO get selected

    IWorkspace workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot root = workspace.getRoot();
    IProject project = root.getProject("NewProject");
    IFolder folder = project.getFolder("tmp");
    IFile file = folder.getFile(playerroot.getGallery().getGalleryItems().get(0).getName() + ".mdi");
    try {
    if (!project.exists())
      project.create(null);
    if (!project.isOpen())
      project.open(null);
    if (!folder.exists())
      folder.create(IResource.NONE, true, new NullProgressMonitor());

    if (file.exists())
        file.delete(true, new NullProgressMonitor());

    MidiFile eobject = normalize((MidiFile) playerroot.getGallery().getGalleryItems().get(0));
    String content = Util.getSerializedString(eobject);
    InputStream source = new ByteArrayInputStream(content.getBytes());

    file.create(source, IResource.NONE, new NullProgressMonitor());

    project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

    } catch (CoreException e) {
      e.printStackTrace();
    }





    IEditorInput editorInput = new FileEditorInput(file);
    IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    IWorkbenchPage page = window.getActivePage();


    try {
      final IEditorPart openEditor = page.openEditor(editorInput, "org.mda.editor.xtext.MidiPlayer");
      openEditor.addPropertyListener(new IPropertyListener() {

        @Override
        public void propertyChanged (Object source, int propId) {
          if (propId == AbstractTextEditor.PROP_DIRTY && source == openEditor) {
            XtextEditor part = (XtextEditor) source;
            if (! part.isDirty()) {

              EObject object = Util.getModel(part.getDocument().get());
              System.out.println ("Property " + source + " changed " + propId + " to dirtystate " + part.isDirty());



            }

          }


        }
      });

    }
    catch (PartInitException e) {
      throw new ExecutionException(e.toString(), e);
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
