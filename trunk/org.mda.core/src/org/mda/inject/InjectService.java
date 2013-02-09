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

	public static Collection<Module> cachedModules;
	
	private static Injector injector;

	public static Collection<Module> setupModules() {
		boolean initialising = false;
		
		if (cachedModules == null) {
			initialising = true;
			
			try {
			cachedModules = new ArrayList<Module>();
			IExtensionRegistry registry = RegistryFactory.getRegistry();
			IExtensionPoint extensionPoint = registry.getExtensionPoint("org.mda.core.injected");
			IConfigurationElement[] configurationElements = extensionPoint.getConfigurationElements();
			
			//ApplicationModule must be injected first
			String appBundle = "org.mda.javafx.application"; 
			Class injectAppModuleClass = loadClass(appBundle, "org.mda.javafx.application.ApplicationModule");
			if (injectAppModuleClass != null) {
			  LOGGER.info("Configure application module " + injectAppModuleClass.getName());
			  Module newAppModule = (Module) injectAppModuleClass.newInstance();
			  cachedModules.add(newAppModule);
			}
			else
				LOGGER.error("Application Bundle " + appBundle + " not found");
			
			
			
			for (IConfigurationElement nextElement : configurationElements) {
				if (nextElement.getName().equals("injected")) {
					String nextInterface = nextElement.getAttribute("interface");
					LOGGER.info("Configure module " + nextInterface);
					
						Class injectModuleClass = loadClass(nextElement.getContributor().getName(), nextInterface);
						Module newModule = (Module) injectModuleClass.newInstance();
						cachedModules.add(newModule);
				
				}
			}
			
			} catch (Exception e) {
				throw new IllegalStateException("Error while injection phase: ", e);
			}
			
			
			
		}
		
		if (injector == null)
			injector = Guice.createInjector(cachedModules);
		
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
	private static Class loadClass(final String bundleName, String name) {

		Class modelrepoClass = null;
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null)
			return null;
		try {
			LOGGER.info("Loading class " + name + " in bundle " + bundleName);
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
