package org.mda.editor.preview.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiPlayerRoot;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.editor.preview.ui.PreviewEditorComposite;
import org.mda.editor.preview.ui.parts.TextLine;
import org.mda.presenter.ui.test.MidiFileCreator;

public class PreviewEditorUiTest {

  private MidiPlayerRoot root   = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
  private final String CHORDLINEORIGINAL = "D    G                    A       D           G               A";
  private final String TEXTLINEORIGINAL  = "Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist,";
  private static Shell shell;
  private PreviewEditorComposite editor;
  
  private static ApplicationSession applicationSession;


  /**
   * checks mergeCurrentLine
   * @param expectedLines number of lines expected after merge
   * @param focusedLine  focus this line
   * @param caretPos   set caret at this position, -1 sets it to the end of the line
   */
  private void mergeCurrentLineAndCheckLines (final int expectedLines, final int focusedLine, int caretPos) {
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.REFRAIN);
    creator = creator.line().text("The first line").line().text("The second line");
    MidiFile midiFile = creator.get();
    
    applicationSession.setCurrentMidifile(midiFile);  
    editor.build(shell);
    
    editor.setCurrentPart(midiFile.getParts().get(0));
    editor.getContentpanel().setCurrentFocusedLine(focusedLine);

    int length = editor.getContentpanel().getFocusedTextField().getText().length();
    if (caretPos == -1)
      caretPos = length;
    editor.getContentpanel().setCurrentCaretPosition(caretPos);
    editor.getContentpanel().mergeCurrentLineWithNextLine();
    Assert.assertEquals (expectedLines, editor.getContentpanel().getTextLines().size());
  }

  @Test
  public void mergeCurrentLineWithNextLineNotAtEndOfLine () {
    mergeCurrentLineAndCheckLines(2, 0, 0);
  }

  @Test
  public void mergeCurrentLineWithNextLineAtEndOfLine () {
    mergeCurrentLineAndCheckLines(1, 0, -1);
  }

  @Test
  public void mergeCurrentLineWithNextLineAtLastLine () {
    mergeCurrentLineAndCheckLines(2, 1, -1);
  }


  @Test
  public void deleteWhenSelected () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    StyledText chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(Utils.fillString(TEXTLINEORIGINAL, TextLine.TEXTLINE_LENGTH), text.getText());

    text.setFocus();
    text.setCaretOffset(15);
    text.setSelection(15, 32);
  }


  @Test
  public void stepToEndOfLine () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //step to next line (current caretposition in nextline not out of limits)  (1->2)
    StyledText text = editor.getContentpanel().getFocusedTextField();
    text.setCaretOffset(3);

    editor.getContentpanel().stepToEndOfLine();

    int lengthOfLine = text.getText().length();
    int trimmedLengthOfLine = text.getText().trim().length();

    Assert.assertTrue ("Nothing to trim in line <" + text.getText() + ">", lengthOfLine > trimmedLengthOfLine);
    Assert.assertEquals ("End of line not correct set in line <" + text.getText() + ">" , trimmedLengthOfLine, editor.getContentpanel().getFocusedTextField().getCaretOffset());

  }

  @Test
  public void stepToNextAndPreviousLine () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //step to next line (current caretposition in nextline not out of limits)  (1->2)
    StyledText text = editor.getContentpanel().getFocusedTextField();
    text.setCaretOffset(3);

    assertTrue(text.getText().startsWith("Alle Schöpfung staunt und preist"));  //line 1
    assertTrue(editor.getContentpanel().stepToNextLine());

    text = editor.getContentpanel().getFocusedTextField(); //line 2
    assertTrue(text.getText().startsWith("Ehre Dir auf Deinem Thron"));
    assertEquals (3, text.getCaretOffset());

    //step to next line (current caretposition in nextline greater than current length) (3->4) / 58
    assertTrue(editor.getContentpanel().stepToNextLine()); //line 3
    text = editor.getContentpanel().getFocusedTextField();
    assertTrue(text.getText().startsWith("Alle Schöpfung"));
    text.setCaretOffset(58);

    assertTrue(editor.getContentpanel().stepToNextLine()); //line 4
    text = editor.getContentpanel().getFocusedTextField();
    assertTrue(text.getText().startsWith("Du bist Gott und Du regierst"));
    assertEquals (58, text.getCaretOffset());


    //step on last line to next line (4->4)
    assertFalse(editor.getContentpanel().stepToNextLine()); //should not work, because we are in last line already

    //step to previous line (4->3)
    assertTrue(editor.getContentpanel().stepToPreviousLine()); //line 3
    text = editor.getContentpanel().getFocusedTextField();
    assertTrue(text.getText().startsWith("Alle Schöpfung"));
    text.setCaretOffset(58);

    //step to previous line (current caretposition in nextline greater than current length (3->2) / 58
    assertTrue(editor.getContentpanel().stepToPreviousLine()); //line 3
    text = editor.getContentpanel().getFocusedTextField();
    assertTrue(text.getText().startsWith("Ehre Dir auf Deinem Thron"));
    assertEquals (58, text.getCaretOffset());
  }

  @BeforeClass
  public static void setup () {
    shell = new Shell ();
  }



  private void saveAndShowRoundtrip () {
    MidiFilePart saveToModel = editor.getContentpanel().saveToModel();
    editor.getContentpanel().setCurrentPart(saveToModel);
  }

  @Test
  public void splitAndMergeMiddleOfLinePart () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));
    saveAndShowRoundtrip();

    //split a line at the beginning of an chordpart

    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(0).getText());  //line 1

    getText(0).setCaretOffset(15);
    editor.getContentpanel().saveCurrentCaretSituation();

    editor.getContentpanel().splitLine();
    saveAndShowRoundtrip();

    assertEquals("D    G", getChord(0).getText());
    assertEquals(fill("Alle Schöpfung"), getText(0).getText());  //line 1

    assertEquals("           A       D           G               A", getChord(1).getText());  //line 2
    assertEquals(fill("staunt und preist, betet an in Wahrheit und in Geist,"), getText(1).getText());

  }

  public String fill (String text) {
    return Utils.fillString(text, TextLine.TEXTLINE_LENGTH);
  }

  @Test
  public void splitAndMergeThirdLine () throws Exception {
    final String TEXTLINEORIGINAL  = "Alle Schöpfung singt ein Lob, Du bist mächtig, Du bist groß.";
    final String CHORDLINEORIGINAL = "D    G                   A    D       G                A";
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    TextLine text = editor.getContentpanel().getTextLines().get(2);
    StyledText chord = editor.getContentpanel().getChordLines().get(2);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(fill(TEXTLINEORIGINAL), text.getText());  //line 1

    editor.getContentpanel().setCurrentCaretPosition(15);
    editor.getContentpanel().setFocus(text);

    editor.getContentpanel().splitLine();

    assertEquals (3, editor.getContentpanel().getCurrentFocusedLine());
    assertEquals (0, editor.getContentpanel().getCaretOffsetOfCurrentTextField());
  }

  @Test
  public void splitLineEndOfChordpart () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    StyledText chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(fill(TEXTLINEORIGINAL), text.getText());  //line 1

    text.setCaretOffset(34);
    editor.getContentpanel().saveCurrentCaretSituation();

    editor.getContentpanel().splitLine();

    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    StyledText chord2 = editor.getContentpanel().getChordLines().get(1);
    assertEquals (text2, editor.getContentpanel().getFocusedTextField());

    assertEquals("D    G                    A", chord.getText());
    assertEquals(fill("Alle Schöpfung staunt und preist,"), text.getText());
    assertEquals("D           G               A", chord2.getText());
    assertEquals(fill("betet an in Wahrheit und in Geist,"), text2.getText());
    assertEquals (text2, editor.getContentpanel().getFocusedTextField());
    assertEquals (0, text2.getCaretOffset());
    editor.getContentpanel().mergePreviousLineWithCurrentLine();

    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals (text, editor.getContentpanel().getFocusedTextField());
    assertEquals (33, editor.getContentpanel().getCaretOffsetOfCurrentTextField());
    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(fill(TEXTLINEORIGINAL), text.getText());  //line 1
  }

  @Test
  public void splitLineMidChordpart () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(0).getText());  //line 1

    getText(0).setCaretOffset(14);
    editor.getContentpanel().saveCurrentCaretSituation();
    editor.getContentpanel().splitLine();
    assertEquals (getText(1), editor.getContentpanel().getFocusedTextField());

    assertEquals("D    G", getChord(0).getText());
    assertEquals(fill("Alle Schöpfung"), getText(0).getText());

    assertEquals("            A       D           G               A", getChord(1).getText());
    assertEquals(fill(" staunt und preist, betet an in Wahrheit und in Geist,"), getText(1).getText());

    editor.getContentpanel().mergePreviousLineWithCurrentLine();
    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(0).getText());  //line 1
  }

  private StyledText getText (final int pos) {
    return editor.getContentpanel().getTextLines().get(pos);
  }

  private StyledText getChord (final int pos) {
    return editor.getContentpanel().getChordLines().get(pos);
  }

  @Test
  public void splitAndMergeLineAtHome () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(0).getText());  //line 1

    getText(0).setCaretOffset(0);
    editor.getContentpanel().saveCurrentCaretSituation();

    editor.getContentpanel().splitLine();

    assertEquals("", getChord(0).getText());
    assertEquals(fill(""), getText(0).getText());

    assertEquals(CHORDLINEORIGINAL, getChord(1).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(1).getText());  //line 1

    editor.getContentpanel().mergePreviousLineWithCurrentLine();
    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(0).getText());  //line 1
  }

  @Test
  public void splitAndMergeAtEndOfLine () throws Exception {
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.VERS);
    creator =  creator.line().chordAndText("H", "Dies ist ein Test");
    MidiFile song = creator.line().chordAndText("H", "another line").get();
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(0));
    getText(0).setCaretOffset(17); //To end of line
    editor.getContentpanel().saveCurrentCaretSituation();
    editor.getContentpanel().splitLine();

    assertEquals("", getChord(1).getText());
    assertEquals(fill(" "), getText(1).getText());

    editor.getContentpanel().mergePreviousLineWithCurrentLine();
    assertEquals(fill("Dies ist ein Test "), getText(0).getText());  //line 0
    assertEquals (2, editor.getContentpanel().getTextLines().size());
  }

  @Test
  public void splitAndMergeAtEndOfLastLine () throws Exception {
    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.VERS);
    MidiFile song =  creator.line().chordAndText("H", "Dies ist ein Test").get();
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(0));
    getText(0).setCaretOffset(17); //To end of line
    editor.getContentpanel().saveCurrentCaretSituation();
    editor.getContentpanel().splitLine();

    assertEquals("", getChord(1).getText());
    assertEquals(fill(" "), getText(1).getText());

    editor.getContentpanel().mergePreviousLineWithCurrentLine();
    assertEquals(fill("Dies ist ein Test "), getText(0).getText());  //line 0
    assertEquals (1, editor.getContentpanel().getTextLines().size());
  }

  @Test
  public void splitAndMergeLineAtPreEnd () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    
    applicationSession.setCurrentMidifile(song);  
    editor.build(shell);
    
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the end of an chordpart

    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(0).getText());  //line 1

    getText(0).setCaretOffset(getText(0).getText().length() - 1);
    editor.getContentpanel().saveCurrentCaretSituation();

    editor.getContentpanel().splitLine();

    assertEquals("", getChord(1).getText());
    assertEquals(fill(" "), getText(1).getText());

    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(0).getText());  //line 1

    editor.getContentpanel().mergePreviousLineWithCurrentLine();
    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(fill(TEXTLINEORIGINAL), getText(0).getText());  //line 1



  }






}
