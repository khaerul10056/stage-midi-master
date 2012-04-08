package org.mda.transpose;

import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePartType;
import org.junit.Assert;
import org.junit.Test;
import org.mda.presenter.ui.test.MidiFileCreator;


public class TransposeTest {

  @Test
  public void transpose () throws Exception {

    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.INTRO);
    MidiFile file = creator.line().chordAndText("D", "Hello").chordAndText("G", "you").get();

    TransposeService ts = new TransposeService();
    ts.transpose(file, Note.D, Note.C);
    MidiFileChordPart first = file.getParts().get(0).getTextlines().get(0).getChordParts().get(0);
    MidiFileChordPart second = file.getParts().get(0).getTextlines().get(0).getChordParts().get(1);

    Assert.assertEquals ("C", first.getChord());
    Assert.assertEquals ("F", second.getChord());
  }

  @Test
  public void transpose2 () throws Exception {

    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.INTRO);
    MidiFile file = creator.line().chordAndText("D", "Hello").chordAndText("G", "you").get();

    TransposeService ts = new TransposeService();
    ts.transpose(file, Note.D, Note.A);
    MidiFileChordPart first = file.getParts().get(0).getTextlines().get(0).getChordParts().get(0);
    MidiFileChordPart second = file.getParts().get(0).getTextlines().get(0).getChordParts().get(1);

    Assert.assertEquals ("A", first.getChord());
    Assert.assertEquals ("D", second.getChord());


  }

  @Test
  public void transpose3 () throws Exception {

    MidiFileCreator creator = MidiFileCreator.create().part(MidiFilePartType.INTRO);
    MidiFile file = creator.line().chordAndText("D/A", "Hello").get();

    TransposeService ts = new TransposeService();
    ts.transpose(file, Note.A, Note.F);
    MidiFileChordPart first = file.getParts().get(0).getTextlines().get(0).getChordParts().get(0);

    Assert.assertEquals ("Bb/F", first.getChord());



  }


}
