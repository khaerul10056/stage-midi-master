package org.mda.editor.preview.ui.details;

import java.io.File;

import mda.MidiFile;
import mda.MidiPlayerRoot;

import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;

public class MidiFileDetailsShellTest {
	
	private final static String ORIGINALTITLE = "ORIGINALTITLE";
	private final static String PUBLISHER = "PUBLISHER";
	private final static String PUBLISHERINLAND = "PUBINLAND";
	private final static String WRITERMUSIC = "WRITERMUSIC"; 
	private final static String WRITERTEXT = "WRITERTEXT";
	private final static String WRITERTEXTINLAND = "WRITERTEXTINLAND";
	private final static String YEAR = "2010"; 
	
	@Test
	public void build () {
		InjectServiceMock.initialize();
		ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
	    session.load(null);
	    Shell shell = new Shell();
	    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
	    MidiFile file = (MidiFile) root.getGallery().getGalleryItems().get(0);
	    MidiFileDetailsShell additionalshell = InjectService.getInstance(MidiFileDetailsShell.class); 
	    additionalshell.build(shell, file);
	    Assert.assertEquals ("", additionalshell.txtOriginaltitle.getText());
	    Assert.assertEquals ("", additionalshell.txtPublisher.getText());
	    Assert.assertEquals ("", additionalshell.txtPublisherInland.getText());
	    Assert.assertEquals ("", additionalshell.txtWriterMusic.getText());
	    Assert.assertEquals ("", additionalshell.txtWriterText.getText());
	    Assert.assertEquals ("", additionalshell.txtWriterTextInland.getText());
	    Assert.assertEquals ("", additionalshell.txtYear.getText());
	    
	    additionalshell.txtOriginaltitle.setText(ORIGINALTITLE);
	    additionalshell.txtPublisher.setText(PUBLISHER);
	    additionalshell.txtPublisherInland.setText(PUBLISHERINLAND);
	    additionalshell.txtWriterMusic.setText(WRITERMUSIC);
	    additionalshell.txtWriterText.setText(WRITERTEXT);
	    additionalshell.txtWriterTextInland.setText(WRITERTEXTINLAND);
	    additionalshell.txtYear.setText(YEAR);
	    
	    additionalshell.save();
	    
	    file = (MidiFile) root.getGallery().getGalleryItems().get(0);
	    Assert.assertEquals (ORIGINALTITLE, additionalshell.txtOriginaltitle.getText());
	    Assert.assertEquals (PUBLISHER, additionalshell.txtPublisher.getText());
	    Assert.assertEquals (PUBLISHERINLAND, additionalshell.txtPublisherInland.getText());
	    Assert.assertEquals (WRITERMUSIC, additionalshell.txtWriterMusic.getText());
	    Assert.assertEquals (WRITERTEXT, additionalshell.txtWriterText.getText());
	    Assert.assertEquals (WRITERTEXTINLAND, additionalshell.txtWriterTextInland.getText());
	    Assert.assertEquals (YEAR, additionalshell.txtYear.getText());
		
	}

}
