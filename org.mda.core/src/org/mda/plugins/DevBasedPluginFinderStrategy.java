package org.mda.plugins;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DevBasedPluginFinderStrategy implements IPluginFinderStrategy {

	private static final Log LOGGER = LogFactory.getLogger(DevBasedPluginFinderStrategy.class);

	@Override
	public URL[] findPlugins(File path) throws MalformedURLException {
		Collection <URL> plugins = new ArrayList<URL>();
		
		
			File mainPath = getMainPath(path);
			if (LOGGER.isDebugEnabled())
			  LOGGER.debug("Find plugins in path " + mainPath.getAbsolutePath());
			for (File next: mainPath.listFiles()) {
				
				LOGGER.info("Find plugins in path " + next.getAbsolutePath());
				if (next.isDirectory() && ! next.getName().startsWith(".")) {
				  addPath(plugins, next, "bin");
				  addPath(plugins, next, "src");
				  addPath(plugins, next, "icons");
				  addDependencies(plugins, new File (next, ".classpath"));
				}
			}		
			
			return plugins.toArray(new URL [plugins.size()]);
		
	}
	
	/**
	 * adds dependencies from .classpath file
	 * @param collectedPaths
	 * @param classpathFile
	 */
	private void addDependencies (final Collection <URL> collectedPaths, final File classpathFile)  {
		if (! classpathFile.exists())
			return;
		
		try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(classpathFile);
	 
		doc.getDocumentElement().normalize();
		NodeList entries = doc.getDocumentElement().getElementsByTagName("classpathentry");
		for (int i = 0; i < entries.getLength(); i++) {
			Node item = entries.item(i);
			Node kindNode = item.getAttributes().getNamedItem("kind");
			if (kindNode.getNodeValue().equals("lib")) {
			  Node pathNode = item.getAttributes().getNamedItem("path");
			  
			  URL url = new File (pathNode.getNodeValue()).toURI().toURL();
			  collectedPaths.add(url);
			  LOGGER.info("Adding url " + url + " to urls");
			}
			
		
		}
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
		}
	}
	
	/**
	 * adds a path to the list of collectedPaths
	 * @param collectedPaths 	list of collected paths
	 * @param mainPath			mainpath to find in 
	 * @param lastPathName		pathname that is searched in mainPath
	 * @throws MalformedURLException if the url was malformed
	 */
	private void addPath (final Collection<URL> collectedPaths, final File mainPath, final String lastPathName) throws MalformedURLException {
		File nextBinPath = new File (mainPath, lastPathName); 
		if (nextBinPath.exists()) {
			collectedPaths.add(nextBinPath.toURI().toURL());
			  if (LOGGER.isDebugEnabled())
			    LOGGER.debug("Adding url " + nextBinPath.getAbsolutePath() + " to urls");
		}
		
	}
	
	private File getMainPath (final File file) {
		File current = new File (file.getAbsolutePath());
		while (! new File (current, "settings.gradle").exists()) {
			current = current.getParentFile();
		}
		return current;
	}

	@Override
	public boolean isUsed(final File file) {
		return new File ("src").exists();
		
	}

}
