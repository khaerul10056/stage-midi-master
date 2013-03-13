package org.mda.inject;

import java.util.ArrayList;
import java.util.Collection;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class InjectService {

	private static final Log LOGGER = LogFactory.getLogger(InjectService.class);

	public static Collection<Module> cachedModules = new ArrayList<Module>();
	
	private static Injector injector;

	
	public static Collection<Module> setupModules() {
		
		
		if (injector == null)
			injector = Guice.createInjector(cachedModules);
		
		for (Object nextKey : injector.getAllBindings().keySet()) {
			Binding<?> binding = injector.getAllBindings().get(nextKey);
			LOGGER.info("Binding " + nextKey + "->" + binding.getProvider());
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
	private static Class loadClass(final String bundleName, String name) {

		//TODO implement different
		Class modelrepoClass = null;
//		Bundle bundle = Platform.getBundle(bundleName);
//		if (bundle == null)
//			return null;
//		try {
//			LOGGER.info("Loading class " + name + " in bundle " + bundleName);
//			modelrepoClass = bundle.loadClass(name);
//		} catch (ClassNotFoundException e) {
//			try {
//				modelrepoClass = Class.forName(name);
//			} catch (ClassNotFoundException e1) {
//				throw new IllegalStateException(e);
//			}
//		}
//
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
