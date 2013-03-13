package org.mda.export;


import java.io.File;

import mda.Session;

import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.export.powerpoint.PptExporter;
import org.mda.presenter.config.IPresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;

import com.google.inject.Inject;

public class ExportPptSessionHandler {
	
	@Inject
	private PptExporter exporter;
	
	
	
	@Inject
	private ApplicationSession session;
	
	
	public void execute() {
		
		PresentationConfigurator configurator = new PresentationConfigurator(); 
		IPresenterConfig config = configurator.configure(null, session.getCurrentModel(), PresentationType.PPT);
		Session currentSession = (Session) session.getModelEvents().getCurrentModelElement(Session.class);
		String name = Utils.removeWhitespaces(currentSession.getName());
		File exportPath = new File (session.getExportPath(), name + ".ppt");
		File export = exporter.export(currentSession.getItems(), exportPath, config);
		
		//TODO Open the exported file and make messagebox
//		int style = SWT.ICON_INFORMATION |SWT.OK;
//		String text = "Session " + currentSession.getName() + " was exported to " + export.getAbsolutePath();
//		handler.showMessageBox(mother, style, text);
//		handler.launchProgram(export);
	}
	
	

}
