package org.mda.midi;

import java.util.ArrayList;
import java.util.Collection;

import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.MidiSystem;


public class MidiInfo {
	
	public Collection<MidiDeviceInfo> getAllMidiDevices () {
		Collection <MidiDeviceInfo> mididevices = new ArrayList<>();
		for (Info mdi: MidiSystem.getMidiDeviceInfo()) {
			mididevices.add(new MidiDeviceInfo(mdi));
		}
		
		return mididevices;
	}
	
	public MidiDeviceInfo findDevice (final String devicekey) {
		for (MidiDeviceInfo next: getAllMidiDevices()) {
			if (next.getKey().equals(devicekey))
				return next;
		}
		
		return null;
	}
	
	public int findDeviceIndex (final String devicekey) {
		int i = 0;
		for (MidiDeviceInfo next: getAllMidiDevices()) {
			if (next.getKey().equals(devicekey))
				return i;
			i++;
		}
		
		return -1;
	}
	
	

}
