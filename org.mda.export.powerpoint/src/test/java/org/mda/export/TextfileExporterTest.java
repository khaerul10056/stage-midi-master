package org.mda.export;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mda.AbstractSessionItem;
import mda.Song;
import mda.SongPartType;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.export.textfile.TextfileExporter;
import org.mda.inject.InjectService;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.test.SongCreator;

public class TextfileExporterTest {

	private File tmpFile = new File("tmp/export.txt");
	private File tmpRoot = new File ("tmp");

	@Before
	public void before() {
		Utils.deleteDirectory(tmpRoot);
	}

	@After
	public void after() {
		Utils.deleteDirectory(tmpRoot);
	}
	
	@AfterClass
	public static void afterClass () {
		InjectService.dispose();
	}

	private TextfileExporter getExporter() {
		return InjectService.getInstance(TextfileExporter.class);
	}

	private Song createTestMidiFile() {
		SongCreator creator = SongCreator.create();
		creator.setName("This is my song");
		creator.part(SongPartType.VERS);
		creator.line().chordAndText("C", "This is my song, ").chordAndText("G", "it sounds so good");
		creator.line().text("And this is my second line ").chord("C").chord("G").chordAndText("C", "with an end.");
		creator.part(SongPartType.REFRAIN);
		creator.line().text("Refrain");
		return creator.get();
	}

	@Test
	public void exportWithoutChords() throws IOException {
		TextfileExporter exporter = getExporter();

		DefaultPresenterConfig config = new DefaultPresenterConfig();
		config.setShowChords(false);
		config.setShowTitle(true);

		List<AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
		sessionitems.add(createTestMidiFile());

		exporter.export(sessionitems, tmpFile, config);

		List<String> textfileContent = Utils.readTextFile(tmpFile);
		List<String> textfileContentExpected = Utils.readTextFile(new File("src/test/resources/textexport.expected"));
		Assert.assertArrayEquals(textfileContent.toArray(),textfileContentExpected.toArray());
	}

}
