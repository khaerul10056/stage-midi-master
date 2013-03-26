package org.mda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mda.AbstractSessionItem;
import mda.Gallery;
import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongPartType;
import mda.SongTextLine;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.MidiplayerPackage;
import mda.Session;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class MidiPlayerService {

  public static final MidiplayerFactory mf           = MidiplayerFactory.eINSTANCE;
  public static final MidiplayerPackage mp           = MidiplayerPackage.eINSTANCE;

  private static final List<String>     defaultPaths = new ArrayList<String>();

  private static final Log LOGGER  = LogFactory.getLogger(MidiPlayerService.class);

  static {
    defaultPaths.add("/home/oleym/privat/soundOfFaith/midi"); //todo konfigurierbar machen, pro Pfad Angabe von Filetypen (.mid, .txt...)
  }

  
  public static Session findSession (final MidiPlayerRoot root, final String sessionName) {
		String sessionTrimmed = Utils.removeWhitespaces(sessionName);
		
		String existingSessions = "";
		
		for (Session nextSession: root.getSessions()) {
			String found = Utils.removeWhitespaces(nextSession.getName());
			if (found.equalsIgnoreCase(sessionTrimmed)) {
				LOGGER.info("Starting with session " + sessionTrimmed);
				return nextSession;
			}
			else {
				if (! existingSessions.isEmpty())
					existingSessions+=",";
				
				existingSessions+=found;
			}
		}
		
		throw new IllegalArgumentException("Could not find session <" + sessionName + "> in current model. Existing session: <" + existingSessions + ">");
  }

  public static List <AbstractSessionItem> sortedSessionItemList (final List <AbstractSessionItem> unsorted) {
    List <AbstractSessionItem> cloned = new ArrayList <AbstractSessionItem> (); 
    cloned.addAll(unsorted);

    Collections.sort(cloned, new Comparator<AbstractSessionItem>() {

      @Override
      public int compare (AbstractSessionItem o1, AbstractSessionItem o2) {
        return o1.getName().compareTo(o2.getName());
      }

    });

    return cloned;
  }

  public static String getTitle (final Song midifile) {
    if (midifile == null)
      throw new IllegalArgumentException("Parameter midifile must not be null");
    if (midifile.getName() == null)
      return "";

    return midifile.getName().endsWith(".mid") ? midifile.getName().substring(0, midifile.getName().length() - 4) : midifile.getName();
  }

  /**
   * removes a sessionitem itself and all references in any session, if it is referenced
   * @param rootobject   rootobject
   * @param sessionitem  sessionitem to be removed
   */
  public static void removeSongAndReferences (final MidiPlayerRoot rootobject, final AbstractSessionItem sessionitem) {

    for (Session session: rootobject.getSessions()) {

      Collection<AbstractSessionItem> deleted = new ArrayList<AbstractSessionItem>();

      for (AbstractSessionItem nextSessionitem : session.getItems()) {
        if (sessionitem == nextSessionitem)
          deleted.add(nextSessionitem);
      }

      session.getItems().removeAll(deleted);
    }

    rootobject.getGallery().getGalleryItems().remove(sessionitem);
  }

  /**
   * check if the session item is reverenced
   * @param rootobject
   * @return errormessage or <code>null</code> if object is not referenced anymore
   */
  public static String getReferenced (final MidiPlayerRoot rootobject, final AbstractSessionItem sessionitem) {
    StringBuilder builder = new StringBuilder();
    int numberOfSession = 0;

    for (Session session: rootobject.getSessions()) {
      for (AbstractSessionItem nextSessionitem : session.getItems()) {
        if (sessionitem == nextSessionitem) {
          numberOfSession ++;
          builder.append("- " + session.getName() + "\n");
        }
      }
    }

    if (builder.length() == 0)
      return null;

    if (numberOfSession == 1)
      builder.insert(0, sessionitem.getName() + " is referenced in the following session:\n");
    else
      builder.insert(0, sessionitem.getName() + " is referenced in the following " + numberOfSession + "sessions:\n");

    builder.append("\nRemove it anyway?");

    return builder.toString();

  }

  /**
   * removes a complete line from a part
   * @param part part
   * @param line line
   * @return part
   */
  public final static SongPart removeLine (final SongPart part, final int line) {
    part.getTextlines().remove(line);
    return part;
  }

  /**
   * clones a part and inserts it after the cloned part
   * @param midifile midifile
   * @param clonablePart  part to clone
   * @return midifile
   */
  public final static Song clonePart (final Song midifile, final SongPart clonablePart) {
    int indexOfCurrent = midifile.getParts().indexOf(clonablePart);
    SongPart clonedPart = EcoreUtil.copy(clonablePart);
    midifile.getParts().add(indexOfCurrent + 1, clonedPart);
    return midifile;
  }

  /** merges a line to the previous line
   * checks if the caretposition is at the beginning
   * @param part part
   * @param line line to merge
   * @return part */
  public final static SongPart mergeLine (final SongPart part, final int line, final int caretposition) {
    SongTextLine currentTextLine = part.getTextlines().get(line);
    SongTextLine previousTextLine = part.getTextlines().get(line - 1);
    previousTextLine.getChordParts().addAll(currentTextLine.getChordParts());
    part.getTextlines().remove(currentTextLine);
    return part;

  }

  /** splits a line at the given caretposition
   * @param part unsplitted part
   * @param line current linenumber
   * @param caretposition position of caret in current line
   * @return splitted part */
  public final static SongPart splitLine (final SongPart part, final int line, int caretposition) {

    SongTextLine currentTextLine = part.getTextlines().get(line);

    int lastToken = 0;

    for (lastToken = 0; lastToken < currentTextLine.getChordParts().size(); lastToken++) {
      SongChordPart chordPart = currentTextLine.getChordParts().get(lastToken);
      int longestToken = chordPart.getChord() == null ? chordPart.getText().length() : Math.max(chordPart.getText().length(), chordPart.getChord().length());
      //if current token is splitted, than break
      if (longestToken > caretposition)
        break;
      caretposition -= longestToken;
    }

    int splitToken = lastToken;


    //If split at the end of the line, then add a new line
    if (splitToken >= currentTextLine.getChordParts().size()) {
      SongTextLine newTextLine = mf.createSongTextLine();
      SongChordPart chordpart = mf.createSongChordPart();
      chordpart.setText(" ");
      newTextLine.getChordParts().add(chordpart);
      part.getTextlines().add(line + 1, newTextLine);
      return part;
    }

    SongChordPart splitPart = currentTextLine.getChordParts().get(splitToken);
    LOGGER.info("SplitToken = " +
      splitPart);

    SongTextLine newLine = mf.createSongTextLine();
    SongChordPart newPartInNewLine = mf.createSongChordPart();

    int moveLenText = Math.min(splitPart.getText().length(), caretposition); //get splitpoint of text
    newPartInNewLine.setText(splitPart.getText().substring(moveLenText, splitPart.getText().length())); //add splitted data to new part
    splitPart.setText(splitPart.getText().substring(0, moveLenText)); //set text in front of splitpoint in old text

    if (splitPart.getChord() != null) {
      int moveLenChord = Math.min(splitPart.getChord().length(), caretposition); //get splitpoint of chord
      newPartInNewLine.setChord(splitPart.getChord().substring(moveLenChord, splitPart.getChord().length())); //set chord after splitpoint in new chord
      splitPart.setChord(splitPart.getChord().substring(0, moveLenChord)); //set chord in front of splitpoint in old chord
    }

    LOGGER.info("SplitPart (" + splitPart + ")");
    LOGGER.info("NewPart (" + newPartInNewLine + ")");

    Collection<SongChordPart> toRemove = new ArrayList<SongChordPart>();
    newLine.getChordParts().add(newPartInNewLine); //add new part to new line
    for (int i = splitToken + 1; i < currentTextLine.getChordParts().size(); i++) { //add rest of tokens in new line
      LOGGER.info("Rest Part " + i + "/" + currentTextLine.getChordParts().get(i));
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



  /** removes text and saves model
   * @param file file */
  public final static void removeText (final Song file) {
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

  public final static SongPart getCurrentPart (final Song midifile, int number) {
    SongPart currentPart = null;
    for (SongPart nextPart : midifile.getParts()) {
      if (nextPart.getBar() <= number)
        currentPart = nextPart;
    }

    return currentPart;
  }

  public final static SongPart getNextPart (final Song midifile, final SongPart part) {
	int posCurrent = midifile.getParts().indexOf(part);
	if (posCurrent < midifile.getParts().size() - 1)
		return midifile.getParts().get(posCurrent + 1);
	else
      return null;

  }

  /** getter
   * @param midifile midifile
   * @return description of the midifile as string */
  public static final String getMidiFileAsString (final Song midifile) {
    StringBuilder builder = new StringBuilder();

    builder.append("Name:" +
      midifile.getName() + "\n");
    builder.append("Path:" +
      midifile.getPath() + "\n\n");

    for (SongPart nextPart : midifile.getParts()) {
      builder.append("- " +
        nextPart.getParttype() + ":\n");
      for (SongTextLine nextLine : nextPart.getTextlines()) {
        builder.append("    * ");
        for (SongChordPart nextChordPart : nextLine.getChordParts()) {
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



  /** adds a new part after the addAfter-parent
   * @param currentMidiFile midifile
   * @param addAfter after this part the new part is inserted, if null than it is added to end
   * @param midiFilePartType type of the new part
   * @param reference referenced part, if the new part should be a reference to another part, maybe <code>null</code>
   * @return */
  public static int addPartAfter (Song currentMidiFile, SongPart addAfter, SongPartType midiFilePartType, SongPart reference) {

    if (reference != null && midiFilePartType != null && reference.getRefPart().getParttype() != midiFilePartType)
      LOGGER.warn("addPartAfter was called with different types for direct parameter and reference, using the type " + reference.getParttype() + " from reference");

    int index = addAfter != null ? currentMidiFile.getParts().indexOf(addAfter): (currentMidiFile.getParts().size() - 1);
    SongPart newPart = mf.createSongPart();
    newPart.getTextlines().add(mf.createSongTextLine());
    newPart.setParttype(midiFilePartType);
    if (reference != null) {
      newPart.setParttype(reference.getParttype());
      newPart.setRefPart(reference);
    }
    currentMidiFile.getParts().add(index + 1, newPart);
    return index + 1;
  }





  /**
   * moves a part up in the list of parts of a file
   * @param currentMidiFile file
   * @param part part
   * @return moved part
   */
  public static SongPart movePartUp (Song currentMidiFile, SongPart part) {
    int i = currentMidiFile.getParts().indexOf(part);
    if (i == 0) //if first do nothing
      return part;

    currentMidiFile.getParts().remove(i);
    currentMidiFile.getParts().add(i - 1, part);
    return currentMidiFile.getParts().get(i - 1);
  }

  /**
   * move a part down in the list of parts of a file
   * @param currentMidiFile file
   * @param part part
   * @return moved part
   */
  public static SongPart movePartDown (Song currentMidiFile, SongPart part) {
    int i = currentMidiFile.getParts().indexOf(part);
    if (i == currentMidiFile.getParts().size() - 1) //if last do nothing
      return part;

    currentMidiFile.getParts().remove(i);
    currentMidiFile.getParts().add(i + 1, part);
    return currentMidiFile.getParts().get(i + 1);
  }

  /** removes the given part from the file
   * @param file midifile
   * @param part part to remove
   *          return index of removed part */
  public static SongPart removePart (final Song file, SongPart part) {
    int index = file.getParts().indexOf(part);
    if (index >= 0)
      file.getParts().remove(part);

    index --;
    if (index < 0)
      index = 0;

    if (file.getParts().size() > 0)
      return file.getParts().get(index);
    else
      return null;
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

  public static String toString (Song midifile) {
    StringBuilder builder = new StringBuilder();

    for (SongPart nextPart: midifile.getParts()) {
      builder.append ("\n\n");
      builder.append (nextPart.getParttype() + "\n");
      builder.append (nextPart.getBar() + "\n");
      builder.append(toString(nextPart));
    }

    return builder.toString();

  }

  public static String toString (SongPart nextPart) {
    StringBuilder builder = new StringBuilder();
    List <String> strings = getRawText(nextPart, true);
    for (String nextString: strings)
      builder.append(nextString + "\n");

    return builder.toString();

  }
  public static List<String> getRawText (SongPart nextPart, boolean chords) {
    List<String> lines = new ArrayList<String>();

    if (nextPart.getRefPart() != null)
      nextPart = nextPart.getRefPart();

    for (SongTextLine nextLine : nextPart.getTextlines()) {

      String nextLineAsText = "";
      if (nextLine.isNewSlide())
        nextLineAsText += "->";
      for (SongChordPart nextChordPart : nextLine.getChordParts()) {
        if (nextChordPart.getChord() != null && chords)
          nextLineAsText += "(" + nextChordPart.getChord() + ")";
        if (nextChordPart.getText() != null)
          nextLineAsText += nextChordPart.getText();
      }
      lines.add(nextLineAsText);
    }
    return lines;
  }

  public static Session addSessionItem (Session session, AbstractSessionItem afterItem, AbstractSessionItem selectedSong) {
	  
	if (session.getItems().contains(selectedSong))
		session.getItems().remove(selectedSong);
	  
	int selectionIndex = session.getItems().indexOf(afterItem);
    session.getItems().add(selectionIndex + 1, selectedSong);
    return session;
  }
  
  public static Session removeSessionItem (Session session, AbstractSessionItem selectedSong) {
	  session.getItems().remove(selectedSong);
	  return session;
  }

  public static SongPart splitPart (Song midiFile, SongPart midiFilePart, int caretOffsetOfCurrentTextField) {
    Collection <SongTextLine> movedTextlines = new ArrayList<SongTextLine>();

    for (int i = 0; i < midiFile.getParts().size(); i++) {
      SongPart currentPart = midiFile.getParts().get(i);
      if (currentPart.equals(midiFilePart)) {

        for (int j = caretOffsetOfCurrentTextField; j < currentPart.getTextlines().size(); j++) {
          movedTextlines.add(currentPart.getTextlines().get(j));
        }

        SongPart newPart = mf.createSongPart();
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
  public static SongPart mergeWithPreviousPart (Song midifile, SongPart currentPart) {
    int currentIndex = midifile.getParts().indexOf(currentPart);
    if (currentIndex == 0)
      return currentPart;

    SongPart previousPart = midifile.getParts().get(currentIndex - 1);
    previousPart.getTextlines().addAll(currentPart.getTextlines());
    midifile.getParts().remove(currentPart);
    return previousPart;
  }

  /**
   * find a song in the gallery
   * @param gallery gallery
   * @param string searchstring, contained by the name of the song
   * @return found midifile or <code>null</code> if nothing was found
   */
  public static Song findSong (final Gallery gallery, String string) {
    for (AbstractSessionItem next: gallery.getGalleryItems()) {
      if (next.getName().indexOf(string) >= 0)
        return (Song) next;
    }

    return null;
  }
  
  /**
   * creates a new song
   * @param name  title of the song
   * @return songobject
   */
  public static Song createSong (final MidiPlayerRoot playerroot, final String name) {
	  Song createMidiFile = mf.createSong();
	  createMidiFile.setName(name);
	  if (playerroot.getGallery() == null) {
		  Gallery newGallery = mf.createGallery();
		  playerroot.setGallery(newGallery);
	  }
	  playerroot.getGallery().getGalleryItems().add(createMidiFile);
	  SongPart part = MidiplayerFactory.eINSTANCE.createSongPart();
	  part.setParttype(SongPartType.VERS);
	  SongTextLine textline = MidiplayerFactory.eINSTANCE.createSongTextLine();
	  SongChordPart chordpart = MidiplayerFactory.eINSTANCE.createSongChordPart();
	  chordpart.setText(" ");
	  textline.getChordParts().add(chordpart);
	  part.getTextlines().add(textline);
	  createMidiFile.getParts().add(part);
	  return createMidiFile;	  
  }

  /**
   * creates a new session  
   * @param currentModel model 
   * @param name  name of the new model
   */
	public static Session createSession(MidiPlayerRoot currentModel, String name) {
		
		Session newSession = mf.createSession(); 
		newSession.setName(name);
		currentModel.getSessions().add(newSession);
		
		return newSession;

	}

	public static void moveSessionItem(Session currentSession, int from, int to) {
   	  int max = currentSession.getItems().size();
	  if (from < 0 || to < 0 || from > max || to > max)
	     return;
	  
	  AbstractSessionItem copyItem = currentSession.getItems().get(from);
	  AbstractSessionItem dummy = mf.createSong();
	  currentSession.getItems().set(from, dummy);
	  currentSession.getItems().add(to, copyItem);
	  currentSession.getItems().remove(dummy);
	}


}