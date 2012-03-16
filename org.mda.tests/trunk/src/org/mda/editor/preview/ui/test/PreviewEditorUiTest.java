package org.mda.editor.preview.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiPlayerRoot;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.PreviewEditorContent;

public class PreviewEditorUiTest {

  private MidiPlayerRoot root   = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
  private final String TEXTLINEORIGINAL  = "Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist, ";
  private final String CHORDLINEORIGINAL = "D    G                    A       D           G               A ";
  private Shell shell;
  private PreviewEditorContent editor;



  @Test
  public void deleteWhenSelected () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());

    text.setFocus();
    text.setCaretOffset(15);
    text.setSelection(15, 32);
  }



  @Test
  public void stepToNextAndPreviousLine () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
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
    assertEquals (text.getText().length(), text.getCaretOffset());


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
    assertEquals (text.getText().length(), text.getCaretOffset());
  }

  @Before
  public void setup () {
    shell = new Shell ();
  }

  @After
  public void tearDown () {
    if (shell != null)
      shell.dispose();
    shell = null;

    if (editor != null)
      editor.dispose();
    editor = null;
  }

  private void saveAndShowRoundtrip () {
    MidiFilePart saveToModel = editor.getContentpanel().saveToModel();
    editor.getContentpanel().setCurrentPart(saveToModel);
  }

  @Test
  public void splitAndMergeMiddleOfLinePart () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart

    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(TEXTLINEORIGINAL, getText(0).getText());  //line 1

    getText(0).setCaretOffset(15);

    editor.getContentpanel().splitLine();
    saveAndShowRoundtrip();

    assertEquals("D    G ", getChord(0).getText());
    assertEquals("Alle Schöpfung ", getText(0).getText());  //line 1

    assertEquals("           A       D           G               A ", getChord(1).getText());  //line 2
    assertEquals("staunt und preist, betet an in Wahrheit und in Geist, ", getText(1).getText());

  }

  @Test
  public void splitAndMergeThirdLine () throws Exception {
    final String TEXTLINEORIGINAL  = "Alle Schöpfung singt ein Lob, Du bist mächtig, Du bist groß. ";
    final String CHORDLINEORIGINAL = "D    G                   A    D       G                A ";
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    StyledText text = editor.getContentpanel().getTextLines().get(2);
    Label chord = editor.getContentpanel().getChordLines().get(2);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1

    editor.getContentpanel().setCurrentCaretPosition(15);
    editor.getContentpanel().setFocus(text);

    editor.getContentpanel().splitLine();

    assertEquals (3, editor.getContentpanel().getCurrentFocusedLine());
    assertEquals (0, editor.getContentpanel().getCaretOffsetOfCurrentTextField());
  }

  @Test
  public void splitLineEndOfChordpart () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1

    text.setCaretOffset(34);

    editor.getContentpanel().splitLine();

    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    Label chord2 = editor.getContentpanel().getChordLines().get(1);
    assertEquals (text2, editor.getContentpanel().getFocusedTextField());

    assertEquals("D    G                    A ", chord.getText());
    assertEquals("Alle Schöpfung staunt und preist, ", text.getText());
    assertEquals("D           G               A ", chord2.getText());
    assertEquals("betet an in Wahrheit und in Geist, ", text2.getText());
    assertEquals (text2, editor.getContentpanel().getFocusedTextField());
    assertEquals (0, text2.getCaretOffset());
    editor.getContentpanel().mergeLine();

    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals (text, editor.getContentpanel().getFocusedTextField());
    assertEquals (34, editor.getContentpanel().getCaretOffsetOfCurrentTextField());
    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1
  }

  @Test
  public void splitLineMidChordpart () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(TEXTLINEORIGINAL, getText(0).getText());  //line 1

    getText(0).setCaretOffset(14);
    editor.getContentpanel().splitLine();
    assertEquals (getText(1), editor.getContentpanel().getFocusedTextField());

    assertEquals("D    G ", getChord(0).getText());
    assertEquals("Alle Schöpfung", getText(0).getText());

    assertEquals("            A       D           G               A ", getChord(1).getText());
    assertEquals(" staunt und preist, betet an in Wahrheit und in Geist, ", getText(1).getText());

    editor.getContentpanel().mergeLine();
    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(TEXTLINEORIGINAL, getText(0).getText());  //line 1
  }

  private StyledText getText (final int pos) {
    return editor.getContentpanel().getTextLines().get(pos);
  }

  private Label getChord (final int pos) {
    return editor.getContentpanel().getChordLines().get(pos);
  }

  @Test
  public void splitAndMergeLineAtHome () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the beginning of an chordpart
    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(TEXTLINEORIGINAL, getText(0).getText());  //line 1

    getText(0).setCaretOffset(0);

    editor.getContentpanel().splitLine();

    assertEquals("", getChord(0).getText());
    assertEquals("", getText(0).getText());

    assertEquals(CHORDLINEORIGINAL, getChord(1).getText());
    assertEquals(TEXTLINEORIGINAL, getText(1).getText());  //line 1

    editor.getContentpanel().mergeLine();
    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(TEXTLINEORIGINAL, getText(0).getText());  //line 1
  }

  @Test
  public void splitAndMergeLineAtEnd () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().setCurrentPart(song.getParts().get(1));

    //split a line at the end of an chordpart

    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(TEXTLINEORIGINAL, getText(0).getText());  //line 1

    getText(0).setCaretOffset(getText(0).getText().length() - 1);

    editor.getContentpanel().splitLine();

    assertEquals(" ", getChord(1).getText());
    assertEquals(" ", getText(1).getText());

    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(TEXTLINEORIGINAL.trim(), getText(0).getText());  //line 1

    editor.getContentpanel().mergeLine();
    assertEquals(CHORDLINEORIGINAL, getChord(0).getText());
    assertEquals(TEXTLINEORIGINAL, getText(0).getText());  //line 1



  }






}
