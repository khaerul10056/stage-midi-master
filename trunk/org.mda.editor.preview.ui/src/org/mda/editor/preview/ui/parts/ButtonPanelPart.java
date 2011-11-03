package org.mda.editor.preview.ui.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class ButtonPanelPart extends AbstractPart implements SelectionListener {



  public ButtonPanelPart (Composite parent) {
    super(parent);

    setLayout(new FillLayout(SWT.HORIZONTAL));

    addButton("Edit theme", SWT.NONE);
    addButton("Infos", SWT.NONE);
  }

  public Button addButton (final String text, int style) {
    Button button = new Button (this, style);
    button.setText(text);
    return button;
  }

  @Override
  public void widgetDefaultSelected (SelectionEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void widgetSelected (SelectionEvent arg0) {

  }
}
