package org.mda.midi;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class MidiInfoTest {
	
	
	@Test
	public void infos () {
		MidiInfo info = new MidiInfo();
		Collection<MidiDeviceInfo> allMidiDevices = info.getAllMidiDevices();
		Assert.assertTrue (allMidiDevices.size() > 0);
	}

}
