package org.mda.find;

import java.util.List;

import mda.MidiPlayerRoot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;

public class TestSearchEngine {

	private ApplicationSession applicationSession;

	@Before
	public void before() {
		applicationSession = new ApplicationSession();
		applicationSession.load(null);
	}

	@Test
	public void byNameSearch() {

		MidiPlayerRoot currentModel = applicationSession.getCurrentModel();

		SearchEngine engine = new SearchEngine();
		List<SearchResult> find = engine.find("Alle Schoepfung", currentModel);
		Assert.assertEquals(1, find.size());
		Assert.assertEquals("Song", find.get(0).getClazz().getName());

	}

}
