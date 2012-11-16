package org.mda.commons.ui;

import java.io.IOException;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Device;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.mda.commons.ui.user.UserGeneralTab;
import org.mda.commons.ui.user.UserTabExt;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

  private static Activator plugin;

  private static final Log LOGGER  = LogFactory.getLogger(Activator.class);

  // The plug-in ID
  public static final String PLUGIN_ID = "org.mda.commons.ui"; //$NON-NLS-1$


  

	/**
   * The constructor
   */
  public Activator() {
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
public void start(BundleContext context) throws Exception {
    super.start(context);

    LOGGER.info("Starting bundle " + PLUGIN_ID);
    plugin = this;
    
    UserTabExt.registerUserTab(UserGeneralTab.class);
    
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
public void stop(BundleContext context) throws Exception {
	  
	UserTabExt.deregisterUserTab(UserGeneralTab.class);
	
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  public static ImageDescriptor loadImage (Device device, String name) throws IOException {
    ImageDescriptor imageDescriptorFromPlugin = imageDescriptorFromPlugin("org.mda.commons.ui", name);
    return imageDescriptorFromPlugin;
  }


}
