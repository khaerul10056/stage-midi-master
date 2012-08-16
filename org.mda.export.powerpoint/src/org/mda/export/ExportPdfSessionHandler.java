package org.mda.export;

import java.io.File;

import javax.inject.Inject;

import mda.Session;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.export.pdf.PdfExporter;
import org.mda.export.powerpoint.PptExporter;

public class ExportPdfSessionHandler {
	
	@Inject
	private PdfExporter exporter;
	
	
	@Execute
	public void execute(Shell mother, ApplicationSession session) {
		DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
		Session currentSession = (Session) session.getModelEvents().getCurrentModelElement(Session.class);
		String name = Utils.removeWhitespaces(currentSession.getName());
		File exportPath = new File (session.getExportPath(), name + ".pdf");
		File export = exporter.export(currentSession.getItems(), exportPath, config);
		
		
		
		int style = SWT.ICON_INFORMATION |SWT.OK;
	    MessageBox messageBox = new MessageBox(mother, style);
	    messageBox.setMessage("Session " + currentSession.getName() + " was exported to " + export.getAbsolutePath());
	    messageBox.open();

	}

}
