package org.mda.model;

import java.util.ArrayList;
import java.util.Collection;

import mda.MidiPlayerRoot;
import mda.Session;
import mda.Song;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.test.ModelCreator;
import org.mda.test.SongCreator;


/**
 * tests for the session service
 * @author OleyMa
 */
public class SessionServiceTest {
	
	private SessionService sessionService = new SessionService();
	
	private MidiPlayerRoot model;
	
	
	@Before
	public void before () {
		model = ModelCreator.create().addSession("Hello").addSession("Second session").addSession("Third session").get();
	}
	
	
	@Test
	public void getReferenced() {

		Song creator = SongCreator.create().setName("Hello").get();
		Song creator2 = SongCreator.create().setName("Hello2").get();
		final String TESTSESSION = "TESTSESSION";

		MidiPlayerRoot root = MidiPlayerService.mf.createMidiPlayerRoot();
		Session session = MidiPlayerService.mf.createSession();
		session.setName(TESTSESSION);
		session.getItems().add(creator2);
		root.getSessions().add(session);

		String referenced1 = sessionService.getReferencedSessionItem(root, creator);
		Assert.assertNull(referenced1);

		String referenced2 = sessionService.getReferencedSessionItem(root, creator2);
		Assert.assertTrue(referenced2.indexOf(TESTSESSION) >= 0);

	}
	
	@Test
	public void removeSessions () {
		Collection <Session> sessionsToRemove = new ArrayList<>();
		sessionsToRemove.add(model.getSessions().get(1));
		sessionsToRemove.add(model.getSessions().get(2));
		sessionService.removeSessions(sessionsToRemove);
		
		Assert.assertEquals (1, model.getSessions().size());
		Assert.assertEquals ("Hello", model.getSessions().get(0).getName());
		
	}
	
	@Test
	public void findByNameOk () {
		Session foundSession = sessionService.findSessionByName(model, "Hello");
		Assert.assertEquals ("Sessionname of found session invalid", foundSession.getName(), "Hello");
		Assert.assertEquals ("Session is invalid", foundSession, model.getSessions().get(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void findByNameNotFound () {
		sessionService.findSessionByName(model, "Heasllo");
	}
	
	
	
	
	
	

}
