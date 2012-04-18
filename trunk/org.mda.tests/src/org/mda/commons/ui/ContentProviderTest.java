package org.mda.commons.ui;

import mda.AbstractSessionItem;
import mda.Gallery;
import mda.MidiFile;
import mda.Session;
import org.junit.Assert;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.navigator.NavigatorItem;
import org.mda.presenter.ui.test.MidiFileCreator;


public class ContentProviderTest {

  private String getName (final Object object) {
    NavigatorItem item = (NavigatorItem) object;
    return ((AbstractSessionItem) item.getModelElement()).getName();
  }
  @Test
  public void sorting () {

    final String SECOND = "Be the second";
    final String FIRST = "And the first";
    final String THIRD = "The third at last";

    MidiFile file1 = MidiFileCreator.create().setName(SECOND).get();
    MidiFile file2 = MidiFileCreator.create().setName(FIRST).get();
    MidiFile file3 = MidiFileCreator.create().setName(THIRD).get();

    Gallery gallery = MidiPlayerService.mf.createGallery();
    gallery.getGalleryItems().add(file1);
    gallery.getGalleryItems().add(file2);
    gallery.getGalleryItems().add(file3);

    Session session = MidiPlayerService.mf.createSession();
    session.getItems().add(file1);
    session.getItems().add(file2);
    session.getItems().add(file3);

    ContentProvider provider = new ContentProvider();

    Object[] childrensOfGallery =  provider.getChildren(gallery);

    Assert.assertEquals(FIRST, getName(childrensOfGallery [0]));
    Assert.assertEquals(SECOND,  getName(childrensOfGallery [1]));
    Assert.assertEquals(THIRD,  getName(childrensOfGallery [2]));



    Object[] childrensOfSession =  provider.getChildren(session);
    Assert.assertEquals(SECOND, getName(childrensOfSession [0]));
    Assert.assertEquals(FIRST, getName(childrensOfSession [1]));
    Assert.assertEquals(THIRD, getName(childrensOfSession [2]));

  }

}
