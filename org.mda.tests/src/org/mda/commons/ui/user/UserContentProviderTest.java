package org.mda.commons.ui.user;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;

public class UserContentProviderTest {
	
    private final static ApplicationSession session = new ApplicationSession();
	
	@BeforeClass
	public static void beforeClass () {
		session.load(null);	
	}
	
	@Test
	public void getChildren () {
		UserContentProvider provider = new UserContentProvider(); 
		Assert.assertNull (provider.getElements(""));
		Assert.assertEquals (session.getCurrentModel().getUsers().size(), provider.getElements(session.getCurrentModel()).length);
		
	}

}
