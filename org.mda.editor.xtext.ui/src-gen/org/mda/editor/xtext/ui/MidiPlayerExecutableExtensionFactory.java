/*
 * generated by Xtext
 */
package org.mda.editor.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MidiPlayerExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.mda.editor.xtext.ui.internal.MidiPlayerActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.mda.editor.xtext.ui.internal.MidiPlayerActivator.getInstance().getInjector("org.mda.editor.xtext.MidiPlayer");
	}
	
}
