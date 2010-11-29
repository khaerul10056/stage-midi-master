package org.mda.importer;

import mda.AbstractSessionItem;
import mda.Session;

import org.mda.MidiPlayerListener;
import org.mda.PlayerMode;

public class MidiPlayerAdapter implements MidiPlayerListener {

	@Override
	public void sessionItemChanged (AbstractSessionItem newSong) {
	}

	@Override
	public void started() {
	}

	@Override
	public void stopped() {
	}

	@Override
	public void modeToggled(PlayerMode chosePlayerMode) {
	}

  @Override
  public void barChanged(int currentBar) {
  }

  @Override
  public void sessionChanged(Session newSession) {
  }

@Override
public void tickChanged(int currentTick) {
	// TODO Auto-generated method stub

}

}
