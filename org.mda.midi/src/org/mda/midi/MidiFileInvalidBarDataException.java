package org.mda.midi;

import java.util.ArrayList;
import java.util.List;

public class MidiFileInvalidBarDataException extends Exception {
	
	private final List<MidiFileInvalidBarData> invalidBarDataCollected = new ArrayList<MidiFileInvalidBarData>();
	
	
	public void addInvalidBarData (final MidiFileInvalidBarData data)  {
		getInvalidBarDataCollected().add(data);
	}
	
	public boolean mustBeThrown () {
		return getInvalidBarDataCollected().size() > 0;
	}

	public List<MidiFileInvalidBarData> getInvalidBarDataCollected() {
		return invalidBarDataCollected;
	}

}
