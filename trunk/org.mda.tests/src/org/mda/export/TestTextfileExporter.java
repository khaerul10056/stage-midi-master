package org.mda.export;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePartType;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.export.pdf.PdfExporter;
import org.mda.export.textfile.TextfileExporter;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.presenter.ui.test.MidiFileCreator;
import org.mda.presenter.config.DefaultMidiFilePresenterConfig;

public class TestTextfileExporter {
	
	private File tmpFile = new File ("tmp/export.txt");

	  private static ApplicationSession appSession;

	  @Before
	  public void before () {
	    if (tmpFile.exists())
	      Assert.assertTrue (tmpFile.delete());
	  }

	  @After
	  public void after () {
	    if (tmpFile.exists())
	      Assert.assertTrue (tmpFile.delete());
	  }

	  @BeforeClass
	  public static void beforeClass () {
		InjectServiceMock.initialize();
		appSession = InjectService.getInstance(ApplicationSession.class);
	    appSession.load(null);
	    appSession.getGlobalConfs().setShowGrid(true);
	    appSession.getGlobalConfs().setDefaultBorder(0);
	  }
	  
	  private TextfileExporter getExporter () {
		  return InjectService.getInstance(TextfileExporter.class);
	  }

	  
	  
	  private MidiFile createTestMidiFile () {
		  MidiFileCreator creator = MidiFileCreator.create();
		  creator.setName("This is my song"); 
		  creator.part(MidiFilePartType.VERS); 
		  creator.line().chordAndText("C", "This is my song, ").chordAndText("G", "it sounds so good");
		  creator.line().text("And this is my second line ").chord("C").chord("G").chordAndText("C", "with an end.");
		  creator.part(MidiFilePartType.REFRAIN); 
		  creator.line().text("Refrain");
		  return creator.get();
	  }

  @Test
  public void exportWithoutChords () throws IOException {
	    TextfileExporter exporter = getExporter();

	    DefaultMidiFilePresenterConfig config = new DefaultMidiFilePresenterConfig();
	    config.setShowChords(false);
	    config.setShowTitle(true);
	    appSession.getGlobalConfs().setDefaultBorder(new Integer (0));

	    List <AbstractSessionItem> sessionitems = new ArrayList<AbstractSessionItem>();
	    sessionitems.add(createTestMidiFile());

	    exporter.export(sessionitems, tmpFile, config);
	    
	    List <String> textfileContent = Utils.readTextFile(tmpFile);
	    List <String> textfileContentExpected = Utils.readTextFile(new File ("testdata/textexport.expected"));
	    Assert.assertArrayEquals(textfileContent.toArray(), textfileContentExpected.toArray());
  }
}
