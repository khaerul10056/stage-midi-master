 
package org.mda.commons.ui;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.mda.ApplicationSession;

public class SaveModelHandler {
	@Execute
	public void execute(ApplicationSession appSession) {
		appSession.saveModel();
	}
		
}