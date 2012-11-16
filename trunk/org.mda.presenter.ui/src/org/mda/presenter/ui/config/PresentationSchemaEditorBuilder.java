package org.mda.presenter.ui.config;

import java.util.Collection;
import java.util.HashMap;

import javax.inject.Inject;

import mda.PresentationScheme;
import mda.User;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.mda.ApplicationSession;
import org.mda.commons.ui.calculator.configurator.PresentationConfigurator;
import org.mda.commons.ui.calculator.configurator.PresentationType;


public class PresentationSchemaEditorBuilder {
	
	private User user;
	
	private PresentationConfigurator configurator = new PresentationConfigurator();
	
	
	@Inject
	private ApplicationSession appsession;
	
	private PresentationScheme currentScheme;
	
	private Collection <PresentationScheme> parentSchemes;
	
	private HashMap<String, IDefaultableWidget> comps = new HashMap<String, IDefaultableWidget>();

	private Combo combo;
	
	private void changeType () {
		int index = combo.getSelectionIndex(); 
		String item = combo.getItem(index);
		PresentationType type = PresentationType.valueOf(item);
		
		if (user != null)
			currentScheme = configurator.findSchemeByType(user.getPresentationschemes(), type);
		else
			currentScheme = configurator.findSchemeByType(appsession.getCurrentModel().getPresentationschemes(), type);
		
		if (currentScheme == null) {
			currentScheme = configurator.createScheme(user, appsession.getCurrentModel(), type);
		}
		
		parentSchemes = configurator.getParents(user, appsession.getCurrentModel(), currentScheme);
		
	}
	
	public Composite build(Composite shell, final User user) {
		this.user = user;
		
		Composite editorShell = new Composite(shell, SWT.NONE);
		
		editorShell.setLayout(new GridLayout(1, false));
		
		combo = new Combo(editorShell, SWT.NONE);
		combo.setLayoutData(getGridData(20));
		combo.setItems(configurator.getPresentationTypes().toArray(new String [configurator.getPresentationTypes().size()]));
		
		addBooleanState(editorShell, "Show background:", "showBackground", 30);
		addBooleanState(editorShell, "Show block type:", "showBlockType", null);
		addBooleanState(editorShell, "Page per part:", "pagePerPart", null);
		addBooleanState(editorShell, "Use manual new side marks:", "newPageRespected", null);
		addBooleanState(editorShell, "Show title:", "showTitle", null);
		addBooleanState(editorShell, "Show copyright:", "showCopyright", null);
		addBooleanState(editorShell, "Skip empty slides:", "skipEmptySlides", null);
		addBooleanState(editorShell, "Optimize line filling:", "optimizeLineFilling", null);
		addBooleanState(editorShell, "Optimize equal parts:", "optimizeEqualParts", null);
		addBooleanState(editorShell, "Optimize empty tokens:" , "optimizeEmptyTokens", null);
		
		
		/** Integer getBorder();
		  String getBackgroundColor();
		  String getForegroundColor();**/
		
		
		//must be done AFTER initializing components
		combo.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
						load(user);
			}
		});
		combo.select(0);
		load(user);
		
		
		return editorShell;
	}
	
	public void load (final User user) {
		this.user = user; 
		changeType();
		
		for (IDefaultableWidget widget: comps.values())
			widget.load(currentScheme, parentSchemes);
	}
	
	public void save (final User user) {
		for (IDefaultableWidget widget: comps.values())
			widget.save();
	}
	
	public void addBooleanState (final Composite shell, String label, String id, Integer border) {
		BooleanStateBuilder state = new BooleanStateBuilder(shell, label, id);
		state.getComp().setLayoutData(getGridData(border));
		comps.put(id, state);
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
