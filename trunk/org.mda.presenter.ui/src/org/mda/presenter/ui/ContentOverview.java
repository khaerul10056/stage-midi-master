package org.mda.presenter.ui;

import static org.mda.commons.ui.calculator.CalculatorRegistry.getCalculator;
import java.util.ArrayList;
import java.util.List;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.IPresentationView;


public class ContentOverview extends ViewPart implements IPresentationView{

  private static final Log LOGGER  = LogFactory.getLogger(ContentOverview.class);

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  private List<ContentOverviewPanel> previewParts = new ArrayList<ContentOverviewPanel>();

  private Composite root;

  private AbstractSessionItem currentItem;


  @Override
  public void createPartControl (Composite arg0) {
    LOGGER.info("create Part ContentOverview");
    this.root = arg0;
    root.setLayout(new GridLayout(4, false));
    presentationContext.registerView(this);
  }

  public List <ContentOverviewPanel> getPreviewParts () {
    return previewParts;
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
      for (ContentOverviewPanel oldPanel : previewParts)
        oldPanel.dispose();
      previewParts.clear();

      if (currentItem instanceof MidiFile) {
        MidiFile file = (MidiFile) currentItem;

        Point size = new Point (320, 240);
        MidiFileSlideCalculator calculator = (MidiFileSlideCalculator) getCalculator(MidiFileSlideCalculator.class);
        CalculatorPreCondition calcPreCondition = new CalculatorPreCondition();
        DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
        calculator.setConfig(config);
        calcPreCondition.setCalculationsize(size);
        List<Slide> slides = calculator.calculate(currentItem, calcPreCondition);
        for (Slide slide: slides) {
          final ContentOverviewPanel overviewPanel = new ContentOverviewPanel(root, (MidiFilePart) slide.getModelRef(), slide, config);
          overviewPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
          overviewPanel.setSize(size);
          overviewPanel.redraw();
          overviewPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown (MouseEvent e) {
              ContentOverviewPanel currentPanel = (ContentOverviewPanel) e.widget;
              presentationContext.toPart(currentPanel.getCurrentPart());
              System.out.println ("MouseDown from " + e.widget + "(" + e.widget.getClass() + ")");

            }


          });

          previewParts.add(overviewPanel);
        }
      }

      root.layout(true, true);
      refresh();


    }

    LOGGER.info("refreshSelection called for " + presentationContext.getCurrentSlide().getTextline(0));
    for (ContentOverviewPanel oldPanel : previewParts) {
      oldPanel.setSelected(oldPanel.getCurrentSlide().isSameSlide(presentationContext.getCurrentSlide()));
      LOGGER.info("- set Selected " + oldPanel.isSelected() + "-" + oldPanel.getCurrentSlide().getTextline(0));
    }
    LOGGER.info("after refreshSelection");

  }


}
