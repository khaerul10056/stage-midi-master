package org.mda.midi.ui;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.midi.ui.config.MidiDevicesPreferencePage;
import org.mda.tests.StandaloneInjector;

public class MidiplayerPreferencesTester {
	/** @param args */
	public static void main(String[] args) throws Exception {
		ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class);
		MidiDevicesPreferencePage page = StandaloneInjector.getInstance(MidiDevicesPreferencePage.class);
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
