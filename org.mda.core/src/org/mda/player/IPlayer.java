package org.mda.player;

import java.awt.event.KeyListener;

import mda.MidiFile;
import mda.Session;

import org.mda.MidiPlayerListener;
import org.mda.PlayerMode;

public interface IPlayer extends KeyListener {

	int getCurrentBar();

	void addMidiPlayerListener(MidiPlayerListener midiFileContentEditor);

	String getCurrentName();


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

	PlayerMode getPlayerMode();

}
