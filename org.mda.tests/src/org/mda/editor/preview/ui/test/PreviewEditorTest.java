package org.mda.editor.preview.ui.test;

import static junit.framework.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongPartType;
import mda.SongTextLine;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.util.MidiplayerSwitch;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Listener;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.parts.ContentPart;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.Slide;
import org.mda.presenter.ui.test.MidiFileCreator;


public class PreviewEditorTest extends AbstractEditorTest {

  

  private MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));

  private static final Log LOGGER  = LogFactory.getLogger(PreviewEditorTest.class);

  

  

  @Test
  public void synchronizeEmptyChordlineWhenTextWasModified () {
    MidiFileCreator creator = MidiFileCreator.create().part(SongPartType.REFRAIN);
    creator = creator.line().text("supertest");
    Song midiFile = creator.get();
    prepareEditor(midiFile);    
    
    editor.setCurrentPart(midiFile.getParts().get(0));
    editor.getContentpanel().synchronizeChordWhenTextWasModified("t", 5, 0);
  }

  @Test
  public void removeNewSlides () {
    MidiFileCreator creator = MidiFileCreator.create().part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText(" ", " ");
    creator = creator.lineOnNewSlide().chordAndText("D", " ");
    creator = creator.lineOnNewSlide().chordAndText("", "Test");
    Song midiFile = creator.get();
    prepareEditor(midiFile);    
    
    int children = editor.getContentpanel().getComp().getChildren().length;

    editor.setCurrentPart(midiFile.getParts().get(0));
    int childrenAfter = editor.getContentpanel().getComp().getChildren().length;


    editor.setCurrentPart(midiFile.getParts().get(0));
    int childrenAfterAfter = editor.getContentpanel().getComp().getChildren().length;

    Assert.assertEquals (children, childrenAfter);
    Assert.assertEquals (children, childrenAfterAfter);
  }


  @Test
  public void isLineEmpty () {
    MidiFileCreator creator = MidiFileCreator.create().part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText(" ", " ");
    creator = creator.line().chordAndText("D", " ");
    creator = creator.line().chordAndText("", "Test");
    Song midiFile = creator.get();
    prepareEditor(midiFile);
    
    Assert.assertTrue (editor.getContentpanel().isLineEmpty(0));
    Assert.assertFalse (editor.getContentpanel().isLineEmpty(1));
    Assert.assertFalse (editor.getContentpanel().isLineEmpty(2));
  }

  @Test
  public void testCaret () {
    MidiFileCreator creator = MidiFileCreator.create().part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "This is a test");
    creator = creator.line().chordAndText("F", "and another line");
    creator = creator.line().chordAndText("F", "and another line");
    creator = creator.part(SongPartType.VERS);
    creator = creator.line().chordAndText("D", "and only one line");
    Song midiFile = creator.get();
    prepareEditor(midiFile);
    
    logEditorContent(editor.getContentpanel());

    //set new position
    editor.getContentpanel().setCurrentFocusedLine(2);
    editor.getContentpanel().setCurrentCaretPosition(20);
    Assert.assertEquals (2, editor.getContentpanel().getCurrentFocusedLine());
    Assert.assertEquals (20, editor.getContentpanel().getCurrentCaretPosition());
  }

  @Test
  public void stepToNewPart () {
    //select first part
    MidiFileCreator creator = MidiFileCreator.create().part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "This is a test");
    creator = creator.line().chordAndText("F", "and another line");
    creator = creator.line().chordAndText("F", "and another line");
    creator = creator.part(SongPartType.VERS);
    creator = creator.line().chordAndText("D", "and only one line");
    Song midiFile = creator.get();
    prepareEditor(midiFile);
    
    logEditorContent(editor.getContentpanel());

    //set new position
    editor.getContentpanel().setCurrentFocusedLine(2);
    editor.getContentpanel().setCurrentCaretPosition(20);

    //select second part (with invalid position) and step right
    editor.setCurrentPart(midiFile.getParts().get(1));
    editor.getContentpanel().setCurrentCaretPosition(1);
    logEditorContent(editor.getContentpanel());

    Assert.assertEquals (0, editor.getContentpanel().getCurrentFocusedLine());
    Assert.assertEquals (1, editor.getContentpanel().getCurrentCaretPosition());
  }

  @Test
  public void newSong () {
	MidiPlayerRoot root = MidiplayerFactory.eINSTANCE.createMidiPlayerRoot();
    Song song = MidiPlayerService.createSong(root, "Testsong");
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    assertEquals ("Textlines invalid: <" + contentPanel.getTextLines() + ">", 1, contentPanel.getTextLines().size());
  }
  
  

  @Test
  public void moveChords () {
    Song song = MidiFileCreator.create().part(SongPartType.INTRO).line().chordAndText("D", "Alle ").chordAndText("G", "Schoepfung staunt und").get();
    
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();

    LOGGER.info(MidiPlayerService.toString(song.getParts().get(0)));
    contentPanel.setCurrentCaretPosition(2);
    Assert.assertTrue (contentPanel.chordToRight());
    Assert.assertTrue (contentPanel.chordToRight());
    SongPart newPart = contentPanel.saveToModel();
    SongTextLine midiFileTextLine = newPart.getTextlines().get(0);
    Assert.assertEquals ("D", midiFileTextLine.getChordParts().get(0).getChord());
    Assert.assertEquals ("Alle Sc", midiFileTextLine.getChordParts().get(0).getText());
    Assert.assertEquals ("G", midiFileTextLine.getChordParts().get(1).getChord());
    Assert.assertEquals ("hoepfung staunt und", midiFileTextLine.getChordParts().get(1).getText());

    for (int i = 0; i < 40; i++)
      contentPanel.chordToRight();
    newPart = contentPanel.saveToModel();

    midiFileTextLine = newPart.getTextlines().get(0);
    Assert.assertEquals ("G", midiFileTextLine.getChordParts().get(1).getChord());
    Assert.assertEquals (" ", midiFileTextLine.getChordParts().get(1).getText());

    for (int i = 0; i < 42; i++)
      Assert.assertTrue (contentPanel.chordToLeft());

    newPart = contentPanel.saveToModel();
    midiFileTextLine = newPart.getTextlines().get(0);
    Assert.assertEquals ("D", midiFileTextLine.getChordParts().get(0).getChord());
    Assert.assertEquals ("Alle ", midiFileTextLine.getChordParts().get(0).getText());
    Assert.assertEquals ("G", midiFileTextLine.getChordParts().get(1).getChord());
    Assert.assertEquals ("Schoepfung staunt und", midiFileTextLine.getChordParts().get(1).getText());
  }

  @Test
  public void newPart () {
    //create an empty line
    Song song = MidiFileCreator.create().part(SongPartType.INTRO).get();
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    Assert.assertEquals (1, contentPanel.getTextLines().size());
    Assert.assertEquals (1, contentPanel.getChordLines().size());
  }


  @Test
  public void trim () {
    Song song = MidiFileCreator.create().part(SongPartType.INTRO).line().chordAndText("D    ", "Hallo    ").get();
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    SongPart part = contentPanel.saveToModel();
    Assert.assertEquals("D", part.getTextlines().get(0).getChordParts().get(0).getChord());
    Assert.assertEquals("Hallo", part.getTextlines().get(0).getChordParts().get(0).getText());
  }

  @Test
  public void donttrim () {
    Song song = MidiFileCreator.create().part(SongPartType.INTRO).line().chordAndText("D", "Hallo    ").chordAndText("D", " ").get();
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    SongPart part = contentPanel.saveToModel();
    Assert.assertEquals("D", part.getTextlines().get(0).getChordParts().get(0).getChord());
    Assert.assertEquals("Hallo    ", part.getTextlines().get(0).getChordParts().get(0).getText());
    Assert.assertEquals("D", part.getTextlines().get(0).getChordParts().get(1).getChord());
    Assert.assertEquals(" ", part.getTextlines().get(0).getChordParts().get(1).getText());
  }



  @Test
  public void removeLast () {
    Song song = MidiFileCreator.create().part(SongPartType.INTRO).line().chord("D").chord("G").chord("A").chord("G").get();

    /**
     * <D G A G  D G A   >
<                >
2012-03-24 21:24:36,127 INFO org.mda.editor.preview.ui.parts.SlideItemPanel ReplacedText : < >
2012-03-24 21:24:36,128 INFO org.mda.editor.preview.ui.parts.SlideItemPanel Modified     : <16-0
     */
    ContentPart.listenersActive = false;
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    contentPanel.getChordLines().get(0).setText("D G A G  D G A   ");
    Listener[] listeners = contentPanel.getTextLines().get(0).getListeners(SWT.Modify);
    for (Listener next: listeners) {
      contentPanel.getTextLines().get(0).removeExtendedModifyListener((ExtendedModifyListener) next);
    }
    contentPanel.getTextLines().get(0).setText ("                ");

    contentPanel.synchronizeChordWhenTextWasModified(" ", 16, 0);
  }

  @Test
  public void loadAndSavePartWithNewSlide () {
    MidiFileCreator part = MidiFileCreator.create().part(SongPartType.INTRO);
    part = part.line().chordAndText("D", "This is the first line").chordAndText("Ab", "");
    part = part.line().chordAndText("D", "Second line").chordAndText("Ab", "");
    part = part.line().chordAndText("D", "Third line").chordAndText("Ab", "");

    Song song = part.get();
    song.getParts().get(0).getTextlines().get(2).setNewSlide(true);
    
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    SongPart saveToModel = contentPanel.saveToModel();
    Assert.assertTrue ("newSlide is not saved", saveToModel.getTextlines().get(2).isNewSlide());

  }

  @Test
  public void chordlineLongerAsTextLIne () {
    Song song = MidiFileCreator.create().part(SongPartType.INTRO).line().chordAndText("D", "This is a").chordAndText("Ab", "").get();
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    SongPart saveToModel = contentPanel.saveToModel();
    SongChordPart midiFileChordPart = saveToModel.getTextlines().get(0).getChordParts().get(1);
    Assert.assertEquals (midiFileChordPart.getText().length(), midiFileChordPart.getChord().length());
  }

  @Test
  public void editChordAfterText () {
    Song song = MidiFileCreator.create().part(SongPartType.INTRO).line().chordAndText("D", "Hello").chordAndText("D", "  ").get();
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    contentPanel.setCurrentPart(song.getParts().get(0));
    contentPanel.setCurrentCaretPositionInLine(5, 0);
    contentPanel.editChord(editor.getContentpanel().getChordLines().get(0), editor.getContentpanel().getTextLines().get(0), 5, "Eb", "");

    SongPart saveToModel = contentPanel.saveToModel();
    SongChordPart chordpart1 = saveToModel.getTextlines().get(0).getChordParts().get(0);
    Assert.assertEquals ("D", chordpart1.getChord().trim());
    Assert.assertEquals ("Hello", chordpart1.getText());

    SongChordPart chordpart2 = saveToModel.getTextlines().get(0).getChordParts().get(1);
    Assert.assertEquals ("Eb", chordpart2.getChord().trim());
    Assert.assertEquals ("  ", chordpart2.getText());

  }

  @Test
  public void editChordInNewChordline () {
    Song song = MidiFileCreator.create().part(SongPartType.VERS).line().text("This is new textline").get();
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    contentPanel.setCurrentPart(song.getParts().get(0));

    contentPanel.setCurrentCaretPositionInLine(5, 0);
    contentPanel.editChord(editor.getContentpanel().getChordLines().get(0), editor.getContentpanel().getTextLines().get(0), 5, "Eb", "");


  }

  @Test
  public void editChord () {
    Song song = (Song) root.getGallery().getGalleryItems().get(0);
    prepareEditor(song);
    
    ContentPart contentPanel = editor.getContentpanel();
    contentPanel.setCurrentPart(song.getParts().get(1));
    contentPanel.setCurrentFocusedLine(0);
    contentPanel.setCurrentCaretPosition(0);
    contentPanel.editChord(editor.getContentpanel().getChordLines().get(0), editor.getContentpanel().getTextLines().get(0), 0, "Eb", "D");
    SongPart saveToModel = contentPanel.saveToModel();
    SongTextLine midiFileTextLine = saveToModel.getTextlines().get(0);
    Assert.assertEquals("Eb", midiFileTextLine.getChordParts().get(0).getChord().trim());

  }

  @Test
  public void saveToModel () {
    Song song = (Song) root.getGallery().getGalleryItems().get(0);
    prepareEditor(song);
    
    Song old = EcoreUtil.copy(song);

    //initialize model, because it is trimmed
    SongPart oldModel = old.getParts().get(1);
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    editor.getContentpanel().stepToNextLine();
    Assert.assertEquals (1, editor.getContentpanel().getCurrentFocusedLine());
    oldModel = editor.getContentpanel().saveToModel();

    Assert.assertEquals (1, editor.getContentpanel().getCurrentFocusedLine());


    logEditorContent(editor.getContentpanel());
    //check if multiple save-process change the model
    for (int i = 0; i< 10; i++) {
      SongPart saveToModel = editor.getContentpanel().saveToModel();
      editor.getContentpanel().setCurrentPart(saveToModel);
      LOGGER.info("Old: " + MidiPlayerService.toString(oldModel));
      LOGGER.info("New: " + MidiPlayerService.toString(saveToModel));
      if (i > 0)
        assertEquals(oldModel, saveToModel);
    }

  }



  @Test
  public void stepToPart () throws Exception {
    Song song = (Song) root.getGallery().getGalleryItems().get(0);
    prepareEditor(song);    

    int i = 0;
    try {

    for (i = 0; i < editor.getSlidelistpanel().getSlideItems().size(); i++) {
      editor.getSlidelistpanel().getSlideItems().get(i).select();
      Slide currentSlide = editor.getContentpanel().getCurrentSlide();
      assertEquals (song.getParts().get(i), currentSlide.getModelRef());
    }
    } catch (Exception e) {
      throw new RuntimeException("Error at index " + i + ":" , e);
    }

    editor.getComp().dispose();
  }



  private void logEditorContent (final ContentPart contentPart) {
    List <String> chords = new ArrayList<String>();
    List <String> texts = new ArrayList<String>();

    assertEquals (chords.size(), texts.size());

    for (StyledText nextLabel: contentPart.getChordLines()) {
      chords.add(nextLabel.getText());
    }

    for (StyledText nextText: contentPart.getTextLines()) {
      texts.add(nextText.getText());
    }

    for (int i = 0; i <  chords.size(); i++) {
      LOGGER.info ("|" + chords.get(i) + "|");
      LOGGER.info ("|" + texts.get(i) + "|");
    }
  }


}
