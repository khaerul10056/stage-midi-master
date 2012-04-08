package org.mda.commons.ui.transpose;

import mda.MidiFile;
import org.eclipse.swt.widgets.Shell;


public class TransposeShell extends Shell {

  private MidiFile midifile;


  public TransposeShell (final MidiFile file) {
    this.midifile = file;
  }


  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
