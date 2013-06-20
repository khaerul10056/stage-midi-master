package org.mda.inject;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class InjectService {

	private static final Log LOGGER = LogFactory.getLogger(InjectService.class);

	public static Set<Module> cachedModules = new HashSet<Module>();
	
	private static Injector injector;
	
	/**
	 * cleans all injections
	 */
	public static void dispose () {
		injector = null; 
		cachedModules.clear();
	}

	
	public static Collection<Module> setupModules() {
		
		
		if (injector == null)
			injector = Guice.createInjector(cachedModules);
		
		for (Object nextKey : injector.getAllBindings().keySet()) {
			Binding<?> binding = injector.getAllBindings().get(nextKey);
			LOGGER.info("Binding " + nextKey + "->" + binding.getProvider());
		}
		
		
		return cachedModules;

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
