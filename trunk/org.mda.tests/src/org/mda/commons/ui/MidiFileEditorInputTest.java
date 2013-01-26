package org.mda.commons.ui;

import java.io.File;
import mda.Song;
import mda.MidiPlayerRoot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mda.MidiPlayerService;


public class MidiFileEditorInputTest {

  private String saveOldName;
  private Song song;
  @Before
  public void before () {
    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
    song = (Song) root.getGallery().getGalleryItems().get(0);

    saveOldName = song.getName();
  }
  @Test
  public void dirtyDetection () throws Exception {
    MidiFileEditorInput input1 = new MidiFileEditorInput(song);

    Assert.assertFalse (input1.isDirty());
    song.setName("New songnametitle");
    Assert.assertTrue (input1.isDirty());
    song.setName(saveOldName);
    Assert.assertFalse (input1.isDirty());


  }


}
