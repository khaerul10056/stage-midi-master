package org.mda.transpose;

import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongPartType;

import org.junit.Assert;
import org.junit.Test;
import org.mda.test.SongCreator;

public class TransposeTest {
	 @Test
	  public void transpose () throws Exception {

	    SongCreator creator = SongCreator.create().part(SongPartType.INTRO);
	    Song file = creator.line().chordAndText("D", "Hello").chordAndText("G", "you").get();

	    TransposeService ts = new TransposeService();
	    ts.transpose(file, Pitch.D, Pitch.C);
	    SongChordPart first = file.getParts().get(0).getTextlines().get(0).getChordParts().get(0);
	    SongChordPart second = file.getParts().get(0).getTextlines().get(0).getChordParts().get(1);

	    Assert.assertEquals ("C", first.getChord());
	    Assert.assertEquals ("F", second.getChord());
	  }

	  @Test
	  public void transpose2 () throws Exception {

	    SongCreator creator = SongCreator.create().part(SongPartType.INTRO);
	    Song file = creator.line().chordAndText("D", "Hello").chordAndText("G", "you").get();

	    TransposeService ts = new TransposeService();
	    ts.transpose(file, Pitch.D, Pitch.A);
	    SongChordPart first = file.getParts().get(0).getTextlines().get(0).getChordParts().get(0);
	    SongChordPart second = file.getParts().get(0).getTextlines().get(0).getChordParts().get(1);

	    Assert.assertEquals ("A", first.getChord());
	    Assert.assertEquals ("D", second.getChord());


	  }

	  @Test
	  public void transpose3 () throws Exception {

	    SongCreator creator = SongCreator.create().part(SongPartType.INTRO);
	    Song file = creator.line().chordAndText("D/A", "Hello").get();

	    TransposeService ts = new TransposeService();
	    ts.transpose(file, Pitch.A, Pitch.F);
	    SongChordPart first = file.getParts().get(0).getTextlines().get(0).getChordParts().get(0);

	    Assert.assertEquals ("Bb/F", first.getChord());



	  }

	  @Test
	  public void transposeSong () throws Exception {
	    SongCreator creator = SongCreator.create();
	    creator = creator.part(SongPartType.INTRO).line().chordAndText("D", "Hello").chordAndText("G", "you");
	    creator = creator.part(SongPartType.VERS).line().chordAndText("D", "Hello").chordAndText("G", "you");
	    creator = creator.part(SongPartType.REFRAIN).line().chordAndText("D", "Hello").chordAndText("G", "you");
	    creator = creator.part(SongPartType.VERS).line().chordAndText("D", "Hello").chordAndText("G", "you");
	    Song file = creator.get();

	    TransposeService ts = new TransposeService();
	    ts.transpose(file, Pitch.D, Pitch.E);

	    for (SongPart nextPart: file.getParts()) {
	      SongChordPart first = nextPart.getTextlines().get(0).getChordParts().get(0);
	      SongChordPart second = nextPart.getTextlines().get(0).getChordParts().get(1);
	      Assert.assertEquals ("E", first.getChord());
	      Assert.assertEquals ("A", second.getChord());
	    }

	    Assert.assertEquals (Pitch.E.getLabel(), file.getKey());



	  }

	  @Test
	  public void transposeMoll () throws Exception {

	    SongCreator creator = SongCreator.create().part(SongPartType.INTRO);
	    Song file = creator.line().chordAndText("f#", "Hello").get();

	    TransposeService ts = new TransposeService();
	    ts.transpose(file, Pitch.A, Pitch.F);
	    SongChordPart first = file.getParts().get(0).getTextlines().get(0).getChordParts().get(0);

	    Assert.assertEquals ("d", first.getChord());



	  }

}
