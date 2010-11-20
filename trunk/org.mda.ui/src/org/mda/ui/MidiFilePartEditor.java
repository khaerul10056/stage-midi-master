package org.mda.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiFileTextLine;

import org.eclipse.emf.common.util.EList;
import org.mda.Chord;
import org.mda.MidiPlayerService;
import org.mda.importer.InvalidChordException;
import org.mda.ui.util.VerticalLabelUI;

public class MidiFilePartEditor extends JPanel implements KeyListener {

  /**
   *
   */
  private static final long     serialVersionUID = 2033902468498152017L;

  private MidiFilePart          part;

  private MidiFileContentEditor contentEditor;

  private final ContentPartDetailClip          extendedClip;

  private int                   currentCaretPosition;

  private JPanel                clip = new JPanel ();
  private JPanel                content          = new JPanel();

  private ChordEditor           editor;

  private boolean isReference;

  private static HashMap<MidiFilePartType, Color> colors = new HashMap<MidiFilePartType, Color>();

  static {
    colors.put(MidiFilePartType.VERS, new Color (230, 130, 130));
    colors.put(MidiFilePartType.REFRAIN, new Color (130, 230, 130));
    colors.put(MidiFilePartType.SOLO, new Color (130, 130, 230));
  }

  private Color getColor (final MidiFilePartType parttype) {
    Color color = parttype != null ? colors.get(parttype): null;
    return color != null ? color: new Color (230, 230, 230);
  }



  public MidiFilePartEditor(MidiFileContentEditor midiFileContentEditor, final MidiFilePart part) {
    setOpaque(false);
    this.isReference = part.getRefPart() != null;
    this.part = part;
    this.contentEditor = midiFileContentEditor;
    content.setLayout(new GridBagLayout());
    content.setBackground(midiFileContentEditor.getConfig().getBackgroundColor());
    setBackground(midiFileContentEditor.getConfig().getBackgroundColor());

    extendedClip = new ContentPartDetailClip(getContentEditor().getApplication(), part);

    clip.setBackground(getColor(part.getParttype()));
    JLabel clipHeader = new JLabel (part.getRefPart() != null ? part.getParttype().name() + "-Reference" : part.getParttype().name());
    clipHeader.setUI(new VerticalLabelUI(true));
    clip.add(clipHeader);

    setLayout(new GridBagLayout());
    if (midiFileContentEditor.getConfig().isEditable())
      add(clip, new GridBagConstraints(0, 0, 1, 1, 0d, 0d, GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(0, 0, 2, 0), 0, 0));
    add(content, new GridBagConstraints(getComponentCount(), 0, 1, 1, 1d, 1d, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 2, 2, 0), 0, 0));



