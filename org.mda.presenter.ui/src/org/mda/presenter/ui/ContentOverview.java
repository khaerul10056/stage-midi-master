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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.IPresentationView;


public class ContentOverview extends ViewPart implements IPresentationView{

  private static final Log LOGGER  = LogFactory.getLogger(ContentOverview.class);

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  private AbstractSessionItem currentItem = null;

  private Collection<ContentOverviewPanel> previewParts = new ArrayList<ContentOverviewPanel>();

  private Composite root;

  @Override
  public void createPartControl (Composite arg0) {
    LOGGER.info("creatPart");
    this.root = arg0;
    root.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_BLUE));
    root.setLayout(new GridLayout(4, false));

    for (IPresentationController controller : presentationContext.getRegisteredControllers()) {
      controller.connect(this);
    }

  }



  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }



  @Override
  public void end () {
    // TODO Auto-generated method stub

  }



  @Override
  public boolean nextSlide () {
    // TODO Auto-generated method stub
    return false;
  }



  @Override
  public boolean previousSlide () {
    // TODO Auto-generated method stub
    return false;
  }



  @Override
  public boolean toItem (AbstractSessionItem item) {

    for (ContentOverviewPanel oldPanel : previewParts)
      oldPanel.dispose();
    previewParts.clear();



    currentItem = item;
    if (item instanceof MidiFile) {
      MidiFile file = (MidiFile) currentItem;
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
    return false;
  }

}
