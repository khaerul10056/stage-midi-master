package org.mda.core;

import java.util.Collection;
import java.util.List;
import junit.framework.Assert;
import mda.Song;
import mda.SongPartType;
import org.junit.Test;
import org.mda.copyright.CopyrightSerializer;
import org.mda.presenter.ui.test.MidiFileCreator;


public class CopyrightSerializerTest {

  final String ORIGINALTITLE = "ORIGINALTITLE";
  final String publisher = "PUBLISHER";
  final String publisherInland = "PUBLISHERINLAND";
  final String writerInlandText = "WRITERINLANDTEXT";
  final String writerMusic = "WRITERMUSIC";
  final String writerText = "WRITERTEXT";
  final String name = "SONGNAME";
  final Integer year = new Integer (2000);


  @Test
  public void noCopyright () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    Song file = creator.get();
    CopyrightSerializer serializer = new CopyrightSerializer();
    Collection<String> serialize = serializer.serialize(file);
    Assert.assertTrue (serialize.isEmpty());
  }

  @Test
  public void emptyCopyright () {
    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    creator = creator.copyright(null, "", "    ", null, null, null, null);
    Song file = creator.get();
    CopyrightSerializer serializer = new CopyrightSerializer();
    Collection<String> serialize = serializer.serialize(file);
    Assert.assertTrue (serialize.isEmpty());
  }

  @Test
  public void simpleCopyright () {

    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.setName(name);
    creator = creator.part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    creator = creator.copyright(ORIGINALTITLE, publisher, publisherInland, writerInlandText, writerMusic, writerText, year);
    Song file = creator.get();
    CopyrightSerializer serializer = new CopyrightSerializer();
    List<String> serialize = serializer.serialize(file);
    Assert.assertFalse (serialize.isEmpty());
    Assert.assertEquals ("SONGNAME, Originaltitel: ORIGINALTITLE, Text: WRITERTEXT, Melodie: WRITERMUSIC,", serialize.get(0));
    Assert.assertEquals ("Dt. Text: WRITERINLANDTEXT, (c) 2000, PUBLISHER, Für D,A,CH: PUBLISHERINLAND,", serialize.get(1)); 
    Assert.assertEquals ("genehmigtes Exemplar", serialize.get(2));

  }

  @Test
  public void copyrightSameTextAndMusic () {

    MidiFileCreator creator = MidiFileCreator.create();
    creator = creator.setName(name);
    creator = creator.part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    creator = creator.copyright(ORIGINALTITLE, publisher, publisherInland, writerInlandText, writerMusic, writerMusic, year);
    Song file = creator.get();
    CopyrightSerializer serializer = new CopyrightSerializer();
    List<String> serialize = serializer.serialize(file);
    Assert.assertFalse (serialize.isEmpty());
    Assert.assertEquals ("SONGNAME, Originaltitel: ORIGINALTITLE,  Melodie & Text: WRITERMUSIC,", serialize.get(0));
    Assert.assertEquals ("Dt. Text: WRITERINLANDTEXT, (c) 2000, PUBLISHER, Für D,A,CH: PUBLISHERINLAND,", serialize.get(1));
    Assert.assertEquals ("genehmigtes Exemplar", serialize.get(2));

  }



}
