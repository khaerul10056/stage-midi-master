package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;


public class SlideListPart extends AbstractPart  {
  

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

      getSlideItems().add(nextPanel);
    }
  }

  public List <SlideItemPanel> getSlideItems () {
    return slideItems;
  }

  
}
