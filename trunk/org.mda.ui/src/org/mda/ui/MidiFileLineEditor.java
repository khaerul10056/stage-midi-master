package org.mda.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import mda.MidiFileChordPart;
import mda.MidiFileTextLine;

import org.mda.Chord;
import org.mda.MidiFileContentEditorConfigIF;
import org.mda.MidiPlayerService;
import org.mda.Utils;

public class MidiFileLineEditor extends JPanel implements MouseListener {

  /**
   *
   */
  private static final long serialVersionUID = 1783814670412212362L;

  private PartContextMenu contextMenu;

  private final JTextField              txtChordEditor = new JTextField();
  private final JTextField              txtTextLine    = new JTextField();

  private MidiFileTextLine              currentLine;

  private final MidiFilePartEditor partEditor;

  private MidiFileContentEditorConfigIF config;

  public MidiFileLineEditor(final MidiFilePartEditor parteditor, MidiFileTextLine midiFileTextLine) {


    contextMenu = new PartContextMenu(this);
    getTxtChordEditor().setEditable(false);
    getTxtTextLine().setEditable(parteditor.getPart().getRefPart() == null);
    this.partEditor = parteditor;
    config = parteditor.getContentEditor().getConfig();
    setLayout(new GridLayout(config.isChordVisible() ? 2 : 1, 1));
    if (config.isChordVisible()) add(getTxtChordEditor());
    setBorder(BorderFactory.createEmptyBorder());

    add(getTxtTextLine());

    getTxtTextLine().setFont(GuiHelper.fontText);
    getTxtChordEditor().setFont(GuiHelper.fontText);

    getTxtTextLine().addKeyListener(parteditor);
    getTxtChordEditor().addMouseListener(this);
    getTxtTextLine().addMouseListener(this);

    setOpaque(false);
    getTxtChordEditor().setOpaque(false);
    getTxtTextLine().setOpaque(false);

    getTxtChordEditor().setBackground(parteditor.getContentEditor().getConfig().getBackgroundColor());
    getTxtTextLine().setBackground(parteditor.getContentEditor().getConfig().getBackgroundColor());
    getTxtTextLine().setForeground(parteditor.getContentEditor().getConfig().getForegroundColor());
    setBackground(parteditor.getContentEditor().getConfig().getBackgroundColor());
    getTxtChordEditor().setForeground(Color.GRAY);
    getTxtChordEditor().setBorder(BorderFactory.createEmptyBorder());
    getTxtTextLine().setBorder(BorderFactory.createEmptyBorder());


    // txtTextLine.setHorizontalAlignment(JTextField.CENTER); -> fuer Presentation
    this.currentLine = midiFileTextLine;
    refresh();
    setVisible(true);
  }

  public boolean hasFocus() {
    return getTxtTextLine().hasFocus() || getTxtChordEditor().hasFocus();
  }

  public boolean requestFocusInWindow() {
    getTxtTextLine().setCaretPosition(0);
    return getTxtTextLine().requestFocusInWindow();
  }

  private String createEmptyString(int length) {
    if (length < 0) return "";

    String neuerString = "";
    for (int i = 0; i < length; i++)
      neuerString += " ";

    return neuerString;
  }


  private void refresh() {

    int caretPosition = getTxtTextLine().getCaretPosition();

    String builderChord = "";
    String builderText = "";
    for (MidiFileChordPart nextPart : currentLine.getChordParts()) {
      if (nextPart.getText() != null)
        builderText += nextPart.getText();

      if (nextPart.getChord() != null) {
        if (nextPart.getText() == null)
          builderChord += nextPart.getChord();
        else
          builderChord += nextPart.getChord() + createEmptyString(nextPart.getText().length() - nextPart.getChord().length());
      }
      else builderChord += createEmptyString(nextPart.getText().length());

      if (builderText.length() < builderChord.length()) { //fill with blank, if chord is longer than text
        for (int i = builderText.length(); i <= builderChord.length(); i++)
          builderText+=" ";
      }

    }

    getTxtTextLine().setText(builderText);
    getTxtChordEditor().setText(builderChord);
    setCaretPositionSavely(caretPosition);
  }

