package org.mda;

import java.util.Collection;
import java.util.List;

import mda.Song;
import mda.SongPartType;

import org.junit.Assert;
import org.junit.Test;
import org.mda.copyright.CopyrightSerializer;
import org.mda.inject.InjectService;
import org.mda.test.SongCreator;

/**
 * tests the serializing of copyright
 * @author OleyMa
 */
public class CopyrightSerializerTest {

  final String ORIGINALTITLE = "ORIGINALTITLE";
  final String publisher = "PUBLISHER";
  final String publisherInland = "PUBLISHERINLAND";
  final String writerInlandText = "WRITERINLANDTEXT";
  final String writerMusic = "WRITERMUSIC";
  final String writerText = "WRITERTEXT";
  final String name = "SONGNAME";
  final Integer year = new Integer (2000);

  CopyrightSerializer serializer = InjectService.getInstance(CopyrightSerializer.class);


  @Test
  public void noCopyright () {
    SongCreator creator = SongCreator.create();
    creator = creator.part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    Song file = creator.get();

    Collection<String> serialize = serializer.serialize(file);
    Assert.assertTrue (serialize.isEmpty());
  }

  @Test
  public void emptyCopyright () {
    SongCreator creator = SongCreator.create();
    creator = creator.part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    creator = creator.copyright(null, "", "    ", null, null, null, null);
    Song file = creator.get();

    Collection<String> serialize = serializer.serialize(file);
    Assert.assertTrue (serialize.isEmpty());
  }

  @Test
  public void simpleCopyright () {

    SongCreator creator = SongCreator.create();
    creator = creator.setName(name);
    creator = creator.part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    creator = creator.copyright(ORIGINALTITLE, publisher, publisherInland, writerInlandText, writerMusic, writerText, year);
    Song file = creator.get();

    List<String> serialize = serializer.serialize(file);
    Assert.assertFalse (serialize.isEmpty());
    Assert.assertEquals ("SONGNAME, Originaltitel: ORIGINALTITLE, Text: WRITERTEXT, Melodie: WRITERMUSIC,", serialize.get(0));
    Assert.assertEquals ("Dt. Text: WRITERINLANDTEXT, (c) 2000, PUBLISHER, F�r D,A,CH: PUBLISHERINLAND,", serialize.get(1));
    Assert.assertEquals ("genehmigtes Exemplar", serialize.get(2));

  }

  @Test
  public void copyrightSameTextAndMusic () {

    SongCreator creator = SongCreator.create();
    creator = creator.setName(name);
    creator = creator.part(SongPartType.REFRAIN);
    creator = creator.line().chordAndText("D", "                         ").chordAndText("F", "    ");
    creator = creator.copyright(ORIGINALTITLE, publisher, publisherInland, writerInlandText, writerMusic, writerMusic, year);
    Song file = creator.get();

    List<String> serialize = serializer.serialize(file);
    Assert.assertFalse (serialize.isEmpty());
    Assert.assertEquals ("SONGNAME, Originaltitel: ORIGINALTITLE,  Melodie & Text: WRITERMUSIC,", serialize.get(0));
    Assert.assertEquals ("Dt. Text: WRITERINLANDTEXT, (c) 2000, PUBLISHER, F�r D,A,CH: PUBLISHERINLAND,", serialize.get(1));
    Assert.assertEquals ("genehmigtes Exemplar", serialize.get(2));

  }



}
