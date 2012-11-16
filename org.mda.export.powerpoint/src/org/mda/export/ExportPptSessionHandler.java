package org.mda.export;


import java.io.File;

import javax.inject.Inject;

import mda.Session;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.UIHandler;
import org.mda.commons.ui.calculator.configurator.PresentationConfigurator;
import org.mda.commons.ui.calculator.configurator.PresentationType;
import org.mda.export.powerpoint.PptExporter;

public class ExportPptSessionHandler {
	
	@Inject
	private PptExporter exporter;
	
	@Inject
	UIHandler handler;
	
	
	@Execute
	public void execute(Shell mother, ApplicationSession session) {
		PresentationConfigurator configurator = new PresentationConfigurator(); 
		IMidiFileEditorUIConfig config = configurator.configure(null, session.getCurrentModel(), PresentationType.PPT);
		Session currentSession = (Session) session.getModelEvents().getCurrentModelElement(Session.class);
		String name = Utils.removeWhitespaces(currentSession.getName());
		File exportPath = new File (session.getExportPath(), name + ".ppt");
		File export = exporter.export(currentSession.getItems(), exportPath, config);
		
		int style = SWT.ICON_INFORMATION |SWT.OK;
		String text = "Session " + currentSession.getName() + " was exported to " + export.getAbsolutePath();
		handler.showMessageBox(mother, style, text);
		handler.launchProgram(export);
	}

}