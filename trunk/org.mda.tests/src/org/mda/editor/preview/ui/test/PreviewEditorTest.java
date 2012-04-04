package org.mda.editor.preview.ui.test;

import static junit.framework.Assert.assertEquals;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.calculator.Slide;
import org.mda.editor.preview.ui.PreviewEditorContent;
import org.mda.editor.preview.ui.parts.ContentPart;
import org.mda.presenter.ui.test.MidiFileCreator;


public class PreviewEditorTest {

  private Shell shell;

  private PreviewEditorContent editor;

  private MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));



  @Before
  public void setUp () {
    shell = new Shell();
    MdaModule.getInjector().getInstance(ApplicationSession.class).load(null);

  }

  @After
  public void tearDown () {
    if (editor != null)
      editor.dispose();

    shell.dispose();
  }


  @Test
  public void newSong () {
    MidiFile song = MidiFileCreator.create().get();

    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    assertEquals (1, contentPanel.getTextLines().size());
  }

  @Test
  public void moveChords () {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", "Alle ").chordAndText("G", "Schoepfung staunt und").get();
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();

    System.out.println (MidiPlayerService.toString(song.getParts().get(0)));
    contentPanel.setCurrentCaretPosition(2);
    Assert.assertTrue (contentPanel.chordToRight());
    Assert.assertTrue (contentPanel.chordToRight());
    MidiFilePart newPart = contentPanel.saveToModel();
    MidiFileTextLine midiFileTextLine = newPart.getTextlines().get(0);
    Assert.assertEquals ("D", midiFileTextLine.getChordParts().get(0).getChord());
    Assert.assertEquals ("Alle Sc", midiFileTextLine.getChordParts().get(0).getText());
    Assert.assertEquals ("G", midiFileTextLine.getChordParts().get(1).getChord());
    Assert.assertEquals ("hoepfung staunt und", midiFileTextLine.getChordParts().get(1).getText());

    for (int i = 0; i < 40; i++)
      contentPanel.chordToRight();
    newPart = contentPanel.saveToModel();

    midiFileTextLine = newPart.getTextlines().get(0);
    Assert.assertEquals ("G", midiFileTextLine.getChordParts().get(1).getChord());
    Assert.assertEquals ("  ", midiFileTextLine.getChordParts().get(1).getText());


    for (int i = 0; i < 42; i++) {
      Assert.assertTrue (contentPanel.chordToLeft());
    }

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
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).get();

    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    Assert.assertEquals (1, contentPanel.getTextLines().size());
    Assert.assertEquals (1, contentPanel.getChordLines().size());
  }


  @Test
  public void trim () {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D    ", "Hallo    ").get();
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    System.out.println ("<" + contentPanel.getChordLines().get(0).getText() + ">");
    System.out.println ("<" + contentPanel.getTextLines().get(0).getText() + ">");
    MidiFilePart part = contentPanel.saveToModel();
    Assert.assertEquals("D", part.getTextlines().get(0).getChordParts().get(0).getChord());
    Assert.assertEquals("Hallo ", part.getTextlines().get(0).getChordParts().get(0).getText());
  }

  @Test
  public void donttrim () {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", "Hallo    ").chordAndText("D", " ").get();
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    System.out.println ("<" + contentPanel.getChordLines().get(0).getText() + ">");
    System.out.println ("<" + contentPanel.getTextLines().get(0).getText() + ">");
    MidiFilePart part = contentPanel.saveToModel();
    Assert.assertEquals("D", part.getTextlines().get(0).getChordParts().get(0).getChord());
    Assert.assertEquals("Hallo    ", part.getTextlines().get(0).getChordParts().get(0).getText());
    Assert.assertEquals("D", part.getTextlines().get(0).getChordParts().get(1).getChord());
    Assert.assertEquals(" ", part.getTextlines().get(0).getChordParts().get(1).getText());
  }



  @Test
  public void removeLast () {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chord("D").chord("G").chord("A").chord("G").get();

    /**
     * <D G A G  D G A   >
<                >
2012-03-24 21:24:36,127 INFO org.mda.editor.preview.ui.parts.SlideItemPanel ReplacedText : < >
2012-03-24 21:24:36,128 INFO org.mda.editor.preview.ui.parts.SlideItemPanel Modified     : <16-0
     */
    ContentPart.listenersActive = false;

    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    contentPanel.getChordLines().get(0).setText("D G A G  D G A   ");
    Listener[] listeners = contentPanel.getTextLines().get(0).getListeners(SWT.Modify);
    for (Listener next: listeners) {
      contentPanel.getTextLines().get(0).removeExtendedModifyListener((ExtendedModifyListener) next);
    }
    contentPanel.getTextLines().get(0).setText ("                ");

    contentPanel.doModifyText(" ", 16, 0);
  }

  @Test
  public void chordlineLongerAsTextLIne () {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", "This is a").chordAndText("Ab", "").get();

    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    MidiFilePart saveToModel = contentPanel.saveToModel();
    MidiFileChordPart midiFileChordPart = saveToModel.getTextlines().get(0).getChordParts().get(1);
    Assert.assertEquals (midiFileChordPart.getText().length(), midiFileChordPart.getChord().length());
  }

  @Test
  public void editChordAfterText () {
    MidiFile song = MidiFileCreator.create().part(MidiFilePartType.INTRO).line().chordAndText("D", "Hello").chordAndText("D", "  ").get();
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    contentPanel.setCurrentPart(song.getParts().get(0));
    contentPanel.setCurrentFocusedLine(0);
    contentPanel.setCurrentCaretPosition(5);
    contentPanel.editChord(editor.getContentpanel().getChordLines().get(0), editor.getContentpanel().getTextLines().get(0), 5, "Eb", "");

    MidiFilePart saveToModel = contentPanel.saveToModel();
    MidiFileChordPart chordpart1 = saveToModel.getTextlines().get(0).getChordParts().get(0);
    Assert.assertEquals ("D", chordpart1.getChord().trim());
    Assert.assertEquals ("Hello", chordpart1.getText());

    MidiFileChordPart chordpart2 = saveToModel.getTextlines().get(0).getChordParts().get(1);
    Assert.assertEquals ("Eb", chordpart2.getChord().trim());
    Assert.assertEquals ("  ", chordpart2.getText());

  }

  @Test
  public void editChord () {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    ContentPart contentPanel = editor.getContentpanel();
    contentPanel.setCurrentPart(song.getParts().get(1));
    contentPanel.setCurrentFocusedLine(0);
    contentPanel.setCurrentCaretPosition(0);
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
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    editor.getContentpanel().stepToNextLine();
    Assert.assertEquals (1, editor.getContentpanel().getCurrentFocusedLine());
    oldModel = editor.getContentpanel().saveToModel();

    Assert.assertEquals (1, editor.getContentpanel().getCurrentFocusedLine());


    logEditorContent(editor.getContentpanel());
    //check if multiple save-process change the model
    for (int i = 0; i< 10; i++) {
      MidiFilePart saveToModel = editor.getContentpanel().saveToModel();
      editor.getContentpanel().setCurrentPart(saveToModel);
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
    shell.setSize(new Point (800, 1600));
    editor.getContentpanel().setCurrentPart(song.getParts().get(0));

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

    int i = 0;
    try {

    for (i = 0; i < editor.getSlidelistpanel().getSlideItems().size(); i++) {
      editor.getSlidelistpanel().getSlideItems().get(i).select();
      Slide currentSlide = editor.getContentpanel().getCurrentSlide();
      assertEquals (song.getParts().get(i), editor.getPreviewpanel().getCurrentSlide().getModelRef());
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


}
