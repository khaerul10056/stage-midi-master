package org.mda.midi;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mda.midi.MidiDeviceInfo;
import org.mda.midi.MidiInfo;


public class MidiInfoTest {
	
	@Test
	public void infos () {
		MidiInfo info = new MidiInfo();
		Collection<MidiDeviceInfo> allMidiDevices = info.getAllMidiDevices(true, true);
		Assert.assertTrue (allMidiDevices.size() > 0);
	}

}
