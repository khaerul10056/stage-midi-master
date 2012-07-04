package org.mda.presenter.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.SelectionInfo;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.Util;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;


public class StartPresentation extends AbstractHandler  {

  private static final Log LOGGER  = LogFactory.getLogger(StartPresentation.class);

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
  private ApplicationSession applicationSession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  @Override
  public Object execute (ExecutionEvent event) throws ExecutionException {
    SelectionInfo selectioninfo = (SelectionInfo) event.getApplicationContext();

    final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    final IPerspectiveRegistry reg = activeWorkbenchWindow.getWorkbench().getPerspectiveRegistry();

    LOGGER.info("Starting presentation of selection " + selectioninfo.getSession().getName() + "-" + selectioninfo.getItem().getName());

    //Register global controller
    final GlobalKeyRegistryPresentationController globalkeycontroller = new GlobalKeyRegistryPresentationController(activeWorkbenchWindow.getShell().getDisplay());
    presentationContext.registerController(globalkeycontroller);

    IPartService service = (IPartService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite().getService(IPartService.class);
    final BeamerPresenter presenter = new BeamerPresenter(activeWorkbenchWindow.getShell().getDisplay(), selectioninfo.getSession(), applicationSession.getFeatureActivation().isPresentationAlwaysOnTop(), service);
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(false);
    config.setShowBackground(true);
    config.setSkipEmptySlides(true);
    config.setOptimizeEmptyTokens(true);
    presentationContext.setCurrentSession(selectioninfo.getSession(), config, presenter.getSize());
    presentationContext.registerView(presenter);

    IPerspectiveDescriptor presentationPerspective = reg.findPerspectiveWithId(Util.PRESENTATION_PERSPECTIVE);
    LOGGER.info("Set perspective " + presentationPerspective.getId());
    activeWorkbenchWindow.getActivePage().setPerspective(presentationPerspective);

    if (selectioninfo.getItem() != null)
      presentationContext.selectItem(selectioninfo.getItem());

    presenter.addDisposeListener(new DisposeListener() {

      @Override
      public void widgetDisposed (DisposeEvent arg0) {
        globalkeycontroller.close();

        if (activeWorkbenchWindow != null && activeWorkbenchWindow.getActivePage() != null)
          activeWorkbenchWindow.getActivePage().setPerspective(reg.findPerspectiveWithId(Util.ADMIN_PERSPECTIVE));
        presentationContext.deregisterView(presenter.getClass());
        presentationContext.closePresentationSession();

      }
    });

    presenter.setEnabled(true);

    return null;
  }



}
