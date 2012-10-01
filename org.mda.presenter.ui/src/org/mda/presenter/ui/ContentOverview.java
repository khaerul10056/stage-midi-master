package org.mda.presenter.ui;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePart;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.Util;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.IPresentationView;

@Creatable
public class ContentOverview  implements IPresentationView{

  private static final Log LOGGER  = LogFactory.getLogger(ContentOverview.class);

  @Inject
  private PresentationContext  presentationContext;
  
  @Inject
  private MidiFileSlideCalculator calculator; 

  private List<ContentOverviewPanel> previewParts = new ArrayList<ContentOverviewPanel>();

  private Composite comp;

  private AbstractSessionItem currentItem;


  public Composite build (Composite mother) {
    LOGGER.info("create Part ContentOverview");
    comp = new Composite(mother, SWT.NONE);
    comp.setLayout(new GridLayout(4, false));
    Util.disableEscOnComponent(comp);
    presentationContext.registerView(this);
    return comp;
  }

  public List <ContentOverviewPanel> getPreviewParts () {
    return previewParts;
  }
  
  public Composite getComp () {
	  return comp;
  }



  @Override
  public void end () {
    comp.dispose();
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
        CalculatorPreCondition calcPreCondition = new CalculatorPreCondition();
        DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
        calculator.setConfig(config);
        calcPreCondition.setCalculationsize(size);
        List<Slide> slides = calculator.calculate(currentItem, calcPreCondition);
        for (Slide slide: slides) {
          final ContentOverviewPanel overviewPanel = new ContentOverviewPanel(comp, (MidiFilePart) slide.getModelRef(), slide, config);
          GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
          gd.heightHint = size.y; 
          gd.widthHint = size.x;
          overviewPanel.setSize(size);
          overviewPanel.setLayoutData(gd);
          overviewPanel.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
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

      comp.layout(false, true);


    }

    LOGGER.info("refreshSelection called for " + presentationContext.getCurrentSlide().getTextline(0));
    for (ContentOverviewPanel oldPanel : previewParts) {
      oldPanel.setSelected(oldPanel.getCurrentSlide().isSameSlide(presentationContext.getCurrentSlide()));
      LOGGER.info("- set Selected " + oldPanel.isSelected() + "-" + oldPanel.getCurrentSlide().getTextline(0));
    }
    LOGGER.info("after refreshSelection");

  }


}
