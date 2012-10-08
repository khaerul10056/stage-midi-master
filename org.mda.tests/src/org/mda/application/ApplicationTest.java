package org.mda.application;

import mda.Session;

import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.tests.StandaloneInjector;

public class ApplicationTest {
	
	@Test
	public void logFonts () {
		Application app = StandaloneInjector.getInstance(Application.class);
		app.logFonts();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sessionNotFound () {
		ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class); 
		session.load(null);
		
		Application app = StandaloneInjector.getInstance(Application.class);
		String [] params = new String [] {"-session", "Hello"};
		app.runPresentationOnStartup(params);
	}
	
	@Test
	public void sessionFound () {
		ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class); 
		session.load(null);
		
		Session newSession = MidiPlayerService.mf.createSession();
		newSession.setName("my new Session");
		session.getCurrentModel().getSessions().add(newSession);
		
		Application app = StandaloneInjector.getInstance(Application.class);
		String [] params = new String [] {"-session", "MyNewSession"};
		app.runPresentationOnStartup(params);
		
		Assert.assertEquals (newSession, session.getFeatureActivation().getRunSession());
		
	}

}
