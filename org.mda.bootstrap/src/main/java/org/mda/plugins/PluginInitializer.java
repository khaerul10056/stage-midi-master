package org.mda.plugins;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Creates a plugin classloader from all plugins
 * @author OleyMa
 *
 */
public class PluginInitializer {
	
	
	private Collection<IPluginFinderStrategy> pluginFinderStrategies = new ArrayList<IPluginFinderStrategy>();
	
	public PluginInitializer() {
		pluginFinderStrategies.add(new DevBasedPluginFinderStrategy());
		pluginFinderStrategies.add(new AppBasedPluginFinderStrategy());
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
	public ClassLoader createClassloader (final File file) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		System.out.println ("Find plugins in path <" + file.getAbsolutePath() + ">");
		
		ClassLoader cl = null;

		for (IPluginFinderStrategy nextStrategy : pluginFinderStrategies) {
			if (nextStrategy.isUsed(file)) {
				if (cl != null)
					throw new IllegalStateException("Multiple pluginfinder strategies registered for path " + file.getAbsolutePath());
				else 
					cl = nextStrategy.createClassloader(file);
			}
			else
				System.out.println ("PluginFinderStrategy " + nextStrategy.getClass().getName() + " not used");
		}
		
		
		return cl;
	}
}
