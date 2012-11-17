package org.mda.commons.ui.user;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;

import com.google.inject.Inject;


public class UserHandler {
	
  @Inject
  ApplicationSession session; 

  @Execute
  public Object execute (Shell parentShell, IEclipseContext context) throws ExecutionException {
	InjectService.injectObject(this);
	Collection <IUserTab> tabs = UserTabExt.createRegisteredUsertabs(context);
    new UserShell(parentShell, session, tabs);
    
    return null;
  }

}
