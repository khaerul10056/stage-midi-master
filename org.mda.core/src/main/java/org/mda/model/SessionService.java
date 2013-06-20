package org.mda.model;

import java.util.Collection;
import java.util.Comparator;

import mda.AbstractSessionItem;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.Session;

import org.eclipse.emf.common.util.ECollections;
import org.mda.Utils;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
/**
 * service contains methods to make changes on the model regarding to sessions 
 * @author OleyMa
 */
public class SessionService {
	
	/**
	 * factory from EMF
	 */
	public static final MidiplayerFactory mf           = MidiplayerFactory.eINSTANCE;
	  
	/**
	 * logger
	*/
	private static final Log LOGGER  = LogFactory.getLogger(SongPartService.class);
	
	/**
	 * removes a session
	 * @param session		current session
	 * @param sessionItemToRemove  session item that should be removed
	 * @return
	 */
	public Session removeSessionItem(Session session, AbstractSessionItem sessionItemToRemove) {

		if (session == null)
			throw new NullPointerException("Parameter session must not be null");
		if (sessionItemToRemove == null)
			throw new NullPointerException("Parameter sessionItemToRemove not be null");

		session.getItems().remove(sessionItemToRemove);
		return session;
	}
	
	/**
	 * check if the session item is reverenced
	 * 
	 * @param rootobject
	 * @return errormessage or <code>null</code> if object is not referenced
	 *         anymore
	 */
	public String getReferencedSessionItem(final MidiPlayerRoot rootobject,
			final AbstractSessionItem sessionitem) {
		StringBuilder builder = new StringBuilder();
		int numberOfSession = 0;

		for (Session session : rootobject.getSessions()) {
			for (AbstractSessionItem nextSessionitem : session.getItems()) {
				if (sessionitem == nextSessionitem) {
					numberOfSession++;
					builder.append("- " + session.getName() + "\n");
				}
			}
		}

		if (builder.length() == 0)
			return null;

		if (numberOfSession == 1)
			builder.insert(0, sessionitem.getName() + " is referenced in the following session:\n");
		else
			builder.insert(0, sessionitem.getName() + " is referenced in the following " + numberOfSession + "sessions:\n");

		builder.append("\nRemove it anyway?");

		return builder.toString();

	}

	/**
	 * removes all sessions from their container
	 * 
	 * @param sessionsToRemove
	 *            list of sessions to be removed, must live in a container
	 */
	public void removeSessions(Collection<Session> sessionsToRemove) {
		MidiPlayerRoot root = null;
		for (Session next : sessionsToRemove) {
			root = (MidiPlayerRoot) next.eContainer();
			root.getSessions().remove(next);
		}
		// todo in service and check, disable button if selected item that is still referenced
		if (root != null)
			sortSession(root);
	}
	
	/**
	 * find session by name
	 * @param model			model
	 * @param sessionName	name of session to look for
	 * @return session that was found
	 */
	public Session findSessionByName (final MidiPlayerRoot model, final String sessionName) {
		String sessionTrimmed = Utils.removeWhitespaces(sessionName);
		
		String existingSessions = "";
		
		for (Session nextSession: model.getSessions()) {
			String found = Utils.removeWhitespaces(nextSession.getName());
			if (found.equalsIgnoreCase(sessionTrimmed)) {
				LOGGER.info("Starting with session " + sessionTrimmed);
				return nextSession;
			}
			else {
				if (! existingSessions.isEmpty())
					existingSessions+=",";
				
				existingSessions+=found;
			}
		}
		
		throw new IllegalArgumentException("Could not find session <" + sessionName + "> in current model. Existing session: <" + existingSessions + ">");
  }

	public void sortSession(final MidiPlayerRoot root) {
		ECollections.sort(root.getSessions(), new Comparator<Session>() {

			@Override
			public int compare(Session o1, Session o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

}
