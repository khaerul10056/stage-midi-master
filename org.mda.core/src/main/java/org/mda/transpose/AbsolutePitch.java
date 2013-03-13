package org.mda.transpose;

/**
 * Pitch with remarks in which octave it lays
 * @author oleym
 *
 */
public class AbsolutePitch {
	
	private final Pitch pitch; 
	
	
	private final int oktaveindex; //starting with 0
	
	public AbsolutePitch (final Pitch pitch, final int octaveindex) {
		this.pitch = pitch;
		this.oktaveindex = octaveindex;
	}

	public Pitch getPitch() {
		return pitch;
	}

	public int getOktaveindex() {
		return oktaveindex;
	}
	
	

	

}
