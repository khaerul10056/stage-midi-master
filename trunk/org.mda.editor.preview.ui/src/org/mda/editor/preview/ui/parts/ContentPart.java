package org.mda.editor.preview.ui.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import mda.SongChordPart;
import mda.SongPart;
import mda.SongTextLine;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
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
import org.eclipse.swt.widgets.Widget;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.commons.ui.Util;
import org.mda.editor.preview.ui.AbstractPart;
import org.mda.editor.preview.ui.PreviewEditorComposite;
import org.mda.editor.preview.ui.chords.ChordHover;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.CalculationParam;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideItem;
import org.mda.presenter.SongSlideCalculator;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.DefaultPresenterConfig;

@Creatable
public class ContentPart extends AbstractPart implements FocusListener {

  private static final Log                   LOGGER            = LogFactory.getLogger(ContentPart.class);

  @com.google.inject.Inject
  private DefaultPresenterConfig config;

  private final List<TextLine>             textLines         = new ArrayList<TextLine>();

  private final List<StyledText>                  chordLines        = new ArrayList<StyledText>();

  private final List<StyledText>                  newSlideStyledTexts = new ArrayList<StyledText>();

  private Slide                              currentSlide;

  private Font                               font;

  @Inject
  private SongSlideCalculator            calculator;

  private int                                currentCaretPosition;

  private int                                currentFocusedLine;
  
  private SizeInfo partSize = new SizeInfo (640, 480);


  public static boolean listenersActive = true;


  public Composite build (PreviewEditorComposite parent) {
	comp = new Composite(parent.getComp(), SWT.NONE);
    setEditorComposite(parent);

    comp.setLayout(new RowLayout(SWT.VERTICAL));
    comp.getShell().addControlListener(new ControlAdapter() {

      /** Sent when the size (width, height) of a control changes.
       * The default behavior is to do nothing.
       * @param e an event containing information about the resize */
      @Override
	public void controlResized (ControlEvent e) {
        Rectangle rect = comp.getShell().getClientArea();
        Point size = new Point(rect.width, rect.height);
        if (size.x > 0 &&
          size.y > 0)
          size = showPart(getCurrentPart(), size);
        comp.setSize(size);
      }
    });

    return comp;
  }

