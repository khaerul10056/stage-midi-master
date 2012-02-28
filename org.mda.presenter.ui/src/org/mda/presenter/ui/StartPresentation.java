package org.mda.presenter.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.mda.ApplicationSession;
import org.mda.SelectionInfo;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.Util;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;


public class StartPresentation extends AbstractHandler {

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  @Override
  public Object execute (ExecutionEvent arg0) throws ExecutionException {
    SelectionInfo selectioninfo = (SelectionInfo) arg0.getApplicationContext();

    final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    final IPerspectiveRegistry reg = activeWorkbenchWindow.getWorkbench().getPerspectiveRegistry();
    activeWorkbenchWindow.getActivePage().setPerspective(reg.findPerspectiveWithId(Util.PRESENTATION_PERSPECTIVE));

    //Register global controller
    final GlobalKeyRegistryPresentationController controller = new GlobalKeyRegistryPresentationController(activeWorkbenchWindow.getShell().getDisplay());
    final Collection <IPresentationController> controllers = new ArrayList<IPresentationController>();
    if (! presentationContext.getRegisteredControllers().contains(controller))
      presentationContext.getRegisteredControllers().add(controller);

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(false);
    BeamerPresenter presenter = new BeamerPresenter(activeWorkbenchWindow.getShell().getDisplay(), selectioninfo.getSession(), presentationContext.getRegisteredControllers(), config, ! selectioninfo.isPreview());
    if (selectioninfo.getItem() != null)
      controller.toItem(selectioninfo.getItem());

    presenter.addDisposeListener(new DisposeListener() {

      @Override
      public void widgetDisposed (DisposeEvent arg0) {
        activeWorkbenchWindow.getActivePage().setPerspective(reg.findPerspectiveWithId(Util.ADMIN_PERSPECTIVE));

        //Remove global controller
        controller.close();
        controllers.remove(controller);
      }
    });

    presenter.setEnabled(true);

    return null;
  }

}
