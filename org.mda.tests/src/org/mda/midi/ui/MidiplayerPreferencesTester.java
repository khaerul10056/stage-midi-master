package org.mda.midi.ui;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.midi.ui.config.MidiDevicesPreferencePage;

public class MidiplayerPreferencesTester {
	/** @param args */
	public static void main(String[] args) throws Exception {
		InjectServiceMock.initialize();
		ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
		MidiDevicesPreferencePage page = InjectService.getInstance(MidiDevicesPreferencePage.class);
		session.load(null);
		Shell shell = new Shell();
		page.createControl(shell);
		shell.setVisible(true);

		while (!shell.isDisposed()) {
			if (!shell.getDisplay().readAndDispatch()) {
				shell.getDisplay().sleep();
			}
		}

	}

}
