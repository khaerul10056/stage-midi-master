package org.mda.midi.ui.config;

import javax.inject.Inject;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.mda.ApplicationSession;
import org.mda.commons.ui.util.UIUtils;
import org.mda.midi.MidiDeviceInfo;
import org.mda.midi.MidiDeviceContentProvider;
import org.mda.midi.MidiInfo;


public class MidiDevicesPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	
	@Inject
	ApplicationSession appSession;
	
	private ComboViewer viewer;
	
	private MidiInfo midiinfo = new MidiInfo();

	@Override
	public void init(IWorkbench workbench) {
	}
	
	@Override
	protected Control createContents(Composite parent) {
		parent.setLayout(UIUtils.createLayout(2, 20));
		
		Label lblMidiDevices = new Label(parent, SWT.NONE);
		lblMidiDevices.setLayoutData(UIUtils.getContentData(2));
		lblMidiDevices.setText("Midi-Device");
		lblMidiDevices.setLayoutData(UIUtils.getLabelData());
		
		Combo cmbMidiDevice = new Combo(parent, SWT.NONE);
		viewer = new ComboViewer(cmbMidiDevice);
		cmbMidiDevice.setLayoutData(UIUtils.getContentData());
		viewer.setContentProvider(new MidiDeviceContentProvider(true));
		viewer.setLabelProvider(new LabelProvider());
		viewer.setInput(midiinfo);
		
		int foundDevice = midiinfo.findDeviceIndex(appSession.getCurrentModel().getConfig().getMididevice());
		if (foundDevice >= 0) 
			cmbMidiDevice.select(foundDevice + 1);	
		
		return parent;
	}
	
	@Override
	public boolean performOk() {
		if (appSession == null)
			return true;
		
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection(); 
		MidiDeviceInfo firstElement = (MidiDeviceInfo) selection.getFirstElement();
		
		if (firstElement != null && firstElement.getKey().trim().length() > 0)
		  appSession.getConfig().setMididevice(firstElement.getKey());
		else
		  appSession.getConfig().setMididevice(null);
		
		appSession.saveModel();
		return true;
	}

}
