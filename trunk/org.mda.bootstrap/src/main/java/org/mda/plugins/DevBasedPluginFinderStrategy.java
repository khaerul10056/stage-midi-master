package org.mda.plugins;

import java.io.File;
import java.net.MalformedURLException;

public class DevBasedPluginFinderStrategy implements IPluginFinderStrategy {


	@Override
	public ClassLoader createClassloader(File path) throws MalformedURLException {
	  return getClass().getClassLoader();
	}
	
	

	@Override
	public boolean isUsed(final File file) {
		return new File ("src").exists();
		
	}

}
