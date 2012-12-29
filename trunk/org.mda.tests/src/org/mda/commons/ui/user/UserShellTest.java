package org.mda.commons.ui.user;

import java.util.ArrayList;
import java.util.Collection;

import mda.MidiPlayerRoot;

import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.presenter.ui.config.UserPresentationConfigTab;

public class UserShellTest {
	
	@Test
	public void buildAndRefresh () {
		InjectServiceMock.initialize(); 
		
		ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
	    session.load(null);
	    MidiPlayerRoot model = session.getCurrentModel();
	    
	    Collection <IUserTab> userTabs = new ArrayList<IUserTab>(); 
	    userTabs.add(InjectService.getInstance(UserGeneralTab.class));
	    userTabs.add(InjectService.getInstance(UserPresentationConfigTab.class));
	    
	    Shell shell = new Shell();
	    UserShell usershell = new UserShell(shell, session, userTabs);
	    Assert.assertEquals (model.getUsers().size(), usershell.tblUsers.getItems().length);
	}

}
