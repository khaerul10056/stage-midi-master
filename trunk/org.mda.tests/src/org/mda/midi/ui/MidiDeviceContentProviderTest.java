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
		String text = defaultLabelProvider.getText(elements [0]);
		Assert.assertTrue (text.length() > 0);
	}

}
