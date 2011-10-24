package org.mda.editor.preview.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.PreviewEditorContent;

public class PreviewEditorUiTest {

  private MidiPlayerRoot root   = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));



  @Test
  public void stepToNextAndPreviousLine () throws Exception {

    Shell shell = new PreviewEditorTester();
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //step to next line (current caretposition in nextline not out of limits)  (1->2)
    StyledText text = editor.getContentpanel().getTextLines().get(editor.getContentpanel().getFocusedTextField());
    text.setCaretOffset(3);

    assertTrue(text.getText().startsWith("Alle Schöpfung staunt und preist"));  //line 1
    assertTrue(editor.getContentpanel().stepToNextLine());

    text = editor.getContentpanel().getTextLines().get(editor.getContentpanel().getFocusedTextField()); //line 2
    assertTrue(text.getText().startsWith("Ehre Dir auf Deinem Thron"));
    assertEquals (3, text.getCaretOffset());

    //step to next line (current caretposition in nextline greater than current length) (3->4) / 58
    assertTrue(editor.getContentpanel().stepToNextLine()); //line 3
    text = editor.getContentpanel().getTextLines().get(editor.getContentpanel().getFocusedTextField());
    assertTrue(text.getText().startsWith("Alle Schöpfung"));
    text.setCaretOffset(58);

    assertTrue(editor.getContentpanel().stepToNextLine()); //line 4
    text = editor.getContentpanel().getTextLines().get(editor.getContentpanel().getFocusedTextField());
    assertTrue(text.getText().startsWith("Du bist Gott und Du regierst"));
    assertEquals (text.getText().length(), text.getCaretOffset());


    //step on last line to next line (4->4)
    assertFalse(editor.getContentpanel().stepToNextLine()); //should not work, because we are in last line already

    //step to previous line (4->3)
    assertTrue(editor.getContentpanel().stepToPreviousLine()); //line 3
    text = editor.getContentpanel().getTextLines().get(editor.getContentpanel().getFocusedTextField());
    assertTrue(text.getText().startsWith("Alle Schöpfung"));
    text.setCaretOffset(58);

    //step to previous line (current caretposition in nextline greater than current length (3->2) / 58
    assertTrue(editor.getContentpanel().stepToPreviousLine()); //line 3
    text = editor.getContentpanel().getTextLines().get(editor.getContentpanel().getFocusedTextField());
    assertTrue(text.getText().startsWith("Ehre Dir auf Deinem Thron"));
    assertEquals (text.getText().length(), text.getCaretOffset());

    editor.dispose();


  }

  @Test
  public void splitLineEndOfChordpart () throws Exception {
    Shell shell = new PreviewEditorTester();
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals("D    G                    A       D           G               A", chord.getText());
    assertEquals("Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist,", text.getText());  //line 1

    text.setCaretOffset(34);

    editor.getContentpanel().splitLine();


    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    Label chord2 = editor.getContentpanel().getChordLines().get(1);

    assertEquals("D    G                    A", chord.getText());
    assertEquals("Alle Schöpfung staunt und preist,", text.getText());
    assertEquals("D           G               A", chord2.getText());
    assertEquals("betet an in Wahrheit und in Geist,", text2.getText());

    editor.dispose();
  }

  @Test
  public void splitLineMidChordpart () throws Exception {
    Shell shell = new PreviewEditorTester();
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals("D    G                    A       D           G               A", chord.getText());
    assertEquals("Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist,", text.getText());  //line 1

    text.setCaretOffset(14);

    editor.getContentpanel().splitLine();


    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    Label chord2 = editor.getContentpanel().getChordLines().get(1);

    assertEquals("D    G", chord.getText());
    assertEquals("Alle Schöpfung", text.getText());

    assertEquals("            A       D           G               A", chord2.getText());
    assertEquals(" staunt und preist, betet an in Wahrheit und in Geist,", text2.getText());
    editor.dispose();
  }

  @Test
  public void splitLineAtHome () throws Exception {
    Shell shell = new PreviewEditorTester();
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals("D    G                    A       D           G               A", chord.getText());
    assertEquals("Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist,", text.getText());  //line 1

    text.setCaretOffset(0);

    editor.getContentpanel().splitLine();


    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    Label chord2 = editor.getContentpanel().getChordLines().get(1);

    assertEquals("", chord.getText());
    assertEquals("", text.getText());

    assertEquals("D    G                    A       D           G               A", chord2.getText());
    assertEquals("Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist,", text2.getText());  //line 1
    editor.dispose();
  }

  @Test
  public void splitLineAtEnd () throws Exception {
    Shell shell = new PreviewEditorTester();
    MidiFile song = (MidiFile) root.getGallery().getGalleryItems().get(0);
    PreviewEditorContent editor = new PreviewEditorContent(shell, song);
    editor.getContentpanel().showSlide(song.getParts().get(1));
    shell.setVisible(true);

    //split a line at the beginning of an chordpart
    editor.getContentpanel().getChordLines().get(0);
    StyledText text = editor.getContentpanel().getTextLines().get(0);
    Label chord = editor.getContentpanel().getChordLines().get(0);

    assertEquals("D    G                    A       D           G               A", chord.getText());
    assertEquals("Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist,", text.getText());  //line 1

    text.setCaretOffset(text.getText().length());

    editor.getContentpanel().splitLine();


    text = editor.getContentpanel().getTextLines().get(0);
    chord = editor.getContentpanel().getChordLines().get(0);
    StyledText text2 = editor.getContentpanel().getTextLines().get(1);
    Label chord2 = editor.getContentpanel().getChordLines().get(1);

    assertEquals("", chord2.getText());
    assertEquals("", text2.getText());

    assertEquals("D    G                    A       D           G               A", chord.getText());
    assertEquals("Alle Schöpfung staunt und preist, betet an in Wahrheit und in Geist,", text.getText());  //line 1
    editor.dispose();
  }


}
