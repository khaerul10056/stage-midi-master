 
package org.mda.commons.ui.commands;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

/**
 * Handler to exit the application
 * @author mao
 */
public class ExitHandler {
  
  /**
   * logger
   */
  private static final Log LOGGER  = LogFactory.getLogger(ExitHandler.class);
  
  @Execute
  public void execute(IWorkbench workbench) {
    LOGGER.info("Exit workspace");
    workbench.close();
  }
		
}