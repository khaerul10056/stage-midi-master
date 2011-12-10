package org.mda.commons.ui.test;

import org.eclipse.swt.widgets.Table;
import org.junit.Test;
import org.mda.commons.ui.SongSelectorPanel;


public class TestSongSelectorPanel {

  @Test
  public void call () {
    SongSelectorPanel panel = new SongSelectorPanel();
    Table table = panel.getTable();
    System.out.println (table.getColumns() [0].getText());
  }

}
