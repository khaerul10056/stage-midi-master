package org.mda.midi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.MidiSystem;
import javax.sound.sampled.ReverbType;


public class MidiInfo {
	
	public Collection<MidiDeviceInfo> getAllMidiDevices (final boolean recieving, final boolean transmitting) {
		Collection <MidiDeviceInfo> mididevices = new ArrayList<>();
		for (Info mdi: MidiSystem.getMidiDeviceInfo()) {
			MidiDeviceInfo midiDeviceInfo = new MidiDeviceInfo(mdi);
			if (midiDeviceInfo.isRecievingDevice() && recieving)
  			  mididevices.add(midiDeviceInfo);
			else if (midiDeviceInfo.isTransmittingDevice() && transmitting)
			  mididevices.add(midiDeviceInfo);
		}
		
		return mididevices;
	}
	
	public List<MidiDeviceInfo> findDeviceInfos (final String devicekey) {
		List<MidiDeviceInfo> found = new ArrayList<>();
		for (MidiDeviceInfo next: getAllMidiDevices(true, true)) {
			if (next.getKey().equals(devicekey))
				found.add(next);
		}
		
		return found;
	}
	
	public MidiDeviceInfo findDeviceInfoTransmitting (final String devicekey) {
		for (MidiDeviceInfo next: getAllMidiDevices(false, true)) {
			if (next.getKey().equals(devicekey) && next.isTransmittingDevice())
				return next;
		}
		
		return null;
	}
	
	public MidiDeviceInfo findDeviceInfoRecieving (final String devicekey) {
		for (MidiDeviceInfo next: getAllMidiDevices(true, false)) {
			if (next.getKey().equals(devicekey) && next.isRecievingDevice())
				return next;
		}
		
		return null;
	}
	
	

}
