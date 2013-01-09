package org.mda.midi;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MidifileReader {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InvalidMidiDataException 
	 */
	public static void main(String[] args) throws InvalidMidiDataException, IOException {
		File midifile = new File ("/home/oleym/Dropbox/soundOfFaith/midi/We have a vision.mid");		
		Sequence loadedSequence = MidiSystem.getSequence(midifile);
		System.out.println ("File: " + midifile.getName());
		System.out.println ("Ticklength: " + loadedSequence.getTickLength());
		for (Track nextTrack : loadedSequence.getTracks()) {
			System.out.println ("Track " + nextTrack + ":");
			System.out.println ("  Length : " + nextTrack.size());
			for (int i = 0; i < nextTrack.size(); i++) {
				MidiEvent midiEvent = nextTrack.get(i);
				
				MidiMessage message = midiEvent.getMessage();
				
				if (message instanceof MetaMessage) {
					MetaMessage metamessage = (MetaMessage) message;
					System.out.println ("    MetaMessage: Timestamp " + midiEvent.getTick() + "- Type " + metamessage.getType() + "-Data " + metamessage.getData() + "- Message " + metamessage.getMessage());
				}
				if (message instanceof ShortMessage) {
					ShortMessage shortmessage = (ShortMessage) message;
					
					String controlname = null; 
					switch (shortmessage.getCommand()) {
					  case ShortMessage.ACTIVE_SENSING: controlname = "ActiveSensing"; break; 
					  case ShortMessage.CHANNEL_PRESSURE: controlname = "ChannelPressure"; break;
					    case ShortMessage.MIDI_TIME_CODE : controlname = "MidiTimeCode"; break; 
					    case ShortMessage.SONG_POSITION_POINTER : controlname = "SongPositionPointer"; break;
					    case ShortMessage.SONG_SELECT : controlname = "SongSelect"; break;
					    case ShortMessage.TUNE_REQUEST : controlname = "TuneRequest"; break;
					    case ShortMessage.END_OF_EXCLUSIVE : controlname = "EndOfExclusive"; break;
					    case ShortMessage.TIMING_CLOCK : controlname = "TimingClock"; break;
					    case ShortMessage.START : controlname = "Start"; break;
					    case ShortMessage.CONTINUE : controlname = "Continue"; break;
					    case ShortMessage.STOP : controlname = "Stop"; break;
					    case ShortMessage.SYSTEM_RESET : controlname = "SystemReset"; break;
					    case ShortMessage.NOTE_OFF : controlname = "NoteOff"; break;
					    case ShortMessage.NOTE_ON : controlname = "NoteOn"; break;
					    case ShortMessage.POLY_PRESSURE : controlname = "PolyPressure"; break;
					    case ShortMessage.CONTROL_CHANGE : controlname = "ControlChange"; break;
					    case ShortMessage.PROGRAM_CHANGE : controlname = "ProgramChange"; break;
					    case ShortMessage.PITCH_BEND : controlname = "PitchBend"; break;
					    default : controlname = "Generic"; break;
					}
					
					
					
					System.out.println ("    ShortMessage: Timestamp " + midiEvent.getTick() + "- Control " + controlname + "- Data1 " + shortmessage.getData1() + "- Data2 " + shortmessage.getData2() + "- Status " + shortmessage.getStatus() + "- Channel " + shortmessage.getChannel() + "- Length " + shortmessage.getLength() + "- Message " + shortmessage.getMessage());
				}
				
				
			}
		}
	}

}
