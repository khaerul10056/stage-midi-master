package org.mda.javafx.autoconfig;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.mda.javafx.api.IconRegistry;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.plugins.PluginInfo;

import com.google.inject.Inject;


public class AutomaticPluginConfigurator {
	
	private static final Log LOGGER  = LogFactory.getLogger(AutomaticPluginConfigurator.class);
	
	@Inject
	private IconRegistry iconregistry; 
	//i18n
	
	
	public void configure (final List<PluginInfo> plugins) throws IOException {
		
		LOGGER.info("Start configuring plugins");

		for (PluginInfo next: plugins) {
			LOGGER.info("Configure plugin " + next.getModule().getClass());
			for (URL nextIcon: next.getIcons()) {
				iconregistry.registerIcon(nextIcon);
			}
		}
		
		
		LOGGER.info("Finished configuring plugins");
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
