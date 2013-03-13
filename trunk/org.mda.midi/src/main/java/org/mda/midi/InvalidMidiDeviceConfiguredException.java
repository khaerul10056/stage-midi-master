package org.mda.midi;

public class InvalidMidiDeviceConfiguredException extends Exception {

	private final String midiDeviceKey;

	public InvalidMidiDeviceConfiguredException(String midiDeviceKey) {
		this.midiDeviceKey = midiDeviceKey;
	}

	public String getMidiDeviceKey() {
		return midiDeviceKey;
	}

}