  @Override
public void setCurrentPart (SongPart currentPart) {
    super.setCurrentPart(currentPart);
    showPart(currentPart, comp.getSize());
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
  private Point showPart (final SongPart part, final Point size) {
	  
	  if (part == null)
		  return size; 

    boolean partIsReference = part.getRefPart() != null;

    int currentLine = getCurrentFocusedLine();
    int currentcarePosition = getCaretOffsetOfCurrentTextField();

    LOGGER.info("Show part (position " + currentLine + "/" + currentcarePosition);

    config.setNewPageRespected(false);
    config.setAutoWrapToNewPage(false);
    
    if (size.x >0 && size.y > 0)
    	partSize = new SizeInfo(size.x, size.y); 
    
    CalculationParam param = new CalculationParam(partSize); 
    
    setCalculatePart(calculator.calculatePart(getCurrentPart(), param, config).get(0));

    //Dispose and clear old textwidgets and chordwidgets
    clearWidgetList(getTextLines());
    clearWidgetList(getChordLines());
    clearWidgetList(newSlideStyledTexts);

    //Initialize lines from saved part
    for (int i = 0; i < getCurrentSlide().getLineCount(); i++) {
      Collection<SlideItem> items = getCurrentSlide().getItems(i);
      if (items.isEmpty())
        continue;

      if (getCurrentSlide().isNewLineForced(i))
        newSlideStyledTexts.add(new StyledText(comp, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL));

      addChordLine(getCurrentSlide().getChordline(i), partIsReference);
      addTextLine(getCurrentSlide().isNewLineForced(i), getCurrentSlide().getTextline(i), size, partIsReference);
    }

    //If no line is available, then default one
    if (getTextLines().size() == 0 && getChordLines().size() == 0) {
      addChordLine("", partIsReference);
      addTextLine(false, " ", size, partIsReference);
    }


    comp.layout();

    //focus last focused position
    if (currentLine >= 0 && currentLine < getTextLines().size()) {
      LOGGER.info("Focus first line");
      setFocus(getTextLines().get(currentLine));
      if (currentcarePosition >= 0)
        setCurrentCaretPositionInLine(currentcarePosition, currentLine);
    }
    return new Point ((int)param.getPresentationSize().getWidth(), (int) param.getPresentationSize().getHeight());
  }

  public void saveCurrentCaretSituation () {
    int before = currentCaretPosition;
    this.currentCaretPosition = getTextLines().get(getCurrentFocusedLine()).getCaretOffset();
    LOGGER.info("save current caret from " + before + " to " + currentCaretPosition);
  }

  public void synchronizeChordWhenTextWasModified (final String replacedText, final int start, final int length) {
    StyledText lblChordLine = getChordLines().get(getCurrentFocusedLine());
    TextLine txtTextLine = getTextLines().get(getCurrentFocusedLine());

    LOGGER.info("PreModifyText:\n<" + lblChordLine.getText() + ">\n<" + txtTextLine.getText() + ">" + logCaretBehaviour());
    LOGGER.info("ReplacedText : <" + replacedText + ">");
    LOGGER.info("Modified     : <" + start + "-" + length);

    String newChordLine = lblChordLine.getText();
    if (replacedText != null && replacedText.length() > 0 && newChordLine.length() > start) { //adapt chordline
      int restOfLine = Math.min(replacedText.length(), newChordLine.length() - start);
      newChordLine = Utils.removeString(newChordLine, start, restOfLine);
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


  private void addTextLine (final boolean newSlide, final String text, final Point size, final boolean readonly) {
    TextLine nextText = new TextLine(newSlide, comp, SWT.SINGLE);

    nextText.addFocusListener(this);
    nextText.setText(text);
    if (readonly) {
      nextText.setEditable(false);
      nextText.setEnabled(false);
      nextText.setBackground(comp.getBackground());
    }

    nextText.setFont(font);
    if (listenersActive) {
    nextText.addExtendedModifyListener(new ExtendedModifyListener() {

      @Override
      public void modifyText (ExtendedModifyEvent arg0) {
        synchronizeChordWhenTextWasModified(arg0.replacedText, arg0.start, arg0.length);
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
        	
          if (e.character == SWT.ESC)
        	  e.doit = false;

          LOGGER.info("KeyPressed : " + Util.logEvent(e) + logCaretBehaviour());
          if (e.character == SWT.BS) {
            e.doit = false;
            LOGGER.info("KeyPressed : - Backspace, Merging lines" + logCaretBehaviour());
            mergePreviousLineWithCurrentLine();
          }

          if (e.character == SWT.DEL) {
            e.doit = false;
            LOGGER.info("KeyPressed : - Del at end of line, Merging lines" + logCaretBehaviour());
            mergeCurrentLineWithNextLine();
          }

          saveCurrentCaretSituation(); //has to be saved after backspace is handled

          if (e.keyCode == SWT.END) {
            LOGGER.info("KeyPressed : - End of line");
            e.doit = false;
            stepToEndOfLine();
          }

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
          else if (e.keyCode == SWT.F1) {
            e.doit = false;
            TextLine focused = getTextLines().get(getCurrentFocusedLine());
            Point caretLocation = focused.getCaret().getLocation();

            StyledText label = getChordLines().get(getCurrentFocusedLine());

            Point display2 = focused.toDisplay(1, 1);
            display2.x += caretLocation.x;
            display2.y += caretLocation.y;

            String chord = Utils.getChordFromPosition(label.getText(), focused.getCaretOffset());

            ChordHover hover = new ChordHover(focused.getFont(), focused, display2, chord);
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

          //getEditorComposite().getPreviewpanel().setCurrentPart(getCurrentPart());

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

  private boolean isCaretAtEndOfLine () {
    int realLength = getTextLines().get(getCurrentFocusedLine()).getText().trim().length();
    return getCurrentCaretPosition() >= realLength;
  }

  private void addChordLine (final String chord, final boolean readonly) {
    StyledText chordStyledText = new StyledText(comp, SWT.NONE);
    chordStyledText.setText(chord);
    chordStyledText.setEnabled(false);
    chordStyledText.setFont(font);
    getChordLines().add(chordStyledText);

  }

  public boolean editChord (final StyledText chordline, final TextLine textline, final int offset, final String newCharacter, String before) {
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



  public SongPart saveToModel () {
    getCurrentPart().getTextlines().clear();
    for (int i = 0; i < getTextLines().size(); i++) {
      SongTextLine newTextLine = MidiPlayerService.mf.createSongTextLine();
      getCurrentPart().getTextlines().add(newTextLine);

      String chord = Utils.trimRight(getChordLines().get(i).getText());
      String text = getTextLines().get(i).getSaveableText();
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
        SongChordPart newChordPart = MidiPlayerService.mf.createSongChordPart();
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
          SongChordPart newChordPart = MidiPlayerService.mf.createSongChordPart();
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

  public StyledText getFocusedChordLine () {
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
    FontData fontdata = new FontData("DejaVu Sans Mono", 15, SWT.NONE);
    this.font = new Font(comp.getDisplay(), fontdata);
    
    LOGGER.info("Set font to " + font.getFontData() [0].getName());
    
    
    
  }

  public Slide getCurrentSlide () {
    return currentSlide;
  }

  public void setFocus (final TextLine currenttext) {
    LOGGER.info("set Focus to <" + currenttext.getText() + ">");
    currenttext.setFocus();
    currentFocusedLine = textLines.indexOf(currenttext);
  }

  public void stepToEndOfLine () {
    int currentLine = getCurrentFocusedLine();
    TextLine newTextLine = getTextLines().get(currentLine);
    int newLength = newTextLine.getText().trim().length();
    setCurrentCaretPositionInLine(newLength, currentLine);
  }

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

  public void splitLine () {
    LOGGER.info("Split line " +
      getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = getCurrentFocusedLine() + 1;
    setCurrentPart(MidiPlayerService.splitLine(getCurrentPart(), getCurrentFocusedLine(), getCaretOffsetOfCurrentTextField()));
    TextLine newTextLine = getTextLines().get(currentLine);
    setCurrentCaretPosition(0);
    setFocus(newTextLine);
  }


  /**
   * merges the previous line with the current focused line, if the current line is not the first line
   */
  public void mergePreviousLineWithCurrentLine () {
    if (getCurrentFocusedLine() > 0 && getCaretOffsetOfCurrentTextField() == 0) {
      doMergeLine(getCurrentFocusedLine());
    }

  }

  /**
   * merges the current line with the next line, if it is not the last line
   */
  public void mergeCurrentLineWithNextLine () {
    if (getCurrentFocusedLine() < getTextLines().size() - 1 && isCaretAtEndOfLine())
      doMergeLine(getCurrentFocusedLine() + 1);
  }


  /**
   * merges a line to the previous line
   * @param linenumber  the number of the line, which should be merged to the end of the previous line
   */
  private void doMergeLine (final int linenumber) {
    LOGGER.info("Merge line " + linenumber + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = linenumber - 1;
    int lastposChord = Utils.trimRight(getChordLines().get(currentLine).getText()).length();
    int lasttextChord = Utils.trimRight(getTextLines().get(currentLine).getText()).length();
    int nextpos = Math.max(lastposChord, lasttextChord);
    getEditorComposite().setCurrentPart(MidiPlayerService.mergeLine(getCurrentPart(), linenumber, getCaretOffsetOfCurrentTextField()));
    TextLine previousTextLine = getTextLines().get(currentLine);
    setFocus(previousTextLine);
    setCurrentCaretPosition(nextpos);
  }

  public void splitPart () {
    LOGGER.info("Split part " +
      getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = getCurrentFocusedLine() - 1;
    getEditorComposite().setCurrentPart(MidiPlayerService.splitPart(getMidifile(), getCurrentPart(), getCurrentFocusedLine()));
    TextLine newTextLine = getTextLines().get(currentLine);
    setFocus(newTextLine);
    getEditorComposite().redrawSlidelist();
  }

  public void mergeWithPreviousPart () {
    LOGGER.info("Merge with previous part " +
      getCurrentFocusedLine() + " at caretposition " + getCaretOffsetOfCurrentTextField());
    int currentLine = 0;
    getEditorComposite().setCurrentPart(MidiPlayerService.mergeWithPreviousPart(getMidifile(), getCurrentPart()));
    TextLine newTextLine = getTextLines().get(currentLine);
    setFocus(newTextLine);
    getEditorComposite().redrawSlidelist();

  }

  public List<StyledText> getChordLines () {
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

  public boolean chordToLeft () {
    StyledText label = getChordLines().get(getCurrentFocusedLine());
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

  public boolean chordToRight () {
    StyledText label = getChordLines().get(getCurrentFocusedLine());

    String chord = label.getText();
    StringBuilder builder = new StringBuilder(chord);
    builder.insert(getCurrentCaretPosition() - 1, " ");

    label.setText(builder.toString());

    return true;
  }

}
