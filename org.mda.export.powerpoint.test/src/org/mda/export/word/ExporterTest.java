package org.mda.export.word;

import java.io.File;
import mda.MidiPlayerRoot;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.export.word.Exporter;


public class ExporterTest {

  private MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));

  private File exportFile = new File ("exportfile.doc");



  @Test
  public void test () throws Exception {
    Exporter exporter = new Exporter();

    exporter.export(root.getGallery().getGalleryItems(), exportFile);
  }
}
