package org.mda.commons.ui.config;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.mda.ApplicationSession;


public class ConfigHandler extends AbstractHandler {

  private ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    Shell parentShell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
    ConfigShell shell = new ConfigShell(parentShell, session.getCurrentModel().getConfig());
    return null;
  }

}
