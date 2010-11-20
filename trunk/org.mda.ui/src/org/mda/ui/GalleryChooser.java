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

import mda.AbstractSessionItem;
import mda.Gallery;
import mda.MidiPlayerRoot;

import org.mda.MidiPlayerService;


public class GalleryChooser extends JDialog implements ActionListener {

	/**
   *
   */
  private static final long serialVersionUID = 5197643400811649490L;

  private JButton btnSelect;

	private JButton btnAbbruch;
	private JButton btnImport;
	private JButton btnRemove;

	private JList lstSongs;

	private Gallery gallery;


	public void update () {
	  lstSongs.setModel(new ListModel() {

      @Override
      public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
      }

      @Override
      public int getSize() {
        return gallery.getGalleryItems().size();
      }

      @Override
      public Object getElementAt(int index) {
        return gallery.getGalleryItems().get(index).getName();
      }

      @Override
      public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

      }
    });


	}


	public GalleryChooser (final Gallery gallery) {
		this.gallery = gallery;
		setLayout(new GridBagLayout());
		setTitle("Gallery");
		setModal(true);
		btnSelect = new JButton("OK");
		btnSelect.addActionListener(this);

		btnImport = new JButton("Import");
		btnImport.addActionListener(this);

		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(this);

		btnAbbruch = new JButton("Abbruch");
		btnAbbruch.addActionListener(this);
		lstSongs = new JList();
		update();

		add(lstSongs, new GridBagConstraints(0, 0, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets (5, 5, 5, 5), 0,0));
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
		  lstSongs.clearSelection();
			setVisible(false);
		}

		if (e.getSource().equals(btnSelect)) {
			setVisible(false);
		}

		if (e.getSource().equals(btnRemove)) {
		  MidiPlayerService.removeSongsFromGallery(gallery, getSelectedItems());
		  lstSongs.clearSelection();
		  update();
		}

		if (e.getSource().equals(btnImport)) {
		  MidiPlayerRoot root = MidiPlayerService.getRoot(gallery);
		  MidiPlayerService.importDefaultPathsToGallery(root);
		  update();
		}

	}


	public List <AbstractSessionItem> getSelectedItems() {
	  List <AbstractSessionItem> items = new ArrayList <AbstractSessionItem> ();
	  for (int nextIndex: lstSongs.getSelectedIndices())
	    items.add(gallery.getGalleryItems().get(nextIndex));
		return items;
	}





}
