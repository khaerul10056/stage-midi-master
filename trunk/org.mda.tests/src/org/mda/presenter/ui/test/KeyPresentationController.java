package org.mda.presenter.ui.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.DefaultPresentationController;


public class KeyPresentationController extends DefaultPresentationController implements KeyListener {

  private static final Log LOGGER  = LogFactory.getLogger(KeyPresentationController.class);
  @Override
  public void keyPressed (KeyEvent e) {
    LOGGER.info("KeyPressed " + e.character);

    if (e.character == SWT.ESC)
      end();

    if (e.keyCode == SWT.ARROW_RIGHT)
      nextSlide();

    if (e.keyCode == SWT.ARROW_LEFT)
      previousSlide();

  }

  @Override
  public void keyReleased (KeyEvent e) {
    LOGGER.info("KeyReleased " + e.character);
  }



}
