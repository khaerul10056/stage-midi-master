package org.mda.presenter.ui;

import javax.inject.Inject;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;

@Creatable
public class StartPresentation   {

  private static final Log LOGGER  = LogFactory.getLogger(StartPresentation.class);

  @Inject
  private PresentationContext  presentationContext;
  
  @Inject
  private ApplicationSession applicationSession;
  
  @Inject
  private BeamerPresenter beamerpresenter;
  
  @Inject
  private GlobalKeyRegistryPresentationController globalkeycontroller;
  
  @Inject
  private RunSessionShell runsessionshell;
  
  

  @Execute
  public Object execute (Shell parentShell) throws ExecutionException {
    LOGGER.info("Starting presentation of selection " + applicationSession.getCurrentSession().getName());

    //Register global controller
    presentationContext.registerController(globalkeycontroller);

    beamerpresenter.build(parentShell.getDisplay(), applicationSession.getCurrentSession(), applicationSession.getFeatureActivation().isPresentationAlwaysOnTop());
    
    
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(false);
    config.setShowBackground(true);
    config.setSkipEmptySlides(true);
    config.setOptimizeEmptyTokens(true);
    presentationContext.setCurrentSession(applicationSession.getCurrentSession(), config, beamerpresenter.getShell().getSize());
    presentationContext.registerView(beamerpresenter);

    beamerpresenter.getShell().setEnabled(true);
    
    runsessionshell.build(parentShell);
    runsessionshell.getShell().addDisposeListener(new DisposeListener() {
		
		@Override
		public void widgetDisposed(DisposeEvent e) {
			beamerpresenter.getShell().dispose();
			
		}
	});
    
    return null;
  }



}
