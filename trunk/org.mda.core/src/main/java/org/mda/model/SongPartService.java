package org.mda.model;

import mda.SongPart;

/**
 * service contains methods to make changes on the model regarding to one songpart 
 * @author OleyMa
 */
public class SongPartService {
	/**
	   * removes a complete line from a part
	   * @param part part
	   * @param line line
	   * @return part
	   */
	  public final SongPart removeLine (final SongPart part, final int line) {
	    part.getTextlines().remove(line);
	    return part;
	  }	
	
}
