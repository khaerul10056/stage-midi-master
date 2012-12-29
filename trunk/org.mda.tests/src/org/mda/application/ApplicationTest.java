package org.mda.application;

import mda.Session;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;

public class ApplicationTest {
	
	@BeforeClass
	public static void beforeClass () {
		InjectServiceMock.initialize();		
	}
	
	@Test
	public void logFonts () {
		Application app = InjectService.getInstance(Application.class);
		app.logFonts();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sessionNotFound () {
		ApplicationSession session = InjectService.getInstance(ApplicationSession.class); 
		session.load(null);
		
		Application app = InjectService.getInstance(Application.class);
		String [] params = new String [] {"-session", "Hello"};
		app.runPresentationOnStartup(params);
	}
	
	@Test
	public void sessionFound () {
		ApplicationSession session = InjectService.getInstance(ApplicationSession.class); 
		session.load(null);
		
		Session newSession = MidiPlayerService.mf.createSession();
		newSession.setName("my new Session");
		session.getCurrentModel().getSessions().add(newSession);
		
		Application app = InjectService.getInstance(Application.class);
		String [] params = new String [] {"-session", "MyNewSession"};
		app.runPresentationOnStartup(params);
		
		Assert.assertEquals (newSession, session.getFeatureActivation().getRunSession());
		
	}

}
