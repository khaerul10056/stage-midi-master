package org.mda.model;

import mda.Gallery;
import mda.MidiPlayerRoot;
import mda.Session;
import mda.Song;

import org.junit.Assert;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.test.SongCreator;

public class ModelServiceTest {
	
	private ModelService modelService = new ModelService ();

	@Test
	public void removeSongAndReferences() {
		
		Song creator = SongCreator.create().setName("Hello").get();
		Song creator2 = SongCreator.create().setName("Hello2").get();
		final String TESTSESSION = "TESTSESSION";

		MidiPlayerRoot root = MidiPlayerService.mf.createMidiPlayerRoot();
		Gallery gallery = MidiPlayerService.mf.createGallery();
		gallery.getGalleryItems().add(creator2);
		gallery.getGalleryItems().add(creator);
		root.setGallery(gallery);

		Session session = MidiPlayerService.mf.createSession();
		session.setName(TESTSESSION);
		session.getItems().add(creator2);
		root.getSessions().add(session);

		Assert.assertEquals(2, root.getGallery().getGalleryItems().size());
		Assert.assertEquals(1, root.getSessions().get(0).getItems().size());

		modelService.removeSongAndReferences(root, creator2);

		Assert.assertEquals(1, root.getGallery().getGalleryItems().size());
		Assert.assertEquals(0, root.getSessions().get(0).getItems().size());

	}

}
