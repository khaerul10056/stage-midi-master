package org.mda.midi;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.ShortMessage;

import org.mda.inject.InjectServiceMock;


public class MidiPlayerTester {
	
	
	 public static boolean useExternalSynth = true;
	 
	 static int instrument = 45;
	    static int note = 100;
	    static int timbre = 0;
	    static int force = 100;

	    public static void main (String args []) throws Exception {
	    	
	    	InjectServiceMock.initialize();
	    	
	    	MidiInfo info = new MidiInfo();
	        for (MidiDeviceInfo devinfo: info.getAllMidiDevices(true, true)) {
	        	System.out.println ("-" + devinfo.getKey());
	        }
	        MidiDeviceInfo findDeviceIndex = info.findDeviceInfoRecieving("M1 [hw:1,0,0]");
	        
	        ShortMessage instrumentChange = new ShortMessage();
	        
	        ShortMessage myMsg = new ShortMessage();
	        // Start playing the note Middle C (60), 
	        // moderately loud (velocity = 93).
	        myMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 00);
	        MidiSystem.getReceiver().send(myMsg, 0);
	        myMsg.setMessage(ShortMessage.NOTE_OFF, 0, 60, 00);
	        MidiSystem.getReceiver().send(myMsg, 0);
	        
	        
	        
	        
	        instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 32, 0);
	        findDeviceIndex.getDevice().getReceiver().send(instrumentChange, 0);
	        
	        instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 0, 2);
	        findDeviceIndex.getDevice().getReceiver().send(instrumentChange, 0);
	        
	        instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 2, 0);
	        findDeviceIndex.getDevice().getReceiver().send(instrumentChange, 0);
	        
//	        for (int i = 0; i < 16; i++) {
//	          System.out.println ("Sending on channel " + i); 
//	          instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, i, 16, 16);
//	          findDeviceIndex.getDevice().getReceiver().send(instrumentChange, 0);
//	          
//	          Thread.sleep(1000);
//	        }
	        
	        System.out.println ("Done");
	        
	        
	        	
	    }
}
