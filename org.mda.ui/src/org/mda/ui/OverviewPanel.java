package org.mda.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import mda.AbstractSessionItem;
import mda.Session;

public class OverviewPanel extends JPanel {

	/**
   *
   */
  private static final long serialVersionUID = 6038756352929497211L;


  /**
   * List with songs
   */
	private JList lstSongs = new JList();

	private DefaultListModel listmodel = new DefaultListModel();

	public OverviewPanel (Session session, final KeyListener listener) {
		setSize(400,800);
		GuiHelper.layout(this, false);
		GuiHelper.layout(lstSongs, false);

		addKeyListener(listener);

		setLayout(new GridLayout(1, 1));
		add(lstSongs);

		listmodel.clear();
		lstSongs.addKeyListener(listener);
		for (AbstractSessionItem nextItem: session.getItems()) {
			listmodel.addElement(nextItem.getName());
		}

		lstSongs.setBackground(Color.DARK_GRAY);

		lstSongs.setModel(listmodel);


	}

}
