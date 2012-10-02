package org.mda.commons.ui;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;

public class SessionsContentProviderTest {
	
	private final static ApplicationSession session = new ApplicationSession();
	
	@BeforeClass
	public static void beforeClass () {
		session.load(null);	
	}
    
	
	@Test
	public void getChildren () {
		SessionsContentProvider provider = new SessionsContentProvider(); 
		Assert.assertNull (provider.getChildren(""));
		Assert.assertEquals (session.getCurrentModel().getSessions().size(), provider.getChildren(session.getCurrentModel()).length);
		Assert.assertNull (provider.getParent(session.getCurrentModel()));
	}
	
	@Test
	public void getElements () {
		SessionsContentProvider provider = new SessionsContentProvider(); 
		Assert.assertNull (provider.getElements(""));
		Assert.assertEquals (session.getCurrentModel().getSessions().size(), provider.getElements(session.getCurrentModel()).length);
	}
	
	@Test
	public void hasChildren () {
		SessionsContentProvider provider = new SessionsContentProvider(); 
		Assert.assertFalse (provider.hasChildren(""));
		Assert.assertTrue (provider.hasChildren(session.getCurrentModel()));
	}

}
