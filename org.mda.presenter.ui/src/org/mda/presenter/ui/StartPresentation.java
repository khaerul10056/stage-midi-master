package org.mda.presenter.ui;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.Util;
import org.mda.commons.ui.calculator.configurator.PresentationConfigurator;
import org.mda.commons.ui.calculator.configurator.PresentationType;
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

  
  
//	//Run a special session at startup
//	if (appSession.getFeatureActivation().getRunSession() != null) {
//		
//		appSession.getFeatureActivation().setRunSession(null);
//		ParameterizedCommand myCommand = commandservice.createCommand("org.mda.commons.ui.command.searchengine", new HashMap());
//		Object result = handlerservice.executeHandler(myCommand);
//		
//	}


  @Execute
  public Object execute (Shell parentShell) throws ExecutionException {
    LOGGER.info("Starting presentation of selection " + applicationSession.getCurrentSession().getName());


    beamerpresenter.build(Display.getCurrent(), applicationSession.getCurrentSession(), applicationSession.getFeatureActivation().isPresentationAlwaysOnTop());
    beamerpresenter.getShell().setEnabled(true);
    
    PresentationConfigurator configurator = new PresentationConfigurator();
    IMidiFileEditorUIConfig config = configurator.configure(null, applicationSession.getCurrentModel(), PresentationType.SCREEN);
    
    presentationContext.setCurrentSession(applicationSession.getCurrentSession(), config, beamerpresenter.getShell().getSize());
    presentationContext.registerView(beamerpresenter);
    presentationContext.registerController(globalkeycontroller);    //Register global controller

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