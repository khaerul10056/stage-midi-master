package org.mda.editor.preview.ui.test;

import static junit.framework.Assert.assertEquals;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.PreviewEditorContent;
import org.mda.editor.preview.ui.parts.ContentPart;
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

    assertEquals(height, heightNew * 2);
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
      assertEquals (song.getParts().get(i), currentSlide.getModelRef());
    }
    } catch (Exception e) {
      throw new RuntimeException("Error at index " + i + ":" , e);
    }
  }
  
  @Test
  public void toggleChordline () throws Exception {
    
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    shell.setVisible(true);
    editor.getSlidelistpanel().getSlideItems().get(1).showPartOnContentScreen();
    
    logEditorContent(editor.getContentpanel());
    
  }
  
  private void logEditorContent (final ContentPart contentPart) {
    List <String> chords = new ArrayList<String>(); 
    List <String> texts = new ArrayList<String>();
    
    assertEquals (chords.size(), texts.size());
    
    for (Label nextLabel: contentPart.getChordLines()) {
      chords.add(nextLabel.getText());
    }
    
    for (Text nextText: contentPart.getTextLines()) {
      texts.add(nextText.getText());
    }
    
    for (int i = 0; i <  chords.size(); i++) {
      System.out.println ("|" + chords.get(i) + "|");
      System.out.println ("|" + texts.get(i) + "|");
    }
       
    
  }
  
  @Test
  public void stepToNextAndPreviousLine () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    shell.setVisible(true);
    //editor.getContentpanel().
    
  }

}
