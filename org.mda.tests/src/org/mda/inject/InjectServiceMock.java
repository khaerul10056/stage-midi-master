package org.mda.inject;

import java.util.HashSet;

import org.mda.CoreModule;
import org.mda.editor.preview.ui.PreviewUiModule;
import org.mda.javafx.presenter.javafx.PresenterJavaFxModule;
import org.mda.midi.MidiModule;
import org.mda.presenter.PresenterModule;
import org.mda.presenter.ui.PresenterUiModule;

/**
 * Mocks the Injector service
 * 
 * @author oleym
 * 
 */
public class InjectServiceMock {

	public static void initialize() {
		if (InjectService.cachedModules == null) {
			InjectService.cachedModules = new HashSet<>();
			InjectService.cachedModules.add(new CoreModule());
			InjectService.cachedModules.add(new MidiModule());
			InjectService.cachedModules.add(new PresenterUiModule());
			InjectService.cachedModules.add(new PreviewUiModule());
			InjectService.cachedModules.add(new TestModule());
			InjectService.cachedModules.add(new PresenterJavaFxModule());
			InjectService.cachedModules.add(new PresenterModule());
		}
	}

}