    clip.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        extendedClip.setBounds(content.getLocationOnScreen().x, content.getLocationOnScreen().y, 400, content.getHeight());
        extendedClip.setVisible(! extendedClip.isVisible());
      }
    });

    refresh(0);

    doLayout();
    if (content.getComponentCount() > 0) content.getComponents()[content.getComponentCount() - 1].requestFocusInWindow();

    if (part.getTextlines().isEmpty()) addNewLine();


    setVisible(true);
  }

  public void refresh (int caretposition) {
    content.removeAll();

    EList<MidiFileTextLine> viewableTextLines = part.getTextlines();
    if (part.getRefPart() != null)
      viewableTextLines = part.getRefPart().getTextlines();

    for (MidiFileTextLine nextLine : viewableTextLines) {
      MidiFileLineEditor midiFileLineEditor = new MidiFileLineEditor(this, nextLine);

      content.add(midiFileLineEditor, contentEditor.createConstraints(content.getComponentCount()), content.getComponentCount());
      if (caretposition == content.getComponentCount() - 1)
        midiFileLineEditor.requestFocusInWindow();
    }

    getContentEditor().invalidate();
    getContentEditor().validate();

  }

  public boolean hasFocus() {
    for (Component next : content.getComponents()) {
      if (next.hasFocus()) return true;
    }

    return false;

  }

  @Override
  public boolean requestFocusInWindow() {
    if (content.getComponents().length > 0) return content.getComponents()[0].requestFocusInWindow();

    return content.requestFocusInWindow();
  }

  private int addNewLine() {
    int focusedLine = getFocusedLine();

    if (focusedLine >= 0) {
      MidiFileTextLine createMidiFileTextLine = MidiPlayerService.mf.createMidiFileTextLine();
      MidiFileChordPart emptyPart = MidiPlayerService.mf.createMidiFileChordPart();
      emptyPart.setText("");
      createMidiFileTextLine.getChordParts().add(emptyPart);
      part.getTextlines().add(focusedLine + 1, createMidiFileTextLine);
      return focusedLine + 1;
    }

    return focusedLine;

  }

  public List<MidiFileLineEditor> getLineEditors() {
    List<MidiFileLineEditor> editors = new ArrayList<MidiFileLineEditor>();
    for (Component nextComp : content.getComponents()) {
      editors.add((MidiFileLineEditor) nextComp);
    }

    return editors;

  }

  @Override
  public void keyTyped(KeyEvent e) {
    if (e.isConsumed()) return;
    System.out.println("keyTyped of " + getClass().getName());


    if (e.getKeyChar() == KeyEvent.VK_DELETE) {
      getLineEditors().get(getFocusedLine()).delete(currentCaretPosition);
    } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
      e.consume();
      getLineEditors().get(getFocusedLine()).backward(currentCaretPosition);
    } else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) { // ESC leaves the editor
      e.consume();
      if (getContentEditor().getApplication() != null) getContentEditor().getApplication().getSessionTable().requestFocusInWindow(); // TODO The editor should
                                                                                                                                     // work without references
                                                                                                                                     // to application
    } else if (Character.isDefined(e.getKeyChar()) && !e.isAltDown() && !e.isAltGraphDown() && !e.isControlDown() && !e.isMetaDown()) { // input a valid char
                                                                                                                                        // (no special keys)
      getLineEditors().get(getFocusedLine()).insert(e.getKeyChar(), currentCaretPosition);
      e.consume();
    } else if (e.isAltDown()) {
      String key = Character.toString(e.getKeyChar());
      try {
        Chord chord = new Chord(key);
        MidiFileLineEditor midiFileLineEditor = getLineEditors().get(getFocusedLine());
        Point loc = midiFileLineEditor.getLocationOfChordAtCurrentCaretOnScreen();

        if (editor == null) editor = new ChordEditor(midiFileLineEditor.getTxtChordEditor());
        editor.show(loc.x, loc.y, chord);

        if (editor.getChord() != null) midiFileLineEditor.insertChord(editor.getChord());
      } catch (InvalidChordException e1) {

      }
    }
  }

  private int getFocusedLine() {
    for (int i = 0; i < getLineEditors().size(); i++) {
      MidiFileLineEditor line = getLineEditors().get(i);
      if (line.hasFocus()) return i;
    }

    return -1;
  }

  @Override
  public void keyPressed(KeyEvent e) {

    currentCaretPosition = getLineEditors().get(getFocusedLine()).getTxtTextLine().getCaretPosition();

    if (e.isConsumed()) return;
    System.out.println("keyPressed of " + getClass().getName());
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      e.consume();
      int line = addNewLine();
      refresh(line);
    }
    else
      if (e.getKeyCode() == KeyEvent.VK_INSERT && e.isAltDown()) {
        getContentEditor().insertNewPart();
      }

      else if (e.getKeyCode() == KeyEvent.VK_LEFT && e.isAltDown()) {
      e.consume();
      getLineEditors().get(getFocusedLine()).moveChordLeft(currentCaretPosition);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && e.isAltDown()) {
      e.consume();
      getLineEditors().get(getFocusedLine()).moveChordRight(currentCaretPosition);
    } else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_UP) {
      e.consume();
      int newIndex = MidiPlayerService.movePartUp (getContentEditor().getCurrentMidiFile(), getPart());
      getContentEditor().refresh(newIndex);
    } else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
      e.consume();
      int newIndex = MidiPlayerService.movePartDown (getContentEditor().getCurrentMidiFile(), getPart());
      getContentEditor().refresh(newIndex);
    }
    else if (e.getKeyCode() == KeyEvent.VK_UP) {
      e.consume();
      stepToPrevLine();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      e.consume();
      stepToNextLine();
    }

  }


  private void stepToPrevLine() {
    if (getFocusedLine() > 0)
      getLineEditors().get(getFocusedLine() - 1).requestFocusInWindow();
    else getContentEditor().stepToPreviousPart();
  }

  private void stepToNextLine() {
    if (getFocusedLine() < getLineEditors().size() - 1)
      getLineEditors().get(getFocusedLine() + 1).requestFocusInWindow();
    else getContentEditor().stepToNextPart();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  public void setContentEditor(MidiFileContentEditor contentEditor) {
    this.contentEditor = contentEditor;
  }

  public MidiFileContentEditor getContentEditor() {
    return contentEditor;
  }

  public boolean requestFocusInWindowToLast() {
    if (content.getComponents().length > 0) return content.getComponents()[content.getComponentCount() - 1].requestFocusInWindow();
    return content.requestFocusInWindow();
  }

  public MidiFilePart getPart() {
    return part;
  }



  public void disableClips() {
    extendedClip.setVisible(false);
  }








}
