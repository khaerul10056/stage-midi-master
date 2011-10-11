package org.mda.editor.preview.ui.test;

import java.io.File;
import junit.framework.Assert;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.PreviewEditorContent;


public class PreviewEditorTest {


  @Test
  public void zoom () {
    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);


    Shell shell = new Shell();
    shell.setSize(new Point (800, 600));

    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    shell.setVisible(true);

    int height = editor.getContentpanel().getCurrentSlide().getItems().get(0).getFont().getFontData() [0].getHeight();

    shell.setSize(new Point (400, 800));

    int heightNew = editor.getContentpanel().getCurrentSlide().getItems().get(0).getFont().getFontData() [0].getHeight();

    Assert.assertEquals(height, heightNew * 2);
  }

  public void stepToPart () {

  }

}
