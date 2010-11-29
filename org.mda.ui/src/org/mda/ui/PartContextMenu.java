package org.mda.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import mda.MidiFile;

import org.mda.MidiPlayerService;

public class PartContextMenu extends JPopupMenu implements ActionListener{

  private MidiFileLineEditor editor;

  private JMenuItem menuItemRemovePart = new JMenuItem("Remove part");
  private JMenuItem menuItemAddPart = new JMenuItem ("Add part");

  public PartContextMenu (final MidiFileLineEditor editor) {
    this.editor = editor;
    add(menuItemAddPart);
    menuItemAddPart.addActionListener(this);
    add(menuItemRemovePart);
    menuItemRemovePart.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(menuItemRemovePart)) {
      MidiFileContentEditor contentEditor = editor.getPartEditor().getContentEditor();
      MidiFile file = editor.getPartEditor().getContentEditor().getCurrentMidiFile();
      int removedIndex = MidiPlayerService.removePart (file, editor.getPartEditor().getPart());
      contentEditor.refresh(removedIndex);
    }

    if (e.getSource().equals(menuItemAddPart)) {
    	editor.getPartEditor().getContentEditor().insertNewPart();
    }
  }

}
