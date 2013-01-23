package org.mda.presenter.ui;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.UIHandler;
import org.mda.inject.InjectService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.midi.InvalidMidiDeviceConfiguredException;
import org.mda.midi.MidiDeviceInfo;
import org.mda.midi.MidiFileInvalidBarDataException;
import org.mda.midi.MidiInfo;
import org.mda.midi.MidiPlayer;
import org.mda.midi.MidiplayerMode;
import org.mda.midi.NoMidiDeviceConfiguredException;
import org.mda.midi.NoMidiFileFoundException;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.IMidiFilePresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;

import com.google.inject.Inject;

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

  private MidiDeviceInfo midiDevice;
  
  @Inject
  private MidiPlayer midiplayer ;
  
  @Inject
  private UIHandler uihandler;
  
  
  @Execute
  public Object execute (Shell parentShell, final IWorkbench workbench) throws ExecutionException {
	  InjectService.injectObject(this);
    LOGGER.info("Starting presentation of selection " + applicationSession.getCurrentSession().getName());

    PresentationConfigurator configurator = new PresentationConfigurator();
    IMidiFilePresenterConfig config = configurator.configure(null, applicationSession.getCurrentModel(), PresentationType.SCREEN);
    
    boolean alwaysOnTop = applicationSession.getFeatureActivation().isPresentationAlwaysOnTop();
    
    beamerpresenter.build(Display.getCurrent(), applicationSession.getCurrentSession(), alwaysOnTop);
    beamerpresenter.getShell().setEnabled(true);
    
    SizeInfo sizeinfo = new SizeInfo(beamerpresenter.getShell().getSize().x, beamerpresenter.getShell().getSize().y);
    presentationContext.setCurrentSession(applicationSession.getCurrentSession(), config, sizeinfo);
    presentationContext.registerView(beamerpresenter);
    presentationContext.registerController(globalkeycontroller);    //Register global controller
    
    globalkeycontroller.open();
    
    //Initialize midi
    MidiInfo info = new MidiInfo();
    String midideviceKey = applicationSession.getCurrentModel().getConfig().getMididevice();
    if (midideviceKey != null) { 
      midiDevice = info.findDeviceInfoTransmitting(midideviceKey);
      try {
		midiplayer.start(MidiplayerMode.PLAYING);
	} catch (MidiUnavailableException | NoMidiFileFoundException| InvalidMidiDataException | IOException | MidiFileInvalidBarDataException e1) {
		LOGGER.error(e1.getLocalizedMessage(), e1);
		midiplayer.end();
	} catch (NoMidiDeviceConfiguredException e1) {
		midiplayer.end();
		LOGGER.info("No mididevice configured, disabling midiplayer");
	} catch (InvalidMidiDeviceConfiguredException e1) {
		midiplayer.end();
		uihandler.showMessageBox(parentShell, SWT.ICON_ERROR, "Invalid mididevice " + e1.getMidiDeviceKey() + " configured");
	}
    }

    runsessionshell.build(parentShell);
    runsessionshell.getShell().addDisposeListener(new DisposeListener() {
		
		@Override
		public void widgetDisposed(DisposeEvent e) {
			
			if (midiplayer.isRunning())
			  midiplayer.end();
			
			globalkeycontroller.close();
			
			beamerpresenter.getShell().dispose();
			
			if (applicationSession.getFeatureActivation().isStartupSessionConfigured()) {
				LOGGER.info("Closing workbench because widget was disposed");
				workbench.close();
			}
			
		}
	});
    
    
    
    return null;
  }



}
