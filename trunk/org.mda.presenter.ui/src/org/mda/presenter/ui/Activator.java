package org.mda.presenter.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.osgi.framework.BundleContext;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  private static final Log LOGGER  = LogFactory.getLogger(Activator.class);

	// The plug-in ID
	public static final String PLUGIN_ID = "org.mda.presenter.ui"; //$NON-NLS-1$

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
		super.start(context);
		LOGGER.info("Starting bundle " + getClass().getName() + "-" +  context.getBundle().getSymbolicName());
		Injector injector = Guice.createInjector(new MdaPresenterModule());
    injector.injectMembers(this);
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
