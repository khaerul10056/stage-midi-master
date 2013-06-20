package org.mda.model;

import mda.MidiplayerFactory;
import mda.Song;
import mda.SongPart;
import mda.SongPartType;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;

/**
 * service contains methods to make changes on the model regarding to one song 
 * and changing features of the song or the order of songparts
 * @author OleyMa
 */
public class SongService {
	
	/**
	 * factory from EMF
	 */
	public static final MidiplayerFactory mf           = MidiplayerFactory.eINSTANCE;
	  
	/**
	 * logger
	*/
	private static final Log LOGGER  = LogFactory.getLogger(SongPartService.class);

	
	/**
	 * moves a part up in the list of parts of a file
	 * 
	 * @param song			song
	 * @param part			part to move up
	 * @return moved part
	 */
	public SongPart movePartUp(Song song, SongPart part) {
		int i = song.getParts().indexOf(part);
		if (i == 0) // if first do nothing
			return part;

		song.getParts().remove(i);
		song.getParts().add(i - 1, part);
		return song.getParts().get(i - 1);
	}
	
	/**
	 * move a part down in the list of parts of a file
	 * 
	 * @param song       	the song
	 * @param partToMove    part to move
	 * @return moved part
	 */
	public SongPart movePartDown(Song song, SongPart partToMove) {
		int i = song.getParts().indexOf(partToMove);
		if (i == song.getParts().size() - 1) // if last do nothing
			return partToMove;

		song.getParts().remove(i);
		song.getParts().add(i + 1, partToMove);
		return song.getParts().get(i + 1);
	}

	/**
	 * removes the given part from the file
	 * 
	 * @param song        	the song
	 * @param partToRemove  part to remove 
	 * @return removed part
	 */
	public SongPart removePart(final Song song, SongPart partToRemove) {
		int index = song.getParts().indexOf(partToRemove);
		if (index >= 0)
			song.getParts().remove(partToRemove);

		index--;
		if (index < 0)
			index = 0;

		if (song.getParts().size() > 0)
			return song.getParts().get(index);
		else
			return null;
	}
	
	/** adds a new part after the addAfter-parent
	   * @param song the song
	   * @param addAfter after this part the new part is inserted, if null than it is added to end
	   * @param midiFilePartType type of the new part
	   * @param reference referenced part, if the new part should be a reference to another part, maybe <code>null</code>
	   * @return */
	public static int addPartAfter (Song song, SongPart addAfter, SongPartType midiFilePartType, SongPart reference) {

	    if (reference != null && midiFilePartType != null && reference.getRefPart().getParttype() != midiFilePartType)
	      LOGGER.warn("addPartAfter was called with different types for direct parameter and reference, using the type " + reference.getParttype() + " from reference");

	    int index = addAfter != null ? song.getParts().indexOf(addAfter): (song.getParts().size() - 1);
	    SongPart newPart = mf.createSongPart();
	    newPart.getTextlines().add(mf.createSongTextLine());
	    newPart.setParttype(midiFilePartType);
	    if (reference != null) {
	      newPart.setParttype(reference.getParttype());
	      newPart.setRefPart(reference);
	    }
	    song.getParts().add(index + 1, newPart);
	    return index + 1;
	  }
	
	
	

}
