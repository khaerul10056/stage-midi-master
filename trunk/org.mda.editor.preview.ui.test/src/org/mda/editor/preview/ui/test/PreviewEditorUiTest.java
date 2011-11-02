package org.mda.editor.preview.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import mda.MidiFile;
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

  private MidiPlayerRoot root   = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
  private final String TEXTLINEORIGINAL = "Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist,";
  private final String CHORDLINEORIGINAL = "D    G                    A       D           G               A";
  private Shell shell;
  private PreviewEditorContent editor;

  @Test
  public void deleteWhenSelected () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());

    text.setFocus();
    text.setCaretOffset(15);
    text.setSelection(15, 32);
    editor.getContentpanel().deleteCharacter();

    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    assertEquals ("Alle Schöpfung , betet an in Wahrheit und in Geist,", text.getText());
    assertEquals ("D    G           D           G               A", chord.getText());
  }

  @Test
  public void typeWhenSelected () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());

    text.setFocus();
    text.setCaretOffset(15);
    text.setSelection(15, 32);
    editor.getContentpanel().input('A');

    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);

    System.out.println (MidiPlayerService.getRawText(editor.getContentpanel().getCurrentPart()));
    //     |                    |       |
    //Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist
    //               _________________
    assertEquals ("Alle Schöpfung A, betet an in Wahrheit und in Geist,", text.getText());
    assertEquals ("D    G            D           G               A", chord.getText());
  }

  @Test
  public void stepToNextAndPreviousLine () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

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
    shell = new PreviewEditorTester();
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

  @Test
  public void splitAndMergeThirdLine () throws Exception {
    final String TEXTLINEORIGINAL  = "Alle Schöpfung singt ein Lob, Du bist mächtig, Du bist groß.";
    final String CHORDLINEORIGINAL = "D    G                   A    D       G                A";
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(2);
    Label chord = editor.getContentpanel().getChordLines().get(2);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1

    text.setCaretOffset(15);
    text.setFocus();

    editor.getContentpanel().splitLine();

    assertEquals (3, editor.getContentpanel().getFocusedTextFieldIndex());
    assertEquals (0, editor.getContentpanel().getCaretOffsetOfCurrentTextField());
  }

  @Test
  public void splitLineEndOfChordpart () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
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

    assertEquals("D    G                    A", chord.getText());
    assertEquals("Alle Schöpfung staunt und preist,", text.getText());
    assertEquals("D           G               A", chord2.getText());
    assertEquals("betet an in Wahrheit und in Geist,", text2.getText());
    assertEquals (text2, editor.getContentpanel().getFocusedTextField());
    assertEquals (0, text2.getCaretOffset());
    editor.getContentpanel().mergeLine();

    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals (text, editor.getContentpanel().getFocusedTextField());
    assertEquals (33, editor.getContentpanel().getCaretOffsetOfCurrentTextField());
    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1
  }

  @Test
  public void splitLineMidChordpart () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1

    text.setCaretOffset(14);

    editor.getContentpanel().splitLine();


    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    Label chord2 = editor.getContentpanel().getChordLines().get(1);

    assertEquals (text2, editor.getContentpanel().getFocusedTextField());

    assertEquals("D    G", chord.getText());
    assertEquals("Alle Schöpfung", text.getText());

    assertEquals("            A       D           G               A", chord2.getText());
    assertEquals(" staunt und preist, betet an in Wahrheit und in Geist,", text2.getText());
  }

  @Test
  public void splitLineAtHome () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1

    text.setCaretOffset(0);

    editor.getContentpanel().splitLine();


    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    Label chord2 = editor.getContentpanel().getChordLines().get(1);

    assertEquals("", chord.getText());
    assertEquals("", text.getText());

    assertEquals(CHORDLINEORIGINAL, chord2.getText());
    assertEquals(TEXTLINEORIGINAL, text2.getText());  //line 1
  }

  @Test
  public void splitLineAtEnd () throws Exception {
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1

    text.setCaretOffset(text.getText().length());

    editor.getContentpanel().splitLine();


    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    Label chord2 = editor.getContentpanel().getChordLines().get(1);

    assertEquals("", chord2.getText());
    assertEquals("", text2.getText());

    assertEquals(CHORDLINEORIGINAL, chord.getText());
    assertEquals(TEXTLINEORIGINAL, text.getText());  //line 1
  }


}
