package org.mda.editor.preview.ui.parts;

import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.mda.editor.preview.ui.PreviewEditorContent;


public class SlideItemPanel extends Composite  {

  private MidiFilePart part;

  private PreviewEditorContent content;

  private Button btnName;


  public SlideItemPanel (Composite parent) {
    super(parent, SWT.NONE);
    setLayout(new FillLayout(SWT.VERTICAL));
    setBtnName(new Button(parent, SWT.NONE));

    getBtnName().addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        showPartOnContentScreen();
      }
    });
  }
  
  public void showPartOnContentScreen () {
    content.getController().showPart(part);
  }

  public void setModelPart (final MidiFilePart part) {
    this.part = part;
    getBtnName().setText(part.getParttype().toString());

  }

  public void setContent (PreviewEditorContent content) {
    this.content = content;
  }

  public PreviewEditorContent getContent () {
    return content;
  }

  private void setBtnName (Button btnName) {
    this.btnName = btnName;
  }

  public Button getBtnName () {
    return btnName;
  }



}
