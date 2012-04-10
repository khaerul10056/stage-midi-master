package org.mda.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

  private static final Log LOGGER  = LogFactory.getLogger(ApplicationWorkbenchWindowAdvisor.class);

  private ApplicationSession session = MdaModule.getInjector().getInstance(ApplicationSession.class);

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }

    private Monitor getPreferredExternalMonitor () {
      for (Monitor nextMonitor: Display.getCurrent().getMonitors()) {
        if (nextMonitor.equals(Display.getCurrent().getPrimaryMonitor()))
          return nextMonitor;
      }

      return Display.getCurrent().getPrimaryMonitor();
    }

    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();

        configurer.setTitle("MDA (#" + session.getVersion() + ")");
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
        configurer.setShellStyle(SWT.NONE);

    }

    @Override
    public void postWindowCreate () {
      super.postWindowCreate();
      Rectangle bounds = getPreferredExternalMonitor().getBounds();
      LOGGER.info("Setting bounds of workbench to " + bounds);
      Shell shell = getWindowConfigurer().getWorkbenchConfigurer().getWorkbench().getWorkbenchWindows() [0].getShell();

      //Workaround due to Bug 84938- Provide a way to set initial application window position
      shell.setBounds(new Rectangle(bounds.x,  bounds.y, bounds.width-100, bounds.height-100));

      //0, 150, 1680, 1050}
    }


}
