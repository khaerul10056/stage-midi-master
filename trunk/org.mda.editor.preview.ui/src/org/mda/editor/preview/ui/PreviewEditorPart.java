package org.mda.editor.preview.ui;

import javax.annotation.PostConstruct;

import mda.MidiFile;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.listeners.IModelElementReloadListener;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

@Creatable
public class PreviewEditorPart {

	private static final Log LOGGER = LogFactory.getLogger(PreviewEditorPart.class);


	private ApplicationSession appSession = InjectService.getInstance(ApplicationSession.class) ;
	
	private PreviewEditorComposite previewEditorContent = InjectService.getInstance(PreviewEditorComposite.class);

	
	
	@PostConstruct
	public void postConstruct (final Composite composite) {
		if (appSession.getFeatureActivation().isStartupSessionConfigured())
			return;
		
		appSession.getModelEvents().addReloadListener(new IModelElementReloadListener() {
			
			@Override
			public void reload(Object newObject, Object oldObject) {
				MidiFile newMidiFile = (MidiFile) newObject;
				
				if (! previewEditorContent.isBuilt()) {
				  previewEditorContent.build(composite);
		  		  composite.setLayout(new GridLayout());
				  previewEditorContent.getComp().setLayoutData(new GridData(SWT.FILL, SWT.FILL,  true, true));
				}
				
				previewEditorContent.redrawSlidelist();
				previewEditorContent.getComp().getParent().getShell().layout(true, true);
			}
			
			@Override
			public Class<? extends Object> isRelevant() {
				return MidiFile.class;
			}
		});
	}

}
