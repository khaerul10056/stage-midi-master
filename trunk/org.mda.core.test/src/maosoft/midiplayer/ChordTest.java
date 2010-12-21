package maosoft.midiplayer;

import org.junit.Assert;
import org.junit.Test;
import org.mda.Chord;
import org.mda.importer.Note;
import org.mda.importer.NoteAddition;

public class ChordTest {

  @Test
  public void sus () throws Exception {
    Chord chord = new Chord("Dsus4");
    chord.render("Dsus4");
    Assert.assertEquals ("Mainnote invalid", Note.D, chord.getMain());
    Assert.assertEquals ("Addition invalid", NoteAddition.sus, chord.getAddition());
    Assert.assertNull ("Bassnote invalid", chord.getBass());
  }


}
