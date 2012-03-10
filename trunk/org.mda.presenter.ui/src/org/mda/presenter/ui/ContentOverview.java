package org.mda.presenter.ui;

import java.util.ArrayList;
import java.util.Collection;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.part.ViewPart;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.IPresentationView;
import org.mda.presenter.ui.slide.PresentationToControllerConnector;


public class ContentOverview extends ViewPart implements IPresentationView{

  private static final Log LOGGER  = LogFactory.getLogger(ContentOverview.class);

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  private Collection<ContentOverviewPanel> previewParts = new ArrayList<ContentOverviewPanel>();

  private Composite root;

  private AbstractSessionItem currentItem;


  @Override
  public void createPartControl (Composite arg0) {
    LOGGER.info("creatPart");
    this.root = arg0;
    root.setLayout(new GridLayout(4, false));
    if (getSite() != null) {
      IPartService partservice = (IPartService) getSite().getService(IPartService.class);
      partservice.addPartListener(new PresentationToControllerConnector(this));
    }
  }





  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }



  @Override
  public void end () {
    dispose();
  }

  @Override
  public void refresh () {

    if (currentItem == null || ! currentItem.equals(presentationContext.getCurrentSessionItem())) {
      currentItem = presentationContext.getCurrentSessionItem();
      toItem(currentItem);
    }

    LOGGER.info("refreshSelection called");
    for (ContentOverviewPanel oldPanel : previewParts) {
      oldPanel.setSelected(oldPanel.getCurrentPart().equals(presentationContext.getCurrentSlide().getModelRef()));
    }

  }



  @Override
  public boolean toItem (AbstractSessionItem item) {

    for (ContentOverviewPanel oldPanel : previewParts)
      oldPanel.dispose();
    previewParts.clear();

    if (item instanceof MidiFile) {
      MidiFile file = (MidiFile) item;
      for (MidiFilePart nextPart: file.getParts()) {
        LOGGER.info("Create overviewpanel for part " + MidiPlayerService.toString(nextPart));
        ContentOverviewPanel overviewPanel = new ContentOverviewPanel(root, nextPart);

        overviewPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
        overviewPanel.setSize(320, 240);
        overviewPanel.redraw();
        previewParts.add(overviewPanel);
      }
    }

    root.layout(true, true);
    refresh();

    return false;
  }

}
