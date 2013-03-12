package org.mda.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public interface IPluginFinderStrategy {

	
	/**
	 * finds all urls which can be asked with pluginclassloader
	 * @param path reference path 
	 * @return urls
	 */
	public URL [] findPlugins (final File path) throws MalformedURLException;
	
	/**
	 * returns if the current plugin finder strategy is used
 	 * @param path reference path 
	 * @return true: it is used, false: it is not used
	 */
	public boolean isUsed (final File file);
}
