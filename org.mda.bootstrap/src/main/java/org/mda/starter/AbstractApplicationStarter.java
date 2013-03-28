package org.mda.starter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.mda.plugins.PluginClassloader;
import org.mda.plugins.PluginInitializer;

public class AbstractApplicationStarter {
	

	
	private String startupClass;
	
	private String [] args;
	
	public AbstractApplicationStarter (final String startupClass, final String [] args) {
		this.startupClass = startupClass;
		this.args = args;
	}
	
	
	public void start () throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		PluginInitializer initializer = new PluginInitializer(); 
    	PluginClassloader pluginClassloader = initializer.createPluginClassloader(new File (""));
    	System.out.println("Calling main class " + startupClass);
    	Class<?> mainClass = pluginClassloader.loadClass(startupClass);
    	Thread.currentThread().setContextClassLoader(pluginClassloader);
    	Method method = mainClass.getMethod("main",  new Class[]{String[].class});
    	method.invoke(null, new Object[] {args});
	}
	
	

}