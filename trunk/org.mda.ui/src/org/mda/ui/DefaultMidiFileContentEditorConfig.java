package org.mda.ui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import mda.MidiFilePartType;

import org.mda.MidiFileContentEditorConfigIF;

public class DefaultMidiFileContentEditorConfig implements MidiFileContentEditorConfigIF {

    private boolean chordVisible = true;

    private boolean editable = true;

    private boolean showOnlyCurrentPart = false;

    private Color backgroundColor = Color.WHITE;

    private Color foregroundColor = Color.BLACK;

    private List<MidiFilePartType> partsToIgnore = new ArrayList<MidiFilePartType>();

    private Font font;

    @Override
    public boolean isChordVisible() {
	return chordVisible;
    }

    public void setChordVisible(boolean chordVisible) {
	this.chordVisible = chordVisible;
    }

    public void setEditable(boolean editable) {
      this.editable = editable;
    }

    public boolean isEditable() {
      return editable;
    }

    @Override
    public boolean isShowOnlyCurrentPart() {
      return showOnlyCurrentPart;
    }

    public void setShowOnlyCurrentPart(boolean showOnlyCurrentPart) {
      this.showOnlyCurrentPart = showOnlyCurrentPart;
    }

    public void setBackgroundColor(Color black) {
      this.backgroundColor = black;
    }

    public Color getBackgroundColor () {
      return backgroundColor;
    }

    public void setForegroundColor(Color white) {
      this.foregroundColor  = white;
    }

    public Color getForegroundColor () {
      return foregroundColor;
    }

    public void addIgnoredPartType(MidiFilePartType solo) {
      partsToIgnore.add(solo);
    }

    public boolean isPartIgnored (final MidiFilePartType parttype) {
      return partsToIgnore.contains(parttype);
    }



    public Font getFont() {
      return font;
    }

    public void setFont (Font font) {
      this.font = font;
    }

}
