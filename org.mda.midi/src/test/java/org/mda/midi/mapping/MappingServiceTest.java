package org.mda.midi.mapping;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

import org.junit.Test;
import org.mda.midi.mapping.MappingService;

public class MappingServiceTest {
	
	@Test
	public void testMapFromKorgToGM () throws InvalidMidiDataException, IOException {
		
		File asGM = new File ("src/test/resources/midimapping/testsongGM.mid");
		Sequence loadedSequence = MidiSystem.getSequence(new File ("src/test/resources/midimapping/testsong.mid"));
		
		MappingService service = new MappingService(); 
		service.convert(loadedSequence, asGM, false);
	}

}
