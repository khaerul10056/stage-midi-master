package org.mda.test;

import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.Session;

/**
 * creator to create model for the tests
 * implemented as builder
 * @author OleyMa
 *
 */
public class ModelCreator {

	/**
	 * factory from EMF
	 */
	private MidiplayerFactory factory = MidiplayerFactory.eINSTANCE;

	/**
	 * created model root element
	 */
	private MidiPlayerRoot root;

	/**
	 * private constructor
	 */
	private ModelCreator() {
		root = factory.createMidiPlayerRoot();
	}
	
	/**
	 * create method
	 * @return new model creator
	 */
	public static ModelCreator create () {
		return new ModelCreator();
	}

	/**
	 * add a session to the model
	 * @param name  name of session
	 * @return self instance
	 */
	public ModelCreator addSession(final String name) {
		Session session = factory.createSession();
		session.setName(name);
		root.getSessions().add(session);
		return this;
	}

	/**
	 * return the created model root
	 * @return root
	 */
	public MidiPlayerRoot get() {
		
		if (root.getGallery() == null)
			root.setGallery(factory.createGallery());
		
		if (root.getConfig() == null)
			root.setConfig(factory.createConfiguration());
		
		return root;

	}

}
