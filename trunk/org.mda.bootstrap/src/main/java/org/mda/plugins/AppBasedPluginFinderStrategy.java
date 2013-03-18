package org.mda.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class AppBasedPluginFinderStrategy implements IPluginFinderStrategy {

	@Override
	public URL[] findPlugins(File path) throws MalformedURLException {
		
		
		System.out.println ("Find plugins from " + path.getAbsolutePath());
		Collection <URL>urls = new ArrayList<URL>();
		File pluginPath = getPluginPath(path);
		System.out.println ("Use pluginpath " + path.getAbsolutePath());

		for (File next: pluginPath.listFiles()) {
			System.out.println ("Adding " + next.toURI().toURL() + " to urls");
			urls.add(next.toURI().toURL());
		}
		return urls.toArray(new URL [urls.size()]);
	}

	@Override
	public boolean isUsed(File file) {
		File pluginPath = getPluginPath(file);
		boolean used = pluginPath.exists();
		System.out.println ("  Pluginpath " + pluginPath.getAbsolutePath() + "exists: " + used);
		return used ;
	}
	
	File getPluginPath (final File file) {
		System.out.println ("get parentfile from <" + file.getAbsolutePath() + "/ " + file.getParent());
		
		File basepath = new File (file.getAbsoluteFile().getParent());
		System.out.println ("- basepath <" + basepath.getAbsolutePath() + ">");
		
		File pluginpath =  new File (basepath, "plugins");
		System.out.println ("- pluginpath " + pluginpath.getAbsolutePath());
		return pluginpath;
	}
	
	public static void main (final String []args) {
		AppBasedPluginFinderStrategy strategy = new AppBasedPluginFinderStrategy(); 
		File pluginPath = strategy.getPluginPath(new File (""));
		System.out.println("Pluginpath: " + pluginPath.getAbsolutePath());
		
		
	}
	
	

}
