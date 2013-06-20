package org.mda.importer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mda.MidiplayerFactory;
import mda.Song;
import mda.SongPartType;

import org.junit.Assert;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

/**
 * tests the text importer
 * @author OleyMa
 *
 */
public class TextImporterTest {

  private static final Log LOGGER  = LogFactory.getLogger(TextImporterTest.class);

	@Test
	public void importTest() throws Exception {
		List<String> loadFile = loadFile ("src/test/resources/TestSong1.txt");

		if (LOGGER.isDebugEnabled()) {
		  for (String nextLine: loadFile) {
	  		LOGGER.debug("- " + nextLine);
  		}
		}

		DefaultTextImporterConfig config = new DefaultTextImporterConfig();
		TextImporterService service = new TextImporterService (loadFile, config);

		Song midifile = MidiplayerFactory.eINSTANCE.createSong();


		service.importText(midifile);

		Assert.assertEquals (SongPartType.INTRO, midifile.getParts().get(0).getParttype());
		Assert.assertEquals (SongPartType.REFRAIN, midifile.getParts().get(1).getParttype());
		Assert.assertEquals (SongPartType.VERS, midifile.getParts().get(2).getParttype());

		LOGGER.info(MidiPlayerService.getMidiFileAsString(midifile));

	}

	@Test
	public void importTest2 () throws Exception {
		List<String> loadFile = loadFile ("src/test/resources/TestSong2.txt");

		if (LOGGER.isDebugEnabled()) {
		  for (String nextLine: loadFile) {
		    LOGGER.debug("- " + nextLine);
		  }
		}

		DefaultTextImporterConfig config = new DefaultTextImporterConfig();
		TextImporterService service = new TextImporterService (loadFile, config);

		Song midifile = MidiplayerFactory.eINSTANCE.createSong();
		service.importText(midifile);

		Assert.assertEquals (SongPartType.INTRO, midifile.getParts().get(0).getParttype());
		Assert.assertEquals (SongPartType.VERS, midifile.getParts().get(1).getParttype());
		Assert.assertEquals (SongPartType.REFRAIN, midifile.getParts().get(2).getParttype());

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
		try {
			String nextLine = null;
			do {
				nextLine = reader.readLine();
				if (nextLine != null)
					lines.add(nextLine);

			} while (nextLine != null);
		} finally {
			reader.close();
		}

		return lines;
	}

}
