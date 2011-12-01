package org.mda.editor.preview.ui.chords;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class ChordHover extends Shell {

  @Override
  protected void checkSubclass () {
  }

  private Text txtChord;

  public ChordHover (final StyledText styledText) {
    super (SWT.NONE);


    setSize(40, 40);
    setLocation(styledText.getLocationAtOffset(styledText.getCaretOffset()).x, styledText.getBounds().y);
    getLocation().y = styledText.getBounds().y;
    setLayout(new FillLayout());
    txtChord = new Text(getShell(), SWT.NONE);
    txtChord.setText("Am");
    txtChord.addKeyListener(new KeyAdapter() {

      public void keyReleased (final KeyEvent event) {
        if (event.keyCode == SWT.ALT) {
          dispose();
        }
      }


    });
    setVisible(true);
    setActive();

    while (!isDisposed()) {
      if (!getDisplay().readAndDispatch()) {
        getDisplay().sleep();
      }
    }

  }

}