  private void setCaretPositionSavely (final int caretPosition) {
    if (caretPosition > 0 && caretPosition <= getTxtTextLine().getText().length())
      getTxtTextLine().setCaretPosition(caretPosition);
    else getTxtTextLine().setCaretPosition(0);

  }

  private void modelChanged(int caretposition) {
    currentLine.getChordParts().clear();
    currentLine.getChordParts().addAll(Utils.getChordPartsFromText(getTxtTextLine().getText(), getTxtChordEditor().getText()));
    refresh();
    setCaretPositionSavely(caretposition);
  }

  /**
   * insert a character at the correct place in the model
   *
   * @param c
   */
  public void insert(char c, int caretIndex) {
    // insert carachter at text
    StringBuilder builder = new StringBuilder(getTxtTextLine().getText());
    builder.insert(caretIndex, c);
    getTxtTextLine().setText(builder.toString());

    // Insert whitespace in chord, if not currently in a chord
    builder = new StringBuilder(getTxtChordEditor().getText());
    if (caretIndex == 0 || Character.isWhitespace(builder.charAt(caretIndex - 1))) builder.insert(caretIndex, ' ');
    getTxtChordEditor().setText(builder.toString());

    modelChanged(caretIndex + 1);

  }

  public void moveChordLeft(int currentCaretPosition) {
    StringBuilder builder = new StringBuilder(getTxtChordEditor().getText());

    if (currentCaretPosition <= 0 || Character.isWhitespace(builder.charAt(currentCaretPosition))) return;

    int nextWhitespaceLeft = Utils.nextWhitespaceLeft(builder, currentCaretPosition);
    if (nextWhitespaceLeft >= 0) {
      builder.delete(nextWhitespaceLeft, nextWhitespaceLeft + 1);
      getTxtChordEditor().setText(builder.toString());
      modelChanged(currentCaretPosition - 1);
    }
  }

  public void moveChordRight(int currentCaretPosition) {

    StringBuilder builder = new StringBuilder(getTxtChordEditor().getText());

    if (currentCaretPosition >= builder.length() || Character.isWhitespace(builder.charAt(currentCaretPosition))) return;

    int nextWhitespaceLeft = Utils.nextWhitespaceLeft(builder, currentCaretPosition);
    if (nextWhitespaceLeft >= 0) {
      builder.insert(nextWhitespaceLeft, " ");
      getTxtChordEditor().setText(builder.toString());
      modelChanged(currentCaretPosition + 1);
    }
  }

  private int getCurrentLineIndex () {
    return getPartEditor().getLineEditors().indexOf(this);
  }

  /**
   * go backward (Backspace)
   */
  public void backward(int caretIndex) {
    if (caretIndex < 0) return;
    int currentLineIndex = getCurrentLineIndex();

    int loeschposition = caretIndex > 0 ? caretIndex : 0;

    // delete character at text
    StringBuilder builder = new StringBuilder(getTxtTextLine().getText());
    if (loeschposition < getTxtTextLine().getText().length())
      builder.delete(loeschposition, loeschposition);
    getTxtTextLine().setText(builder.toString());

    // delete whitespace in chord, if not currently in a chord
    builder = new StringBuilder(getTxtChordEditor().getText());

    if (loeschposition > 0 && loeschposition < getTxtChordEditor().getText().length())
      builder.delete(loeschposition - 1, loeschposition);

    getTxtChordEditor().setText(builder.toString());

    if (isLineEmpty()) {
      MidiPlayerService.removeLine (getPartEditor().getPart(), currentLine);
      getPartEditor().refresh(currentLineIndex - 1);
    }
    else
      modelChanged(caretIndex - 1);
  }


  private boolean isLineEmpty () {
    return  (getTxtChordEditor().getText() == null || getTxtChordEditor().getText().trim().length() == 0) &&
            (getTxtTextLine().getText() == null || getTxtTextLine().getText().trim().length() == 0);
  }


