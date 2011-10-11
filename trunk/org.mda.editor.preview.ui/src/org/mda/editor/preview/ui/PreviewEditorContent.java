package org.mda.editor.preview.ui;

import java.util.ArrayList;
import java.util.List;
import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.mda.editor.preview.ui.parts.AbstractPart;
import org.mda.editor.preview.ui.parts.ButtonPanelPart;
import org.mda.editor.preview.ui.parts.ContentPart;
import org.mda.editor.preview.ui.parts.SlideListPart;
import org.mda.presenter.ui.ImplementationController;


public class PreviewEditorContent extends Composite  {

  private final ImplementationController controller = new ImplementationController();


  private List <AbstractPart> editorParts = new ArrayList<AbstractPart>();


  private final ContentPart contentpanel;

  public PreviewEditorContent (final Composite composite, final MidiFile file) {
    super(composite, SWT.NONE);
    setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_BLACK));

    setLayout(new GridLayout(2, false));

    ButtonPanelPart buttonpanel = new ButtonPanelPart(this);
    editorParts.add(buttonpanel);
    buttonpanel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

    SlideListPart slidelistpanel = new SlideListPart(this);
    editorParts.add(slidelistpanel);
    slidelistpanel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true));

    contentpanel = new ContentPart(this, file);
    editorParts.add(getContentpanel());
    getContentpanel().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    getController().connect(getContentpanel());

    for (AbstractPart nextPart: editorParts) {
      nextPart.setEditorContent(this);
    }

    reconnectSong(file);
  }


  private void reconnectSong (final MidiFile file) {
    for (AbstractPart nextPart: editorParts) {
      nextPart.setMidifile(file);
    }
  }

  public ImplementationController getController () {
    return controller;
  }


  public ContentPart getContentpanel () {
    return contentpanel;
  }



}
