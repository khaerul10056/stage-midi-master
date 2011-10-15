package org.mda.editor.preview.ui.test;

import static org.junit.Assert.assertTrue;
import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.PreviewEditorContent;

public class PreviewEditorUiTest {

  private MidiPlayerRoot root   = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));

  
  @Test
  public void stepToNextAndPreviousLine () throws Exception {

    Display display = Display.getCurrent();
    Shell shell = new PreviewEditorTester();
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    Text text = editor.getContentpanel().getFocusedTextField();
    assertTrue(text.getText().startsWith("Alle Schöpfung staunt und preist"));
    boolean nextLineAvailable = editor.getContentpanel().stepToNextLine();
    assertTrue(nextLineAvailable);
    assertTrue(text.getText().startsWith("betet an in Wahrheit"));

    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }

    display.dispose();

  }

}
