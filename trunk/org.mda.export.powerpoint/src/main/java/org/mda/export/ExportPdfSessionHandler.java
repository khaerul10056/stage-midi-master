package org.mda.export;

import java.io.File;

import mda.Session;

import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.export.pdf.PdfExporter;
import org.mda.presenter.config.IPresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;

import com.google.inject.Inject;

public class ExportPdfSessionHandler {
	
	@Inject
	private PdfExporter exporter;
	
	
	
	@Inject
	private ApplicationSession session;
	
	
	public void execute() {
		
		
		PresentationConfigurator configurator = new PresentationConfigurator(); 
		IPresenterConfig config = configurator.configure(null, session.getCurrentModel(), PresentationType.PDF);
		
		Session currentSession = (Session) session.getModelEvents().getCurrentModelElement(Session.class);
		String name = Utils.removeWhitespaces(currentSession.getName());
		File exportPath = new File (session.getExportPath(), name + ".pdf");
		File export = exporter.export(currentSession.getItems(), exportPath, config);
		
//		int style = SWT.ICON_INFORMATION |SWT.OK;
//		String text = "Session " + currentSession.getName() + " was exported to " + export.getAbsolutePath();
//		uihandler.showMessageBox(mother, style, text);
//		
//		uihandler.launchProgram(export);
	}
	
	

}
