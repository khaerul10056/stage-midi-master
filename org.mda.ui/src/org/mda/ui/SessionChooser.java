package org.mda.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import mda.MidiPlayerRoot;
import mda.Session;

import org.mda.MidiPlayerService;

public class SessionChooser extends JDialog implements ActionListener {

  /**
   *
   */
  private static final long serialVersionUID = 5197643400811649490L;

  private JButton btnSelect;

  private JButton btnAbbruch;
  private JButton btnImport;
  private JButton btnRemove;

  private JList lstSessions;

  private MidiPlayerRoot root;

  private MidiPlayerApplicationFrame midiPlayerApplicationFrame;


  public void update () {
    lstSessions.setModel(new ListModel() {

      @Override
      public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
      }

      @Override
      public int getSize() {
        return root.getSessions().size();
      }

      @Override
      public Object getElementAt(int index) {
        return root.getSessions().get(index).getName() == null ? "unnamed" : root.getSessions().get(index).getName();
      }

      @Override
      public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

      }
    });


  }


  public SessionChooser (MidiPlayerApplicationFrame midiPlayerApplicationFrame, final MidiPlayerRoot root) {
    this.midiPlayerApplicationFrame = midiPlayerApplicationFrame;
    this.root = root;
    setLayout(new GridBagLayout());
    setTitle("Sessions");
    setModal(true);
    btnSelect = new JButton("OK");
    btnSelect.addActionListener(this);

    btnImport = new JButton("New");
    btnImport.addActionListener(this);

    btnRemove = new JButton("Remove");
    btnRemove.addActionListener(this);

    btnAbbruch = new JButton("Abbruch");
    btnAbbruch.addActionListener(this);
    lstSessions = new JList();
    update();

    add(lstSessions, new GridBagConstraints(0, 0, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets (5, 5, 5, 5), 0,0));
    add(btnSelect, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets (5, 5, 5, 20), 0,0));

    add(btnImport, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets (5, 5, 5, 5), 0,0));
    add(btnRemove, new GridBagConstraints(2, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets (5, 5, 5, 5), 0,0));

    add(btnAbbruch, new GridBagConstraints(3, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets (5, 20, 5, 5), 0,0));

    setSize(600, 800);
    setVisible(true);


  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnAbbruch)) {
      lstSessions.clearSelection();
      setVisible(false);
    }

    if (e.getSource().equals(btnImport)) {
      Session session = MidiPlayerService.mf.createSession();
      midiPlayerApplicationFrame.getRoot().getSessions().add(session);
      midiPlayerApplicationFrame.getPlayer().setCurrentSession(session);
      setVisible(false);

    }

    if (e.getSource().equals(btnSelect)) {
      midiPlayerApplicationFrame.getPlayer().setCurrentSession(getSelectedItems().get(0));
      setVisible(false);
    }

    if (e.getSource().equals(btnRemove)) {
      MidiPlayerService.removeSessionsFromGallery(root, getSelectedItems());
      lstSessions.clearSelection();
      update();
    }


  }


  public List <Session> getSelectedItems() {
    List <Session> items = new ArrayList <Session> ();
    for (int nextIndex: lstSessions.getSelectedIndices())
      items.add(root.getSessions().get(nextIndex));
    return items;
  }

}
