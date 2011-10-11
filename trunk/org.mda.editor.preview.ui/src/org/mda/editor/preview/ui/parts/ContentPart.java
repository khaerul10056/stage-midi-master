package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.mda.IPresentationView;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.CalculatorPreCondition;
import org.mda.presenter.ui.MidiFileSlideCalculator;
import org.mda.presenter.ui.slide.Slide;
import org.mda.presenter.ui.slide.SlideItem;


public class ContentPart extends AbstractPart implements IPresentationView {

  private MidiFile file;

  private MidiFilePart currentPart;

  private CalculatorPreCondition calcPreConditions = new CalculatorPreCondition ();

  private List <Text> textLines = new ArrayList<Text>();


  private Slide currentSlide;

  public ContentPart (Composite parent, MidiFile file) {
    super(parent);
    this.file = file;
    currentPart = file.getParts().get(0);
    setLayout(new RowLayout(SWT.VERTICAL));
    //setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));

    getShell().addControlListener(new ControlAdapter() {
      /**
       * Sent when the size (width, height) of a control changes.
       * The default behavior is to do nothing.
       *
       * @param e an event containing information about the resize
       */
      public void controlResized(ControlEvent e) {
        Rectangle rect = getShell().getClientArea();
        Point size = new Point (rect.width, rect.height);
        if (size.x > 0 && size.y > 0)
          size = showPart(currentPart,size);
        setSize(size);
      }
    });

  }


  public Point showPart (final MidiFilePart part, final Point size) {
    this.currentPart = part;

    calcPreConditions.setCalculationsize(size);

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(new DefaultMidiFileContentEditorConfig());
    setCalculatePart(calculator.calculatePart(currentPart, calcPreConditions));

    for (Text nextOldLine: textLines) {
      nextOldLine.dispose();
    }
    textLines.clear();

    for (int i = 0; i < getCurrentSlide().getLineCount(); i++) {
      Collection<SlideItem> items = getCurrentSlide().getItems(i);
      if (items.isEmpty())
        continue; 
      
      SlideItem next = items.iterator().next();
      Text nextText = new Text(this, SWT.NONE);
      nextText.setFont(next.getFont());
      nextText.setText(getCurrentSlide().getText(i));
      textLines.add(nextText);
    }



    layout();

    return calcPreConditions.getCalculationsize();



  }



  @Override
  public void end () {
    dispose();
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
  public void showSlide (MidiFilePart part) {
    showPart(part, getSize());
  }


  private void setCalculatePart (Slide calculatePart) {
    this.currentSlide = calculatePart;
  }


  public Slide getCurrentSlide () {
    return currentSlide;
  }

}
