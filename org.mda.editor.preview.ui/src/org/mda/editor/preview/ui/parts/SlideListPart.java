package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class SlideListPart extends AbstractPart  {

  private static final Log LOGGER  = LogFactory.getLogger(SlideListPart.class);

  private final List <SlideItemPanel> slideItems = new ArrayList<SlideItemPanel>();

  private Color defaultColor;


  public SlideListPart (Composite parent) {
    super(parent);

    setLayout(new GridLayout(1, true));
  }


  private void resetColors () {
    for (SlideItemPanel panel: getSlideItems()) {
      if (panel.getModelPart().equals(getCurrentPart())) {
        panel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
      }
      else
        panel.setBackground(defaultColor);
    }
    setBackground(defaultColor);
  }

  public void setCurrentPart (MidiFilePart currentPart) {
    super.setCurrentPart(currentPart);
    resetColors();
  }

  public void setMidifile (final MidiFile file) {
    super.setMidifile(file);

    //remove old items
    for (SlideItemPanel nextPanel: getSlideItems()) {
      nextPanel.dispose();
    }
    getSlideItems().clear();

    //add new items
    for (MidiFilePart nextPart: file.getParts()) {
      SlideItemPanel nextPanel = new SlideItemPanel(this);
      nextPanel.setModelPart(nextPart);
      nextPanel.setContent(getEditorContent());
      GridData data = new GridData();
      data.widthHint = 130;
      data.heightHint = 40;
      data.horizontalAlignment = GridData.HORIZONTAL_ALIGN_FILL;
      data.grabExcessHorizontalSpace = true;
      nextPanel.setLayoutData(data);
      String excerpt = "";
      if (nextPart.getTextlines().size() > 0 && nextPart.getTextlines().get(0).getChordParts().size() > 0)
         excerpt = nextPart.getTextlines().get(0).getChordParts().get(0).getText();
      LOGGER.info("Add part " + nextPart.getParttype() + "(" + excerpt + ") to partlist");
      defaultColor = nextPanel.getBtnName().getBackground();


      getSlideItems().add(nextPanel);
    }

    if (file.getParts().size() > 0)
      setCurrentPart(file.getParts().get(0));

    resetColors();

    for (SlideItemPanel panel: getSlideItems()) {
      panel.getShell().layout();
    }
    getShell().layout();




    Display.getCurrent().update();

  }

  public List <SlideItemPanel> getSlideItems () {
    return slideItems;
  }


}
