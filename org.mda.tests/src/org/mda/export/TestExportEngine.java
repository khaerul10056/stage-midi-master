package org.mda.export;

import java.io.File;
import java.util.List;
import mda.AbstractSessionItem;
import mda.MidiPlayerRoot;
import mda.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class TestExportEngine {

  private static List<ExportResult> exportSongbooks;

  private static final Log LOGGER  = LogFactory.getLogger(TestExportEngine.class);

  @Test
  public void exportSongbooks () {

    final String USER1 = "USER1";
    final String MAIL1 = "markus.oley@t-online.de";
    final String NOTSONGBOOKUSER = "NOTSONGBOOKUSER";

    ApplicationSession instance = new ApplicationSession();
    instance.load(null);
    instance.getCurrentModel().getConfig().setPdfExportPath("tmp/export");
    File path = new File ("tmp/export");
    if (path.exists())
      Utils.deleteDirectory(path);
    Assert.assertTrue (path.mkdirs());

    MidiPlayerRoot model = instance.getCurrentModel();
    model.getUsers().clear();
    List<AbstractSessionItem> subList = model.getGallery().getGalleryItems().subList(3, model.getGallery().getGalleryItems().size() - 1);
    model.getGallery().getGalleryItems().removeAll(subList);

    User user1 = createUser(USER1, MAIL1, true);
    model.getUsers().add(user1);
    User user2 = createUser(NOTSONGBOOKUSER,null, false);
    model.getUsers().add(user2);
    Assert.assertEquals (4, model.getGallery().getGalleryItems().size()); //Precondition-check

    ExportEngine engine = new ExportEngine();

    exportSongbooks = engine.exportSongbooks();

    Assert.assertEquals (1 , exportSongbooks.size());
    Assert.assertNull (exportSongbooks.get(0).getException());

    Assert.assertTrue (exportSongbooks.get(0).getExportFile().exists());
    Assert.assertEquals (USER1, exportSongbooks.get(0).getUser().getName());
    Assert.assertEquals ("songbook_" + USER1 + ".pdf", exportSongbooks.get(0).getExportFile().getName());



  }

  @Test@Ignore //Mock the mailing
  public void checkMail () {
    Assert.assertNotNull ("Test exportSongbooks must run before", exportSongbooks);

    ExportEngine engine = new ExportEngine();
    engine.mailExportedSongbooks(exportSongbooks);


  }

  private User createUser (final String name, final String email, final boolean songbook) {
    User newUser = MidiPlayerService.mf.createUser();
    newUser.setName(name);
    newUser.setMail(email);
    newUser.setSendSongbook(songbook);

    return newUser;
  }


}
