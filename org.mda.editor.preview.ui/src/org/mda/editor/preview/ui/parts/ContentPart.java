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
import org.eclipse.swt.widgets.Widget;
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

public class ContentPart extends AbstractPart implements IPreviewEditorView, FocusListener {

  private static final Log                   LOGGER            = LogFactory.getLogger(ContentPart.class);

  private DefaultMidiFileContentEditorConfig config            = new DefaultMidiFileContentEditorConfig(); //TODO inject

  private CalculatorPreCondition             calcPreConditions = new CalculatorPreCondition();            //TODO inject

  private final List<TextLine>             textLines         = new ArrayList<TextLine>();

  private final List<Label>                  chordLines        = new ArrayList<Label>();

  private final List<Label>                  newSlideLabels = new ArrayList<Label>();

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
    setCurrentFocusedLine(0);
    setCurrentCaretPosition(0); //initialize position again

  }

  /**
   * disposes all widget in a list and removes them from list afterwards
   * @param widgets list of widgets
   */
  private void clearWidgetList (final Collection <? extends Widget> widgets) {
    for (Widget next: widgets)
      next.dispose();
    widgets.clear();
  }

  /** This method should only be called in the repaint-method to adapt size.
   * In any other cases please call setCurrentPart() which calls showPart()
   * @param part part to repaint
   * @param size size
   * @return size */
  private Point showPart (final MidiFilePart part, final Point size) {


    int currentLine = getCurrentFocusedLine();
    int currentcarePosition = getCaretOffsetOfCurrentTextField();

    LOGGER.info("Show part (position " + currentLine + "/" + currentcarePosition);

    calcPreConditions.setCalculationsize(size);
    config.setNewPageRespected(false);

    calculator.setConfig(config);
    setCalculatePart(calculator.calculatePart(getCurrentPart(), calcPreConditions).get(0));

    //Dispose and clear old textwidgets and chordwidgets
    clearWidgetList(getTextLines());
    clearWidgetList(getChordLines());
    clearWidgetList(newSlideLabels);

    //Initialize lines from saved part
    for (int i = 0; i < getCurrentSlide().getLineCount(); i++) {
      Collection<SlideItem> items = getCurrentSlide().getItems(i);
      if (items.isEmpty())
        continue;

      if (getCurrentSlide().isNewLineForced(i))
        newSlideLabels.add(new Label(this, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL));

      addChordLine(getCurrentSlide().getChordline(i));
      addTextLine(getCurrentSlide().isNewLineForced(i), getCurrentSlide().getTextline(i), size);
    }

    //If no line is available, then default one
    if (getTextLines().size() == 0 && getChordLines().size() == 0) {
      addChordLine("");
      addTextLine(false, " ", size);
    }


    layout();

    //focus last focused position
    if (currentLine >= 0 && currentLine < getTextLines().size()) {
      LOGGER.info("Focus first line");
      setFocus(getTextLines().get(currentLine));
      if (currentcarePosition >= 0)
        setCurrentCaretPositionInLine(currentcarePosition, currentLine);
    }
    return calcPreConditions.getCalculationsize();
  }

  public void saveCurrentCaretSituation () {
    int before = currentCaretPosition;
    this.currentCaretPosition = getTextLines().get(getCurrentFocusedLine()).getCaretOffset();
    LOGGER.info("save current caret from " + before + " to " + currentCaretPosition);
  }

  public void doModifyText (final String replacedText, final int start, final int length) {
    Label lblChordLine = getChordLines().get(getCurrentFocusedLine());
    TextLine txtTextLine = getTextLines().get(getCurrentFocusedLine());

    LOGGER.info("PreModifyText:\n<" + lblChordLine.getText() + ">\n<" + txtTextLine.getText() + ">" + logCaretBehaviour());
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

    LOGGER.info("PostModifyText:\n<" + lblChordLine.getText() + ">\n<" + txtTextLine.getText() + ">"  + logCaretBehaviour());
  }

  /**
   * returns if the line indexed by the parameter is empty or not
   * @param pos index to check
   * @return is empty?
   */
  public boolean isLineEmpty (final int pos) {

    if (pos >= getChordLines().size())
      return false;

    if (pos >= getTextLines().size())
      return false;

    if (! getChordLines().get(pos).getText().trim().isEmpty())
        return false;

    if (! getTextLines().get(pos).getText().trim().isEmpty())
      return false;

    return true;

  }


  private void addTextLine (final boolean newSlide, final String text, final Point size) {
    TextLine nextText = new TextLine(newSlide, this, SWT.SINGLE);

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
        LOGGER.info("KeyReleased : " + Util.logEvent(e) + logCaretBehaviour());

        if (e.keyCode == SWT.ARROW_LEFT &&
          (e.stateMask & SWT.SHIFT) != 0) {
          LOGGER.info("- Move chord to left");
          chordToLeft();
          saveToModel();
          showPart(getCurrentPart(), size);
        }

        if ((e.keyCode == SWT.DEL && (e.stateMask & SWT.SHIFT) != 0 ) ||
            (e.keyCode == SWT.DEL && isLineEmpty(getCurrentFocusedLine()))) {
          e.doit = false;
          LOGGER.info("KeyReleased : - Remove complete line");
          MidiPlayerService.removeLine(getCurrentPart(), getCurrentFocusedLine());
          showPart(getCurrentPart(), size);
        }

        if (e.keyCode == SWT.ARROW_RIGHT &&
          (e.stateMask & SWT.SHIFT) != 0) {
          LOGGER.info("KeyReleased : - Move chord to right");
          chordToRight();
          saveToModel();
          showPart(getCurrentPart(), size);
        }

        LOGGER.info("KeyReleased end : " + logCaretBehaviour());

      }


      @Override
      public void keyPressed (KeyEvent e) {

        try {

          LOGGER.info("KeyPressed : " + Util.logEvent(e) + logCaretBehaviour());
          if (e.character == SWT.BS) {
            e.doit = false;
            LOGGER.info("KeyPressed : - Backspace, Merging lines" + logCaretBehaviour());
            mergeLine();
          }

          saveCurrentCaretSituation(); //has to be saved after backspace is handled

          if (e.keyCode == SWT.ARROW_DOWN) {
            LOGGER.info("KeyPressed : - Arrow down, stepping to next line");
            stepToNextLine();
          }
          else if (e.keyCode == SWT.ARROW_UP) {
            LOGGER.info("KeyPressed : - Arrow up, stepping to previous line");
            stepToPreviousLine();
          }

          else if (e.keyCode == SWT.CR) {
            e.doit = false;
            LOGGER.info("KeyPressed : - CR, splitting line");
            splitLine();
          }
          else if (e.keyCode == SWT.CTRL) {
            e.doit = false;
            TextLine focused = getTextLines().get(getCurrentFocusedLine());
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



          saveToModel();
          showPart(getCurrentPart(), size);

          editorContent.getPreviewpanel().setCurrentPart(getCurrentPart());

          LOGGER.info("KeyPressed end : " + logCaretBehaviour());
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

  public boolean editChord (final Label chordline, final TextLine textline, final int offset, final String newCharacter, String before) {
    StringBuilder builder = new StringBuilder(chordline.getText());
    if (before.length() > 0) {
      for (int i = offset; i < (offset + before.length()); i++)
        builder.setCharAt(i, ' ');
    }

    int maxlen = offset + newCharacter.length();

    //if chordline is too short than fill up with whitespaces to replace with the new chord
    int fillUp = maxlen - builder.length();
    if (fillUp > 0) {
      for (int i = 0; i < fillUp; i++)
        builder.append(" ");
    }

    builder.replace(offset, maxlen, newCharacter);
    setCurrentCaretPosition(getCaretOffsetOfCurrentTextField() + 1);
    chordline.setText(builder.toString());

    return true;
  }

  public String logCaretBehaviour () {
    return " (Caret at " + getCurrentFocusedLine() + "/" + getCurrentCaretPosition() + ")";
  }



  public MidiFilePart saveToModel () {
    getCurrentPart().getTextlines().clear();
    for (int i = 0; i < getTextLines().size(); i++) {
      MidiFileTextLine newTextLine = MidiPlayerService.mf.createMidiFileTextLine();
      getCurrentPart().getTextlines().add(newTextLine);

      String chord = Utils.trimRight(getChordLines().get(i).getText());
      String text = getTextLines().get(i).getText();
      newTextLine.setNewSlide(getTextLines().get(i).isNewSlide());

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

  public TextLine getFocusedTextField () {
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

  public void setFocus (final TextLine currenttext) {
    LOGGER.info("set Focus to <" + currenttext.getText() + ">");
    currenttext.setFocus();
    currentFocusedLine = textLines.indexOf(currenttext);
  }

  @Override
  public boolean stepToNextLine () {
    int currentLine = getCurrentFocusedLine();
    if (currentLine == getTextLines().size() - 1)
      return false;

    int currentCaretPosition = getTextLines().get(currentLine).getCaretOffset();
    TextLine newTextLine = getTextLines().get(++currentLine);
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
    TextLine newTextLine = getTextLines().get(--currentLine);
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
    TextLine newTextLine = getTextLines().get(currentLine);
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
      TextLine previousTextLine = getTextLines().get(currentLine);
      setFocus(previousTextLine);
      setCurrentCaretPosition(nextpos);

    }
  }

  @Override
  public void splitPart () {
    LOGGER.info("Split part " +
      getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = getCurrentFocusedLine() - 1;
    getEditorContent().setCurrentPart(MidiPlayerService.splitPart(getMidifile(), getCurrentPart(), getCurrentFocusedLine()));
    TextLine newTextLine = getTextLines().get(currentLine);
    setFocus(newTextLine);
    getEditorContent().redrawSlidelist();
  }

  @Override
  public void mergeWithPreviousPart () {
    LOGGER.info("Merge with previous part " +
      getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = 0;
    getEditorContent().setCurrentPart(MidiPlayerService.mergeWithPreviousPart(getMidifile(), getCurrentPart()));
    TextLine newTextLine = getTextLines().get(currentLine);
    setFocus(newTextLine);
    getEditorContent().redrawSlidelist();

  }

  public List<Label> getChordLines () {
    return chordLines;
  }

  public List<TextLine> getTextLines () {
    return textLines;
  }

//  @Override
//  public void caretMoved (CaretEvent arg0) {
//    LOGGER.info("Caret moved thrown at position " + arg0.caretOffset + "-" + logCaretBehaviour());
//    setCurrentCaretPosition(arg0.caretOffset);
//  }

  public int getCurrentCaretPosition () {
    return currentCaretPosition;
  }

  public void setCurrentCaretPosition (int currentCaretPosition) {
    setCurrentCaretPositionInLine(currentCaretPosition, currentFocusedLine);
  }

  /**
   * sets in the focusedline the currentCaretposition
   * <b>Attention: doesn't set the current focused line</b>
   * @param newCaretPosition
   * @param focusedLine
   */
  public void setCurrentCaretPositionInLine (int newCaretPosition, int focusedLine) {
    LOGGER.info("set current caret at position " + newCaretPosition + " in line " + focusedLine);
    getTextLines().get(focusedLine).setCaretOffset(newCaretPosition);
    this.currentCaretPosition = newCaretPosition;
  }

  @Override
  public void focusGained (FocusEvent arg0) {
    for (int i = 0; i < getTextLines().size(); i++)
      if (arg0.getSource() == getTextLines().get(i))
        currentFocusedLine = i;
    LOGGER.info("Focused gained in new line: " + currentFocusedLine);
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
