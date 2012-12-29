package org.mda.midi.ui;

import org.eclipse.jface.viewers.LabelProvider;
import org.junit.Assert;
import org.junit.Test;
import org.mda.midi.MidiDeviceContentProvider;
import org.mda.midi.MidiInfo;

public class MidiDeviceContentProviderTest {
	
	@Test
	public void provide () {
		MidiDeviceContentProvider contentProvider = new MidiDeviceContentProvider(true, true, true); 
		Object[] elements = contentProvider.getElements(new MidiInfo());
		LabelProvider defaultLabelProvider = new LabelProvider();
		String text0 = defaultLabelProvider.getText(elements [0]);
		String text1 = defaultLabelProvider.getText(elements [1]);
		Assert.assertTrue(text0.trim().isEmpty());
		Assert.assertFalse(text1.trim().isEmpty());
	}

}
