package org.mda.javafx.presenter;

import javafx.scene.image.Image;
import mda.Session;

import org.mda.ApplicationSession;
import org.mda.javafx.api.ISessionViewAction;
import org.mda.javafx.api.IconRegistry;
import org.mda.javafx.common.MonitorManager;
import org.mda.javafx.presentationcontrol.PresentationControlView;
import org.mda.presenter.CalculationParam;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;

import com.google.inject.Inject;

public class StartPresentationAction implements ISessionViewAction {
	
	@Inject
	PresentationControlView controlview;
	
	@Inject
	private IconRegistry iconregistry;
	
	@Inject
	private PresentationContext presentationcontext;
	
	@Inject
	private BeamerPresenter beamerpresenter;
	
	@Inject
	private ApplicationSession appSession;
	
	@Inject
	private MonitorManager monitormanager;

	@Override
	public String toString() {
		return "Start";
	}

	@Override
	public void execute() {
		
		Session currentSession = appSession.getCurrentSession();
		
		PresentationConfigurator configurator = new PresentationConfigurator();
 	    DefaultPresenterConfig config = (DefaultPresenterConfig) configurator.configure(null, appSession.getCurrentModel(), PresentationType.SCREEN);
 	    
		CalculationParam param = new CalculationParam (monitormanager.getBeamerOrPreviewBounds());
		presentationcontext.setCurrentSession(currentSession, config, param);
		controlview.build();
		if (monitormanager.isDualMonitorAvailable())
		  beamerpresenter.build(currentSession,false, config, param);
		

		//Controlview has to be registered and build AFTER beamerpresenter, 
		//because beamerpresenter fills the current session and the current slide 
		//into the presentationcontext
		presentationcontext.registerView(controlview);
		
	}

	@Override
	public Image getIcon() {
		return iconregistry.getIcon(IPresenterIconConst.ICON_PLAY);
	}

	

}
