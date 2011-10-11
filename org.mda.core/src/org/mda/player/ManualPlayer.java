package org.mda.player;

import java.awt.event.KeyEvent;
import javax.sound.midi.MidiUnavailableException;
import mda.MidiFilePart;
import mda.MidiPlayerRoot;
import org.mda.MidiPlayerListener;

public class ManualPlayer extends MidiPlayer implements IPlayer {

	private int currentPage = 0;

	@Override
	public void init(MidiPlayerRoot root) throws MidiUnavailableException {
	  setRoot(root);

	}

	@Override
	public int getCurrentBar() {
		return 0;
	}

	@Override
	public void open() {

	}

	public void setLoopFrom(int bar) {

	}

	public void setLoopTo(int i) {

	}

	private void stepToPage (final int number) {
		MidiFilePart midiFilePart = getCurrentMidifile().getParts().get(currentPage);

		for (MidiPlayerListener listener : listeners)
			listener.barChanged(midiFilePart.getBar());

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			if (currentPage > 0)
			  currentPage--;

			stepToPage(currentPage);


		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			if (currentPage < getCurrentMidifile().getParts().size())
			  currentPage++;

			stepToPage(currentPage);
		}
		else
			super.keyPressed(e);
	}

}
