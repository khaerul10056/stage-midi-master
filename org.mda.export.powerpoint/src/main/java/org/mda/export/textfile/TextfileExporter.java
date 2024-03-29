package org.mda.export.textfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mda.AbstractSessionItem;
import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongTextLine;

import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.export.AbstractExporter;
import org.mda.export.ExportException;
import org.mda.presenter.config.IPresenterConfig;

public class TextfileExporter extends AbstractExporter {
	
	
	private List <String> content = new ArrayList<String>();

	/**
	 * adds only a newline, if last exported line was none
	 */
	public void addNewLineOnDemand () {
		if (! content.get(content.size() - 1).trim().isEmpty())
			content.add("");
	}

	@Override
	public File export(Collection<AbstractSessionItem> items, File exportFile, IPresenterConfig config) throws ExportException {
		content.clear();
		
		if (config.isChordPresented())
			throw new IllegalStateException("Presenting chords in textexport is not supported yet");
		
		for (AbstractSessionItem sessionItem: items) {
			if (sessionItem instanceof Song) {
				Song nextFile = (Song) sessionItem;
				
			    if (config.isShowTitle()) {
			    	String title= MidiPlayerService.getTitle(nextFile);
			    	if (title != null) {
			    		content.add(title);
			    		addNewLineOnDemand();
			    	}
			    }
			    
			    for (SongPart nextPart : nextFile.getParts()) {
			    	
			    	if (nextPart.getRefPart() != null)
			    		nextPart = nextPart.getRefPart();
			        for (SongTextLine nextLine : nextPart.getTextlines()) {
			          StringBuilder builder = new StringBuilder();
			          for (SongChordPart nextChordPart : nextLine.getChordParts()) {
			        	if (nextChordPart.getText() != null)
			              builder.append(nextChordPart.getText());
			          }
			          
			          String newString = Utils.trimRight(builder.toString()).trim();
			          if (newString != null && newString.length() > 0)
			            content.add(newString);
			        }
			        addNewLineOnDemand();
			      }
			}
			content.add("=====================================================================");
		}
		
		try {
			Utils.writeTextFile (exportFile, content);
		} catch (IOException e) {
			throw new ExportException("Error saving exportfile " + exportFile.getAbsolutePath(), e);
		}
		return exportFile;
	}

	@Override
	public String getSuffix() {
		return ".txt";
	}

}
