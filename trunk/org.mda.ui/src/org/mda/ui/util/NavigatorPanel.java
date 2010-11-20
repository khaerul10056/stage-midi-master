package org.mda.ui.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.security.acl.LastOwnerException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.Session;

import org.mda.MidiPlayer;
import org.mda.MidiPlayerListener;
import org.mda.MidiPlayerService;
import org.mda.PlayerMode;
import org.mda.ui.MidiPlayerApplicationFrame;

public class NavigatorPanel extends JPanel implements MidiPlayerListener {

  private MidiFile midifile;
  private JList    lstParts;
  private MidiPlayer player;

  public NavigatorPanel(MidiPlayerApplicationFrame application) {
    player = application.getPlayer();
    player.addMidiPlayerListener(this);
    setLayout(new BorderLayout());

    lstParts = new JList();
    lstParts.addKeyListener(player);
    add(lstParts, BorderLayout.CENTER);
    lstParts.addListSelectionListener(new ListSelectionListener() {

      @Override
      public void valueChanged(ListSelectionEvent e) {
        int index = lstParts.getSelectedIndex() - 1;
        if (index < 0)
           index = 0;

        if (!e.getValueIsAdjusting()) {
          if (midifile.getParts().size() >= lstParts.getSelectedIndex()) {
            MidiFilePart midiFilePart = midifile.getParts().get(index);
            System.out.println("Selected " + midiFilePart.getParttype().toString() + "-" + midiFilePart.getBar());
            if (midiFilePart.getBar() >= 0) player.setLoopFrom(midiFilePart.getBar());
          }
        }
      }
    });
  }

  @Override
  public void sessionChanged(Session newSession) {
    player.setLoopFrom(0);
    player.setLoopTo (-1);

  }

  @Override
  public void sessionItemChanged(AbstractSessionItem abstractSessionItem) {
    this.midifile = (MidiFile) abstractSessionItem;

    List<String> partsForSelectable = MidiPlayerService.getPartsForSelectable(midifile.getParts(), true);
    lstParts.setModel(new DefaultComboBoxModel(partsForSelectable.toArray(new String[partsForSelectable.size()])));

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

  @Override
  public void barChanged(int currentBar) {
    // TODO Auto-generated method stub

  }

}
