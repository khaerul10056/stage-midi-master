package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IPreviewEditorView;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.editor.preview.ui.chords.ChordHover;

public class ContentPart extends AbstractPart implements IPreviewEditorView {

  private MidiFile                           file;

  private MidiFilePart                       currentPart;

  private DefaultMidiFileContentEditorConfig config            = new DefaultMidiFileContentEditorConfig(); //TODO inject

  private CalculatorPreCondition             calcPreConditions = new CalculatorPreCondition();            //TODO inject

  private final List<StyledText>             textLines         = new ArrayList<StyledText>();

  private final List<Label>                  chordLines        = new ArrayList<Label>();

  private Slide                              currentSlide;

  private Font                               font;

  public ContentPart (Composite parent, MidiFile file) {
    super(parent);
    this.file = file;
    currentPart = file.getParts().get(0);
    setLayout(new RowLayout(SWT.VERTICAL));
    //setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));

    getShell().addControlListener(new ControlAdapter() {

      /** Sent when the size (width, height) of a control changes.
       * The default behavior is to do nothing.
       * @param e an event containing information about the resize */
      public void controlResized (ControlEvent e) {
        Rectangle rect = getShell().getClientArea();
        Point size = new Point(rect.width, rect.height);
        if (size.x > 0 &&
          size.y > 0)
          size = showPart(currentPart, size);
        setSize(size);
      }
    });
  }

  private int getLayoutFactor () {
    return config.isChordVisible() ? 2 : 1;
  }

  private Point showPart (final MidiFilePart part, final Point size) {
    this.currentPart = part;

    calcPreConditions.setCalculationsize(size);

    MidiFileSlideCalculator calculator = new MidiFileSlideCalculator();
    calculator.setConfig(config);
    setCalculatePart(calculator.calculatePart(currentPart, calcPreConditions));

    //Dispose and clear old textwidgets and chordwidgets
    for (StyledText nextOldLine : getTextLines())
      nextOldLine.dispose();
    getTextLines().clear();
    for (Label nextOldLine : getChordLines())
      nextOldLine.dispose();
    getChordLines().clear();

    for (int i = 0; i < getCurrentSlide().getLineCount(); i++) {
      Collection<SlideItem> items = getCurrentSlide().getItems(i);
      if (items.isEmpty())
        continue;

      SlideItem next = items.iterator().next();
      if (config.isChordVisible()) {
        Label chordLabel = new Label(this, SWT.NONE);
        chordLabel.setText(getCurrentSlide().getChordline(i));
        chordLabel.setFont(font);
        chordLabel.setEnabled(false);
        getChordLines().add(chordLabel);
      }

      StyledText nextText = new StyledText(this, SWT.SINGLE);
      nextText.setText(getCurrentSlide().getTextline(i));
      nextText.setFont(font);
      nextText.addKeyListener(new KeyAdapter() {

        @Override
        public void keyPressed (KeyEvent e) {
          if (e.keyCode == SWT.ARROW_DOWN)
            stepToNextLine();
          if (e.keyCode == SWT.ARROW_UP)
            stepToPreviousLine();
          if (e.keyCode == SWT.CR) {
            e.doit = false;
            splitLine();

          }
          if (e.keyCode == SWT.ALT) {
            e.doit = false;
            StyledText focused = getTextLines().get(getFocusedTextField());
            ChordHover hover = new ChordHover(focused);

          }
        }

      });
      if (getTextLines().isEmpty())
        nextText.setFocus();
      getTextLines().add(nextText);
    }

    layout();

    getFocusedTextField();

    return calcPreConditions.getCalculationsize();
  }

  public int getFocusedTextField () {
    for (int i = 0; i < textLines.size(); i++) {
      if (textLines.get(i).isFocusControl())
        return i;
    }

    return -1;
  }

  @Override
  public void showSlide (MidiFilePart part) {
    showPart(part, getSize());
  }

  private void setCalculatePart (Slide calculatePart) {
    this.currentSlide = calculatePart;
    FontData fontdata = new FontData("Monospace", 12, SWT.NONE);
    this.font = new Font(getDisplay(), fontdata);
  }

  public Slide getCurrentSlide () {
    return currentSlide;
  }

  @Override
  public boolean stepToNextLine () {
    int currentLine = getFocusedTextField();
    if (currentLine == getTextLines().size() - 1)
      return false;

    int currentCaretPosition = getTextLines().get(currentLine).getCaretOffset();
    StyledText newTextLine = getTextLines().get(++currentLine);
    newTextLine.setCaretOffset(currentCaretPosition);
    newTextLine.setFocus();
    return true;
  }

  @Override
  public boolean stepToPreviousLine () {
    int currentLine = getFocusedTextField();
    if (currentLine == 0)
      return false;

    int currentCaretPosition = getTextLines().get(currentLine).getCaretOffset();
    StyledText newTextLine = getTextLines().get(--currentLine);
    newTextLine.setCaretOffset(currentCaretPosition);
    newTextLine.setFocus();
    return true;
  }

  @Override
  public void splitLine () {
    int currentLine = getFocusedTextField();
    currentPart = MidiPlayerService.splitLine(currentPart, currentLine, getTextLines().get(currentLine).getCaretOffset());
    showPart(currentPart, getSize());
  }

  @Override
  public void mergeLine () {

  }

  @Override
  public boolean toggleChordline () {
    config.setChordVisible(!config.isChordVisible());
    showPart(currentPart, getSize());

    return config.isChordVisible();
  }

  public List<Label> getChordLines () {
    return chordLines;
  }

  public List<StyledText> getTextLines () {
    return textLines;
  }

}
