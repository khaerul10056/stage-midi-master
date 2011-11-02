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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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

  private MidiFileSlideCalculator            calculator        = new MidiFileSlideCalculator();

  public ContentPart (Composite parent, MidiFile file) {
    super(parent);
    this.file = file;
    setCurrentPart(file.getParts().get(0));
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
          size = showPart(getCurrentPart(), size);
        setSize(size);
      }
    });
  }

  private int getLayoutFactor () {
    return config.isChordVisible() ? 2 : 1;
  }

  private Point showPart (final MidiFilePart part, final Point size) {

    int currentLine = getFocusedTextFieldIndex();
    int currentcarePosition = getCaretOffsetOfCurrentTextField();

    this.setCurrentPart(part);

    calcPreConditions.setCalculationsize(size);

    calculator.setConfig(config);
    setCalculatePart(calculator.calculatePart(getCurrentPart(), calcPreConditions));

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

        public void keyReleased (KeyEvent e) {
          System.out.println ("");

        }

        @Override
        public void keyPressed (KeyEvent e) {
          if (e.keyCode == SWT.DEL) {
            e.doit = false;
            deleteCharacter();
          }
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
            StyledText focused = getTextLines().get(getFocusedTextFieldIndex());
            ChordHover hover = new ChordHover(focused);
          }


          if (e.character == SWT.BS) {
            e.doit = false;
            mergeLine();
          }

          else if (isShowableCharacter(e.character)) {
            e.doit = false;
            System.out.println("Character: <" +
              e.character + ">");
            input(e.character);
          }

        }

      });
      if (getTextLines().isEmpty())
        nextText.setFocus();
      getTextLines().add(nextText);
    }

    layout();

    if (currentLine >= 0 && currentLine < getTextLines().size()) {
      getTextLines().get(currentLine).setFocus();
      if (currentcarePosition >= 0)
        getTextLines().get(currentLine).setCaretOffset(currentcarePosition);
    }
    return calcPreConditions.getCalculationsize();
  }

  public int getFocusedTextFieldIndex () {
    for (int i = 0; i < textLines.size(); i++) {
      if (textLines.get(i).isFocusControl())
        return i;
    }

    return -1;
  }

  public boolean isShowableCharacter (final char character) {
    if (character >= 'A' &&
      character <= 'Z')
      return true;
    if (character >= 'a' &&
      character <= 'z')
      return true;
    if (character >= '0' &&
      character <= '9')
      return true;

    return false;

  }

  public Label getFocusedChordLine () {
    if (getFocusedTextFieldIndex() < 0)
      return null;
    return getChordLines().get(getFocusedTextFieldIndex());

  }

  public StyledText getFocusedTextField () {
    if (getFocusedTextFieldIndex() < 0)
      return null;

    return getTextLines().get(getFocusedTextFieldIndex());

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
    int currentLine = getFocusedTextFieldIndex();
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
    int currentLine = getFocusedTextFieldIndex();
    if (currentLine == 0)
      return false;

    int currentCaretPosition = getTextLines().get(currentLine).getCaretOffset();
    StyledText newTextLine = getTextLines().get(--currentLine);
    newTextLine.setCaretOffset(currentCaretPosition);
    newTextLine.setFocus();
    return true;
  }

  public int getCaretOffsetOfCurrentTextField () {
    if (getFocusedTextFieldIndex() < 0)
      return -1;

    return getTextLines().get(getFocusedTextFieldIndex()).getCaretOffset();
  }

  @Override
  public void splitLine () {

    int currentLine = getFocusedTextFieldIndex() + 1;
    setCurrentPart(MidiPlayerService.splitLine(getCurrentPart(), getFocusedTextFieldIndex(), getCaretOffsetOfCurrentTextField()));
    showPart(getCurrentPart(), getSize());
    StyledText newTextLine = getTextLines().get(currentLine);
    newTextLine.setCaretOffset(0);
    newTextLine.setFocus();
  }

  @Override
  public void mergeLine () {
    if (getFocusedTextFieldIndex() > 0) {
      int currentLine = getFocusedTextFieldIndex() - 1;
      int nextpos = getTextLines().get(currentLine).getText().length();

      setCurrentPart(MidiPlayerService.mergeLine(getCurrentPart(), getFocusedTextFieldIndex(), getCaretOffsetOfCurrentTextField()));
      showPart(getCurrentPart(), getSize());
      StyledText previousTextLine = getTextLines().get(currentLine);
      previousTextLine.setCaretOffset(nextpos);
      previousTextLine.setFocus();
    }
  }

  @Override
  public boolean toggleChordline () {
    config.setChordVisible(!config.isChordVisible());
    showPart(getCurrentPart(), getSize());

    return config.isChordVisible();
  }

  public List<Label> getChordLines () {
    return chordLines;
  }

  public List<StyledText> getTextLines () {
    return textLines;
  }

  /** removes the selected part of the current textline */
  public void removeSelected () {
    if (getFocusedTextField().getSelectionText() != null &&
      getFocusedTextField().getSelectionText().trim().length() > 0) {
      int[] selectionRanges = getFocusedTextField().getSelectionRanges();
      setCurrentPart(MidiPlayerService.remove(getCurrentPart(), getCurrentPart().getTextlines().get(getFocusedTextFieldIndex()), selectionRanges));
      getFocusedTextField().setCaretOffset(selectionRanges [0]);
    }

  }

  @Override
  public void input (char newchar) {
    removeSelected();
    currentPart = MidiPlayerService.addCharacter(getCurrentPart(), getFocusedTextFieldIndex(), getCaretOffsetOfCurrentTextField(), newchar);
    showPart(getCurrentPart(), getSize());
  }

  @Override
  public void deleteCharacter () {
    removeSelected();
    showPart(getCurrentPart(), getSize());
  }

  public MidiFilePart getCurrentPart () {
    return currentPart;
  }

  private void setCurrentPart (MidiFilePart currentPart) {
    this.currentPart = currentPart;
  }

}
