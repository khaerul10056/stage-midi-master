package org.mda.application;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import mda.Session;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.StartPresentation;

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
    session.load(null);
    session.setVersion(Activator.getDefault().getVersion());
    
    logFonts();
  }
  
  @ProcessAdditions
  public void runPresentationOnStartup (StartPresentation startpresentationDirectly,  @Named(IServiceConstants.ACTIVE_SHELL) Shell activeShell) {
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
							session.setCurrentSession(nextSession);
//							try {
//								startpresentationDirectly.execute(Display.getDefault().getActiveShell());
//							} catch (ExecutionException e) {
//								e.printStackTrace();
//							}
							//ParameterizedCommand myCommand = commandservice.createCommand("org.mda.commons.ui.command.searchengine", new HashMap());
							//Object result = handlerservice.executeHandler(myCommand);
							return;
						}
					}
				}
			}
			
		}
		
	  
  }
  
  private void logFonts () {
	  LOGGER.info("All registered fonts:");
	  GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Font[] fonts = e.getAllFonts(); // Get the fonts
	    for (Font f : fonts) {
	      LOGGER.info("-" + f.getFontName() + "-" + f.getFamily() + "-" + f.getFamily(Locale.getDefault()));
	    }
  }


}
