package org.mda.navigator.ui;

import mda.MidiPlayerRoot;


public class SongGroup {


  private final MidiPlayerRoot root;

  public SongGroup (final MidiPlayerRoot root) {
    this.root = root;
  }

  public MidiPlayerRoot getRoot () {
    return root;
  }

}
