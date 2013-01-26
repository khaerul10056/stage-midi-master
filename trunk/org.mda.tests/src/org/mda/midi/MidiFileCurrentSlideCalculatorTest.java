package org.mda.midi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import mda.SongPart;
import mda.SongPartType;
import mda.Session;
import mda.Song;

import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.presenter.ui.test.MidiFileCreator;

public class MidiFileCurrentSlideCalculatorTest {
	
	@Test
	public void initWrongBarOrder () {
        MidiFileCreator creator = MidiFileCreator.create();
		
		Session session = MidiPlayerService.mf.createSession();
		creator.part(SongPartType.INTRO).setBar(12);
		creator.chordAndText("This is a chord", "And this is a text");
		creator.part(SongPartType.VERS).setBar(11);
		creator.chordAndText("This is a chord", "And this is a text");
		session.getItems().add(creator.get());
		
		try {
			MidiFileCurrentSlideCalculator calculator = new MidiFileCurrentSlideCalculator(); 
			calculator.init(session);
		} catch (MidiFileInvalidBarDataException e) {
			assertEquals (1, e.getInvalidBarDataCollected().size());
			assertEquals (MidiFileInvalidBarData.WRONG_BARORDER, e.getInvalidBarDataCollected().get(0).getCurrentMessage());
			assertNotNull (e.getInvalidBarDataCollected().get(0).getLocation());
			
		}
		
	}
	
	@Test
	public void initNoBar () {
		MidiFileCreator creator = MidiFileCreator.create();
		
		Session session = MidiPlayerService.mf.createSession();
		creator.part(SongPartType.INTRO);
		creator.chordAndText("This is a chord", "And this is a text");
		session.getItems().add(creator.get());
		
		try {
			MidiFileCurrentSlideCalculator calculator = new MidiFileCurrentSlideCalculator(); 
			calculator.init(session);
		} catch (MidiFileInvalidBarDataException e) {
			assertEquals (1, e.getInvalidBarDataCollected().size());
			assertEquals (MidiFileInvalidBarData.NOBARDATA_AVAILABLE, e.getInvalidBarDataCollected().get(0).getCurrentMessage());
			assertNotNull (e.getInvalidBarDataCollected().get(0).getLocation());
			
		}
		
	}
	
	@Test
	public void calculate () throws MidiFileInvalidBarDataException { 
		MidiFileCurrentSlideCalculator calculator = new MidiFileCurrentSlideCalculator();
        MidiFileCreator creator = MidiFileCreator.create();
		
		Session session = MidiPlayerService.mf.createSession();
		creator.part(SongPartType.INTRO).setBar(12);
		creator.chordAndText("This is a chord", "And this is a text");
		creator.part(SongPartType.VERS).setBar(15);
		creator.chordAndText("This is a chord", "And this is a text");
		Song midiFile = creator.get();
		session.getItems().add(midiFile);
		calculator.init(session);
		
		SongPart firstPart = midiFile.getParts().get(0);
		SongPart secondPart = midiFile.getParts().get(1);
		
		assertEquals (firstPart, calculator.getCurrentPart(midiFile, new Position (12,1)));
		assertEquals (firstPart, calculator.getCurrentPart(midiFile, new Position (13,1)));
		assertEquals (firstPart, calculator.getCurrentPart(midiFile, new Position(14,1)));
		assertEquals (secondPart, calculator.getCurrentPart(midiFile, new Position(15,1)));
		assertEquals (secondPart, calculator.getCurrentPart(midiFile, new Position(80,1)));
		
	}

}
