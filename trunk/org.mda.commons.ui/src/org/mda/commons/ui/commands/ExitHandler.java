 
package org.mda.commons.ui.commands;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Inject;

/**
 * Handler to exit the application
 * @author mao
 */
public class ExitHandler {
	
  @Inject
  ApplicationSession applicationSession;	
  
  /**
   * logger
   */
  private static final Log LOGGER  = LogFactory.getLogger(ExitHandler.class);
  
  @Execute
  public void execute(IWorkbench workbench) {
	InjectService.injectObject(this);
    LOGGER.info("Exit workspace");
    
    applicationSession.save(applicationSession.getConfigFile());
    workbench.close();
  }
		
}