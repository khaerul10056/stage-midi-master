package org.mda.importer;

import java.util.ArrayList;
import java.util.List;

import mda.SongChordPart;
import mda.SongPartType;

import org.mda.MidiPlayerService;
import org.mda.Utils;

public class TextImporterLine {

  private String               content;

  private TextImporterConfigIF config;

  private TextImporterLine     previousLine;

  private String getEmptyString(int length) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++)
      builder.append(" ");
    return builder.toString();
  }

  private String getTextWithoutWhitespaces(String content) {
    int tablen = config.getTabulatorWidth().intValue();
    do {
      int pos = content.indexOf("\t");
      if (pos >= 0) {
        int len = tablen - (pos % tablen);
        content = content.replaceFirst("\t", getEmptyString(len));
      }
    } while (content.indexOf("\t") >= 0);

    return content;

  }

  public TextImporterLine(final TextImporterConfigIF config, final String content, final TextImporterLine previousLine) {
    this.config = config;
    this.previousLine = previousLine;
    this.content = getTextWithoutWhitespaces(content);

  }

  private String getContent() {
    return content;
  }

  /**
   * parttype
   *
   * @return <code>null</code>, if this is not the beginning of a midipart
   */
  public SongPartType getPartType() {
    SongPartType[] values = SongPartType.values();
    for (SongPartType nextValue : values) {
      if (getContent().toUpperCase().startsWith(nextValue.getName().toUpperCase())) return nextValue;
    }

    return null;

  }

  /**
   * checks if the current line contains only chords (is a chordline)
   *
   * @return true/false
   */
  public boolean isChordLine() {
    int maxTokenLen = 0;
    String[] tokens = getContent().split(" ");
    for (String nextToken : tokens) { // todo: check tokens with chords
      // (implement a Chord-Class)
      if (nextToken.length() > maxTokenLen && nextToken.indexOf("/") < 0) maxTokenLen = nextToken.length();
    }

    return maxTokenLen < 3;
  }

  public List<SongChordPart> getChordParts() {
    List<SongChordPart> parts = new ArrayList<SongChordPart>();

    if (previousLine != null && !previousLine.isChordLine()) {
      SongChordPart singleChorPart = MidiPlayerService.mf.createSongChordPart();
      singleChorPart.setText(getContent());
      parts.add(singleChorPart);
    }
    else {
    	String previousLineContent = previousLine != null ? previousLine.getContent(): null;
      parts.addAll(Utils.getChordPartsFromText(getContent(), previousLineContent));
    }

    return parts;
  }



}
