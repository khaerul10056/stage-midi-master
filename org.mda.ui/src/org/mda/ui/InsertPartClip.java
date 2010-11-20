package org.mda.ui;

import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFilePartType;

import org.mda.MidiPlayerService;

public class InsertPartClip extends JFrame {

  private JComboBox cmbTypes;
  private JComboBox cmbReference;

  private List<MidiFilePart> partsForReference;
  private List <String> renderedPartsForReference;

  private void renderReferences (MidiFile file, MidiFilePartType parttype) {
    partsForReference = MidiPlayerService.getParts(file, parttype, false);
    renderedPartsForReference = MidiPlayerService.getPartsForSelectable(partsForReference, false);
    cmbReference.setModel(new DefaultComboBoxModel(renderedPartsForReference.toArray(new String [renderedPartsForReference.size()])));
  }


  public InsertPartClip (final JFrame frame, final MidiFilePartEditor parteditor, final MidiFile file) {
    setLayout(new GridBagLayout());
    cmbTypes = GuiHelper.addLabelAndCombobox("Type:", getContentPane(), 0, 0);
    cmbReference = GuiHelper.addLabelAndCombobox("Reference:", getContentPane(), 0, 1);

    KeyAdapter adapter = new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
          setVisible(false);

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          if (!cmbReference.isPopupVisible() && !cmbTypes.isPopupVisible()) {
            MidiFilePart ref = (((String) cmbReference.getSelectedItem()).trim().isEmpty() ? null : partsForReference.get(cmbReference.getSelectedIndex() - 1)); //-1 because the first index show an empty item
            int addIndex = MidiPlayerService.addPartAfter(file, parteditor.getPart(), ((MidiFilePartType)cmbTypes.getSelectedItem()), ref);
            parteditor.getContentEditor().refresh(addIndex);
          }
          setVisible(false);
        }

      }
    };

    cmbReference.addKeyListener(adapter);
    cmbTypes.addKeyListener(adapter);

    renderReferences(file, MidiFilePartType.get(0));

    cmbTypes.setModel(new DefaultComboBoxModel(MidiFilePartType.values()));
    cmbTypes.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getItem() instanceof MidiFilePartType) {
          MidiFilePartType parttype = (MidiFilePartType) e.getItem();
          renderReferences(file, parttype);
        }
      }
    });

    setUndecorated(true);

    setLocationRelativeTo(parteditor);
    setLocation(parteditor.getLocationOnScreen().x + 10, parteditor.getLocationOnScreen().y + 10);
    setSize(600, 200);
    GuiHelper.layout(getContentPane(), false);
    setVisible(true);
  }

}
