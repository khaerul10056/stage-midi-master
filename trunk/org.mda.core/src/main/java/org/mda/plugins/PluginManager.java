package org.mda.plugins;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.mda.inject.InjectService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Module;

public class PluginManager {
	
	private static final Log LOGGER = LogFactory.getLogger(PluginManager.class);

	/**
	 * loads all available things from plugins
	 * uses file plugin.definition, that has to be in rootpath of the pluginjar to initialize module and dependency injection 
	 * this is the root for all following actions and initializations
	 * @return 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void loadPlugins () throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = getClass().getClassLoader();
		Enumeration<URL> resources = cl.getResources("plugin.definition");
		while (resources.hasMoreElements()) {
			URL nextURL = resources.nextElement();
			
			Properties props = new Properties();
			props.load(nextURL.openStream());
			
			String module = props.getProperty("startupmodule"); 
			if (module != null) {
				
				Class<?> loadClass = cl.loadClass(module);
				Module loadedmodule = (Module) loadClass.newInstance();
				
				InjectService.cachedModules.add(loadedmodule);
				LOGGER.info("Found plugin " + nextURL.toString() + " with injection startup module " + module);
				System.out.println("Found plugin " + nextURL.toString() + " with injection startup module " + module);
				
			}
			
		}
		
		
			
	}

	

}
