package org.mda.midi;

import org.junit.Test;
import org.mda.inject.InjectServiceMock;

public class MidiPlayerTester {
	
	
	 public static boolean useExternalSynth = true;

	    @Test
	    public void startPlayer () throws Exception {
	    	InjectServiceMock.initialize();
	    	throw new IllegalStateException("Not yet implemented");
	    	
	    	
//	    	ApplicationSession applicationsession = InjectService.getInstance(ApplicationSession.class);
//	    	PresentationContext presentationcontext = InjectService.getInstance(PresentationContext.class);
//	        applicationsession.load(null);
//	        MidiInfo info = new MidiInfo();
//	        for (MidiDeviceInfo devinfo: info.getAllMidiDevices(true, true)) {
//	        	System.out.println ("-" + devinfo.getKey());
//	        }
//	        MidiDeviceInfo findDeviceIndex = info.findDeviceInfoTransmitting("M1 [hw:1,0,0]");
//	        applicationsession.getConfig().setMididevice(findDeviceIndex.getKey());
//	        
//	        presentationcontext.setCurrentSession(applicationsession.getCurrentModel().getSessions().get(0), new DefaultMidiFileContentEditorConfig(), new Point (0,0));
//	        System.out.println ("Set current session: " + presentationcontext.getCurrentSession().getName());
//	        
//	        MidiPlayer player = InjectService.getInstance(MidiPlayer.class);
//	        GlobalKeyRegistryPresentationController controller = new GlobalKeyRegistryPresentationController();
//	        presentationcontext.registerController(controller);
//	        player.start(MidiplayerMode.PLAYING);
//	        while (player.isRunning()) {
//	        	
//	        }
//	        	
	    }
}
