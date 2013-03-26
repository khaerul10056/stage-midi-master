package org.mda.plugins;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Inherited;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;



/**
 * Classloader implementation for a plugin mechanism
 * 
 * <p/>
 * With this classloader the default behaviour of a URLClassloader is changed in a way, that resources are primarily loaded 
 * in urls which you give into the classloader. 
 * If the resource is not found in one of these urls, this classloaders delegates to the parent classloader
 * 
 */
public class PluginClassloader extends URLClassLoader {

  

  /**
   * {@inheritDoc}
   */
  public PluginClassloader(URL[] urls, ClassLoader parent) {
	super(urls, parent);
    System.out.println("PluginClassLoader: instance=" + super.toString() + "; URLs=" + Arrays.toString(urls) + "; parent=" + parent);
  }

  /**
   * {@inheritDoc}
   */
  public PluginClassloader(URL[] urls) {
    super(urls);
    System.out.println("PluginClassLoader: instance=" + this + "; URLs=" + Arrays.toString(urls));
    
  }

  /**
   * {@inheritDoc}
   */
  public PluginClassloader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
    super(urls, parent, factory);
    
    	System.out.println("PluginClassLoader: instance=" + this + "; URLs=" + Arrays.toString(urls) + "; parent=" + parent + "; urlStreamHandlerFactory=" + factory);
    
  }

  /**
   * Tries to load a class via one of the given urls
   * 
   * @param name classname
   * @return class
   */
  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException {
	    Class loadedClass = findLoadedClass(name);

	    if (loadedClass == null) {
	      try {
	        loadedClass = findClass(name);
	      } catch (ClassNotFoundException ignore) {
	        	//System.out.println("loadClass: Klasse nicht gefunden! classLoader=" + this + "; name=" + name);
	      }
	    } else {
	    	//System.out.println("loadClass: zustaendig! name=" + name);
	    }

	    // So, jetzt delegieren wir an den Parent, weil wir die Klasse nicht laden konnten
	    if (loadedClass == null) {
	      loadedClass = super.loadClass(name);
	      //System.out.println("loadClass: delegiert! classLoader=" + this + "; name=" + name + "; loadedClass=" + loadedClass);
	     
	    }

	    return loadedClass;
	  }

  /**
   * {@link Inherited}
   * If not yet loaded the plugin classloader tries to load the resource in the given urls
   * @param name name of resources
   * @return url of loaded resources or <code>null</code> if resource could not be found
   */
  @Override
  public URL getResource(String name) {
    // kann ich das selber erledigen?
    URL url = findResource(name);

    if (url == null) 
      // jetzt muss delegiert werden
      url = super.getResource(name);
      

    return url;
  }

@Override
public Enumeration<URL> getResources(String name) throws IOException {
	Collection <URL> urls = new ArrayList<URL>();
	System.out.println ("getResources <" + name + ">");
	for (URL next: getURLs()) {
		
		if (next.getPath().endsWith(".jar")) { 
			URL jarUrl = new URL ("jar:" + new File (next.getPath()).toURI().toURL().toExternalForm() + "!/" + name);
			
			final JarURLConnection connection = (JarURLConnection) jarUrl.openConnection();
			if (connection.getContentLength() > 0) {
				System.out.println("Check Jar URL " + jarUrl.toString());
			    urls.add(jarUrl);
			}
		}
		else {
			File file = new File (next.getPath() + File.separator + name);
			
			if (file.exists()) {
				System.out.println("Check File URL " + file.getAbsolutePath());
				urls.add(file.toURI().toURL());
			}
		}
	}
	
	if (urls.isEmpty()) {
		URL superUrl = super.findResource(name);
		if (superUrl != null)
		urls.add(superUrl);
	}

	return Collections.enumeration(urls);
}
  
  

}
