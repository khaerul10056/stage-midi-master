package org.mda.commons.ui.user;

import java.util.ArrayList;
import java.util.Collection;

import mda.MidiPlayerRoot;

import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.presenter.ui.config.UserPresentationConfigTab;
import org.mda.tests.StandaloneInjector;

public class UserShellTest {
	
	@Test
	public void buildAndRefresh () {
		
		ApplicationSession session = new ApplicationSession();
	    session.load(null);
	    MidiPlayerRoot model = session.getCurrentModel();
	    
	    Collection <IUserTab> userTabs = new ArrayList<IUserTab>(); 
	    userTabs.add(StandaloneInjector.getInstance(UserGeneralTab.class));
	    userTabs.add(StandaloneInjector.getInstance(UserPresentationConfigTab.class));
	    
	    Shell shell = new Shell();
	    UserShell usershell = new UserShell(shell, session, userTabs);
	    Assert.assertEquals (model.getUsers().size(), usershell.tblUsers.getItems().length);
//	    Assert.assertEquals ("Rausch", usershell.txtFamilyName.getText());
//	    Assert.assertEquals ("Dieter", usershell.txtFirstName.getText());
//	    Assert.assertEquals ("khd.rausch@t-online.de", usershell.txtMail.getText());
//	    Assert.assertFalse (usershell.chkWithChords.getSelection());
//	    usershell.tblUsers.setSelection(3);
//	    usershell.refreshDetails();
//	    
//	    Assert.assertEquals ("Meinel", usershell.txtFamilyName.getText());
//	    Assert.assertEquals ("Renate", usershell.txtFirstName.getText());
//	    Assert.assertEquals ("renate.meinel@gmx.de", usershell.txtMail.getText());
//	    Assert.assertFalse (usershell.chkWithChords.getSelection());
		
	}

}
