package maosoft;

import java.io.File;
import java.util.List;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiPlayerRoot;

import org.junit.Test;
import org.mda.Chord;
import org.mda.MidiFileSearchConf;
import org.mda.MidiPlayerService;
import org.mda.TransposeService;

public class TransposeServiceTest {


	@Test
	public void transposeFromCToF () throws Exception {
		MidiPlayerRoot loadRootObject = MidiPlayerService.loadRootObject(new File ("../org.mda.core.test/conf/midiplayer.conf"));
		MidiFileSearchConf conf = new MidiFileSearchConf();
		conf.setTitle("Alle");
		List<AbstractSessionItem> find = MidiPlayerService.find(loadRootObject, conf);

		TransposeService.transposeFile((MidiFile) find.get(0), new Chord("F"));



	}

}
