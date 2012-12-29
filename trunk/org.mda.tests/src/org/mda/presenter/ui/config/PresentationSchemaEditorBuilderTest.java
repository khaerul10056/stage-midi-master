package org.mda.presenter.ui.config;

import mda.MidiPlayerRoot;
import mda.User;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;


public class PresentationSchemaEditorBuilderTest {
	
	@Test
	public void buildWithoutUser () {
		InjectServiceMock.initialize();
		ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
	    session.load(null);
	    
	    Shell shell = new Shell();
	    PresentationSchemaEditorBuilder builder = InjectService.getInstance(PresentationSchemaEditorBuilder.class); 
		Composite buildershellWithoutUser = builder.build(shell, null);
		//Assert.assertEquals ("Edit schemas", buildershellWithoutUser.getText());
		
		
	}
	
	@Test
	public void buildWithUser () {
		InjectServiceMock.initialize();
		ApplicationSession session = InjectService.getInstance(ApplicationSession.class);
	    session.load(null);
	    MidiPlayerRoot model = session.getCurrentModel();
	    User currentUser = model.getUsers().get(0);
	    
	    Shell shell = new Shell();
	    PresentationSchemaEditorBuilder builder = InjectService.getInstance(PresentationSchemaEditorBuilder.class); 
		Composite buildershellWithoutUser = builder.build(shell, currentUser);
		//Assert.assertEquals ("Edit schemas", buildershellWithoutUser.getText());
		
		
	}

}
