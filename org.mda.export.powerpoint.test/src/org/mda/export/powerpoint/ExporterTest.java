package org.mda.export.powerpoint;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import org.junit.Test;
import org.mda.MidiPlayerService;


public class ExporterTest {

  private MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));

  private File exportFile = new File ("exportfile.ppt");



  @Test
  public void test () throws Exception {
    Exporter exporter = new Exporter();

    Collection <AbstractSessionItem> files = new ArrayList<AbstractSessionItem>();
    MidiFile file1 = (MidiFile) root.getGallery().getGalleryItems().get(2);
    file1.setPic("testdata/example1.jpg");

    MidiFile file2 = (MidiFile) root.getGallery().getGalleryItems().get(3);

    files.add(file1);
    files.add(file2);


    exporter.export(files, exportFile);
  }

}
