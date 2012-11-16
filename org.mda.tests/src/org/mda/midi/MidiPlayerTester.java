package org.mda.midi;

import org.eclipse.swt.graphics.Point;
import org.mda.ApplicationSession;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.PresentationContext;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;
import org.mda.tests.StandaloneInjector;

public class MidiPlayerTester {
	
	
	 public static boolean useExternalSynth = true;

	    public static void main(String[] args) throws Exception {
	    	
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
	        //presentationcontext.registerView(player);
	        GlobalKeyRegistryPresentationController controller = new GlobalKeyRegistryPresentationController();
	        presentationcontext.registerController(controller);
	        player.start();
	    }
//	        
//
//	    	
//	    	
//	    	
//	    	
//
//	            
//	            MidiDevice dev = getReceivingDevice();
//	            
//	            
//	            if (dev != null) {
//	              MidiDevice.Info mdi = dev.getDeviceInfo();
//	              System.out.println ("Used device: " +mdi.getName() + "-" +  mdi.getVendor() + "-" + mdi.getDescription() + "- Recievers " + dev.getMaxReceivers() + "- Transmitters " + dev.getMaxTransmitters());
//	              dev.open(); //remove to enable internal sound
//	              
//		            // From file
//		            Sequence sequence = MidiSystem.getSequence(new File("/home/mao/Dropbox/soundOfFaith/midi/For all you've done.mid"));
//		            
//
//		        
//		            // Create a sequencer for the sequence
//		            
//		            Sequencer           seq;
//		            Transmitter         seqTransmitter;
//		            try {
//		                  seq     = MidiSystem.getSequencer();
//		                  seqTransmitter = seq.getTransmitter();
//		                  seqTransmitter.setReceiver(dev.getReceiver());      
//		            seq.setSequence(sequence);
//		            seq.setSlaveSyncMode(SyncMode.MIDI_SYNC);
//		            
//		            
//		            for (MidiChannel nextChannel: MidiSystem.getSynthesizer().getChannels()) {
//		            	nextChannel.allSoundOff();
//		            }
//		            
//		            
//		            for (Info nextMixer : AudioSystem.getMixerInfo()) {
//		            	System.out.println ("Mixer " + nextMixer.getName() + "-" + nextMixer.getVendor() + "-" + nextMixer.getDescription() + "-" + nextMixer.getClass());
//		            	Mixer mixer = AudioSystem.getMixer(nextMixer);
//		            	mixer.close(); //todo remove to enable internal sound
//		            	
//		            }
//		            
//		            seq.open();
//		        
//		            // Start playing
//		            seq.start();
//		            } catch (MidiUnavailableException e) {
//		                  // handle or throw exception
//		            }
//
//	            }
//	            else
//	              System.out.println ("No device found");
//	    }
//
//	    private static MidiDevice getReceivingDevice() throws MidiUnavailableException {
//	        for (MidiDevice.Info mdi: MidiSystem.getMidiDeviceInfo()) {
//	        	MidiDevice dev = MidiSystem.getMidiDevice(mdi);
//	        	System.out.println (mdi.getName() + "-" +  mdi.getVendor() + "-" + mdi.getDescription() + "- Recievers " + dev.getMaxReceivers() + "- Transmitters " + dev.getMaxTransmitters());
//	        	if (mdi.getDescription().indexOf("USB") >= 0 && dev.getMaxReceivers() != 0)
//	        		return dev;
//	        	else {
//	        		System.out.println (mdi.getName() + " is open: " + dev.isOpen()); 
//	        		dev.close();
//	        	}
//	        	
//	        }
//	        return null;
//	    }

}
