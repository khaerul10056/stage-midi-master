package org.mda.find;

import java.util.List;

import mda.MidiPlayerRoot;

import org.junit.Assert;
import org.junit.Test;
import org.mda.test.ModelCreator;
import org.mda.test.SongCreator;

public class SearchEngineTest {

	@Test
	public void byNameSearch() {
		
		MidiPlayerRoot root = ModelCreator.create().get();
		
		root.getGallery().getGalleryItems().add(SongCreator.create().setName("This is the first song").get());
		root.getGallery().getGalleryItems().add(SongCreator.create().setName("This is not the second song").get());

		SearchEngine engine = new SearchEngine();
		List<SearchResult> find = engine.find("This is the", root);
		Assert.assertEquals(1, find.size());
		Assert.assertEquals("Song", find.get(0).getClazz().getName());

	}

}
