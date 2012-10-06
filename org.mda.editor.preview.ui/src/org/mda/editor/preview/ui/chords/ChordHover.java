package org.mda.editor.preview.ui.chords;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class ChordHover extends Shell {

  private static String history = "";

  @Override
  protected void checkSubclass () {
  }

  Text txtChord;

  private final String before;
  private String after;
  private String preselection;

  public ChordHover (final Font font, final StyledText styledText, Point point, final String preseletion) {
    super (SWT.NONE);
    this.before = preseletion;
    this.preselection = preseletion;

    setSize(120, 40);
    setLocation(point.x,point.y - getSize().y);
    setBackground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
    setLayout(new FillLayout());
    txtChord = new Text(getShell(), SWT.NONE);
    if (font != null)
      txtChord.setFont(font);
    txtChord.setText(preseletion);
    if (preseletion == null || preseletion.trim().length() == 0)  {
      txtChord.setText(history);
    }

    txtChord.selectAll();
    txtChord.addKeyListener(new KeyAdapter() {

      public void keyReleased (final KeyEvent event) {
        if (event.keyCode == SWT.CR) {
          save();
          dispose();
        }

        if (event.keyCode == SWT.ESC) {
          dontsave();      
          dispose();
        }
      }
    });

    setVisible(true);
    txtChord.setFocus();
  }
  
  public void save () {
	 after = txtChord.getText();
     history = after;
  }
  
  public void dontsave () {
	    after = preselection;
        history = after;
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
