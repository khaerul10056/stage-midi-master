package org.mda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

import mda.SongChordPart;
import mda.SongPartType;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.resources.ImageDescriptor;

public class Utils {


  private static final Log LOGGER  = LogFactory.getLogger(Utils.class);


  public final static String ICON_SONG = "song.jpg";
  public final static String ICON_SESSION = "session.png";
  public final static String ICON_ADD_PART = "add_part.gif";
  public final static String ICON_CLONE_PART = "clone_part.gif";
  public final static String ICON_LINK = "link.gif";
  public final static String ICON_REMOVE_PART = "remove_part.gif";
  public final static String ICON_PART = "part.gif";
  public final static String ICON_REFPART = "referencedPart.gif";

  public final static String ICON_SPLIT_PART = "split_part.gif";
  public final static String ICON_MERGE_PART = "merge_part.gif";
  public final static String ICON_MOVE_PART_UP = "part_up.gif";
  public final static String ICON_MOVE_PART_DOWN = "part_down.gif";

  public static final String ICON_PROPERTIES = "properties.gif";
  public static final String ICON_TRANSPOSE = "transpose.gif";
  public static final String ICON_NEXT = "next.png";
  public static final String ICON_PREVIOUS = "previous.png";
  public static final String ICON_NEXT_SONG = "folder_next.png";
  public static final String ICON_PREVIOUS_SONG = "folder_previous.png";
  public static final String ICON_WHITE_BACKGROUND = "white.png";
  public static final String ICON_BLACK_BACKGROUND = "black.png";
  public static final String ICON_IMAGE_BACKGROUND = "image.png";
  public static final String ICON_NORMAL_BACKGROUND = "normal.png";

  public static final String ICON_PARTPROPERTIES = "partproperties.gif";
  
  /**
   * reads textfile in an string list
   * @param file file
   * @return list of strings
   * @throws IOException if occurs
   */
  public static List<String> readTextFile (final File file) throws IOException {
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  final List <String> content = new ArrayList<String>();
	    try {
	        String line = null;
	        do {
	        	line = br.readLine();
	        	if (line != null) 
	        	  content.add(line);
	        }
	        while (line != null);
	    } finally {
	        br.close();
	    }
	    
	    return content;
  }
  
  /**
   * writes textfile from an string list
   * @param file  file to write to
   * @param content  content to write
   * @throws IOException  if occurs 
   */
  public static void writeTextFile(final File file, final Collection<String> content) throws IOException {
	  if (! file.getAbsoluteFile().getParentFile().exists())
		  file.getParentFile().mkdirs();
	  
	   BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
       for (String nextLine: content)
         bw.write(nextLine + System.getProperty("line.separator"));
          
       bw.close();
  }

  /**
   * remove whitespaces from string
   * @param before	string with whitespaces
   * @return string without whitespaces
   */
  public static String removeWhitespaces (final String before) {
	  return before.replaceAll("\\s","");
  }

  /**
   * fills the string with whitespaces in the length
   * @param text		text to fill
   * @param length		length
   * @return manipulated string
   */
  public static String fillString (final String text, final int length) {
    int filler = length - text.length();
    StringBuilder builder = new StringBuilder(text);
    for (int i = 0; i < filler; i++)
      builder = builder.append (" ");
    return builder.toString();
  }

  /**
   * creates an empty string
   * @param length length of string
   * @return string itself
   */
  public static String createEmptyString (final int length) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++)
      builder.append (" ");
    return builder.toString();
  }
  
  /**
   * deletes a directory recursively
   * @param path path
   * @return true/false
   */
  public static boolean deleteDirectory(File path) {
    if( ! path.exists() )
    	return false;
    
      File[] files = path.listFiles();
      if (files != null) {

      for(int i=0; i<files.length; i++) {
         if(files[i].isDirectory()) {
           deleteDirectory(files[i]);
         }
         else {
           files[i].delete();
         }
      }
      }
    
    return path.delete();
  }

  /**
   * Copies a file
   *
   * @param to  target file
   * @param from  sourcefile
   */
  public final static void copyFile(final File to, final File from) throws IOException {
    FileInputStream fis1 = null;
    FileChannel fic1 = null;
    FileOutputStream fos = null;
    FileChannel foc = null;
    try {

      LOGGER.debug("Kopiere Datei " + from.getAbsolutePath() + " nach " + to.getAbsolutePath());
      fis1 = new FileInputStream(from);
      fic1 = fis1.getChannel();

      fos = new FileOutputStream(to);
      foc = fos.getChannel();

      long position = 0;
      long transfered;
      long remaining = fic1.size();

      while (remaining > 0) {
        transfered = fic1.transferTo(position, remaining, foc);

        position += transfered;
        remaining -= transfered;
      }

    } finally {
        if (fic1 != null)
          fic1.close();

        if (fis1 != null)
          fis1.close();

        if (fos != null)
          fos.close();

        if (foc != null)
          foc.close();
    }
  }


  /**
   * gets the chord at the given position
   * @param chordline  chordline
   * @param position position of chord
   * @return chord
   */
  public static String getChordFromPosition (String chordline, final int position) {

    if (position < 0)
      return "";

    if (chordline.length() <= position)
      return "";

    if (chordline.charAt(position) == ' ')
      return "";

    int lastIndexOf = chordline.lastIndexOf(' ', position);
    int nextIndexOf = chordline.indexOf(' ', position);

    if (lastIndexOf < 0)
      lastIndexOf = 0;

    if (nextIndexOf < 0)
      nextIndexOf = chordline.length();

    return chordline.substring(lastIndexOf, nextIndexOf);
  }

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
    for (SongPartType nextType : SongPartType.values()) {
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

  public static List <SongChordPart> getChordPartsFromText (final String textline, final String chordline) {
    List <SongChordPart> parts = new ArrayList <SongChordPart> ();

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
        SongChordPart nextPart = MidiPlayerService.mf.createSongChordPart();
        nextPart.setText(text);
        parts.add(nextPart);
      }

    }

    if (indeces.length == 0) {
      String text = getTextWithoutTagsTrimmed(textline);
      SongChordPart nextPart = MidiPlayerService.mf.createSongChordPart();
      nextPart.setText(text);
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
        SongChordPart nextPart = MidiPlayerService.mf.createSongChordPart();
        nextPart.setChord(chord);
        nextPart.setText(nextTextToken);
        parts.add(nextPart);
      }
    }
    }
    return parts;
  }




  public static String removeString (String text, int start, int length) {


    if (start < 0)
      start = 0;

    if (start + length >= text.length())
      length = text.length() - start;

    String newText = text.substring(0, start);
    newText += text.substring(start + length, text.length());
    return newText;
  }




}
