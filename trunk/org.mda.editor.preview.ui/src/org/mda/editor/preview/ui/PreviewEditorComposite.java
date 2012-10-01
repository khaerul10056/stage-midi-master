package org.mda.editor.preview.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import mda.AbstractSessionItem;
import mda.MidiFilePart;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.editor.preview.ui.parts.ButtonPanelPart;
import org.mda.editor.preview.ui.parts.ContentPart;
import org.mda.editor.preview.ui.parts.SlideListPart;

@Creatable
public class PreviewEditorComposite {

  private List <AbstractPart> editorParts = new ArrayList<AbstractPart>();

  @Inject
  private SlideListPart slidelistpanel;

  @Inject
  private ContentPart contentpanel;


  @Inject
  private PreviewPart previewpanel;
  
  @Inject
  private ButtonPanelPart buttonpanel;

  @Inject
  private ApplicationSession applicationsession;

private Composite comp;

public Composite getComp () {
	return comp;
}


public boolean isBuilt () {
	return comp != null;
}
  
  public void build (final Composite composite) {
	comp = new Composite(composite, SWT.NONE);
    comp.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

    comp.setLayout(new GridLayout(3, false));

    buttonpanel.build(this);
    editorParts.add(buttonpanel);
    buttonpanel.getComp().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

    slidelistpanel.build(this);
    editorParts.add(getSlidelistpanel());
    getSlidelistpanel().getComp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 2));

    contentpanel.build(this);
    editorParts.add(contentpanel);
    contentpanel.getComp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

    previewpanel.build(this, 400, 300);
    editorParts.add(getPreviewpanel());
    getPreviewpanel().getComp().setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

    for (AbstractPart nextPart: editorParts) {
      nextPart.setEditorComposite(this);
    }
    
    
  }

	public void redrawSlidelist() {
		for (AbstractPart nextPart : editorParts) {
			nextPart.setMidifile(applicationsession.getCurrentMidifile());
		}

		comp.getShell().getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (!comp.isVisible() && !comp.getParent().getShell().isDisposed())
				comp.getParent().getShell().layout(true, true);
			}

		});

	}


  public ContentPart getContentpanel () {
    return contentpanel;
  }


  public SlideListPart getSlidelistpanel () {
    return slidelistpanel;
  }


  public PreviewPart getPreviewpanel () {
    return previewpanel;
  }
  

  public void setCurrentPart (MidiFilePart part) {
    for (AbstractPart nextPart: editorParts) {
      nextPart.setCurrentPart(part);
    }
  }





}
