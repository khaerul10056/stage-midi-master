package org.mda.editor.preview.ui.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.mda.editor.preview.ui.PreviewEditorContent;


public class ButtonPanelPart extends AbstractPart implements SelectionListener {

  private PreviewEditorContent previewEditor;

  private Button btnSplit;

  private Button btnMerge;


  public ButtonPanelPart (PreviewEditorContent parent) {
    super(parent);
    this.previewEditor = parent;

    setLayout(new FillLayout(SWT.HORIZONTAL));

    addButton("Edit theme", SWT.NONE, null);
    addButton("Infos", SWT.NONE, null);
    btnSplit = addButton("Split", SWT.NONE, "Splits this part at current line");
    btnMerge = addButton("Merge", SWT.NONE, "Merges this part with previous part");
  }

  public Button addButton (final String text, int style, final String tooltip) {
    Button button = new Button (this, style);
    button.setText(text);
    if (tooltip != null)
      button.setToolTipText(tooltip);
    button.addSelectionListener(this);
    return button;
  }

  @Override
  public void widgetDefaultSelected (SelectionEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void widgetSelected (SelectionEvent arg0) {
    if (arg0.widget.equals(btnMerge))
      previewEditor.getContentpanel().mergeWithPreviousPart();

    if (arg0.widget.equals(btnSplit))
      previewEditor.getContentpanel().splitPart();

  }
}
