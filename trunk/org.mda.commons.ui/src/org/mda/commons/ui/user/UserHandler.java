package org.mda.commons.ui.user;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;


public class UserHandler extends AbstractHandler{

  @Override
  public Object execute (ExecutionEvent arg0) throws ExecutionException {
    Shell parentShell = HandlerUtil.getActiveWorkbenchWindow(arg0).getShell();
    new UserShell(parentShell);
    return null;
  }

}
