package org.mda.application;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Locale;

import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.mda.ApplicationSession;
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
    session.load(null);
    session.setVersion(Activator.getDefault().getVersion());
    
    logFonts();
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
