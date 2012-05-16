package org.mda.editor.preview.ui.chords;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class ChordHover extends Shell {

  @Override
  protected void checkSubclass () {
  }

  private Text txtChord;

  private final String before;
  private String after;

  public ChordHover (final StyledText styledText, Point point, final String preseletion) {
    super (SWT.NONE);
    this.before = preseletion;
    setSize(40, 40);
    setLocation(point.x,point.y - getSize().y);
    setBackground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
    setLayout(new FillLayout());
    txtChord = new Text(getShell(), SWT.NONE);
    txtChord.setText(preseletion);
    txtChord.selectAll();
    txtChord.addKeyListener(new KeyAdapter() {

      public void keyReleased (final KeyEvent event) {
        if (event.keyCode == SWT.CR || event.keyCode == SWT.ESC) {
          after = txtChord.getText();
          dispose();
        }
      }
    });

    setVisible(true);
    txtChord.setFocus();

    while (!isDisposed()) {
      if (!getDisplay().readAndDispatch()) {
        getDisplay().sleep();
      }
    }

  }

  public boolean isChanged () {
    if (after != null && before == null)
      return true;
    if (before != null && after == null)
      return true;

    return ! after.trim().equals(before.trim());
  }

  public void setChord (final String newChord) {
    this.after = newChord;
  }
  public String getChord () {
    return after.trim();
  }

  public String getPreviousChord () {
    return before.trim();
  }

}
