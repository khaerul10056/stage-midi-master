package org.mda.presenter.ui.test;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.mda.IPresentationController;
import org.mda.IPresentationView;


public class KeyController implements IPresentationController, KeyListener {

  private List <IPresentationView> views = new ArrayList<IPresentationView>();


  @Override
  public void keyPressed (KeyEvent e) {
    System.out.println ("KeyPressed " + e.character);

    if (e.character == SWT.ESC) {
      for (IPresentationView nextView: views) {
        nextView.end();
      }
    }

    if (e.keyCode == SWT.ARROW_RIGHT) {
      for (IPresentationView nextView: views) {
        nextView.nextSlide();
      }
    }

    if (e.keyCode == SWT.ARROW_LEFT) {
      for (IPresentationView nextView: views) {
        nextView.previousSlide();
      }
    }


  }

  @Override
  public void keyReleased (KeyEvent e) {
    System.out.println ("KeyReleased " + e.character);

  }



  @Override
  public void connect (IPresentationView view) {
    views.add(view);

  }

}
