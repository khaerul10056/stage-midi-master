package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
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
import org.mda.Utils;
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

      Label chordLabel = new Label(this, SWT.NONE);
      chordLabel.setText(getCurrentSlide().getChordline(i));
      chordLabel.setFont(font);
      chordLabel.setEnabled(false);
      getChordLines().add(chordLabel);

      StyledText nextText = new StyledText(this, SWT.SINGLE);
      nextText.setText(getCurrentSlide().getTextline(i));
      nextText.setFont(font);
      nextText.addExtendedModifyListener(new ExtendedModifyListener() {

        @Override
        public void modifyText (ExtendedModifyEvent arg0) {
          Label lblChordLine = getChordLines().get(getFocusedTextFieldIndex());
          String newChordLine = lblChordLine.getText();
          if (arg0.replacedText != null && arg0.replacedText.length() > 0) { //adapt chordline
            newChordLine = Utils.removeString(newChordLine, arg0.start, arg0.replacedText.length());
          }

          StringBuilder builder = new StringBuilder(newChordLine);
          for (int i = 0; i < arg0.length; i++) {
            builder.insert(arg0.start, ' ');
          }

          lblChordLine.setText(builder.toString());

          StyledText txtTextLine = getTextLines().get(getFocusedTextFieldIndex());
          System.out.println (lblChordLine.getText() + "\n" + txtTextLine.getText());
        }
      });
      nextText.addKeyListener(new KeyAdapter() {

        public void keyReleased (KeyEvent e) {
        }

        @Override
        public void keyPressed (KeyEvent e) {
          if (e.keyCode == SWT.ARROW_DOWN)
            stepToNextLine();
          else if (e.keyCode == SWT.ARROW_UP)
            stepToPreviousLine();
          else if (e.keyCode == SWT.CR) {
            e.doit = false;
            splitLine();
          }
          else if (e.keyCode == SWT.ALT) {
            e.doit = false;
            StyledText focused = getTextLines().get(getFocusedTextFieldIndex());
            ChordHover hover = new ChordHover(focused);
          }
          else if (e.character == SWT.BS) {
            e.doit = false;
            mergeLine();
          }
          else {
            saveToModel ();
            showPart(getCurrentPart(), size);
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

  public MidiFilePart saveToModel () {
    currentPart.getTextlines().clear();
    for (int i = 0; i < getTextLines().size(); i++) {
      MidiFileTextLine newTextLine = MidiPlayerService.mf.createMidiFileTextLine();
      currentPart.getTextlines().add(newTextLine);

      String chord = getChordLines().get(i).getText();
      String text = getTextLines().get(i).getText();

      if (chord.trim().length() == 0) { //without chords
        MidiFileChordPart newChordPart = MidiPlayerService.mf.createMidiFileChordPart();
        newChordPart.setText(text);
        newTextLine.getChordParts().add(newChordPart);
      }
      else {
        List <Integer> positions = new ArrayList<Integer>();
        boolean inChord = false;
        for (int linepos = 0; linepos < chord.length(); linepos++) { //Find chordpositions
          if (!inChord && !Character.isWhitespace(chord.charAt(linepos))) {
              positions.add(new Integer(linepos));
              inChord = true;
          }

          if (Character.isWhitespace(chord.charAt(linepos)))
            inChord = false;
        }

        positions.add(Math.max(chord.length(), text.length()));

        for (int linepos = 0; linepos < positions.size() - 1; linepos ++) {
          MidiFileChordPart newChordPart = MidiPlayerService.mf.createMidiFileChordPart();
          int from = positions.get(linepos);
          int toChord = Math.min(positions.get(linepos + 1), chord.length());
          String chordPart = chord.substring(from, toChord);
          newChordPart.setChord(Utils.trimRight(chordPart));

          if (from < text.length()) {
            int toText = Math.min(positions.get(linepos + 1), text.length());
            String textPart = text.substring(from, toText);
            newChordPart.setText(Utils.trimRight(textPart));
          }
          newTextLine.getChordParts().add(newChordPart);
        }
      }
    }

    System.out.println (MidiPlayerService.toString(currentPart));

    return currentPart;
  }

  public int getFocusedTextFieldIndex () {
    for (int i = 0; i < textLines.size(); i++) {
      if (textLines.get(i).isFocusControl())
        return i;
    }

    return -1;
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
    if (getFocusedTextFieldIndex() > 0 && getCaretOffsetOfCurrentTextField() == 0) {
      int currentLine = getFocusedTextFieldIndex() - 1;
      int nextpos = getTextLines().get(currentLine).getText().length();

      setCurrentPart(MidiPlayerService.mergeLine(getCurrentPart(), getFocusedTextFieldIndex(), getCaretOffsetOfCurrentTextField()));
      showPart(getCurrentPart(), getSize());
      StyledText previousTextLine = getTextLines().get(currentLine);
      previousTextLine.setCaretOffset(nextpos);
      previousTextLine.setFocus();
    }
  }



  public List<Label> getChordLines () {
    return chordLines;
  }

  public List<StyledText> getTextLines () {
    return textLines;
  }


  public MidiFilePart getCurrentPart () {
    return currentPart;
  }

  private void setCurrentPart (MidiFilePart currentPart) {
    this.currentPart = currentPart;
  }

}
