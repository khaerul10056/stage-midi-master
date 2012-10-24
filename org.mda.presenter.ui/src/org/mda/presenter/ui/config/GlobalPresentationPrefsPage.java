package org.mda.presenter.ui.config;

import javax.inject.Inject;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class GlobalPresentationPrefsPage extends PreferencePage implements IWorkbenchPreferencePage  {
	
	@Inject
	private PresentationSchemaEditorBuilder editorBuilder;

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Control createContents(Composite parent) {
		editorBuilder.build(parent, null);
		return null;
	}

	@Override
	public boolean performOk() {
		if (editorBuilder == null)
			return true ;
		editorBuilder.save(null);
		return true;
	}
	
	

}
