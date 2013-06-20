package org.mda;

import org.junit.Assert;
import org.junit.Test;
import org.mda.transpose.NoteAddition;
import org.mda.transpose.Pitch;

public class ChordTest {

  @Test
  public void sus () throws Exception {

    Chord chord = new Chord("Dsus4");
    chord.render();
    Assert.assertEquals ("Mainnote invalid", Pitch.D, chord.getMain());
    Assert.assertEquals ("Addition invalid", NoteAddition.sus, chord.getAddition());
    Assert.assertNull ("Bassnote invalid", chord.getBass());
  }

  @Test
  public void minor () throws Exception {

    Chord chord = new Chord("f#");
    chord.render();

    Assert.assertEquals ("Mainnote invalid", Pitch.FIS, chord.getMain());
    Assert.assertTrue ("Minor invalid", chord.isMinor());

  }

  @Test
  public void minorWithM () throws Exception {
    Chord chord = new Chord("Am/E");
    chord.render();

    Assert.assertEquals ("Mainnote invalid", Pitch.A, chord.getMain());
    Assert.assertTrue ("Minor invalid", chord.isMinor());
    Assert.assertEquals ("Bassnote invalid", Pitch.E, chord.getBass());
  }


}
