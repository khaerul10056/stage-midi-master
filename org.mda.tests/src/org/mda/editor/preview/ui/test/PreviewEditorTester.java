package org.mda.editor.preview.ui.test;

import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.PreviewEditorComposite;

public class PreviewEditorTester extends Shell {


  private final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
  private PreviewEditorComposite editor;

  public PreviewEditorTester () {
    super ();
    setText("Preview editor tester");
    setLayout(new FillLayout());
    ApplicationSession applicationSession = new ApplicationSession();
    applicationSession.load(null);
    applicationSession.setCurrentMidifile((MidiFile) root.getGallery().getGalleryItems().get(0));
    editor.build(this);
    
  }

  @Override
  protected void checkSubclass () {
  }

  public static void main (String[] args) {
    PreviewEditorTester editorTester = new PreviewEditorTester();
    editorTester.open();
    Display display = editorTester.getDisplay();
    while (!editorTester.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

  public PreviewEditorComposite getEditor () {
    return editor;
  }

  public void setEditor (PreviewEditorComposite editor) {
    this.editor = editor;
  }

}
