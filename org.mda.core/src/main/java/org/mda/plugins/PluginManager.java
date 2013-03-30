package org.mda.plugins;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.mda.inject.InjectService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Module;

public class PluginManager {
	
	private static final Log LOGGER = LogFactory.getLogger(PluginManager.class);
	
	
	
	private List<PluginInfo> plugins = new ArrayList<PluginInfo>();
	
	
	public List<PluginInfo> getLoadedPlugins () {
		return plugins;
	}

	/**
	 * loads all available things from plugins
	 * uses file plugin.definition, that has to be in rootpath of the pluginjar to initialize module and dependency injection 
	 * this is the root for all following actions and initializations
	 * @return 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @return List of all plugins as infoobject
	 */
	public List<PluginInfo> loadPlugins () throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = getClass().getClassLoader();
		Enumeration<URL> resources = cl.getResources("plugin.definition");
		Set <String> loadedModules = new HashSet<String>();
		while (resources.hasMoreElements()) {
			URL nextURL = resources.nextElement();
			
			PluginInfo pluginInfo = new PluginInfo();
			
			Properties props = new Properties();
			props.load(nextURL.openStream());
			
			String module = props.getProperty("startupmodule"); 
			if (module != null) {
				
				Class<?> loadClass = cl.loadClass(module);
				Module loadedmodule = (Module) loadClass.newInstance();
				pluginInfo.setModule(loadedmodule);
				
				if (! loadedModules.contains(loadedmodule.getClass().getName())) {
  				  InjectService.cachedModules.add(loadedmodule);
  				  loadedModules.add(loadedmodule.getClass().getName());
				}
				
				LOGGER.info("Found plugin " + nextURL.toString() + " with injection startup module " + module);
				System.out.println("Found plugin " + nextURL.toString() + " with injection startup module " + module);
				
			}
			
			String icons = props.getProperty("icons");
			LOGGER.info("Configured icons <" + icons + "> in " + nextURL);
			if (icons != null && ! icons.trim().isEmpty()) {
				String [] iconArray = icons.split(",");
				for (String next: iconArray) {
					if (next.trim().isEmpty())
						continue;
					
					String nextIconString = nextURL.toExternalForm().replace("plugin.definition", "icons/" + next.trim());
					LOGGER.info("Add icon <" + next + "->" + nextIconString + ">");
					URL nextIconUrl = new URL(nextIconString);
					pluginInfo.getIcons().add(nextIconUrl);
					
				}
			}
			
			plugins.add(pluginInfo);
			
		}
		
		return plugins;
		
		
			
	}

	

}
