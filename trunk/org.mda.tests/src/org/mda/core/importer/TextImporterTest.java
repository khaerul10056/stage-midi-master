package org.mda.core.importer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePartType;
import mda.MidiplayerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.importer.DefaultTextImporterConfig;
import org.mda.importer.TextImporterService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class TextImporterTest {

  private static final Log LOGGER  = LogFactory.getLogger(TextImporterTest.class);

	@Test
	public void importTest() throws Exception {
		List<String> loadFile = loadFile ("testdata/importer/TestSong1.txt");

		for (String nextLine: loadFile) {
			System.out.println ("- " + nextLine);
		}

		DefaultTextImporterConfig config = new DefaultTextImporterConfig();
		TextImporterService service = new TextImporterService (loadFile, config);

		MidiFile midifile = MidiplayerFactory.eINSTANCE.createMidiFile();



		service.importText(midifile);

		Assert.assertEquals (MidiFilePartType.INTRO, midifile.getParts().get(0).getParttype());
		Assert.assertEquals (MidiFilePartType.REFRAIN, midifile.getParts().get(1).getParttype());
		Assert.assertEquals (MidiFilePartType.VERS, midifile.getParts().get(2).getParttype());

		LOGGER.info(MidiPlayerService.getMidiFileAsString(midifile));

	}

	@Test
	public void importTest2 () throws Exception {
		List<String> loadFile = loadFile ("testdata/importer/TestSong2.txt");

		for (String nextLine: loadFile) {
			System.out.println ("- " + nextLine);
		}

		DefaultTextImporterConfig config = new DefaultTextImporterConfig();
		TextImporterService service = new TextImporterService (loadFile, config);

		MidiFile midifile = MidiplayerFactory.eINSTANCE.createMidiFile();
		service.importText(midifile);

		Assert.assertEquals (MidiFilePartType.INTRO, midifile.getParts().get(0).getParttype());
		Assert.assertEquals (MidiFilePartType.VERS, midifile.getParts().get(1).getParttype());
		Assert.assertEquals (MidiFilePartType.REFRAIN, midifile.getParts().get(2).getParttype());

		LOGGER.info(MidiPlayerService.getMidiFileAsString(midifile));


	}

	/**
	 * loads a textfile
	 * @param filename filename
	 * @return list of textlines
	 * @throws IOException Exception
	 */
	private List<String> loadFile(final String filename) throws IOException {
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String nextLine = null;
		do {
			nextLine = reader.readLine();
			if (nextLine != null)
				lines.add(nextLine);

		} while (nextLine != null);

		return lines;
	}

}
