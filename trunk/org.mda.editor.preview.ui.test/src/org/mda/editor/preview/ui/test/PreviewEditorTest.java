package org.mda.editor.preview.ui.test;

import static junit.framework.Assert.assertEquals;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.calculator.Slide;
import org.mda.editor.preview.ui.PreviewEditorContent;
import org.mda.editor.preview.ui.parts.ContentPart;


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
  public void editChord () {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    contentPanel.showSlide(song.getParts().get(1));
    contentPanel.editChord(editor.getContentpanel().getChordLines().get(0), editor.getContentpanel().getTextLines().get(0), 0, "Eb", "D");
    MidiFilePart saveToModel = contentPanel.saveToModel();
    MidiFileTextLine midiFileTextLine = saveToModel.getTextlines().get(0);
    Assert.assertEquals("Eb", midiFileTextLine.getChordParts().get(0).getChord().trim());

  }

  @Test
  public void saveToModel () {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    MidiFile old = EcoreUtil.copy(song);

    //initialize model, because it is trimmed
    MidiFilePart oldModel = old.getParts().get(1);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    oldModel = editor.getContentpanel().saveToModel();


    logEditorContent(editor.getContentpanel());
    shell.setVisible(true);
    //check if multiple save-process change the model
    for (int i = 0; i< 10; i++) {
      MidiFilePart saveToModel = editor.getContentpanel().saveToModel();
      editor.getContentpanel().showSlide(saveToModel);
      System.out.println("Old: " + MidiPlayerService.toString(oldModel));
      System.out.println("New: " + MidiPlayerService.toString(saveToModel));
      if (i > 0)
        assertEquals(oldModel, saveToModel);
    }

  }



  @Test
  public void zoom () {

    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    shell.setVisible(true);

    int height = editor.getContentpanel().getCurrentSlide().getFont().getFontData() [0].getHeight();

    shell.setSize(new Point (400, 800));

    int heightNew = editor.getContentpanel().getCurrentSlide().getFont().getFontData() [0].getHeight();




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

    editor.dispose();
  }



  private void logEditorContent (final ContentPart contentPart) {
    List <String> chords = new ArrayList<String>();
    List <String> texts = new ArrayList<String>();

    assertEquals (chords.size(), texts.size());

    for (Label nextLabel: contentPart.getChordLines()) {
      chords.add(nextLabel.getText());
    }

    for (StyledText nextText: contentPart.getTextLines()) {
      texts.add(nextText.getText());
    }

    for (int i = 0; i <  chords.size(); i++) {
      System.out.println ("|" + chords.get(i) + "|");
      System.out.println ("|" + texts.get(i) + "|");
    }





  }

//  private static void displayAllLoadedFonts(Shell shell) {
//    // display all scalable fonts in the system
//    FontData[] fd = shell.getDisplay().getFontList(null, true);
//    for( int i = 0; i < fd.length; i++ ) {
//            System.out.println(fd[i].getName());
//    }
//    // and the non-scalable ones
//    fd = shell.getDisplay().getFontList(null, false);
//    for( int i = 0; i < fd.length; i++ ) {
//            System.out.println(fd[i].getName());
//    }
//}



}