  public void delete(int caretIndex) {
    if (caretIndex < 0) return;

    int currentLineIndex = getCurrentLineIndex();

    // delete character at text
    StringBuilder builder = new StringBuilder(getTxtTextLine().getText());
    if (caretIndex < getTxtTextLine().getText().length())
      builder.delete(caretIndex, caretIndex);
    getTxtTextLine().setText(builder.toString());

    // delete whitespace in chord, if not currently in a chord
    builder = new StringBuilder(getTxtChordEditor().getText());
    int chordFrom = Utils.nextWhitespaceLeft(builder, caretIndex);
    int chordTo = Utils.nextWhitespaceRight(builder, caretIndex);

    if (chordFrom < getTxtTextLine().getText().length())
    builder = builder.delete(chordFrom, chordFrom + 1);
    if (chordFrom < chordTo) builder.replace(chordFrom, chordTo - 1, " ");

    getTxtChordEditor().setText(builder.toString());

    if (isLineEmpty()) {
      MidiPlayerService.removeLine (getPartEditor().getPart(), currentLine);
      getPartEditor().refresh(currentLineIndex);
    }
    else
      modelChanged(caretIndex);
  }

  public Point getLocationOfChordAtCurrentCaretOnScreen() {
    int pos = getTxtTextLine().getCaretPosition();
    FontMetrics fontMetrics = getTxtTextLine().getFontMetrics(getTxtTextLine().getFont());
    int stringWidth = fontMetrics.stringWidth(getTxtTextLine().getText().substring(0, pos));
    return new Point(getTxtTextLine().getLocationOnScreen().x + stringWidth, getTxtChordEditor().getLocationOnScreen().y);
  }

  public JTextField getTxtChordEditor() {
    return txtChordEditor;
  }

  public JTextField getTxtTextLine() {
    return txtTextLine;
  }

  private MidiFileChordPart getMidiFileChordPartIndexAtCaret() {
    int pos = 0;
    int caretIndex = getTxtTextLine().getCaretPosition();
    for (MidiFileChordPart nextPart : currentLine.getChordParts()) {

      int lenOfText = nextPart.getText() == null ? nextPart.getChord().length() : nextPart.getText().length();

      if (caretIndex >= pos && caretIndex < pos + lenOfText) return nextPart;

      pos +=lenOfText;
    }

    return null; //if caret is after all
  }

  private int getPositionOfChordPart(final MidiFileChordPart part) {
    int pos = 0;
    for (MidiFileChordPart nextPart : currentLine.getChordParts()) {

      if (part == nextPart) return pos;

      pos += nextPart.getText().length();
    }

    return -1;
  }

  public void insertChord(Chord chord) {
    int caretIndex = getTxtTextLine().getCaretPosition();
    MidiFileChordPart currentPart = getMidiFileChordPartIndexAtCaret();

    if (currentPart == null) { //if after any text, than just add it at the end and increase caretIndex
      MidiFileChordPart newPart = MidiPlayerService.mf.createMidiFileChordPart();
      newPart.setChord(chord.toString());
      currentLine.getChordParts().add(newPart);
    }
    else {
      int startPositionOfCurrentPart = getPositionOfChordPart(currentPart);
      int lengthCurrent = caretIndex - startPositionOfCurrentPart;
      String textOldPart = currentPart.getText().substring(0, lengthCurrent);
      String textNewPart = currentPart.getText().substring(lengthCurrent, currentPart.getText().length());

      // Create new part
      MidiFileChordPart newPart = MidiPlayerService.mf.createMidiFileChordPart();
      newPart.setText(textNewPart);
      newPart.setChord(chord.toString());

      // Adapt old part
      currentPart.setText(textOldPart);
      int indexOfNewPart = currentLine.getChordParts().indexOf(currentPart) + 1;
      currentLine.getChordParts().add(indexOfNewPart, newPart);
    }

    refresh();

  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent event) {
    MouseEvent me = (MouseEvent)event;

    // interested only in popuptriggers
    if(!me.isPopupTrigger())
        return;

    // me.getComponent(...) retunrs the heavy weight component on which event occured
    Component comp = SwingUtilities.getDeepestComponentAt(me.getComponent(), me.getX(), me.getY());

    contextMenu.show(comp, me.getX() + 10, me.getY());


  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  public MidiFilePartEditor getPartEditor() {
    return partEditor;
  }



}
