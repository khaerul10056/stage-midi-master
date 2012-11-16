package org.mda.midi;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.MidiUnavailableException;

public class MidiDeviceInfo {
	
	private Info midiInfo;
	
	public MidiDeviceInfo (Info midiInfo) {
		this.midiInfo = midiInfo;
	}
	
	public String getDisplayname () {
		if (midiInfo == null)
			return "";
		return midiInfo.getName() + " - " + midiInfo.getVendor() + " - " + midiInfo.getVersion() + " - " + midiInfo.getDescription();
	}
	
	public String toString () {
		return getDisplayname();
	}

	public String getKey() {
		if (midiInfo == null)
			return "";
		return midiInfo.getName();
	}
	
	public boolean isTransmittingDevice () {
		return getDevice().getMaxTransmitters() != 0;
	}
	
	public boolean isRecievingDevice () {
		return getDevice().getMaxReceivers() != 0;
	}
	
	public MidiDevice getDevice () {
		try {
			return MidiSystem.getMidiDevice(midiInfo);
		} catch (MidiUnavailableException e) {
			throw new IllegalStateException(e);
		}
	}

}
