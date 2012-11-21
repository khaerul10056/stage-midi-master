package org.mda.midi;

import org.eclipse.swt.graphics.Point;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.PresentationContext;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;
import org.mda.tests.StandaloneInjector;

public class MidiPlayerTester {
	
	
	 public static boolean useExternalSynth = true;

	    @Test
	    public void startPlayer () throws Exception {
	    	
	    	ApplicationSession applicationsession = StandaloneInjector.getInstance(ApplicationSession.class);
	    	PresentationContext presentationcontext = StandaloneInjector.getInstance(PresentationContext.class);
	        applicationsession.load(null);
	        MidiInfo info = new MidiInfo();
	        for (MidiDeviceInfo devinfo: info.getAllMidiDevices(true, true)) {
	        	System.out.println ("-" + devinfo.getKey());
	        }
	        MidiDeviceInfo findDeviceIndex = info.findDeviceInfoTransmitting("M1 [hw:1,0,0]");
	        applicationsession.getConfig().setMididevice(findDeviceIndex.getKey());
	        
	        presentationcontext.setCurrentSession(applicationsession.getCurrentModel().getSessions().get(0), new DefaultMidiFileContentEditorConfig(), new Point (0,0));
	        System.out.println ("Set current session: " + presentationcontext.getCurrentSession().getName());
	        
	        MidiPlayer player = StandaloneInjector.getInstance(MidiPlayer.class);
	        GlobalKeyRegistryPresentationController controller = new GlobalKeyRegistryPresentationController();
	        presentationcontext.registerController(controller);
	        player.start();
	        while (player.isRunning()) {
	        	
	        }
	        	
	    }

}
