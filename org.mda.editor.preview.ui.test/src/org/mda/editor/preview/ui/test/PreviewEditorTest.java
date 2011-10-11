package org.mda.editor.preview.ui.test;

import java.io.File;
import junit.framework.Assert;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.PreviewEditorContent;
import org.mda.presenter.ui.slide.Slide;


public class PreviewEditorTest {
  
  private Shell shell; 
  
  private PreviewEditorContent editor;
  
  private MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));

  
  
  @Before
  public void setUp () {
    shell = new Shell();
    shell.setSize(new Point (800, 600));
  }
  
  @After
  public void tearDown () {
    if (editor != null) 
      editor.dispose();
    
    shell.dispose(); 
  }

  @Test
  public void zoom () {
    
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    shell.setVisible(true);

    int height = editor.getContentpanel().getCurrentSlide().getItems().get(0).getFont().getFontData() [0].getHeight();

    shell.setSize(new Point (400, 800));

    int heightNew = editor.getContentpanel().getCurrentSlide().getItems().get(0).getFont().getFontData() [0].getHeight();

    Assert.assertEquals(height, heightNew * 2);
    shell.dispose();
  }


  @Test
  public void stepToPart () throws Exception {
    
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    shell.setVisible(true);
    
    int i = 0;
    try {
     
    for (i = 0; i < editor.getSlidelistpanel().getSlideItems().size(); i++) {
      editor.getSlidelistpanel().getSlideItems().get(i).showPartOnContentScreen();
      Slide currentSlide = editor.getContentpanel().getCurrentSlide();
      Assert.assertEquals (song.getParts().get(i), currentSlide.getModelRef());
    }
    } catch (Exception e) {
      throw new RuntimeException("Error at index " + i + ":" , e);
    }
    
    
    

  }

}
