package org.mda.midi;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class MidiModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(MidiPlayer.class).in(Singleton.class);

	}

}
