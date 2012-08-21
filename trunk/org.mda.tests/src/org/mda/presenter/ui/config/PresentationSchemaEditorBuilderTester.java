package org.mda.presenter.ui.config;

import java.io.File;

import mda.MidiPlayerRoot;

import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.tests.StandaloneInjector;

public class PresentationSchemaEditorBuilderTester {
	
	/** @param args */
	  public static void main (String[] args) throws Exception {
		
	    ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class);
	    session.load(null);
	    Shell shell = new Shell();
	    final MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
	    PresentationSchemaEditorBuilder additionalshell = StandaloneInjector.getInstance(PresentationSchemaEditorBuilder.class);
	    Shell configShell = additionalshell.build(shell, null);

	    while (!configShell.isDisposed()) {
	      if (!shell.getDisplay().readAndDispatch()) {
	        shell.getDisplay().sleep();
	      }
	    }

	  }

}
