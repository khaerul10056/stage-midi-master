 
package org.mda.commons.ui;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.mda.ApplicationSession;
import org.mda.commons.ui.find.SearchEnginePanel;

public class SearchEngineHandler {
	
	
	
	@Execute
	public void execute(ApplicationSession appsession, SearchEnginePanel panel) {
		panel.build();
	}
		
}