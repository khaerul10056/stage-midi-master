package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class SlideListPart extends AbstractPart  {

  private static final Log LOGGER  = LogFactory.getLogger(SlideListPart.class);

  private final List <SlideItemPanel> slideItems = new ArrayList<SlideItemPanel>();


  public SlideListPart (Composite parent) {
    super(parent);
    setLayout(new FillLayout(SWT.VERTICAL));

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
      String excerpt = "";
      if (nextPart.getTextlines().size() > 0 && nextPart.getTextlines().get(0).getChordParts().size() > 0)
         excerpt = nextPart.getTextlines().get(0).getChordParts().get(0).getText();
      LOGGER.info("Add part " + nextPart.getParttype() + "(" + excerpt + ") to partlist");

      getSlideItems().add(nextPanel);
    }

  }

  public List <SlideItemPanel> getSlideItems () {
    return slideItems;
  }


}
