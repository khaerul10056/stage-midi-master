package org.mda.editor.preview.ui;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Binder;
import com.google.inject.Module;

public class PreviewUiModule implements Module {
	
	private static final Log LOGGER = LogFactory.getLogger(PreviewUiModule.class);

	@Override
	public void configure(Binder binder) {
		LOGGER.info("Setup dependency injection");
		
		
	}

}
