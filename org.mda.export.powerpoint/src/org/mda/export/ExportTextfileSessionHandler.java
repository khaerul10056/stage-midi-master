package org.mda.export;

import java.io.File;

import mda.Session;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.UIHandler;
import org.mda.commons.ui.calculator.configurator.PresentationConfigurator;
import org.mda.commons.ui.calculator.configurator.PresentationType;
import org.mda.export.pdf.PdfExporter;
import org.mda.export.textfile.TextfileExporter;
import org.mda.inject.InjectService;

import com.google.inject.Inject;

public class ExportTextfileSessionHandler {
	
	@Inject
	private TextfileExporter exporter;
	
	@Inject
	private UIHandler uihandler;
	
	@Inject
	private ApplicationSession session;
	
	
	@Execute
	public void execute(Shell mother) {
		InjectService.injectObject(this);

		//TODO make a new PresentationType
		PresentationConfigurator configurator = new PresentationConfigurator(); 
		DefaultMidiFileContentEditorConfig config = (DefaultMidiFileContentEditorConfig) configurator.configure(null, session.getCurrentModel(), PresentationType.PDF);
		config.setShowTitle(true); 
		config.setShowChords(false);
		Session currentSession = (Session) session.getModelEvents().getCurrentModelElement(Session.class);
		String name = Utils.removeWhitespaces(currentSession.getName());
		File exportPath = new File (session.getExportPath(), name + ".txt");
		File export = exporter.export(currentSession.getItems(), exportPath, config);
		
		int style = SWT.ICON_INFORMATION |SWT.OK;
		String text = "Session " + currentSession.getName() + " was exported to " + export.getAbsolutePath();
		uihandler.showMessageBox(mother, style, text);
		
		uihandler.launchProgram(export);
	}
	
	/**
	 * getter
	 * @return uihandler
	 */
	public UIHandler getUiHandler () {
		return uihandler;
	}

}
