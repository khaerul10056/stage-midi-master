package org.mda.presenter.ui.config;

import mda.MidiPlayerRoot;
import mda.User;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.tests.StandaloneInjector;

public class PresentationSchemaEditorBuilderTest {
	
	@Test
	public void buildWithoutUser () {
		ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class);
	    session.load(null);
	    MidiPlayerRoot model = session.getCurrentModel();
	    
	    Shell shell = new Shell();
	    PresentationSchemaEditorBuilder builder = StandaloneInjector.getInstance(PresentationSchemaEditorBuilder.class); 
		Composite buildershellWithoutUser = builder.build(shell, null);
		//Assert.assertEquals ("Edit schemas", buildershellWithoutUser.getText());
		
		
	}
	
	@Test
	public void buildWithUser () {
		ApplicationSession session = StandaloneInjector.getInstance(ApplicationSession.class);
	    session.load(null);
	    MidiPlayerRoot model = session.getCurrentModel();
	    User currentUser = model.getUsers().get(0);
	    
	    Shell shell = new Shell();
	    PresentationSchemaEditorBuilder builder = StandaloneInjector.getInstance(PresentationSchemaEditorBuilder.class); 
		Composite buildershellWithoutUser = builder.build(shell, currentUser);
		//Assert.assertEquals ("Edit schemas", buildershellWithoutUser.getText());
		
		
	}

}
