package org.mda.application;

import org.mda.ApplicationSession;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IGraphicsContext;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.calculator.SWTGraphicsContext;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class ApplicationModule implements Module {

	@Override
	public void configure(Binder binder) {
		
		binder.bind(ApplicationSession.class).in(Singleton.class);
		binder.bind(IGraphicsContext.class).to(SWTGraphicsContext.class);
		binder.bind(IMidiFileEditorUIConfig.class).to(DefaultMidiFileContentEditorConfig.class);
	}

	
}
