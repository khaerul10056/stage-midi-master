package org.mda.midi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mda.AbstractSessionItem;
import mda.Session;
import mda.Song;
import mda.SongPart;

/**
 * calculates the current part for a special bar in a special midifile
 * @author mao
 *
 */

public class MidiFileCurrentSlideCalculator {
	
	/**
	 * list of bar-current part - associations
	 */
	private List<MidiFileCurrentSlideInfo> currentSlideInfos = new ArrayList<MidiFileCurrentSlideInfo>();
	
	
	/**
	 * initialize calculator, sort the slideinfos by name, bar
	 * @param session session
	 * @throws MidiFileInvalidBarDataException if bars are not valid
	 */
	public void init (final Session session) throws MidiFileInvalidBarDataException {
		MidiFileInvalidBarDataException exception = new MidiFileInvalidBarDataException();
		
		currentSlideInfos.clear();
		
		for (AbstractSessionItem nextSessionItem: session.getItems()) {
			if (nextSessionItem instanceof Song) {
				Song nextMidiFile = (Song) nextSessionItem;
				int numberOfBarAssignments = 0;
				int lastBar = -1;
				for (SongPart nextPart : nextMidiFile.getParts()) {
					if (nextPart.getBar() >= 0)
						numberOfBarAssignments++;
					
					if (lastBar >= nextPart.getBar())
						exception.addInvalidBarData(MidiFileInvalidBarData.createWrongBarOrderEntry(nextPart));
					
					currentSlideInfos.add(new MidiFileCurrentSlideInfo(nextMidiFile, nextPart.getPosition(), nextPart));
				}
				
				if (numberOfBarAssignments == 0)
					exception.addInvalidBarData(MidiFileInvalidBarData.createNoBarDataAvailableEntry(nextMidiFile));
				
			}
		}
		Collections.sort(currentSlideInfos, new Comparator<MidiFileCurrentSlideInfo>() {
			

			@Override
			public int compare(MidiFileCurrentSlideInfo o1,
					MidiFileCurrentSlideInfo o2) {
				
				String name1 = o1.getMidiFile().getName() != null ? o1.getMidiFile().getName() : "<null>";
				String name2 = o2.getMidiFile().getName() != null ? o2.getMidiFile().getName() : "<null>";
				
				int compareKey = name1.compareTo(name2);
				if (compareKey == 0)
					compareKey = o1.getPosition().compareTo(o2.getPosition());
				
				return compareKey;
			}
		});
		
		if (exception.mustBeThrown())
			throw exception;
		
	}
	
	/**
	 * gets all slideinfos for the given file
	 * @param file file
	 * @return slideinfos
	 */
	private List <MidiFileCurrentSlideInfo> getCurrentSlideInfos (final Song file) {
		List<MidiFileCurrentSlideInfo> infos = new ArrayList<MidiFileCurrentSlideInfo>();
		for (MidiFileCurrentSlideInfo nextinfo: currentSlideInfos) {
			if (nextinfo.getMidiFile() == file)
				infos.add(nextinfo);
		}
		
		return infos;
	}
	
	/**
	 * gets current part for the given parameters
	 * @param currentItem  midifile
	 * @param bar  bar
	 * @return current bar
	 */
	public SongPart getCurrentPart (final Song currentItem, final Position position) {
		List<MidiFileCurrentSlideInfo> currentSlideInfos2 = getCurrentSlideInfos(currentItem);
		for (MidiFileCurrentSlideInfo next: currentSlideInfos2) {
			Position posNextSlide = next.getPosition();
			if (posNextSlide.isAfter(position)) {
				int indexNextSlide = currentSlideInfos2.indexOf(next);
				if (indexNextSlide > 0)
					indexNextSlide --;
				
				return currentSlideInfos2.get(indexNextSlide).getCurrentPart();
			}
		}
		
		//or the last, if we don't find an entry with a greater bar
		return currentSlideInfos2.get(currentSlideInfos2.size() - 1).getCurrentPart();
		
	}

}
