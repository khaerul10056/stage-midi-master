package org.mda.midi;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MidiDeviceContentProvider implements IStructuredContentProvider{
	
	private boolean withEmptyEntry;
	private boolean recieving;
	private boolean transmitting;
	
	public MidiDeviceContentProvider(boolean withEmptyEntry, final boolean recieving, final boolean transmitting) {
		this.withEmptyEntry = withEmptyEntry;
		this.recieving = recieving;
		this.transmitting = transmitting;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getElements(Object inputElement) {
		Collection <Object> objects = new ArrayList<Object>();
		
		if (withEmptyEntry)
			objects.add(new MidiDeviceInfo(null));
		
		if (inputElement instanceof MidiInfo) 
		   objects.addAll(((MidiInfo)inputElement).getAllMidiDevices(recieving, transmitting));
		
		return objects.toArray();
	}
	
	public int findElement (final String key) {
		if (key == null)
			return -1;
		
		Object[] elements = getElements(new MidiInfo());
		for (int i = 0; i < elements.length; i++) {
			MidiDeviceInfo nextMidiInfo = (MidiDeviceInfo) elements [i];
			if (nextMidiInfo.getKey().equals(key))
					return i;
		}
		
		return -1;
	}

}
