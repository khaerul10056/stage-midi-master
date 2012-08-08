package org.mda.editor.preview.ui.test;

import mda.MidiFile;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.editor.preview.ui.PreviewEditorComposite;
import org.mda.tests.StandaloneInjector;

public class AbstractEditorTest {
	protected static PreviewEditorComposite editor = StandaloneInjector.getInstance(PreviewEditorComposite.class);;

	protected static ApplicationSession applicationSession = StandaloneInjector.getInstance(ApplicationSession.class);

	protected static Shell shell = new Shell();

	/**
	 * sets the first part of the song in the editor, builds the component and
	 * sets the song as currentMidifile
	 * 
	 * @param song
	 */
	protected void prepareEditor(final MidiFile song) {
		applicationSession.setCurrentMidifile(song);
		editor.build(shell);
		if (song.getParts().size() > 0)
			editor.setCurrentPart(song.getParts().get(0));
	}

}
