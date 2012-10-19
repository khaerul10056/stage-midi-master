package org.mda.midi;

import java.io.File;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Sequencer.SyncMode;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Mixer.Info;

public class MidiPlayerTester {
	
	
	 public static boolean useExternalSynth = true;

	    public static void main(String[] args) throws Exception {
	    	

	            
	            MidiDevice dev = getReceivingDevice();
	            
	            
	            if (dev != null) {
	              MidiDevice.Info mdi = dev.getDeviceInfo();
	              System.out.println ("Used device: " +mdi.getName() + "-" +  mdi.getVendor() + "-" + mdi.getDescription() + "- Recievers " + dev.getMaxReceivers() + "- Transmitters " + dev.getMaxTransmitters());
	              dev.open();
//	              
//	              ShortMessage myMsg = new ShortMessage();
//	              // Start playing the note Middle C (60), 
//	              // moderately loud (velocity = 93).
//	              myMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 93);
//	              Receiver rcvr = dev.getReceiver();
//	              rcvr.send(myMsg, 100);
//	              dev.close();
	              
		            // From file
		            Sequence sequence = MidiSystem.getSequence(new File("/home/mao/Dropbox/soundOfFaith/midi/For all you've done.mid"));
		            
//		            Track track = sequence.getTracks() [3];
//		            Receiver rcvr = dev.getReceiver();
//		            for (int i = 0; i < track.size(); i++) {
//		            	MidiEvent nextEvent = track.get(i);
//		            	MidiMessage message = nextEvent.getMessage(); 
//		            	rcvr.send(message, 100);
//		            }
		        
		            // Create a sequencer for the sequence
		            
		            Sequencer           seq;
		            Transmitter         seqTransmitter;
		            try {
		                  seq     = MidiSystem.getSequencer();
		                  seqTransmitter = seq.getTransmitter();
		                  seqTransmitter.setReceiver(dev.getReceiver());      
		            seq.setSequence(sequence);
		            seq.setSlaveSyncMode(SyncMode.MIDI_SYNC);
		            
		            
		            for (MidiChannel nextChannel: MidiSystem.getSynthesizer().getChannels()) {
		            	nextChannel.allSoundOff();
		            }
		            
		            
		            for (Info nextMixer : AudioSystem.getMixerInfo()) {
		            	System.out.println ("Mixer " + nextMixer.getName() + "-" + nextMixer.getVendor() + "-" + nextMixer.getDescription() + "-" + nextMixer.getClass());
		            	Mixer mixer = AudioSystem.getMixer(nextMixer);
		            	mixer.close();
		            	
		            }
		            
		            seq.open();
		        
		            // Start playing
		            seq.start();
		            } catch (MidiUnavailableException e) {
		                  // handle or throw exception
		            }

	            }
	            else
	              System.out.println ("No device found");
	    }

	    private static MidiDevice getReceivingDevice() throws MidiUnavailableException {
	        for (MidiDevice.Info mdi: MidiSystem.getMidiDeviceInfo()) {
	        	MidiDevice dev = MidiSystem.getMidiDevice(mdi);
	        	System.out.println (mdi.getName() + "-" +  mdi.getVendor() + "-" + mdi.getDescription() + "- Recievers " + dev.getMaxReceivers() + "- Transmitters " + dev.getMaxTransmitters());
	        	if (mdi.getDescription().indexOf("USB") >= 0 && dev.getMaxReceivers() != 0)
	        		return dev;
	        	else {
	        		System.out.println (mdi.getName() + " is open: " + dev.isOpen()); 
	        		dev.close();
	        	}
	        	
	        }
	        return null;
	    }

}
