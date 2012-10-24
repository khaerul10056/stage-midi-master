package org.mda.midi;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MidiDeviceContentProvider implements IStructuredContentProvider{
	
	private boolean withEmptyEntry;
	
	public MidiDeviceContentProvider(boolean withEmptyEntry) {
		this.withEmptyEntry = withEmptyEntry;
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
		   objects.addAll(((MidiInfo)inputElement).getAllMidiDevices());
		
		return objects.toArray();
	}

}
