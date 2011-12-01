package org.mda.commons.ui;

import java.io.IOException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Device;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.osgi.framework.BundleContext;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Activator extends AbstractUIPlugin {

  private static Activator plugin;

  @Inject
  private ApplicationSession session;

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

    Injector injector = Guice.createInjector(new MdaModule());
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

  public static ImageDescriptor loadImage (Device device, String name) throws IOException {
    ImageDescriptor imageDescriptorFromPlugin = imageDescriptorFromPlugin("org.mda.commons.ui", name);
    return imageDescriptorFromPlugin;
  }

  public ApplicationSession getSession () {
    return session;
  }


}
