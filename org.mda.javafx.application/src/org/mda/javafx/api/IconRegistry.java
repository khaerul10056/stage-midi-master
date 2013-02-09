package org.mda.javafx.api;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;

import javafx.scene.image.Image;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.osgi.framework.Bundle;

/**
 * Registry to hold automatically loaded icons by convention
 * 
 * @author oleym
 *
 */
public class IconRegistry {
	
	private static final Log LOGGER = LogFactory.getLogger(IconRegistry.class);

	private HashMap<String, URL> registeredImages = new HashMap<String, URL>();
	
	private HashMap<String, Image> loadedImages = new HashMap<String, Image>();
	
	/**
	 * register all icons of the given plugin 
	 * we look in the folder icons and import all icons with the name as key, 
	 * so the convention is to prepend the plugin id to the iconname, e.g. 
	 * org.mda.javafx.application.someicon.png to be unique
	 * 
	 * @param plugin
	 */
	public void registerIcons (Bundle bundle) {
		Enumeration<String> entry = bundle.getEntryPaths("/icons/");
		while (entry.hasMoreElements()) {
		  String nextElement = entry.nextElement();
		  String name = nextElement.substring(6, nextElement.length()); //icons-package is removed
		  if (registeredImages.get(name) != null)
			throw new IllegalStateException("Icon with name " + name + " already registered");
		  LOGGER.info("Load icon " + nextElement + " with name " + name + " in plugin " + bundle.getSymbolicName());
		  registeredImages.put(name, bundle.getEntry(nextElement));
		}
	}
	
	/**
	 * gets the icon with the given key, 
	 * loads it, if not yet loaded
	 * @param key  key
	 * @return  icon 
	 * @throws IllegalStateException if icon is not registered or could not be loaded
	 */
	public Image getIcon (final String key) {
		Image loadedImage = loadedImages.get(key); 
		if (loadedImage != null)
			return loadedImage;
		
		URL registeredImage = registeredImages.get(key);
		if (registeredImage == null)
			return null; //throw new IllegalStateException("Icon with key " + key + " is not registered");
		
		try {
			loadedImage = new Image(registeredImage.openStream());
			loadedImages.put(key, loadedImage);
			return loadedImage;
		} catch (IOException e) {
			throw new IllegalStateException("Error loading image " + registeredImage.toString());
		}
	}
			

}
