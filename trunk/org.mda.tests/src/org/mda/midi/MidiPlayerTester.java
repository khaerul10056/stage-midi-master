package org.mda.midi;

import java.io.File;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

public class MidiPlayerTester {
	
	
	 public static boolean useExternalSynth = true;

	    public static void main(String[] args) throws Exception {
	    	
	            // From file
	            Sequence sequence = MidiSystem.getSequence(new File("/home/mao/Dropbox/soundOfFaith/midi_downloads/blessed_be_the_name_of_the_lord.mid"));
	        
//	            // Create a sequencer for the sequence
//	            Sequencer sequencer = MidiSystem.getSequencer();
//	            sequencer.open();
//	            sequencer.setSequence(sequence);
//	        
//	            // Start playing
//	            sequencer.start();
	            
	            MidiDevice dev = getReceivingDevice();
	    }

	    private static MidiDevice getReceivingDevice() throws MidiUnavailableException {
	        for (MidiDevice.Info mdi: MidiSystem.getMidiDeviceInfo()) {
	        	MidiDevice dev = MidiSystem.getMidiDevice(mdi);
	        	System.out.println (mdi.getName() + mdi.getVendor() + mdi.getDescription() + "- Rec" + dev.getMaxReceivers() + "- Trans" + dev.getMaxTransmitters());
	        }
	        return null;
	    }

}
