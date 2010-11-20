package org.mda.ui;

import java.awt.Color;
import java.awt.Font;

import mda.MidiFilePartType;

public class PresentationEditorConfig extends DefaultMidiFileContentEditorConfig {

  public PresentationEditorConfig () {
    setEditable(false);
    setShowOnlyCurrentPart(true);
    setBackgroundColor (Color.BLACK);
    setForegroundColor (Color.WHITE);
    setChordVisible(false);
    addIgnoredPartType (MidiFilePartType.INTRO);
    addIgnoredPartType (MidiFilePartType.EXTRO);
    addIgnoredPartType (MidiFilePartType.SOLO);
    setFont(new Font(Font.DIALOG, Font.BOLD, 70));
  }

}
