package org.mda.editor.preview.ui.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class ButtonPanelPart extends AbstractPart {

  public ButtonPanelPart (Composite parent) {
    super(parent);

    setLayout(new FillLayout(SWT.HORIZONTAL));
    addButton("Show chords");
    addButton("Edit theme");
    addButton("Infos");
  }

  public void addButton (final String text) {
    Button button = new Button (this, SWT.NONE);
    button.setText(text);
  }
}
