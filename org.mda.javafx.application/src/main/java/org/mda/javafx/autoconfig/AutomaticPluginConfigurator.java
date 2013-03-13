package org.mda.javafx.autoconfig;

import org.mda.javafx.api.IconRegistry;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Inject;


public class AutomaticPluginConfigurator {
	
	private static final Log LOGGER  = LogFactory.getLogger(AutomaticPluginConfigurator.class);
	
	@Inject
	private IconRegistry iconregistry; 
	//i18n
	
	
	public void configure (final String startsWith) {
//	    if (true)
//	    	throw new IllegalStateException("not yet implemented");
		
//		BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext(); 
//		for (Bundle nextBundle: context.getBundles())  {
//			if (nextBundle.getSymbolicName().startsWith(startsWith)) {
//				LOGGER.info("Automatically configure bundle "+ nextBundle.getSymbolicName());
//				
//				iconregistry.registerIcons(nextBundle);
//			}
//			
//		}
		
	}

	
}
