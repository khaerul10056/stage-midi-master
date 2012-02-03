package org.mda.editor.preview.ui;

import java.util.ArrayList;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.mda.editor.preview.ui.parts.AbstractPart;
import org.mda.editor.preview.ui.parts.ButtonPanelPart;
import org.mda.editor.preview.ui.parts.ContentPart;
import org.mda.editor.preview.ui.parts.PreviewPart;
import org.mda.editor.preview.ui.parts.SlideListPart;


public class PreviewEditorContent extends Composite  {

  private List <AbstractPart> editorParts = new ArrayList<AbstractPart>();


  private final ContentPart contentpanel;

  private final SlideListPart slidelistpanel;

  private PreviewPart previewpanel;

  private MidiFile file;

  public PreviewEditorContent (final Composite composite, final MidiFile file) {
    super(composite, SWT.NONE);
    this.file = file;
    setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_BLACK));

    setLayout(new GridLayout(3, false));

    ButtonPanelPart buttonpanel = new ButtonPanelPart(this);
    editorParts.add(buttonpanel);
    buttonpanel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

    slidelistpanel = new SlideListPart(this);
    editorParts.add(getSlidelistpanel());
    getSlidelistpanel().setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 2));

    contentpanel = new ContentPart(this, file);
    editorParts.add(contentpanel);
    contentpanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

    setPreviewpanel(new PreviewPart(this));
    editorParts.add(getPreviewpanel());
    getPreviewpanel().setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

    for (AbstractPart nextPart: editorParts) {
      nextPart.setEditorContent(this);
    }

    redrawSlidelist();
  }

  public void redrawSlidelist () {
    reconnectSong(file);
  }


  private void reconnectSong (final MidiFile file) {
    for (AbstractPart nextPart: editorParts) {
      nextPart.setMidifile(file);
    }

    getShell().getDisplay().asyncExec(new Runnable() {

      @Override
      public void run () {
        getParent().getShell().layout(true, true);
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


  public void setPreviewpanel (PreviewPart previewpanel) {
    this.previewpanel = previewpanel;
  }

  public void setCurrentPart (MidiFilePart part) {
    for (AbstractPart nextPart: editorParts) {
      nextPart.setCurrentPart(part);
    }
  }



}
