package org.mda.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.Session;

import org.mda.MidiFileContentEditorConfigIF;
import org.mda.MidiPlayer;
import org.mda.MidiPlayerListener;
import org.mda.MidiPlayerService;
import org.mda.PlayerMode;

public class MidiFileContentEditor extends JPanel implements MidiPlayerListener {

  /**
   *
   */
  private static final long serialVersionUID = -8546915452803019839L;


  private MidiFile                         currentMidiFile;

  private MidiFileContentEditorConfigIF    config;
  private final MidiPlayerApplicationFrame application;

  private final JPanel                     contentPanel = new JPanel();

  private int currentBar;

  private List<MidiFilePart> partsShown = new ArrayList<MidiFilePart>();


  public MidiFileContentEditor(final MidiPlayerApplicationFrame application, final MidiPlayer midiplayer, MidiFileContentEditorConfigIF config) {
    this.application = application;
    this.setConfig(config);
    JScrollPane spContent = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    setLayout(new GridBagLayout());
    add(spContent, new GridBagConstraints(0, getComponentCount(), 1, 1, 1d, 1d, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets (0,0,0,0), 0, 0));

    if (midiplayer != null) midiplayer.addMidiPlayerListener(this);

    contentPanel.setBackground(config.getBackgroundColor());
    contentPanel.setBorder(null);
    contentPanel.setLayout(new GridBagLayout());
    contentPanel.setVisible(true);

  }

  public void setCurrentBar (final int currentBar) {
    this.currentBar = currentBar;
    refresh(0);
  }

  public static GridBagConstraints createConstraints(int number) {
    return new GridBagConstraints(0, number, 1, 1, 0.5d, 0d, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
  }




  public void refresh(int partindexToFocus) {


    // replace the content only if current content is available or is null

    int number = 0;

    List <MidiFilePart> parts = MidiPlayerService.getCurrentParts(getCurrentMidiFile(), currentBar, config);
    if (MidiPlayerService.changed(parts, partsShown)) {
      partsShown = parts;
      contentPanel.removeAll();

      for (MidiFilePart nextPart : parts) {
        MidiFilePartEditor editor = new MidiFilePartEditor(this, nextPart);
        contentPanel.add(editor, createConstraints(number));
        if (partindexToFocus >= 0 && partindexToFocus == number && hasFocus()) editor.requestFocusInWindow();

        number++;
      }

      if (getCurrentMidiFile() != null && getCurrentMidiFile().getParts().isEmpty())
        contentPanel.add(new MidiFilePartEditor(this, MidiPlayerService.mf.createMidiFilePart()), createConstraints(0));

      invalidate();
      validate();
    }

  }

  private MidiFilePartEditor getCurrentPartEditor () {
    int index = getCurrentPartIndex();
    if (index < 0)
      return null;
    return getPartEditors().get(index);
  }

  public int getCurrentPartIndex() {
    for (int i = 0; i < getPartEditors().size(); i++) {
      MidiFilePartEditor parteditor = getPartEditors().get(i);
      if (parteditor.hasFocus()) return i;
    }

    return -1;
  }


  public List<MidiFilePartEditor> getPartEditors() {
    List<MidiFilePartEditor> editors = new ArrayList<MidiFilePartEditor>();
    for (Component nextComp : contentPanel.getComponents()) {
      if (nextComp instanceof MidiFilePartEditor) editors.add((MidiFilePartEditor) nextComp);
    }

    return editors;

  }

  public boolean requestFocusInWindow() {
    if (getPartEditors().size() > 0) {
      if (getPartEditors().get(0).getLineEditors().size() > 0) return getPartEditors().get(0).getLineEditors().get(0).requestFocusInWindow();
    }
    return false;
  }

  public boolean hasFocus () {
    for (MidiFilePartEditor nextEditor : getPartEditors()) {
      if (nextEditor.isFocusOwner()) return true;
    }
    return false;
  }

  @Override
  public void sessionItemChanged(AbstractSessionItem newSong) {
    if (newSong instanceof MidiFile)
      setCurrentMidiFile((MidiFile) newSong);
    refresh(0);
  }

  @Override
  public void started() {
    // TODO Auto-generated method stub

  }

  @Override
  public void stopped() {
    // TODO Auto-generated method stub

  }

  @Override
  public void modeToggled(PlayerMode chosePlayerMode) {
    // TODO Auto-generated method stub

  }

  private void setConfig(MidiFileContentEditorConfigIF config) {
    this.config = config;
  }

  public MidiFileContentEditorConfigIF getConfig() {
    return config;
  }

  public MidiPlayerApplicationFrame getApplication() {
    return application;
  }

  public void stepToNextPart() {
    int currentFocusIndex = getCurrentPartIndex();
    if (currentFocusIndex < getPartEditors().size() - 1) {
      currentFocusIndex ++;
      getPartEditors().get(currentFocusIndex).requestFocusInWindow();
    }

  }

  public void stepToPreviousPart() {
    int currentFocusIndex = getCurrentPartIndex();
    if (currentFocusIndex > 0) {
      currentFocusIndex --;
      getPartEditors().get(currentFocusIndex).requestFocusInWindowToLast();
    }

  }

  public void disableClips () {
    for (MidiFilePartEditor nextEditor: getPartEditors()) {
      nextEditor.disableClips ();
    }
  }

  @Override
  public void barChanged(int currentBar) {
    // TODO Auto-generated method stub

  }

  /**
   * Shows a menu what to insert and inserts the selected item
   */
  public void insertNewPart() {
    MidiFilePartEditor currentPart = getCurrentPartEditor();
    new InsertPartClip(getApplication(), currentPart, getCurrentMidiFile());



  }

  public void setCurrentMidiFile(MidiFile currentMidiFile) {
    this.currentMidiFile = currentMidiFile;
  }

  public MidiFile getCurrentMidiFile() {
    return currentMidiFile;
  }

  @Override
  public void sessionChanged(Session newSession) {
    if (newSession.getItems().size() > 0)
      setCurrentMidiFile((MidiFile) newSession.getItems().get(0));
    else
      setCurrentMidiFile(null);
  }

@Override
public void tickChanged(int currentTick) {
	// TODO Auto-generated method stub

}





}
