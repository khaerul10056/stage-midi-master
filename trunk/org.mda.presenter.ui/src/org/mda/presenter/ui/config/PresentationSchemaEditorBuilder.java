package org.mda.presenter.ui.config;

import java.util.HashMap;

import javax.inject.Inject;

import mda.PresentationScheme;
import mda.User;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.Util;
import org.mda.commons.ui.calculator.configurator.PresentationConfigurator;
import org.mda.commons.ui.calculator.configurator.PresentationType;

public class PresentationSchemaEditorBuilder {
	
	private User user;
	
	private PresentationConfigurator configurator = new PresentationConfigurator();
	
	@Inject
	private BooleanStateBuilder booleanstate;
	
	@Inject
	private ApplicationSession appsession;
	
	private PresentationScheme currentScheme;

	private Combo combo;
	
	private void changeType () {
		int index = combo.getSelectionIndex(); 
		String item = combo.getItem(index);
		PresentationType type = PresentationType.valueOf(item);
		
		if (user != null)
			currentScheme = configurator.findScheme(user.getPresentationschemes(), type);
		else
			currentScheme = configurator.findScheme(appsession.getCurrentModel().getPresentationschemes(), type);
	}

	public Shell build(Shell shell, User user) {
		this.user = user;
		
		Shell editorShell = new Shell (shell);
		
		editorShell.setLayout(new GridLayout(1, false));
		editorShell.setSize(600, 800);
		Util.centreShell(editorShell);
		editorShell.setText("Edit schemas");
		
		combo = new Combo(editorShell, SWT.NONE);
		combo.setLayoutData(getGridData(20));
		combo.setItems(configurator.getPresentationTypes().toArray(new String [configurator.getPresentationTypes().size()]));
		combo.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
						changeType();
				
			}
		});
		combo.select(0);
		
		
		Composite showBackgroundState = booleanstate.build(editorShell, "Show background:");
		showBackgroundState.setLayoutData(getGridData(30));
		
		Composite showBlocktype = booleanstate.build(editorShell, "Show block type:");
		showBlocktype.setLayoutData(getGridData(null));
		
		Composite pagePerPart = booleanstate.build(editorShell, "Page per Part:");
		pagePerPart.setLayoutData(getGridData(null));
		
		Composite newPageRespected = booleanstate.build(editorShell, "Use manual new side marks:");
		newPageRespected.setLayoutData(getGridData(null));
		
		Composite showTitle = booleanstate.build(editorShell, "Show title:");
		showTitle.setLayoutData(getGridData(null));
		
		Composite showCopyright = booleanstate.build(editorShell, "Show copyright:");
		showCopyright.setLayoutData(getGridData(null));
		
		Composite skipEmptySlides = booleanstate.build(editorShell, "Skip empty slides:");
		skipEmptySlides.setLayoutData(getGridData(null));
		
		Composite optimizeLineFilling = booleanstate.build(editorShell, "Optimize line filling:");
		optimizeLineFilling.setLayoutData(getGridData(null));
		
		Composite optimizeEqualParts = booleanstate.build(editorShell, "Optimize equal parts:");
		optimizeEqualParts.setLayoutData(getGridData(null));
		
		Composite optimizeEmptyTokens = booleanstate.build(editorShell, "Optimize empty tokens:");
		optimizeEmptyTokens.setLayoutData(getGridData(null));
		
		/** Integer getBorder();
		  String getType();
		  String getBackgroundColor();
		  String getForegroundColor();**/
		

		
		
		editorShell.open();
		return editorShell;
	}
	
	private GridData getGridData (Integer verticalIndent) {
		GridData data = new GridData(SWT.FILL,  SWT.BEGINNING,  true,  false);
		if (verticalIndent != null)
		  data.verticalIndent = verticalIndent;
		data.horizontalIndent = 10;
		return data;
	}
	
	public boolean isDefaultSchema () {
		return user == null;
	}
	
}
