package org.mda.javafx.autoconfig;

import org.mda.javafx.api.IconRegistry;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Inject;


public class AutomaticPluginConfigurator {
	
	private static final Log LOGGER  = LogFactory.getLogger(AutomaticPluginConfigurator.class);
	
	@Inject
	private IconRegistry iconregistry; 
	//i18n
	
	
	public void configure (final String startsWith) {
		
		BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext(); 
		for (Bundle nextBundle: context.getBundles())  {
			if (nextBundle.getSymbolicName().startsWith(startsWith)) {
				LOGGER.info("Automatically configure bundle "+ nextBundle.getSymbolicName());
				
				iconregistry.registerIcons(nextBundle);
			}
			
		}
		
	}

	
}
