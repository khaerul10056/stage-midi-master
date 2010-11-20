package org.mda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mda.AbstractSessionItem;
import mda.Session;

import org.mda.MidiPlayer;
import org.mda.MidiPlayerListener;
import org.mda.PlayerMode;

/**
 * Table to display the name of the sound.
 */
public class SessionTable extends JPanel implements MidiPlayerListener, ListSelectionListener, KeyListener  {

	/**
   *
   */
  private static final long serialVersionUID = -1782994312771747449L;

  private ListModel dataModel;

	private final MidiPlayer player;
	private final MidiPlayerApplicationFrame application;

	private JList table;

	public void update() {
	  dataModel = new AbstractListModel() {

      /**
       *
       */
      private static final long serialVersionUID = 6799358215082250976L;

      @Override
      public int getSize() {
        if (getPlayer().isSessionListEmpty())
          return 0;

        return getPlayer().getCurrentSession().getItems().size();
      }

      @Override
      public Object getElementAt(int index) {
        return getPlayer().getNameOf(index);
      }
    };

    table.setModel(dataModel);
  }

	public SessionTable(MidiPlayerApplicationFrame application) {
	  this.player = application.getPlayer();
		player.addMidiPlayerListener(this);
		addKeyListener(player);
		this.application = application;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(260, 300));

		table = new JList();
		update();

		table.setSelectionBackground(Color.YELLOW);
		table.setSelectionForeground(Color.BLACK);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addKeyListener(player);
		table.addKeyListener(this);
		table.addListSelectionListener(this);

		JScrollPane scrollPane = new JScrollPane(table);
		GuiHelper.layout(table, false);
		GuiHelper.layout(scrollPane, false);
		add(scrollPane);

	}


	public MidiPlayerApplicationFrame getApplication() {
		return application;
	}

	public JList getTable() {
		return table;
	}


	public MidiPlayer getPlayer() {
		return player;
	}


	@Override
	public void sessionItemChanged (AbstractSessionItem newSong) {
		for (int i = 0; i < getPlayer().getCurrentSession().getItems().size(); i++) {
			if (getPlayer().getCurrentSession().getItems().get(i).equals(newSong))
				table.setSelectedIndex(i);
		}

	}


	@Override
	public void started() {
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
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
		  player.setCurrentSong(table.getSelectedIndex());

	}

	public boolean requestFocusInWindow () {
	  return table.requestFocusInWindow();
	}


  @Override
  public void keyTyped(KeyEvent e) {
    if (e.isConsumed())
      return;

    System.out.println ("keyTyped of " + getClass().getName());
    if (e.getKeyChar() == KeyEvent.VK_DELETE) {
      getPlayer().getCurrentSession().getItems().remove(getPlayer().getCurrentSongIndex());
      repaint();
    }
    else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
      e.consume();
      if (player.getPlayerMode() == PlayerMode.PROBE) {
        boolean requested = application.getDetailcontrols().getContenteditor().requestFocusInWindow();
        System.out.println ("requestFocus: " + requested);
      }
    }

  }


  @Override
  public void keyPressed(KeyEvent e) {

  }


  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void barChanged(int currentBar) {
    // TODO Auto-generated method stub

  }

  @Override
  public void sessionChanged(Session newSession) {
    update();

  }



}
