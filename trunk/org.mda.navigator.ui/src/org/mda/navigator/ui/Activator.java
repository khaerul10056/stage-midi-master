package org.mda.navigator.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

  private static final Log LOGGER  = LogFactory.getLogger(Activator.class);

  // The plug-in ID
  public static final String PLUGIN_ID = "org.mda.navigator.ui"; //$NON-NLS-1$

  // The shared instance
  private static Activator plugin;

  /**
   * The constructor
   */
  public Activator() {
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  public void start(BundleContext context) throws Exception {
    LOGGER.info("Starting bundle " + getClass().getName() + "-" +  context.getBundle().getSymbolicName());
    super.start(context);
    plugin = this;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  public void stop(BundleContext context) throws Exception {
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

}
