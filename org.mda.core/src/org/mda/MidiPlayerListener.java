package org.mda;

import mda.AbstractSessionItem;
import mda.Session;


public interface MidiPlayerListener {

  public void sessionChanged (Session newSession);

	public void sessionItemChanged (AbstractSessionItem abstractSessionItem);

	public void started ();

	public void stopped ();

	public void modeToggled(PlayerMode chosePlayerMode);

	public void barChanged (int currentBar);

}
