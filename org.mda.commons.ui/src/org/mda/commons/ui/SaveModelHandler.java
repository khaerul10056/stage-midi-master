 
package org.mda.commons.ui;

import org.eclipse.e4.core.di.annotations.Execute;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Inject;

public class SaveModelHandler {
	
	private static final Log LOGGER  = LogFactory.getLogger(SaveModelHandler.class);
	
	@Inject
	private ApplicationSession session;
	
	@Execute
	public void execute() {
		LOGGER.info("Save model");
		InjectService.injectObject(this);
		session.saveModel();
	}
		
}