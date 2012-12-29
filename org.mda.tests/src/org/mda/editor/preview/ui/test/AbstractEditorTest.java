package org.mda.editor.preview.ui.test;

import mda.MidiFile;

import org.eclipse.swt.widgets.Shell;
import org.junit.BeforeClass;
import org.mda.ApplicationSession;
import org.mda.editor.preview.ui.PreviewEditorComposite;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;


public class AbstractEditorTest {
	protected static PreviewEditorComposite editor; 
	protected static ApplicationSession applicationSession; 

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
	
	@BeforeClass
	public static void beforeClass () {
		InjectServiceMock.initialize();
		editor = InjectService.getInstance(PreviewEditorComposite.class);
		applicationSession = InjectService.getInstance(ApplicationSession.class);
	    applicationSession.load(null);
	}

}
