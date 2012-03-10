package org.mda.player;

import java.awt.event.KeyListener;
import javax.sound.midi.MidiUnavailableException;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import mda.Session;
import org.mda.MidiPlayerListener;

public interface IPlayer extends KeyListener {

	int getCurrentBar();

	void addMidiPlayerListener(MidiPlayerListener midiFileContentEditor);

	String getCurrentName();

	void init (final MidiPlayerRoot root) throws MidiUnavailableException;


	boolean isRunning();

	String getCurrentPositionInSong();

	int getCurrentTick();

	Session getCurrentSession();

	MidiFile getCurrentMidifile();

	boolean isSessionListEmpty();

	int getCurrentSongIndex();

	void setCurrentSession(Session currentSession);

	void setCurrentSong(int i);

	void open();

	void setLoopFrom(int bar);

	void setLoopTo(int i);

	Object getNameOf(int index);


}
