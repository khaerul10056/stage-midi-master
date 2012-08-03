package org.mda.commons.ui.user;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;


public class UserHandler {

  @Execute
  public Object execute (Shell parentShell, ApplicationSession session) throws ExecutionException {
    new UserShell(parentShell, session);
    
    return null;
  }

}
