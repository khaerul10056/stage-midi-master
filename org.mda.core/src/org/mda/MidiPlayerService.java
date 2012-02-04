package org.mda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import mda.AbstractSessionItem;
import mda.Gallery;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.MidiplayerPackage;
import mda.Session;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class MidiPlayerService {

  public static final MidiplayerFactory mf           = MidiplayerFactory.eINSTANCE;
  public static final MidiplayerPackage mp           = MidiplayerPackage.eINSTANCE;

  private static final List<String>     defaultPaths = new ArrayList<String>();

  static {
    defaultPaths.add("/home/oleym/privat/soundOfFaith/midi"); //todo konfigurierbar machen, pro Pfad Angabe von Filetypen (.mid, .txt...)
  }

  /** merges a line to the previous line
   * checks if the caretposition is at the beginning
   * @param part part
   * @param line line to merge
   * @return part */
  public final static MidiFilePart mergeLine (final MidiFilePart part, final int line, final int caretposition) {
    if (caretposition > 0)
      return part;

    MidiFileTextLine currentTextLine = part.getTextlines().get(line);
    MidiFileTextLine previousTextLine = part.getTextlines().get(line - 1);
    previousTextLine.getChordParts().addAll(currentTextLine.getChordParts());
    part.getTextlines().remove(currentTextLine);
    return part;

  }

  /** splits a line at the given caretposition
   * @param part unsplitted part
   * @param line current linenumber
   * @param caretposition position of caret in current line
   * @return splitted part */
  public final static MidiFilePart splitLine (final MidiFilePart part, final int line, int caretposition) {

    MidiFileTextLine currentTextLine = part.getTextlines().get(line);

    int lastToken = 0;

    for (lastToken = 0; lastToken < currentTextLine.getChordParts().size(); lastToken++) {
      MidiFileChordPart chordPart = currentTextLine.getChordParts().get(lastToken);
      int longestToken = chordPart.getChord() == null ? chordPart.getText().length() : Math.max(chordPart.getText().length(), chordPart.getChord().length());
      //if current token is splitted, than break
      if (longestToken > caretposition)
        break;
      caretposition -= longestToken;
    }

    int splitToken = lastToken;
    MidiFileChordPart splitPart = currentTextLine.getChordParts().get(splitToken);

    System.out.println("SplitToken = " +
      splitPart);

    MidiFileTextLine newLine = mf.createMidiFileTextLine();
    MidiFileChordPart newPartInNewLine = mf.createMidiFileChordPart();

    int moveLenText = Math.min(splitPart.getText().length(), caretposition); //get splitpoint of text
    newPartInNewLine.setText(splitPart.getText().substring(moveLenText, splitPart.getText().length())); //add splitted data to new part
    splitPart.setText(splitPart.getText().substring(0, moveLenText)); //set text in front of splitpoint in old text

    if (splitPart.getChord() != null) {
      int moveLenChord = Math.min(splitPart.getChord().length(), caretposition); //get splitpoint of chord
      newPartInNewLine.setChord(splitPart.getChord().substring(moveLenChord, splitPart.getChord().length())); //set chord after splitpoint in new chord
      splitPart.setChord(splitPart.getChord().substring(0, moveLenChord)); //set chord in front of splitpoint in old chord
    }

    System.out.println("SplitPart (" +
      splitPart + ")");
    System.out.println("NewPart (" +
      newPartInNewLine + ")");

    Collection<MidiFileChordPart> toRemove = new ArrayList<MidiFileChordPart>();
    newLine.getChordParts().add(newPartInNewLine); //add new part to new line
    for (int i = splitToken + 1; i < currentTextLine.getChordParts().size(); i++) { //add rest of tokens in new line
      System.out.println("Rest Part " +
        i + "/" + currentTextLine.getChordParts().get(i));
      toRemove.add(currentTextLine.getChordParts().get(i));
    }
    newLine.getChordParts().addAll(toRemove);

    part.getTextlines().add(line + 1, newLine);
    return part;
  }

  /** loads the rootobject of the midiplayer
   * @param conffileAsFile
   * @return loaded rootobject or created one, if no file exists
   * @throws IOException Exception */
  public final static MidiPlayerRoot loadRootObject (File conffileAsFile) {
    Resource poResource = new XMLResourceFactoryImpl().createResource(URI.createFileURI(conffileAsFile.getAbsolutePath()));
    if (conffileAsFile.exists()) {
      try {
        poResource.load(null);
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
      return (MidiPlayerRoot) poResource.getContents().get(0);
    }
    else
      return mf.createMidiPlayerRoot();
  }

  /** find sessionitems by searchconf
   * @param root root
   * @param searchconf configuration
   * @return list of items */
  public final static List<AbstractSessionItem> find (MidiPlayerRoot root, MidiFileSearchConf searchconf) {

    List<AbstractSessionItem> found = new ArrayList<AbstractSessionItem>();

    for (AbstractSessionItem nextItem : root.getGallery().getGalleryItems()) {
      if (nextItem instanceof MidiFile) {
        if (nextItem.getName().indexOf(searchconf.getTitle()) >= 0)
          found.add(nextItem);
      }
    }

    return found;
  }

  /** removes text and saves model
   * @param file file */
  public final static void removeText (final MidiFile file) {
    file.getParts().clear();
    saveRootObject(getRoot(file));
  }

  /** gets RootObject of midiplayer-model
   * @param object any object from model
   * @return rootObject */
  public final static MidiPlayerRoot getRoot (EObject object) {
    while (object != null &&
      !(object instanceof MidiPlayerRoot)) {
      object = object.eContainer();
    }

    if (object instanceof MidiPlayerRoot)
      return (MidiPlayerRoot) object;
    else
      return null;
  }

  /** creates a session with all gallery-items
   * @param root rootobject
   * @return session */
  public final static Session createSessionFromGallery (final MidiPlayerRoot root) {
    Session session = mf.createSession();

    for (AbstractSessionItem item : root.getGallery().getGalleryItems()) {
      session.getItems().add(item);
    }

    if (root.getSessions().size() == 0)
      root.getSessions().add(session);
    else
      root.getSessions().set(0, session); // TODO handling for more sessions

    saveRootObject(root);

    return session;

  }

  private static void sort (Gallery gallery) {
    ECollections.sort(gallery.getGalleryItems(), new Comparator<AbstractSessionItem>() {

      @Override
      public int compare (AbstractSessionItem o1, AbstractSessionItem o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });

  }

  public final static void removeSongsFromGallery (final Gallery gallery, List<AbstractSessionItem> items) {
    gallery.getGalleryItems().removeAll(items); //todo in service and check, disable button if selected item that is still referenced
    sort(gallery);
  }

  /** Imports a new session and saves the rootobject
   * @param root rootobject
   * @throws IOException */
  public final static void importDefaultPathsToGallery (final MidiPlayerRoot root) {

    Gallery gallery = root.getGallery();
    if (gallery == null) {
      gallery = mf.createGallery();
      root.setGallery(gallery);
    }

    for (String nextPath : defaultPaths) {
      File file = new File(nextPath);
      if (file.listFiles() != null) {
        for (File files : file.listFiles()) {
          if (files.getName().endsWith(".mid")) { //todo generalize: suffixes per path
            AbstractSessionItem item = findItem(gallery, files.getName());
            if (item == null) {
              MidiFile nextItem = mf.createMidiFile();
              nextItem.setName(files.getName());
              nextItem.setPath(nextPath);
              gallery.getGalleryItems().add(nextItem);
            }
          }
        }
      }
    }

    sort(gallery);
  }

  /** finds a item in the gallery by name
   * @param gallery gallery
   * @param name name of the song
   * @return */
  private static final AbstractSessionItem findItem (final Gallery gallery, final String name) {
    for (AbstractSessionItem item : gallery.getGalleryItems()) {
      if (item.getName().equals(name))
        return item;
    }
    return null;
  }

  /** save rootobject of the midiplayer
   * @param root rootobject
   * @throws IOException Exception */
  public final static void saveRootObject (final MidiPlayerRoot root) {
    Resource poResource = new XMLResourceFactoryImpl().createResource(root.eResource().getURI());
    poResource.getContents().add(root);
    try {
      poResource.save(null);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public final static MidiFilePart getCurrentPart (final MidiFile midifile, int number) {
    MidiFilePart currentPart = null;
    for (MidiFilePart nextPart : midifile.getParts()) {
      if (nextPart.getBar() <= number)
        currentPart = nextPart;
    }

    return currentPart;
  }

  public final static MidiFilePart getNextPart (final MidiFile midifile, int number) {
    for (MidiFilePart nextPart : midifile.getParts()) {
      if (nextPart.getBar() > number)
        return nextPart;
    }

    return null;

  }

  /** getter
   * @param midifile midifile
   * @return description of the midifile as string */
  public static final String getMidiFileAsString (final MidiFile midifile) {
    StringBuilder builder = new StringBuilder();

    builder.append("Name:" +
      midifile.getName() + "\n");
    builder.append("Path:" +
      midifile.getPath() + "\n\n");

    for (MidiFilePart nextPart : midifile.getParts()) {
      builder.append("- " +
        nextPart.getParttype() + ":\n");
      for (MidiFileTextLine nextLine : nextPart.getTextlines()) {
        builder.append("    * ");
        for (MidiFileChordPart nextChordPart : nextLine.getChordParts()) {
          if (nextChordPart.getChord() != null)
            builder.append("(" +
              nextChordPart.getChord() + ")");
          builder.append(nextChordPart.getText());
        }
        builder.append("\n");
      }
    }

    return builder.toString();

  }

  private static List<MidiFilePart> filterIgnoredPartTypes (final Collection<MidiFilePart> unfiltered, IMidiFileEditorConfig config) {
    List<MidiFilePart> filtered = new ArrayList<MidiFilePart>();
    for (MidiFilePart nextPart : unfiltered) {
      if (!config.isPartIgnored(nextPart.getParttype()))
        filtered.add(nextPart);
    }

    return filtered;
  }

  public static boolean changed (List<MidiFilePart> part, List<MidiFilePart> partToCompare) {

    if (part.size() != partToCompare.size())
      return true;

    for (int i = 0; i < part.size(); i++) {
      if (!part.get(i).equals(partToCompare.get(i)))
        return true;
    }

    return false;
  }

  public static List<MidiFilePart> getCurrentParts (MidiFile file, int currentBar, IMidiFileEditorConfig config) {
    List<MidiFilePart> parts = ECollections.emptyEList();
    if (currentBar >= 0)
      parts = MidiPlayerService.getPartsForBar(file, currentBar, config);

    parts = filterIgnoredPartTypes(parts, config);

    return parts;

  }

  private static List<MidiFilePart> getPartsForBar (MidiFile file, int currentBar, IMidiFileEditorConfig config) {
    MidiFilePart fromPart = null;
    MidiFilePart toPart = null;

    for (MidiFilePart nextPart : file.getParts()) {

      if (toPart == null &&
        nextPart.getBar() >= 0 && currentBar < nextPart.getBar()) {
        toPart = nextPart;
      }

      if (nextPart.getBar() >= 0 &&
        currentBar >= nextPart.getBar()) {
        fromPart = nextPart;
      }
    }

    int indexFrom = file.getParts().indexOf(fromPart);
    int indexTo = file.getParts().indexOf(toPart);

    if (indexFrom < 0 &&
      indexTo < 0)
      return file.getParts();

    if (indexFrom < 0)
      indexFrom = 0;

    if (indexTo < 0)
      indexTo = file.getParts().size();

    System.out.println("subList " +
      indexFrom + "-" + indexTo + " (" + (fromPart != null ? fromPart.getBar() : "<NULL>") + "/" + (toPart != null ? toPart.getBar() : "<NULL>"));

    return file.getParts().subList(indexFrom, indexTo);
  }

  /** adds a new part after the addAfter-parent
   * @param currentMidiFile midifile
   * @param addAfter after this part the new part is inserted
   * @param midiFilePartType type of the new part
   * @param reference referenced part, if the new part should be a reference to another part, maybe <code>null</code>
   * @return */
  public static int addPartAfter (MidiFile currentMidiFile, MidiFilePart addAfter, MidiFilePartType midiFilePartType, MidiFilePart reference) {
    int index = currentMidiFile.getParts().indexOf(addAfter);
    MidiFilePart newPart = mf.createMidiFilePart();
    newPart.getTextlines().add(mf.createMidiFileTextLine());
    newPart.setParttype(midiFilePartType);
    if (reference != null)
      newPart.setRefPart(reference);
    currentMidiFile.getParts().add(index + 1, newPart);
    return index + 1;
  }

  public static List<String> getPartsForSelectable (final List<MidiFilePart> parts, final boolean withReferences) {
    List<String> renderedPartsForReference = new ArrayList<String>();
    renderedPartsForReference.add("");
    for (MidiFilePart part : parts) {
      String text = part.getParttype().toString() +
        " - ";
      if (part.getTextlines().size() > 0 &&
        part.getTextlines().get(0).getChordParts().size() > 0) {
        for (MidiFileChordPart nextPart : part.getTextlines().get(0).getChordParts()) {
          text += nextPart.getText();
        }
      }

      if (text.length() > 30)
        text = text.substring(0, 30) +
          "...";
      if (part.getBar() >= 0)
        text += " (" +
          part.getBar() + ")";
      if (part.getRefPart() == null ||
        withReferences == true) {
        renderedPartsForReference.add(text);
      }

    }

    return renderedPartsForReference;

  }

  public static List<MidiFilePart> getParts (MidiFile file, MidiFilePartType parttype, boolean withReferences) {
    List<MidiFilePart> parts = new ArrayList<MidiFilePart>();
    for (MidiFilePart nextPart : file.getParts()) {
      if (nextPart.getParttype().equals(parttype))
        parts.add(nextPart);
    }

    return parts;
  }

  public static void removeLine (MidiFilePart part, MidiFileTextLine currentLine) {
    part.getTextlines().remove(currentLine);
  }

  public static int movePartUp (MidiFile currentMidiFile, MidiFilePart part) {
    int i = currentMidiFile.getParts().indexOf(part);
    currentMidiFile.getParts().remove(i);
    currentMidiFile.getParts().add(i - 1, part);
    return i - 1;
  }

  public static int movePartDown (MidiFile currentMidiFile, MidiFilePart part) {
    int i = currentMidiFile.getParts().indexOf(part);
    currentMidiFile.getParts().remove(i);
    currentMidiFile.getParts().add(i + 1, part);
    return i + 1;
  }

  /** removes the given part from the file
   * @param file midifile
   * @param part part to remove
   *          return index of removed part */
  public static int removePart (final MidiFile file, MidiFilePart part) {
    int index = file.getParts().indexOf(part);
    if (index >= 0)
      file.getParts().remove(part);

    return index;
  }

  public static void removeSessions (Collection<Session> selectedItems) {
    MidiPlayerRoot root = null;
    for (Session next: selectedItems) {
      root = (MidiPlayerRoot) next.eContainer();
      root.getSessions().remove(next);
    }
    //todo in service and check, disable button if selected item that is still referenced
    if (root != null) {
    ECollections.sort(root.getSessions(), new Comparator<Session>() {

      @Override
      public int compare (Session o1, Session o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
    }
  }

  public static String toString (MidiFilePart nextPart) {
    StringBuilder builder = new StringBuilder();
    List <String> strings = getRawText(nextPart);
    for (String nextString: strings)
      builder.append(nextString + "\n");

    return builder.toString();

  }
  public static List<String> getRawText (MidiFilePart nextPart) {
    List<String> lines = new ArrayList<String>();

    if (nextPart.getRefPart() != null)
      nextPart = nextPart.getRefPart();

    for (MidiFileTextLine nextLine : nextPart.getTextlines()) {
      String nextLineAsText = "";
      for (MidiFileChordPart nextChordPart : nextLine.getChordParts()) {
        if (nextChordPart.getChord() != null)
          nextLineAsText += "(" + nextChordPart.getChord() + ")";
        if (nextChordPart.getText() != null)
          nextLineAsText += nextChordPart.getText();
      }
      lines.add(nextLineAsText);
    }
    return lines;
  }

  public static void addSong (Session session, Collection<MidiFile> selectedSongs) {
    session.getItems().addAll(selectedSongs);

  }

  public static MidiFilePart splitPart (MidiFile midiFile, MidiFilePart midiFilePart, int caretOffsetOfCurrentTextField) {
    Collection <MidiFileTextLine> movedTextlines = new ArrayList<MidiFileTextLine>();

    for (int i = 0; i < midiFile.getParts().size(); i++) {
      MidiFilePart currentPart = midiFile.getParts().get(i);
      if (currentPart.equals(midiFilePart)) {

        for (int j = caretOffsetOfCurrentTextField; j < currentPart.getTextlines().size(); j++) {
          movedTextlines.add(currentPart.getTextlines().get(j));
        }

        MidiFilePart newPart = mf.createMidiFilePart();
        newPart.setParttype(currentPart.getParttype());
        newPart.getTextlines().addAll(movedTextlines);
        midiFile.getParts().add(i +1, newPart);
        return midiFilePart;
      }
    }
    return null;
  }

  /**
   * merges a part to the previous part
   * @param midifile
   * @param currentPart
   * @return
   */
  public static MidiFilePart mergeWithPreviousPart (MidiFile midifile, MidiFilePart currentPart) {
    int currentIndex = midifile.getParts().indexOf(currentPart);
    if (currentIndex == 0)
      return currentPart;

    MidiFilePart previousPart = midifile.getParts().get(currentIndex - 1);
    previousPart.getTextlines().addAll(currentPart.getTextlines());
    midifile.getParts().remove(currentPart);
    return previousPart;
  }



}
