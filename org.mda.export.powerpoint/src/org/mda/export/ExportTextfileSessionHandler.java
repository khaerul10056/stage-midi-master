package org.mda.export;

import java.io.File;

import mda.Session;

import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.export.textfile.TextfileExporter;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;

import com.google.inject.Inject;

public class ExportTextfileSessionHandler {
	
	@Inject
	private TextfileExporter exporter;
	
	
	
	@Inject
	private ApplicationSession session;
	
	
	public void execute() {
		
		//TODO make a new PresentationType
		PresentationConfigurator configurator = new PresentationConfigurator(); 
		DefaultPresenterConfig config = (DefaultPresenterConfig) configurator.configure(null, session.getCurrentModel(), PresentationType.PDF);
		config.setShowTitle(true); 
		config.setShowChords(false);
		Session currentSession = (Session) session.getModelEvents().getCurrentModelElement(Session.class);
		String name = Utils.removeWhitespaces(currentSession.getName());
		File exportPath = new File (session.getExportPath(), name + ".txt");
		File export = exporter.export(currentSession.getItems(), exportPath, config);
		
		//TODO messagebox and start program
//		int style = SWT.ICON_INFORMATION |SWT.OK;
//		String text = "Session " + currentSession.getName() + " was exported to " + export.getAbsolutePath();
//		uihandler.showMessageBox(mother, style, text);
//		
//		uihandler.launchProgram(export);
	}
	
	

}
