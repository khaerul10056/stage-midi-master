package org.mda.commons.ui.user;

import junit.framework.Assert;
import mda.MidiplayerFactory;
import mda.User;

import org.junit.Test;

public class UserLabelProviderTest {
	
	@Test
	public void getName () {
		User user = MidiplayerFactory.eINSTANCE.createUser(); 
		user.setName("NAME"); 
		user.setFirstname("FIRSTNAME"); 
		UserLabelProvider provider = new UserLabelProvider(); 
		Assert.assertNull (provider.getText(""));
		Assert.assertEquals("FIRSTNAME NAME",  provider.getText(user));
		
	}

}
