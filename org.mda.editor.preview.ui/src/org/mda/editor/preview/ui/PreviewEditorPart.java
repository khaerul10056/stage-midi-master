package org.mda.editor.preview.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import mda.MidiFile;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.mda.ApplicationSession;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.MidiFileEditorInput;
import org.mda.listeners.IModelElementReloadListener;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

@Creatable
public class PreviewEditorPart {

	private static final Log LOGGER = LogFactory.getLogger(PreviewEditorPart.class);

	private MidiFileEditorInput meei;

	private LabelProvider provider = new LabelProvider();

	@Inject
	private ApplicationSession appSession;
	
	@Inject
	private PreviewEditorComposite previewEditorContent;

	@Inject
	private MDirtyable dirtyable;
	
	
	@PostConstruct
	public void postConstruct (final Composite composite) {
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
				dirtyable.setDirty(false);
			}
			
			@Override
			public Class<? extends Object> isRelevant() {
				return MidiFile.class;
			}
		});
	}

	

	// @Override
	// public void doSave (IProgressMonitor monitor) {
	// LOGGER.info("doSave()");
	// previewEditorContent.getContentpanel().saveToModel();
	// appSession.saveModel();
	// }
	//
	// @Override
	// public void doSaveAs () {
	// LOGGER.info("doSaveAs()");
	// previewEditorContent.getContentpanel().saveToModel();
	// }
	//
	// @Override
	// public void init (IEditorSite site, IEditorInput input) throws
	// PartInitException {
	// setSite(site);
	// setInput(input);
	//
	// meei = (MidiFileEditorInput) input;
	// //setContentDescription(meei.getName());
	// setPartName(meei.getName());
	// setTitleImage(provider.getImage(meei.getEObject()));
	// }
	//
	// @Override
	// public boolean isDirty () {
	// return meei.isDirty();
	// }

	// @Override
	// public boolean isSaveAsAllowed () {
	// return false;
	// }
	//
	// @Override
	// public void createPartControl (Composite parent) {
	//
	//
	// }
	//
	// @Override
	// public void setFocus () {
	// // TODO Auto-generated method stub
	//
	// }

}
