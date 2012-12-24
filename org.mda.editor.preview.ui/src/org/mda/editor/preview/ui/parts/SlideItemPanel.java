package org.mda.editor.preview.ui.parts;

import static org.mda.Utils.ICON_LINK;
import static org.mda.Utils.loadImageFromProject;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.mda.editor.preview.ui.PreviewEditorComposite;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class SlideItemPanel extends Composite  {

  private static final Log LOGGER  = LogFactory.getLogger(SlideItemPanel.class);

  private MidiFilePart part;

  private PreviewEditorComposite editorComposite;

  private Button btnName;


  public SlideItemPanel (Composite parent) {
    super(parent, SWT.NONE);
    GridLayout layout = new GridLayout(1, true);
    layout.verticalSpacing = 0;
    layout.horizontalSpacing = 0;
    layout.marginWidth = 0;
    setLayout(layout);

    setBtnName( new Button(this, SWT.SHADOW_ETCHED_OUT));

    GridData gd = new GridData();
    gd.horizontalAlignment = SWT.FILL;
    gd.grabExcessHorizontalSpace = true;
    gd.heightHint = 46;
    getBtnName().setLayoutData(gd);

    getBtnName().addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        select();
      }
    });
  }

  public boolean isSelected () {
    return btnName.getSelection();

  }



  @Override
  public void setBackground (Color color) {
    if (LOGGER.isDebugEnabled())
      LOGGER.debug("setBackground of part " + part.getParttype() + " to " + color);

    //super.setBackground(color);
    btnName.setBackground(color);

  }



  public void setModelPart (final MidiFilePart part) {
    this.part = part;
    String btnText = part.getParttype().toString(); 
    if (part.getBar() > 0)
    	btnText +="(" + part.getPosition() + ")";
    getBtnName().setText(btnText);
    
    if (part.getRefPart() != null)
      getBtnName().setImage(loadImageFromProject(ICON_LINK));
    else
      getBtnName().setImage(null);
  }

  public MidiFilePart getModelPart () {
    return part;
  }

  public void setContent (PreviewEditorComposite content) {
    this.editorComposite = content;
  }

  public PreviewEditorComposite getContent () {
    return editorComposite;
  }

  private void setBtnName (Button btnName) {
    this.btnName = btnName;
  }

  public Button getBtnName () {
    return btnName;
  }

  public void select () {
    btnName.setFocus();
    getContent().setCurrentPart(part);
  }

  @Override
  public void dispose () {
    btnName.dispose();
    super.dispose();
  }







}
