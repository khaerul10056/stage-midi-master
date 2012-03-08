package org.mda.presenter.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.mda.SelectionInfo;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.Util;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;


public class StartPresentation extends AbstractHandler  {

  private static final Log LOGGER  = LogFactory.getLogger(StartPresentation.class);

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  @Override
  public Object execute (ExecutionEvent arg0) throws ExecutionException {
    SelectionInfo selectioninfo = (SelectionInfo) arg0.getApplicationContext();

    final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    final IPerspectiveRegistry reg = activeWorkbenchWindow.getWorkbench().getPerspectiveRegistry();

    //Register global controller
    final GlobalKeyRegistryPresentationController globalkeycontroller = new GlobalKeyRegistryPresentationController(activeWorkbenchWindow.getShell().getDisplay());
    presentationContext.registerController(globalkeycontroller);

    IPartService service = (IPartService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite().getService(IPartService.class);
    BeamerPresenter presenter = new BeamerPresenter(activeWorkbenchWindow.getShell().getDisplay(), selectioninfo.getSession(), ! selectioninfo.isPreview(), service);
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(false);
    presentationContext.setCurrentSession(selectioninfo.getSession(), config, presenter.getSize());

    activeWorkbenchWindow.getActivePage().setPerspective(reg.findPerspectiveWithId(Util.PRESENTATION_PERSPECTIVE));

    if (selectioninfo.getItem() != null)
      globalkeycontroller.toItem(selectioninfo.getItem());

    presenter.addDisposeListener(new DisposeListener() {

      @Override
      public void widgetDisposed (DisposeEvent arg0) {
        globalkeycontroller.close();

        activeWorkbenchWindow.getActivePage().setPerspective(reg.findPerspectiveWithId(Util.ADMIN_PERSPECTIVE));
        presentationContext.closePresentationSession();

        LOGGER.info("Remaining " + presentationContext.getRegisteredControllers() + " registered controllers after closing presentation");
      }
    });

    presenter.setEnabled(true);

    return null;
  }



}
