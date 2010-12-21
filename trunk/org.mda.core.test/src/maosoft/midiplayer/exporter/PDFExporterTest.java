package maosoft.midiplayer.exporter;

import java.io.File;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiPlayerRoot;

import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.export.PDFExporter;


public class PDFExporterTest {

	@Test
	public void exportTests () {
		PDFExporter exporter = new PDFExporter();
		exporter.setExportPath(new File ("tmp"));
		MidiPlayerRoot loadRootObject = MidiPlayerService.loadRootObject(new File ("conf/midiplayer.conf"));
		for (AbstractSessionItem nextFile: loadRootObject.getSessions().get(0).getItems()) {
			if (nextFile instanceof MidiFile) {
				exporter.exportMidifile((MidiFile) nextFile);
			}
		}

	}

}
