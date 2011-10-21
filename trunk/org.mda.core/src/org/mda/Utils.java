package org.mda;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import mda.MidiFileChordPart;
import mda.MidiFilePartType;

public class Utils {


  /**
   * splits a string at the given position and returns splitted string as array of strings
   * @param completeString
   * @param pos
   * @return
   */
  public static String[] splitString (String completeString, int pos) {
    String oldTextLine = completeString.substring(0, pos);
    String newTextLine = completeString.substring(pos, completeString.length());
    return new String[] { oldTextLine, newTextLine };
  }

  /**
   * trims a string only right, leading whitespaces are untouched
   * @param untrimmed
   * @return
   */
  public final static String trimRight (final String untrimmed) {
    return untrimmed.replaceAll("\\s+$", "");
  }
  /**
   * positions of the beginning of every chord
   *
   * @return list of indexes
   */
  public static TreeMap<Integer, String> getChordPositions(final String content) {
    TreeMap<Integer, String> chordpositions = new TreeMap<Integer, String>();

      for (int i = 0; i < content.length(); i++) {
        if (content.charAt(i) != ' ') {

          int nextEmpty = content.indexOf(" ", i);
          String chordString = null;

          if (nextEmpty < 0)
            chordString = content.substring(i, content.length());
          else chordString = content.substring(i, nextEmpty);

          chordpositions.put(new Integer(i), chordString);

          if (nextEmpty >= 0)
            i = nextEmpty;
          else break;
        }
      }

    return chordpositions;
  }

  private static String getTextWithoutTagsTrimmed(String substring) {

    if (substring.trim().isEmpty()) return " ";
    String textWithoutTag = substring;
    for (MidiFilePartType nextType : MidiFilePartType.values()) {
      if (substring.toUpperCase().startsWith(nextType.getName().toUpperCase()))
        textWithoutTag = substring.substring(nextType.getName().length(), substring.length());
    }

    String textWithoutTagAndTrimmed = textWithoutTag; // remove space at the beginning
    for (int i = 0; i < textWithoutTag.length(); i++) {
      if (!Character.isWhitespace(textWithoutTag.charAt(i))) {
        textWithoutTagAndTrimmed = textWithoutTag.substring(i, textWithoutTag.length());
        break;
      }
    }

    return textWithoutTagAndTrimmed;
  }

  public static List <MidiFileChordPart> getChordPartsFromText (final String textline, final String chordline) {
    List <MidiFileChordPart> parts = new ArrayList <MidiFileChordPart> ();

    TreeMap<Integer,String> chordIndexes = new TreeMap<Integer, String>();
    if (chordline != null) chordIndexes = Utils.getChordPositions(chordline);
    // A G D C H E
    // Hallo, dies ist ein Beispiel -> Chord after textend

    // A G D G
    // Hallo, dies ist ein Beispiel -> Chord before textbeginning

    Integer[] indeces = chordIndexes.keySet().toArray(new Integer[chordIndexes.keySet().size()]);

    if (indeces.length > 0 && indeces[0].intValue() > 0) {
      String text = getTextWithoutTagsTrimmed(textline.substring(0, indeces[0]));
      if (text.trim().length() > 0) {
        MidiFileChordPart nextPart = MidiPlayerService.mf.createMidiFileChordPart();
        nextPart.setText(text);
        parts.add(nextPart);
      }

    }

    if (indeces.length == 0) {
      MidiFileChordPart nextPart = MidiPlayerService.mf.createMidiFileChordPart();
      nextPart.setText(textline);
      parts.add(nextPart);
    }
    else {

    for (int i = 0; i < indeces.length; i++) {
      Integer currentIndex = indeces[i];
      Integer nextIndex = null;
      String nextTextToken = null;

      if (i < (indeces.length - 1)) // if not the last one get the next index
        nextIndex = indeces[i + 1];

      if (currentIndex.intValue() < textline.length()) { // if current chord index is not after textend
        if (nextIndex != null && nextIndex.intValue() < textline.length()) // if next chord index is
          // not after textend
          nextTextToken = textline.substring(currentIndex.intValue(), nextIndex.intValue());
        else
        // if next chord index is after the textend
        nextTextToken = textline.substring(currentIndex.intValue(), textline.length());
      } else
      // if current chord index is after the textend
      nextTextToken = "";

      String chord = chordIndexes.get(currentIndex);

      // ignore empty parts, only not empty parts are added
      if (chord != null && chord.trim().length() > 0 && nextTextToken.length() > 0) {
        MidiFileChordPart nextPart = MidiPlayerService.mf.createMidiFileChordPart();
        nextPart.setChord(chord);
        nextPart.setText(nextTextToken);
        parts.add(nextPart);
      }
    }
    }
    return parts;
  }

  public static int nextWhitespaceRight(StringBuilder builder, int loeschposition) {
    for (int i = loeschposition; i < builder.length(); i++) {
      if (Character.isWhitespace(builder.charAt(i)))
          return i;
    }
    return builder.length();
  }

  public static int nextWhitespaceLeft(StringBuilder builder, int loeschposition) {
    for (int i = loeschposition; i > 0; i--) {
      if (Character.isWhitespace(builder.charAt(i)))
          return i;
    }
    return 0;
  }



}
