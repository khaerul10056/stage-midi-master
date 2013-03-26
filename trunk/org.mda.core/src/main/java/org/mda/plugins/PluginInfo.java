package org.mda.plugins;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Module;

public class PluginInfo {
	
	private final List<URL> icons = new ArrayList<>();
	
	private Module module;
	
	public List<URL> getIcons () {
		return icons;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
