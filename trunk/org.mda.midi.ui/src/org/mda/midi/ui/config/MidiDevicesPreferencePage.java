package org.mda.midi.ui.config;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.mda.ApplicationSession;
import org.mda.commons.ui.util.UIUtils;
import org.mda.inject.InjectService;
import org.mda.midi.MidiDeviceContentProvider;
import org.mda.midi.MidiDeviceInfo;
import org.mda.midi.MidiInfo;

import com.google.inject.Inject;


public class MidiDevicesPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	
	@Inject
	ApplicationSession appSession;
	
	private ComboViewer viewer;
	private ComboViewer viewer2;
	
	private MidiInfo midiinfo = new MidiInfo();

	@Override
	public void init(IWorkbench workbench) {
	}
	
	@Override
	protected Control createContents(Composite parent) {
		InjectService.injectObject(this);
		parent.setLayout(UIUtils.createLayout(2, 20));
		
		Label lblMidiDevices = new Label(parent, SWT.NONE);
		lblMidiDevices.setLayoutData(UIUtils.getContentData(2));
		lblMidiDevices.setText("Midi-Device");
		lblMidiDevices.setLayoutData(UIUtils.getLabelData());
		
		
		Combo cmbMidiDevice = new Combo(parent, SWT.NONE);
		viewer = new ComboViewer(cmbMidiDevice);
		cmbMidiDevice.setLayoutData(UIUtils.getContentData());
		MidiDeviceContentProvider provider = new MidiDeviceContentProvider(true, false, true);
		viewer.setContentProvider(provider);
		viewer.setLabelProvider(new LabelProvider());
		viewer.setInput(midiinfo);
		
		Label lblMidiDevices2 = new Label(parent, SWT.NONE);
		lblMidiDevices2.setLayoutData(UIUtils.getContentData(2));
		lblMidiDevices2.setText("Alternative Midi-Device");
		lblMidiDevices2.setLayoutData(UIUtils.getLabelData());
		
		Combo cmbMidiDevice2 = new Combo(parent, SWT.NONE);
		viewer2 = new ComboViewer(cmbMidiDevice2);
		cmbMidiDevice2.setLayoutData(UIUtils.getContentData());
		viewer2.setContentProvider(provider);
		viewer2.setLabelProvider(new LabelProvider());
		viewer2.setInput(midiinfo);
		
		int foundDevice = provider.findElement(getConfiguredMididevice(0));
		if (foundDevice >= 0) 
			cmbMidiDevice.select(foundDevice);	
		
		int foundDevice2 = provider.findElement(getConfiguredMididevice(1));
		if (foundDevice2 >= 0) 
			cmbMidiDevice2.select(foundDevice2);
		
		return parent;
	}
	
	private String [] getConfiguredMididevices () {
		if (appSession.getCurrentModel().getConfig().getMididevice() == null)
		  return new String [0];
		else
		  return appSession.getCurrentModel().getConfig().getMididevice().split("#");
	}
	
	private String getConfiguredMididevice (int index) {
		String [] devices = getConfiguredMididevices ();
		if (devices.length > index)
			return devices [index]; 
		else
			return null;
	}
	
	@Override
	public boolean performOk() {
		if (appSession == null)
			return true;
		
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection(); 
		MidiDeviceInfo firstElement = (MidiDeviceInfo) selection.getFirstElement();
		String firstKey = firstElement != null ? firstElement.getKey().trim() : "";
		
		IStructuredSelection selection2 = (IStructuredSelection) viewer2.getSelection(); 
		MidiDeviceInfo firstElement2 = (MidiDeviceInfo) selection2.getFirstElement();
		String firstKey2 = firstElement2 != null ? firstElement2.getKey().trim() : "";
		
		if (firstKey.length() == 0 && firstKey2.length() == 0) 
			appSession.getConfig().setMididevice(null);
		else
			appSession.getConfig().setMididevice(firstKey + "#" + firstKey2);
		  
		
		appSession.saveModel();
		return true;
	}

}
