package org.mda.core;

import org.junit.Assert;
import org.junit.Test;
import org.mda.Chord;
import org.mda.transpose.Note;
import org.mda.transpose.NoteAddition;

public class ChordTest {

  @Test
  public void sus () throws Exception {

    Chord chord = new Chord("Dsus4");
    chord.render();
    Assert.assertEquals ("Mainnote invalid", Note.D, chord.getMain());
    Assert.assertEquals ("Addition invalid", NoteAddition.sus, chord.getAddition());
    Assert.assertNull ("Bassnote invalid", chord.getBass());
  }

  @Test
  public void minor () throws Exception {

    Chord chord = new Chord("f#");
    chord.render();

    Assert.assertEquals ("Mainnote invalid", Note.FIS, chord.getMain());
    Assert.assertTrue ("Minor invalid", chord.isMinor());

  }

  @Test
  public void minorWithM () throws Exception {
    Chord chord = new Chord("Am/E");
    chord.render();

    Assert.assertEquals ("Mainnote invalid", Note.A, chord.getMain());
    Assert.assertTrue ("Minor invalid", chord.isMinor());
    Assert.assertEquals ("Bassnote invalid", Note.E, chord.getBass());
  }


}
