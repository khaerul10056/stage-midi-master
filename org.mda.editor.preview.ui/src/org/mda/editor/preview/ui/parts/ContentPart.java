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
import org.eclipse.swt.widgets.Label;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IPreviewEditorView;
import org.mda.commons.ui.Util;
import org.mda.commons.ui.calculator.CalculatorPreCondition;
import org.mda.commons.ui.calculator.MidiFileSlideCalculator;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.editor.preview.ui.AbstractPart;
import org.mda.editor.preview.ui.PreviewEditorContent;
import org.mda.editor.preview.ui.chords.ChordHover;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class ContentPart extends AbstractPart implements IPreviewEditorView, CaretListener, FocusListener {

  private static final Log                   LOGGER            = LogFactory.getLogger(ContentPart.class);

  private DefaultMidiFileContentEditorConfig config            = new DefaultMidiFileContentEditorConfig(); //TODO inject

  private CalculatorPreCondition             calcPreConditions = new CalculatorPreCondition();            //TODO inject

  private final List<StyledText>             textLines         = new ArrayList<StyledText>();

  private final List<Label>                  chordLines        = new ArrayList<Label>();

  private Slide                              currentSlide;

  private Font                               font;

  private MidiFileSlideCalculator            calculator        = new MidiFileSlideCalculator();

  private int                                currentCaretPosition;

  private int                                currentFocusedLine;

  private PreviewEditorContent               editorContent;

  public static boolean listenersActive = true;


  public ContentPart (PreviewEditorContent parent, MidiFile file) {
    super(parent);
    editorContent = parent;



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

  public void setCurrentPart (MidiFilePart currentPart) {
    super.setCurrentPart(currentPart);
    showPart(currentPart, getSize());
  }

  /** This method should only be called in the repaint-method to adapt size.
   * In any other cases please call setCurrentPart() which calls showPart()
   * @param part part to repaint
   * @param size size
   * @return size */
  private Point showPart (final MidiFilePart part, final Point size) {

    int currentLine = getCurrentFocusedLine();
    int currentcarePosition = getCaretOffsetOfCurrentTextField();

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

    //Initialize lines from saved part
    for (int i = 0; i < getCurrentSlide().getLineCount(); i++) {
      Collection<SlideItem> items = getCurrentSlide().getItems(i);
      if (items.isEmpty())
        continue;

      addChordLine(getCurrentSlide().getChordline(i));
      addTextLine(getCurrentSlide().getTextline(i), size);
    }

    //If no line is available, then default one

    if (getTextLines().size() == 0 && getChordLines().size() == 0) {
      addChordLine("");
      addTextLine(" ", size);
    }


    layout();

    //focus first line
    if (currentLine >= 0 && currentLine < getTextLines().size()) {
      setFocus(getTextLines().get(currentLine));
      if (currentcarePosition >= 0)
        setCurrentCaretPosition(currentcarePosition, currentLine);
    }
    return calcPreConditions.getCalculationsize();
  }

  public void doModifyText (final String replacedText, final int start, final int length) {
    Label lblChordLine = getChordLines().get(getCurrentFocusedLine());
    StyledText txtTextLine = getTextLines().get(getCurrentFocusedLine());

    LOGGER.info("PreModifyText:\n<" + lblChordLine.getText() + ">\n<" + txtTextLine.getText() + ">");
    LOGGER.info("ReplacedText : <" + replacedText + ">");
    LOGGER.info("Modified     : <" + start + "-" + length);

    String newChordLine = lblChordLine.getText();
    if (replacedText != null && replacedText.length() > 0) { //adapt chordline
      newChordLine = Utils.removeString(newChordLine, start, replacedText.length());
    }

    StringBuilder builder = new StringBuilder(newChordLine);

    for (int i = 0; i < length; i++) {
      builder.insert(Math.min(start, builder.length()), ' ');
    }

    lblChordLine.setText(builder.toString());

    LOGGER.info("PostModifyText:\n<" + lblChordLine.getText() + ">\n<" + txtTextLine.getText() + ">");
  }

  private void addTextLine (final String text, final Point size) {
    StyledText nextText = new StyledText(this, SWT.SINGLE);
    nextText.addCaretListener(this);
    nextText.addFocusListener(this);
    nextText.setText(text);
    nextText.setFont(font);
    if (listenersActive) {
    nextText.addExtendedModifyListener(new ExtendedModifyListener() {

      @Override
      public void modifyText (ExtendedModifyEvent arg0) {
        doModifyText(arg0.replacedText, arg0.start, arg0.length);
      }
    });

    nextText.addKeyListener(new KeyAdapter() {

      @Override
      public void keyReleased (KeyEvent e) {
        LOGGER.info("KeyReleased : " +
          Util.logEvent(e));
        if (e.keyCode == SWT.ARROW_LEFT &&
          (e.stateMask & SWT.SHIFT) != 0) {
          chordToLeft();
        }

        if (e.keyCode == SWT.ARROW_RIGHT &&
          (e.stateMask & SWT.SHIFT) != 0) {
          chordToRight();
        }
      }

      @Override
      public void keyPressed (KeyEvent e) {
        try {

          LOGGER.info("KeyPressed : " +
            Util.logEvent(e));

          if (e.keyCode == SWT.ARROW_DOWN)
            stepToNextLine();
          else if (e.keyCode == SWT.ARROW_UP)
            stepToPreviousLine();
          else if (e.keyCode == SWT.CR) {
            e.doit = false;
            splitLine();
          }
          else if (e.keyCode == SWT.CTRL) {
            e.doit = false;
            StyledText focused = getTextLines().get(getCurrentFocusedLine());
            Point caretLocation = focused.getCaret().getLocation();

            Label label = getChordLines().get(getCurrentFocusedLine());

            Point display2 = focused.toDisplay(1, 1);
            display2.x += caretLocation.x;
            display2.y += caretLocation.y;

            String chord = Utils.getChordFromPosition(label.getText(), focused.getCaretOffset());

            ChordHover hover = new ChordHover(focused, display2, chord);
            while (!hover.isDisposed()) {
              // Check for waiting events
              if (!hover.getDisplay().readAndDispatch())
                hover.getDisplay().sleep();
            }

            if (hover.isChanged()) {
              editChord(label, focused, focused.getCaretOffset(), hover.getChord(), hover.getPreviousChord());
            }
          }
          else if (e.character == SWT.BS) {
            e.doit = false;
            mergeLine();
          }

          saveToModel();
          showPart(getCurrentPart(), size);

          editorContent.getPreviewpanel().setCurrentPart(getCurrentPart());

          LOGGER.info("doit was set to " + e.doit);

        }
        catch (Exception exception) {
          LOGGER.error(exception.toString(), exception);
        }

      }

    });

    }
    if (getTextLines().isEmpty())
      setFocus(nextText);
    getTextLines().add(nextText);

  }

  private void addChordLine (final String chord) {
    Label chordLabel = new Label(this, SWT.NONE);
    chordLabel.setText(chord);
    chordLabel.setFont(font);
    chordLabel.setEnabled(false);
    getChordLines().add(chordLabel);

  }

  public boolean editChord (final Label chordline, final StyledText textline, final int offset, final String newCharacter, String before) {
    StringBuilder builder = new StringBuilder(chordline.getText());
    if (before.length() > 0) {
      for (int i = offset; i < (offset + before.length()); i++)
        builder.setCharAt(i, ' ');
    }

    builder.replace(offset, offset + newCharacter.length(), newCharacter);
    setCurrentCaretPosition(getCaretOffsetOfCurrentTextField() + 1);
    chordline.setText(builder.toString());

    return true;
  }



  public MidiFilePart saveToModel () {
    getCurrentPart().getTextlines().clear();
    for (int i = 0; i < getTextLines().size(); i++) {
      MidiFileTextLine newTextLine = MidiPlayerService.mf.createMidiFileTextLine();
      getCurrentPart().getTextlines().add(newTextLine);

      String chord = Utils.trimRight(getChordLines().get(i).getText());
      String text = getTextLines().get(i).getText();

      // if test is longer than chord then try to trim text
      int chordLongerAsText = chord.length() - text.length();
      if (chordLongerAsText < 0)
        text = Utils.trimRight(text);

      //if chord is longer than text, than fill text again
      chordLongerAsText = chord.length() - text.length();
      if (chordLongerAsText > 0) {
        text = text + Utils.createEmptyString(chordLongerAsText);
      }


      if (chord.trim().length() == 0) { //without chords
        MidiFileChordPart newChordPart = MidiPlayerService.mf.createMidiFileChordPart();
        newChordPart.setText(text);
        newTextLine.getChordParts().add(newChordPart);
      }
      else {
        List<Integer> positions = new ArrayList<Integer>();
        boolean inChord = false;
        for (int linepos = 0; linepos < chord.length(); linepos++) { //Find chordpositions
          if (!inChord &&
            !Character.isWhitespace(chord.charAt(linepos))) {
            positions.add(new Integer(linepos));
            inChord = true;
          }

          if (Character.isWhitespace(chord.charAt(linepos)))
            inChord = false;
        }

        positions.add(Math.max(chord.length(), text.length()));

        for (int linepos = 0; linepos < positions.size(); linepos++) {
          MidiFileChordPart newChordPart = MidiPlayerService.mf.createMidiFileChordPart();
          int from = linepos == 0 ? 0 : positions.get(linepos - 1);
          int toChord = Math.min(positions.get(linepos), chord.length());
          String chordPart = chord.substring(from, toChord);
          String textPart = "";
          LOGGER.info("get token from " +
            from + " to " + toChord + ": " + chordPart);
          newChordPart.setChord(chordPart.trim());

          if (from < text.length()) {
            int toText = Math.min(positions.get(linepos), text.length());
            textPart = text.substring(from, toText);
            newChordPart.setText(textPart);
          }

          if (textPart.trim().length() > 0 ||
            chordPart.trim().length() > 0)
            newTextLine.getChordParts().add(newChordPart);
        }
      }
    }

    LOGGER.info("Save to model: <" +
      MidiPlayerService.toString(getCurrentPart()) + ">");

    return getCurrentPart();
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
    for (int i = 0; i < textLines.size(); i++) {
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
    LOGGER.info("Split line " +
      getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = getCurrentFocusedLine() + 1;
    setCurrentPart(MidiPlayerService.splitLine(getCurrentPart(), getCurrentFocusedLine(), getCaretOffsetOfCurrentTextField()));
    StyledText newTextLine = getTextLines().get(currentLine);
    setCurrentCaretPosition(0);
    setFocus(newTextLine);
  }

  @Override
  public void mergeLine () {
    if (getCurrentFocusedLine() > 0 &&
      getCaretOffsetOfCurrentTextField() == 0) {
      LOGGER.info("Merge line " +
        getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
      int currentLine = getCurrentFocusedLine() - 1;
      int nextpos = getTextLines().get(currentLine).getText().length();
      getEditorContent().setCurrentPart(MidiPlayerService.mergeLine(getCurrentPart(), getCurrentFocusedLine(), getCaretOffsetOfCurrentTextField()));
      StyledText previousTextLine = getTextLines().get(currentLine);
      setCurrentCaretPosition(nextpos);
      setFocus(previousTextLine);
    }
  }

  @Override
  public void splitPart () {
    LOGGER.info("Split part " +
      getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = getCurrentFocusedLine() - 1;
    getEditorContent().setCurrentPart(MidiPlayerService.splitPart(getMidifile(), getCurrentPart(), getCurrentFocusedLine()));
    StyledText newTextLine = getTextLines().get(currentLine);
    setFocus(newTextLine);
    getEditorContent().redrawSlidelist();
  }

  @Override
  public void mergeWithPreviousPart () {
    LOGGER.info("Merge with previous part " +
      getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = 0;
    getEditorContent().setCurrentPart(MidiPlayerService.mergeWithPreviousPart(getMidifile(), getCurrentPart()));
    StyledText newTextLine = getTextLines().get(currentLine);
    setFocus(newTextLine);
    getEditorContent().redrawSlidelist();

  }

  public List<Label> getChordLines () {
    return chordLines;
  }

  public List<StyledText> getTextLines () {
    return textLines;
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
    LOGGER.info("Focused gained in new line: " +
      currentFocusedLine);
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

  @Override
  public boolean chordToLeft () {
    Label label = getChordLines().get(getCurrentFocusedLine());
    String chord = label.getText();
    if (Character.isWhitespace(chord.charAt(getCurrentCaretPosition()))) {
      StringBuilder builder = new StringBuilder(chord);
      builder.deleteCharAt(getCurrentCaretPosition());
      label.setText(builder.toString());
      return true;
    }
    else
      return false;
  }

  @Override
  public boolean chordToRight () {
    Label label = getChordLines().get(getCurrentFocusedLine());

    String chord = label.getText();
    StringBuilder builder = new StringBuilder(chord);
    builder.insert(getCurrentCaretPosition() - 1, " ");

    label.setText(builder.toString());

    return true;
  }

}