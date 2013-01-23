package org.mda.export;


import java.io.File;

import mda.Session;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.commons.ui.UIHandler;
import org.mda.export.powerpoint.PptExporter;
import org.mda.inject.InjectService;
import org.mda.presenter.config.IMidiFilePresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;

import com.google.inject.Inject;

public class ExportPptSessionHandler {
	
	@Inject
	private PptExporter exporter;
	
	@Inject
	private UIHandler handler;
	
	@Inject
	private ApplicationSession session;
	
	
	@Execute
	public void execute(Shell mother) {
		InjectService.injectObject(this);
		
		PresentationConfigurator configurator = new PresentationConfigurator(); 
		IMidiFilePresenterConfig config = configurator.configure(null, session.getCurrentModel(), PresentationType.PPT);
		Session currentSession = (Session) session.getModelEvents().getCurrentModelElement(Session.class);
		String name = Utils.removeWhitespaces(currentSession.getName());
		File exportPath = new File (session.getExportPath(), name + ".ppt");
		File export = exporter.export(currentSession.getItems(), exportPath, config);
		
		int style = SWT.ICON_INFORMATION |SWT.OK;
		String text = "Session " + currentSession.getName() + " was exported to " + export.getAbsolutePath();
		handler.showMessageBox(mother, style, text);
		handler.launchProgram(export);
	}
	
	/**
	 * getter
	 * @return uihandler
	 */
	public UIHandler getUiHandler () {
		return handler;
	}

}
