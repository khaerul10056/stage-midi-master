package org.mda.editor.preview.ui.test;

import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.PreviewEditorContent;

public class PreviewEditorTester extends Shell {


  private final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));

  public PreviewEditorTester () {
    super ();
    setText("Preview editor tester");
    setLayout(new FillLayout());
    PreviewEditorContent editor = new PreviewEditorContent(this, (MidiFile) root.getGallery().getGalleryItems().get(0));
  }

  @Override
  protected void checkSubclass () {
  }

  public static void main (String[] args) {

    PreviewEditorTester editorTester = new PreviewEditorTester();
    Display display = editorTester.getDisplay();
    editorTester.setVisible(true);
    while (!editorTester.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

}
