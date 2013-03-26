package org.mda.javafx.api;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javafx.scene.image.Image;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;



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
	public void registerIcon (URL url) {
		String urlAsString = url.toExternalForm();
		int indexFrom = urlAsString.lastIndexOf("/") + 1;
		String name = urlAsString.substring(indexFrom);
		LOGGER.info("Register icon <" + url + "> with name <" + name + ">");
		registeredImages.put(name, url);
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
