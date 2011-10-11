
package org.mda.editor.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MidiPlayerStandaloneSetup extends MidiPlayerStandaloneSetupGenerated{

	public static void doSetup() {
		new MidiPlayerStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

