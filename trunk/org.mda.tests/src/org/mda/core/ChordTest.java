package org.mda.core;

import org.junit.Assert;
import org.junit.Test;
import org.mda.Chord;
import org.mda.transpose.Note;
import org.mda.transpose.NoteAddition;

public class ChordTest {

  @Test
  public void sus () throws Exception {

    System.out.println ("Hallo=" + System.getProperty("hallo"));
    Chord chord = new Chord("Dsus4");
    chord.render();
    Assert.assertEquals ("Mainnote invalid", Note.D, chord.getMain());
    Assert.assertEquals ("Addition invalid", NoteAddition.sus, chord.getAddition());
    Assert.assertNull ("Bassnote invalid", chord.getBass());
  }


}
