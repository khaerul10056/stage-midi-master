package org.mda.inject;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class InjectService {

	private static final Log LOGGER = LogFactory.getLogger(InjectService.class);

	private static Collection<Module> cachedModules;
	
	private static Injector injector;

	public static Collection<Module> setupModules() {
		if (cachedModules == null) {
			cachedModules = new ArrayList<Module>();
			IExtensionRegistry registry = RegistryFactory.getRegistry();
			IExtensionPoint extensionPoint = registry.getExtensionPoint("org.mda.core.injected");
			IConfigurationElement[] configurationElements = extensionPoint.getConfigurationElements();
			for (IConfigurationElement nextElement : configurationElements) {
				if (nextElement.getName().equals("injected")) {
					String nextInterface = nextElement.getAttribute("interface");
					LOGGER.info("Configure differ " + nextInterface);
					try {
						Class injectModuleClass = loadClass(nextElement, nextInterface);
						Module newModule = (Module) injectModuleClass.newInstance();
						cachedModules.add(newModule);
					} catch (Exception e) {
						LOGGER.error("Error initialising partworker " + nextInterface, e);
					}
				}
			}
			injector = Guice.createInjector(cachedModules);
		}
		return cachedModules;

	}

	/**
	 * tries to load class with bundle-classloader or with class.forname
	 * 
	 * @param element
	 *            configelement
	 * @param name
	 *            classname
	 * @return class <code>not null</code>
	 */
	private static Class loadClass(final IConfigurationElement element,String name) {

		Class modelrepoClass = null;
		Bundle bundle = Platform.getBundle(element.getContributor().getName());
		try {
			modelrepoClass = bundle.loadClass(name);
		} catch (ClassNotFoundException e) {
			try {
				modelrepoClass = Class.forName(name);
			} catch (ClassNotFoundException e1) {
				throw new IllegalStateException(e);
			}
		}

		if (modelrepoClass == null)
			throw new IllegalStateException("Couldn't load class " + name);

		return modelrepoClass;
	}
	
	

	public static <T> T getInstance(Class<T> class1) {
		setupModules();
		return injector.getInstance(class1);
	}
	
	public static void injectObject (Object object) {
		setupModules();
		injector.injectMembers(object);
	}

}
