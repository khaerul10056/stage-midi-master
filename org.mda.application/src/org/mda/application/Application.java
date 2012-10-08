package org.mda.application;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Locale;

import javax.inject.Inject;

import mda.Session;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

/**
 * This class controls all aspects of the application's lifecycle, 
 * it is registered in plugin.xml
 */
public class Application {

  private static final Log LOGGER  = LogFactory.getLogger(Application.class);

  @Inject
  private ApplicationSession session;
  
  
  @PostContextCreate
  public void initializeSession () {
	LOGGER.debug("initializeSession called");
    session.load(null);
    session.setVersion(Activator.getDefault().getVersion());
    
    logFonts();
    String[] applicationArgs = Platform.getApplicationArgs();
    runPresentationOnStartup(applicationArgs);
    
  }
  
  public void runPresentationOnStartup (String[] applicationArgs) {
	  LOGGER.info("runPresentationOnStartup");
	  
		
		for (int i = 0; i  < applicationArgs.length; i++) {
			String nextArg = applicationArgs [i]; 
			
			if (nextArg.equals("-session")) {
				if (i + 1 < applicationArgs.length) {
					String sessionArg = applicationArgs [i +1];
					String sessionTrimmed = Utils.removeWhitespaces(sessionArg);
					
					String existingSessions = "";
					
					for (Session nextSession: session.getCurrentModel().getSessions()) {
						String found = Utils.removeWhitespaces(nextSession.getName());
						if (found.equalsIgnoreCase(sessionTrimmed)) {
							LOGGER.info("Starting with session " + sessionTrimmed);
							session.getFeatureActivation().setRunSession(nextSession);
							return;
						}
						else {
							if (! existingSessions.isEmpty())
								existingSessions+=",";
							
							existingSessions+=found;
						}
					}
					
					if (session.getFeatureActivation().getRunSession() == null)
						throw new IllegalArgumentException("Could not find session <" + sessionArg + "> in current model. Existing session: <" + existingSessions + ">");
				}
			}
		}
  }
  
  public void logFonts () {
	  LOGGER.info("All registered fonts:");
	  GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Font[] fonts = e.getAllFonts(); // Get the fonts
	    for (Font f : fonts) {
	      LOGGER.info("-" + f.getFontName() + "-" + f.getFamily() + "-" + f.getFamily(Locale.getDefault()));
	    }
  }


}
