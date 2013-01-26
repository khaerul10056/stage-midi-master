package org.mda.midi;

import mda.Song;
import mda.SongPart;

import org.eclipse.emf.ecore.EObject;

public class MidiFileInvalidBarData {
	
	public final static String NOBARDATA_AVAILABLE = "No bardata available";
	public final static String WRONG_BARORDER = "Wrong barorder";
	
	private EObject location;
	private String currentMessage;
	
	public static MidiFileInvalidBarData createNoBarDataAvailableEntry (final Song file) {
		MidiFileInvalidBarData bardata = new MidiFileInvalidBarData(); 
		bardata.setLocation(file);
		bardata.setCurrentMessage(NOBARDATA_AVAILABLE);
		return bardata; 
	}
	
	public static MidiFileInvalidBarData createWrongBarOrderEntry (final SongPart laterPart) {
		MidiFileInvalidBarData bardata = new MidiFileInvalidBarData(); 
		bardata.setLocation(laterPart);
		bardata.setCurrentMessage(NOBARDATA_AVAILABLE);
		return bardata; 
	}

	public String getCurrentMessage() {
		return currentMessage;
	}

	private void setCurrentMessage(String currentMessage) {
		this.currentMessage = currentMessage;
	}

	public EObject getLocation() {
		return location;
	}

	private void setLocation(EObject location) {
		this.location = location;
	}
	
	
	
	
}
