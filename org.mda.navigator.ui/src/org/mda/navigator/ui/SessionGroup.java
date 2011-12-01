package org.mda.navigator.ui;

import mda.MidiPlayerRoot;


public class SessionGroup {

  private final MidiPlayerRoot root;

  public SessionGroup (final MidiPlayerRoot root) {
    this.root = root;
  }

  public MidiPlayerRoot getRoot () {
    return root;
  }

}
