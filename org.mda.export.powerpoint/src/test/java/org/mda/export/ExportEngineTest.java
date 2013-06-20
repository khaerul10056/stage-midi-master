package org.mda.export;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;

import mda.MidiPlayerRoot;
import mda.SongPartType;
import mda.User;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.mda.CoreModule;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.inject.InjectService;
import org.mda.presenter.PresenterModule;
import org.mda.test.ModelCreator;
import org.mda.test.SongCreator;

public class ExportEngineTest {

	private static List<ExportResult> exportSongbooks;
	
	
	final String USER1 = "USER1";
    final String MAIL1 = "markus.oley@t-online.de";
    final String NOTSONGBOOKUSER = "NOTSONGBOOKUSER";

	private MidiPlayerRoot createTestdata() {
		MidiPlayerRoot model = ModelCreator.create().get();

		User user1 = createUser(USER1, MAIL1, true);
		model.getUsers().add(user1);
		User user2 = createUser(NOTSONGBOOKUSER, null, false);
		model.getUsers().add(user2);
		
		SongCreator creator = SongCreator.create(); 
		creator.part(SongPartType.INTRO).line().chord("D").chord("G").chord("D");
		creator.part(SongPartType.VERS).line().chordAndText("D", "This is a new line").chordAndText("G", "we sing").line().chordAndText("D", "and the second line");
		model.getGallery().getGalleryItems().add(creator.get());
		model.getConfig().setMailserverUrl("MAILSERVERURL");
		model.getConfig().setMailserverPassword("PASSWORD");
		model.getConfig().setMailserverUser("USER");
		return model;
	}
	
	@AfterClass
	public static void afterClass () {
		InjectService.dispose();
	}
	

	


	@Test
	public void exportSongbooks() throws MessagingException {

		InjectService.cachedModules.add(new CoreModule());
		InjectService.cachedModules.add(new PresenterModule());
		InjectService.cachedModules.add(new ExportTestModule());

		MidiPlayerRoot model = createTestdata();
		File exportpath = new File("tmp/export");
		if (exportpath.exists())
			Utils.deleteDirectory(exportpath);
		Assert.assertTrue(exportpath.mkdirs());

		ExportEngine engine = InjectService.getInstance(ExportEngine.class);

		exportSongbooks = engine.exportSongbooks(model, exportpath);

		Assert.assertEquals(1, exportSongbooks.size());
		Assert.assertNull(exportSongbooks.get(0).getException());

		Assert.assertTrue(exportSongbooks.get(0).getExportFile().exists());
		Assert.assertEquals(USER1, exportSongbooks.get(0).getUser().getName());
		Assert.assertEquals("songbook_" + USER1 + ".pdf", exportSongbooks.get(0).getExportFile().getName());

		try {
			engine.mailExportedSongbooks(model, exportSongbooks);
			Assert.fail("Messaging Exception expected");
		} catch (MessagingException e) {

		}

	}

	private User createUser(final String name, final String email,
			final boolean songbook) {
		User newUser = MidiPlayerService.mf.createUser();
		newUser.setName(name);
		newUser.setMail(email);
		newUser.setSendSongbook(songbook);

		return newUser;
	}

}
