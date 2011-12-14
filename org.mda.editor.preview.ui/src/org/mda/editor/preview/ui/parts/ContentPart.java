package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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

public class ContentPart extends AbstractPart implements IPreviewEditorView, CaretListener, FocusListener {

  private MidiFilePart                       currentPart;

  private DefaultMidiFileContentEditorConfig config            = new DefaultMidiFileContentEditorConfig(); //TODO inject

  private CalculatorPreCondition             calcPreConditions = new CalculatorPreCondition();            //TODO inject

  private final List<StyledText>             textLines         = new ArrayList<StyledText>();

  private final List<Label>                  chordLines        = new ArrayList<Label>();

  private Slide                              currentSlide;

  private Font                               font;

  private MidiFileSlideCalculator            calculator        = new MidiFileSlideCalculator();

  private int currentCaretPosition;

  private int currentFocusedLine;

  public ContentPart (Composite parent, MidiFile file) {
    super(parent);
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

    int currentLine = getCurrentFocusedLine();
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
      nextText.addCaretListener(this);
      nextText.addFocusListener(this);
      nextText.setText(getCurrentSlide().getTextline(i));
      nextText.setFont(font);
      nextText.addExtendedModifyListener(new ExtendedModifyListener() {

        @Override
        public void modifyText (ExtendedModifyEvent arg0) {
          Label lblChordLine = getChordLines().get(getCurrentFocusedLine());
          String newChordLine = lblChordLine.getText();
          if (arg0.replacedText != null && arg0.replacedText.length() > 0) { //adapt chordline
            newChordLine = Utils.removeString(newChordLine, arg0.start, arg0.replacedText.length());
          }

          StringBuilder builder = new StringBuilder(newChordLine);
          for (int i = 0; i < arg0.length; i++) {
            builder.insert(arg0.start, ' ');
          }

          lblChordLine.setText(builder.toString());
          StyledText txtTextLine = getTextLines().get(getCurrentFocusedLine());
          txtTextLine.getCaret().getBounds();
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
            StyledText focused = getTextLines().get(getCurrentFocusedLine());
            Point caretLocation = focused.getCaret().getLocation();

            Label label = getChordLines().get(getCurrentFocusedLine());

            Point display2 = focused.toDisplay(1,1);
            display2.x += caretLocation.x;
            display2.y += caretLocation.y;

            String chord = Utils.getChordFromPosition(label.getText(), focused.getCaretOffset());

            ChordHover hover = new ChordHover(focused,  display2, chord);
            while (!hover.isDisposed()) {
              // Check for waiting events
              if (!hover.getDisplay().readAndDispatch())
                hover.getDisplay().sleep();
            }

            if (hover.isChanged()) {
               editChord(label, focused, focused.getCaretOffset(), hover.getChord(), hover.getPreviousChord());
               saveToModel();
            }
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
        setFocus(nextText);
      getTextLines().add(nextText);
    }

    layout();

    if (currentLine >= 0 && currentLine < getTextLines().size()) {
      setFocus (getTextLines().get(currentLine));
      if (currentcarePosition >= 0)
        setCurrentCaretPosition(currentcarePosition, currentLine);
    }
    return calcPreConditions.getCalculationsize();
  }

  public boolean editChord (final Label chordline, final StyledText textline, final int offset, final String newCharacter, String before) {
    StringBuilder builder = new StringBuilder(chordline.getText());
    if (before.length() > 0) {
    for (int i = offset; i < (offset + before.length()); i++)
      builder.setCharAt(i, ' ');
    }

    builder.replace(offset, offset + newCharacter.length(), newCharacter);
    chordline.setText(builder.toString());
    return true;
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


  public Label getFocusedChordLine () {
    if (getCurrentFocusedLine() < 0)
      return null;
    return getChordLines().get(getCurrentFocusedLine());

  }

  public StyledText getFocusedTextField () {
    if (getCurrentFocusedLine() < 0)
      return null;

    return getTextLines().get(getCurrentFocusedLine());
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

  public void setFocus (final StyledText currenttext) {
    currenttext.setFocus();
    for (int i = 0; i < textLines.size(); i ++) {
      if (textLines.get(i) == currenttext) {
        currentFocusedLine = i;
        return;
      }
    }
  }

  @Override
  public boolean stepToNextLine () {
    int currentLine = getCurrentFocusedLine();
    if (currentLine == getTextLines().size() - 1)
      return false;

    int currentCaretPosition = getTextLines().get(currentLine).getCaretOffset();
    StyledText newTextLine = getTextLines().get(++currentLine);
    newTextLine.setCaretOffset(currentCaretPosition);
    setFocus(newTextLine);
    return true;
  }

  @Override
  public boolean stepToPreviousLine () {
    int currentLine = getCurrentFocusedLine();
    if (currentLine == 0)
      return false;

    int currentCaretPosition = getTextLines().get(currentLine).getCaretOffset();
    StyledText newTextLine = getTextLines().get(--currentLine);
    newTextLine.setCaretOffset(currentCaretPosition);
    setFocus(newTextLine);
    return true;
  }

  public int getCaretOffsetOfCurrentTextField () {
    if (getCurrentFocusedLine() < 0)
      return -1;
    else
      return getCurrentCaretPosition();
  }

  @Override
  public void splitLine () {
    int currentLine = getCurrentFocusedLine() + 1;
    setCurrentPart(MidiPlayerService.splitLine(getCurrentPart(), getCurrentFocusedLine(), getCaretOffsetOfCurrentTextField()));
    showPart(getCurrentPart(), getSize());
    StyledText newTextLine = getTextLines().get(currentLine);
    setCurrentCaretPosition(0);
    setFocus(newTextLine);
  }

  @Override
  public void mergeLine () {
    if (getCurrentFocusedLine() > 0 && getCaretOffsetOfCurrentTextField() == 0) {
      int currentLine = getCurrentFocusedLine() - 1;
      int nextpos = getTextLines().get(currentLine).getText().length();
      setCurrentPart(MidiPlayerService.mergeLine(getCurrentPart(), getCurrentFocusedLine(), getCaretOffsetOfCurrentTextField()));
      showPart(getCurrentPart(), getSize());
      StyledText previousTextLine = getTextLines().get(currentLine);
      setCurrentCaretPosition(nextpos);
      setFocus(previousTextLine);
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



  @Override
  public void caretMoved (CaretEvent arg0) {
    setCurrentCaretPosition(arg0.caretOffset);
  }



  public int getCurrentCaretPosition () {
    return currentCaretPosition;
  }


  public void setCurrentCaretPosition (int currentCaretPosition) {
    setCurrentCaretPosition(currentCaretPosition, currentFocusedLine);
  }

  public void setCurrentCaretPosition (int currentCaretPosition, int focusedLine) {
    getTextLines().get(focusedLine).setCaretOffset(currentCaretPosition);
    this.currentCaretPosition = currentCaretPosition;
  }



  @Override
  public void focusGained (FocusEvent arg0) {
    for (int i = 0; i < getTextLines().size(); i++)
      if (arg0.getSource() == getTextLines().get(i))
        currentFocusedLine = i;
    System.out.println ("New line: " + currentFocusedLine);
  }



  @Override
  public void focusLost (FocusEvent arg0) {
  }



  public int getCurrentFocusedLine () {
    return currentFocusedLine;
  }



  public void setCurrentFocusedLine (int currentFocusedLine) {
    this.currentFocusedLine = currentFocusedLine;
  }

}
