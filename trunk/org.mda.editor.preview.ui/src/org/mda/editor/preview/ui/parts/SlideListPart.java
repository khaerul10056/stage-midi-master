package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.List;

import mda.MidiFile;
import mda.MidiFilePart;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.mda.editor.preview.ui.AbstractPart;
import org.mda.editor.preview.ui.PreviewEditorComposite;
import org.mda.editor.preview.ui.StepTypeColorInfo;
import org.mda.editor.preview.ui.StepTypeColorer;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

@Creatable
public class SlideListPart extends AbstractPart  {

  private static final Log LOGGER  = LogFactory.getLogger(SlideListPart.class);

  private final List <SlideItemPanel> slideItems = new ArrayList<SlideItemPanel>();

  public Composite build  (PreviewEditorComposite parent) {
	comp = new Composite(parent.getComp(), SWT.NONE);
	comp.setLayout(new GridLayout());
	setEditorComposite(parent);
    return comp;
  }


  private void resetColors () {
    for (SlideItemPanel panel: getSlideItems()) {
      StepTypeColorInfo colorinfo = StepTypeColorer.getColorInfo(panel.getModelPart().getParttype());
      if (panel.getModelPart().equals(getCurrentPart())) {
        panel.setBackground(colorinfo.getSelected());
      }
      else
        panel.setBackground(colorinfo.getNormal());
    }
  }

  public void setCurrentPart (MidiFilePart currentPart) {
    super.setCurrentPart(currentPart);
    resetColors();
  }

  public void setMidifile (final MidiFile file) {
	  if (file == null)
		  return;
	  
    boolean fileChanged = getMidifile() == null || ! file.equals(getMidifile());
    super.setMidifile(file);
    

    //remove old items
    for (SlideItemPanel nextPanel: getSlideItems()) {
      nextPanel.dispose();
    }
    getSlideItems().clear();

    //add new items
    for (MidiFilePart nextPart: file.getParts()) {
      SlideItemPanel nextPanel = new SlideItemPanel(comp);
      nextPanel.setModelPart(nextPart);
      nextPanel.setContent(getEditorComposite());

      GridData data = new GridData();
      data.minimumWidth = 130;
      data.minimumHeight = 50;
      data.horizontalAlignment = GridData.FILL_HORIZONTAL;
      data.grabExcessHorizontalSpace = true;
      nextPanel.setLayoutData(data);
      String excerpt = "";
      if (nextPart.getTextlines().size() > 0 && nextPart.getTextlines().get(0).getChordParts().size() > 0)
         excerpt = nextPart.getTextlines().get(0).getChordParts().get(0).getText();
      LOGGER.info("Add part " + nextPart.getParttype() + "(" + excerpt + ") to partlist");
      getSlideItems().add(nextPanel);
    }

    if (file.getParts().size() > 0 && fileChanged)
      setCurrentPart(file.getParts().get(0));

    resetColors();

    getSlideItems().get(0).select();
    
    comp.layout(false,  true);

    
  }

  public List <SlideItemPanel> getSlideItems () {
    return slideItems;
  }

  public int getSelectedSlideItemIndex () {
    for (int i = 0; i < getSlideItems().size(); i++) {
      SlideItemPanel nextPanel = getSlideItems().get(i);
      if (nextPanel.isSelected())
        return i;
    }

    return -1;
  }


}
