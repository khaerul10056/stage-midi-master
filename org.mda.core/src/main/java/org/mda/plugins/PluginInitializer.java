package org.mda.plugins;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;

/**
 * Creates a plugin classloader from all plugins
 * @author OleyMa
 *
 */
public class PluginInitializer {
	private static final Log LOGGER = LogFactory.getLogger(PluginManager.class);
	
	private Collection<IPluginFinderStrategy> pluginFinderStrategies = new ArrayList<IPluginFinderStrategy>();
	
	public PluginInitializer() {
		pluginFinderStrategies.add(new DevBasedPluginFinderStrategy());
		//TODO AppBased
	}
	
	
	/**
	 * creates a plugin classloader, which can load all the plugin things from plugins
	 * @param file path
	 * @return  classloader
	 * @throws IOException exception
	 * @throws ClassNotFoundException exception
	 * @throws InstantiationException exception
	 * @throws IllegalAccessException exception
	 */
	public PluginClassloader createPluginClassloader (final File file) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		URL [] urls = null;

		for (IPluginFinderStrategy nextStrategy : pluginFinderStrategies) {
			if (nextStrategy.isUsed(file)) {
				if (urls != null)
					throw new IllegalStateException("Multiple pluginfinder strategies registered for path " + file.getAbsolutePath());
				else
					urls = nextStrategy.findPlugins(file);
			}
		}
		
		PluginClassloader pluginClassloader = new PluginClassloader(urls, getClass().getClassLoader());
		return pluginClassloader;
	}
}
