package org.mda.commons.ui;

import javax.inject.Inject;

import mda.Session;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Execute;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

/**
 * Reads the commandline parameter and configures: 
 * - run session at startup
 * 
 * @author mao
 *
 */
public class RunSessionProcessor {
	
	@Inject
	private ApplicationSession session;
	
	private static final Log LOGGER  = LogFactory.getLogger(RunSessionProcessor.class);


	@Execute
	public void execute() {
		String[] applicationArgs = Platform.getApplicationArgs();
		
		for (int i = 0; i  < applicationArgs.length; i++) {
			String nextArg = applicationArgs [i]; 
			
			if (nextArg.equals("-session")) {
				if (i + 1 < applicationArgs.length) {
					String sessionArg = applicationArgs [i +1];
					String sessionTrimmed = Utils.removeWhitespaces(sessionArg);
					
					for (Session nextSession: session.getCurrentModel().getSessions()) {
						String found = Utils.removeWhitespaces(nextSession.getName());
						if (found.equals(sessionTrimmed)) {
							LOGGER.info("Starting with session " + sessionTrimmed);
							session.getFeatureActivation().setRunSession(nextSession);
							return;
						}
					}
				}
			}
			
		}
		
	}
}
